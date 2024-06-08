package com.boryans.deadline.ui.screen.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.boryans.deadline.navigation.Route
import com.boryans.deadline.ui.components.DeadlineButton
import com.boryans.deadline.ui.components.Text
import com.boryans.deadline.ui.theme.DeadlineTheme
import com.boryans.deadline.ui.theme.bigShouldersDisplayBlack
import java.util.Locale

fun NavGraphBuilder.deadlineDetailsScreen() {
  composable<Route.DeadlineDetails> {
    DeadlineDetailsScreen()
  }
}

@Composable
fun DeadlineDetailsScreen(
  modifier: Modifier = Modifier,
) {
  Surface {
    Scaffold { paddingValues ->
      Surface(modifier = modifier.fillMaxSize()) {
        DeadlineContent(paddingValues = paddingValues, onClick = {})
      }
    }
  }
}

@Composable
fun DeadlineContent(
  paddingValues: PaddingValues,
  onClick: () -> Unit,
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues)
      .padding(horizontal = 12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top
  ) {
    TimeBoxCard()
    Spacer(modifier = Modifier.height(20.dp))
    Text.Default(
      modifier = Modifier.padding(horizontal = 12.dp),
      text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
        " Nulla interdum lectus mauris, a ullamcorper diamat." +
        " Praesent ut lectus sit amet enim varius convallis." +
        " Aenean interdum elementum quam vitae rhoncus.",
      maxLines = 10,
    )
    Spacer(modifier = Modifier.height(40.dp))
    DeadlineButton(text = "Edit", onClick = onClick)
  }
}

@Composable
fun TimeBoxCard(modifier: Modifier = Modifier) {
  Surface(
    shape = RoundedCornerShape(10.dp)
  ) {
    Box(
      modifier = modifier
        .padding(horizontal = 16.dp)
        .wrapContentSize()
    ) {
      Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Column(
          modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.Start
        ) {
          Text.Headline(text = "Coding project")
          Spacer(modifier = Modifier.height(4.dp))
          Text.DefaultLarge(text = "Deadline in 23.07.2025")
        }
        Spacer(modifier = Modifier.height(20.dp))
        TimerRowDetails()
      }
    }
  }
}

@Composable
fun TimerRowDetails(modifier: Modifier = Modifier) {
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceAround
  ) {
    TimerBoxDetails(title = "days", time = "22")
    Spacer(modifier = Modifier.width(8.dp))
    TimerBoxDetails(title = "hours", time = "12")
    Spacer(modifier = Modifier.width(8.dp))
    TimerBoxDetails(title = "mins", time = "45")
    Spacer(modifier = Modifier.width(8.dp))
    TimerBoxDetails(title = "sec", time = "45")

  }
}

@Composable
fun TimerBoxDetails(
  title: String,
  time: String,
  modifier: Modifier = Modifier,
) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Surface(
      shape = RoundedCornerShape(10.dp),
      border = BorderStroke(1.dp, color = Color.Gray),
    ) {
      Box(
        modifier = modifier
          .width(70.dp)
          .wrapContentHeight()
          .padding(start = 12.dp, end = 12.dp, bottom = 6.dp),
        contentAlignment = Alignment.Center
      ) {
        Text.Headline(
          modifier = Modifier.wrapContentHeight(),
          text = time.uppercase(Locale.getDefault()),
          textColor = MaterialTheme.colorScheme.primary,
          fontFamily = bigShouldersDisplayBlack
        )
      }
    }
    Spacer(modifier = Modifier.height(3.dp))
    Text.DefaultLarge(
      text = title.uppercase(Locale.getDefault()),
      textColor = Color.Gray
    )
  }


}

fun NavHostController.navigateToDeadlineDetails(deadlineId: String) {
  navigate(route = Route.DeadlineDetails(deadlineId = deadlineId))
}


@Preview
@Composable
private fun DeadlineDetailsPreview() {
  DeadlineTheme {
    DeadlineDetailsScreen()
  }
}