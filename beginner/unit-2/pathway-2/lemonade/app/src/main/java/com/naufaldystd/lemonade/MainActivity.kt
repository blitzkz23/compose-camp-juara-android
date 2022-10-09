package com.naufaldystd.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naufaldystd.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LemonadeTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
				}
			}
		}
	}
}

@Composable
fun LemonadePanel(
	@StringRes stringId: Int,
	@DrawableRes imageId: Int,
	step: Int,
	updateStep: (Int) -> (Unit)
) {
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		content = {
			Text(text = stringResource(stringId))
			Spacer(modifier = Modifier.height(16.dp))
			Image(
				painter = painterResource(id = imageId), contentDescription = "",
				modifier = Modifier
					.wrapContentSize()
					.padding(32.dp)
					.border(BorderStroke(width = 2.dp, color = Color(105, 205, 216)))
					.clip(RoundedCornerShape(4.dp))
					.clickable {
						if (step >= 4) {
							updateStep(step - 3)
						} else {
							updateStep(step + 1)
						}
					}
			)
			Spacer(modifier = Modifier.height(16.dp))
		}
	)
}

@Composable
fun LemonadeApp() {
	var currentStep by remember { mutableStateOf(1) }

	when (currentStep) {
		1 -> {
			LemonadePanel(
				stringId = R.string.lemon_select,
				imageId = R.drawable.lemon_tree,
				step = currentStep,
				updateStep = { newStep ->
					currentStep = newStep
				}
			)
		}
		2 -> {
			LemonadePanel(
				stringId = R.string.lemon_squeeze,
				imageId = R.drawable.lemon_squeeze,
				step = currentStep,
				updateStep = { newStep ->
					currentStep = newStep
				}
			)
		}
		3 -> {
			LemonadePanel(
				stringId = R.string.lemon_drink,
				imageId = R.drawable.lemon_drink,
				step = currentStep,
				updateStep = { newStep ->
					currentStep = newStep
				}
			)
		}
		else -> {
			LemonadePanel(
				stringId = R.string.lemon_empty,
				imageId = R.drawable.lemon_restart,
				step = currentStep,
				updateStep = { newStep ->
					currentStep = newStep
				}
			)
		}
	}
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
	LemonadeTheme {
		LemonadeApp()
	}
}