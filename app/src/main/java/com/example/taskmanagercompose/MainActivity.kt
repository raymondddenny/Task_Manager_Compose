package com.example.taskmanagercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagercompose.ui.theme.TaskManagerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val title = "All tasks completed"
                    val subtitle = "Nice work!"
                    TaskManagerPage(title = title, subtitle = subtitle)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun TaskManagerPage(title:String, subtitle:String, modifier: Modifier=Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        TaskManagerImage( modifier = modifier)
        TaskManagerComposeText(title = title, subtitle = subtitle, modifier = modifier)
    }

}

@Composable
fun TaskManagerImage(modifier: Modifier=Modifier){
    val image = painterResource(id = R.drawable.ic_task_completed)

    Image(painter = image, contentDescription = "success", modifier = modifier)
}

@Composable
fun TaskManagerComposeText(title:String, subtitle:String, modifier: Modifier= Modifier) {
   Column (
       horizontalAlignment = Alignment.CenterHorizontally,
   ) {
         Text(
             text = title,
             modifier = modifier.padding(bottom = 8.dp, top = 24.dp),
             fontWeight = FontWeight.Bold,

             )
         Text(
             text = subtitle,
             modifier = modifier,
             fontSize = 16.sp
             )
   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerComposeTheme {
        Greeting("Android")
    }
}