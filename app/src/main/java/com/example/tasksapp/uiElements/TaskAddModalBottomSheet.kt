package com.example.tasksapp.uiElements

import androidx.compose.runtime.Composable

//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.material3.*
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TaskAddModalBottomSheet(
//    sheetState: SheetState,
//    onDismiss:()->Unit,
//    onSave:(String)->Unit
//){
//    var inputText by remember { mutableStateOf("") }
//
//    ModalBottomSheet(
//        sheetState = sheetState,
//        onDismissRequest = onDismiss
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            Text("Enter Your Task")
//            OutlinedTextField(
//                value = inputText,
//                onValueChange = {inputText=it},
//                modifier = Modifier.fillMaxWidth()
//            )
//            Button(
//                onClick = {
//                    onSave(inputText)
//                    onDismiss()
//                },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Save")
//            }
//        }
//    }
//}

@Composable
fun TasksAddModalBottomSheet(){

}