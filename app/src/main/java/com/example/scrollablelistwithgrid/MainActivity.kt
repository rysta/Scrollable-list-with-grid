package com.example.scrollablelistwithgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

                }
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier){
    Card(modifier = modifier.height(68.dp)){
        Row(){
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.nameResourceId),
                modifier = modifier
                    .fillMaxHeight()
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(){
                Text(stringResource(topic.nameResourceId))
                Text(topic.courseId.toString())
            }
        }
    }

//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier
//            .height(68.dp)
//            .background(
//                color = Color.LightGray,
//                shape = RoundedCornerShape(10.dp)
//            )
//    ) {
//        Image(
//            painterResource(topic.imageResourceId),
//            contentDescription = stringResource(topic.nameResourceId),
//            modifier = modifier
//                .fillMaxHeight()
//                .width(68.dp)
//                .clip(RoundedCornerShape(10.dp)),
//            contentScale = ContentScale.Crop
//        )
//        Column {
//            Text(stringResource(topic.nameResourceId))
//            Text(topic.courseId.toString())
//        }
//    }
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ScrollableListWithGridTheme {
        TopicCard(Topic(R.string.architecture, 58, R.drawable.architecture))
    }
}