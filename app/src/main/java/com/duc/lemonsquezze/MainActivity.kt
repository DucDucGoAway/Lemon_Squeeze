package com.duc.lemonsquezze

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duc.lemonsquezze.ui.theme.LemonSquezzeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonSquezzeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}


@Composable
fun Lemonade(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {

    var state by remember { mutableStateOf(1)}
    var textvar = when(state) {
        1       -> stringResource(R.string.lemon_choose)
        2       -> stringResource(R.string.lemon_squeeze)
        3       -> stringResource(R.string.lemon_drink)
        4       -> stringResource(R.string.lemon_restart)
        else    -> stringResource(R.string.lemon_squeeze)
    }
    var imagevar = when(state) {
        1       -> R.drawable.lemon_tree
        2       -> R.drawable.lemon_squeeze
        3       -> R.drawable.lemon_drink
        4       -> R.drawable.lemon_restart
        else    -> R.drawable.lemon_squeeze
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = textvar,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )
        Button(
            onClick = {when (state) {
                1       -> state = 2
                2       -> {state = ( 5..7).random()}
                3       -> state = 4
                5, 6    -> state = 2
                7       -> state = 3
                else    -> state = 1
            } },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .size(300.dp)
        ) {
            Image(
                painter = painterResource(imagevar),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun LemonPreview() {
    LemonSquezzeTheme {
        Lemonade()
    }
}