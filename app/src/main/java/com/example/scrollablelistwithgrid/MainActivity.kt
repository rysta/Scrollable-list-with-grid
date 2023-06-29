package com.example.scrollablelistwithgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrollablelistwithgrid.data.DataSource
import com.example.scrollablelistwithgrid.model.Topic
import com.example.scrollablelistwithgrid.ui.theme.ScrollableListWithGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableListWithGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicsGridApp(Modifier)
                }
            }
        }
    }
}

@Composable
fun TopicsGridApp(modifier: Modifier = Modifier){
    TopicsGrid(
        topics = DataSource().topics,
        modifier = modifier
    )
}

@Composable
fun TopicsGrid(topics: List<Topic>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.padding(8.dp)
    ){
        items(topics){ topic ->
            TopicCard(topic, modifier)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .height(68.dp)
    ){
        Row(
            modifier = modifier
        ){
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.nameResourceId),
                modifier = modifier
                    .fillMaxHeight()
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            TopicBody(topic, modifier)
        }
    }
}

@Composable
fun TopicBody(topic: Topic, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
    ){
        Text(text = stringResource(topic.nameResourceId), style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = modifier.height(8.dp))
        Row(
            modifier = modifier
        ){
            Image(
                painter = painterResource(R.drawable.ic_grain),
                contentDescription = "grains"
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(text = topic.courseId.toString(), style = MaterialTheme.typography.labelMedium)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ScrollableListWithGridTheme {
        TopicsGridApp(Modifier)
    }
}