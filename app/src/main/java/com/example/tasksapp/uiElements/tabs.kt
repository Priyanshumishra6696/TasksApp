package com.example.tasksapp.uiElements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.tasksapp.TaskViewModel
import kotlinx.coroutines.launch

@Composable
fun Tabs(viewModel: TaskViewModel,pagerState: PagerState,navController: NavController){
    //stores the tab index for each tab
    val scope = rememberCoroutineScope()
    //lists of tabs
//    var tabs by remember { mutableStateOf(listOf("Starred","My Tasks")) }

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(31,31,34)
    ) {
        viewModel.tabs.forEachIndexed { index, title ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }

                },
                text = { Text(title) }
            )
        }
        Tab(
            selected = false,
            onClick = {
                navController.navigate("Create_List_Page")
            },
            text = { Text(text = "+ New List") }
        )
    }
//    HorizontalPager(
//        state = pagerState,
//        modifier = Modifier.fillMaxWidth()
//    ) {page ->
//        when(page){
//            0 -> {
//                Text("starred Tab")
//            }
//            1 -> {
//                TaskColumn(viewModel)
//            }
//        }
//    }
}


