package com.example.tasksapp.uiElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.tasksapp.TaskViewModel

//@Composable
//fun Tabs(viewModel: TaskViewModel,navController: NavController){
//
//    val listList by viewModel.listList.observeAsState()
//
//    val taskList by viewModel.taskList.observeAsState()
//    var selected by remember { mutableIntStateOf(0) }
//
//    ScrollableTabRow(
//        selectedTabIndex = selected,
//        modifier = Modifier.fillMaxWidth(),
//        containerColor = Color(31,31,34)
//    ) {
//        Tab(
//            selected = selected==0,
//            onClick = {
//                selected=0
//            },
//            text = { Text(text = "Starred") }
//        )
//        Tab(
//            selected = selected==1,
//            onClick = {
//                selected=1
//            },
//            text = { Text(text = "My Tasks") }
//        )
//        listList?.forEachIndexed { index, title ->
//            Tab(
//                selected = selected==index+2,
//                onClick = {
//                    selected=index+2
//
//                },
//                text = { Text(title.listName) }
//            )
//        }
//
//        Tab(
//            selected = false,
//            onClick = {
//                navController.navigate("Create_List_Page")
//            },
//            text = { Text(text = "+ New List") }
//        )
//    }
//    when(selected){
//        0 -> {
//            StarredPage()
//        }
//        1 -> {
//            StarredPage()
//        }
//        else -> {
//            Text("guyfwe")
//        }
//    }
//}


@Composable
fun Tabs(viewModel: TaskViewModel,navController: NavController) {
    // Static tab titles
    val staticTabs = listOf("Starred", "My Tasks")

    // Observe listList LiveData from viewModel
    val dynamicTabs by viewModel.listList.observeAsState(emptyList())

    // Track selected tab index
    var selectedTabIndex by remember { mutableStateOf(0) }

    // Variable to hold current content Composable based on selected tab
    var content by remember { mutableStateOf<@Composable () -> Unit>({ StarredPage() }) }

    // Combine static and dynamic tabs with an additional "Add Tab"
    val allTabs = staticTabs + dynamicTabs.map { it.listName } + "Add Tab"

    Column {
        ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
            allTabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        content = when (title) {
                            "Starred" -> { { StarredPage() } }
                            "My Tasks" -> { { StarredPage() } }
                            "Add Tab" -> {
                                viewModel.addList("New List")
                                content // Keep the current content when adding a new tab
                            }
                            else -> { { GeneralPage(viewModel,selectedTabIndex) } }
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            textAlign = TextAlign.Center
                        )
                    }
                )
            }
        }

        // Display the current selected content
        content()
    }
}

