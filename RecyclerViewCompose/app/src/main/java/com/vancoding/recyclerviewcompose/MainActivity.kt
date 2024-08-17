package com.vancoding.recyclerviewcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vancoding.recyclerviewcompose.ui.theme.RecyclerViewComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            ScrollableColumnDemo()
//            LazyColumnDemo()
            LazyColumnDemo2 {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ScrollableColumnDemo() {
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for(i in 1..100) {
            Text(
                "User Name $i",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}

@Composable
fun LazyColumnDemo() {
    LazyColumn {
        items(100) {
            Text(
                "User Name $it",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}

@Composable
fun LazyColumnDemo2(selectedItem: (String)->(Unit)) {
    LazyColumn {
        items(100) {
            Text(
                "User Name $it",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it Selected") }
            )
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}