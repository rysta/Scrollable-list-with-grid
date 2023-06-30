package com.example.scrollablelistwithgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
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
        modifier = modifier.padding(dimensionResource(R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
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
    Column(){
        Text(
            text = stringResource(topic.nameResourceId),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium),
                bottom = dimensionResource(R.dimen.padding_small),
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(R.drawable.ic_grain),
                contentDescription = "grains",
                modifier = modifier.padding(start = dimensionResource(R.dimen.padding_medium))
            )
            Text(
                text = topic.courseId.toString(),
                style = MaterialTheme.typography.labelMedium,
                modifier = modifier.padding(start = dimensionResource(R.dimen.padding_small))
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardPreview() {
    ScrollableListWithGridTheme {
        TopicsGridApp(Modifier)
    }
}