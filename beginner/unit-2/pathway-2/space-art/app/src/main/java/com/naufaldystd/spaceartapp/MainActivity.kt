package com.naufaldystd.spaceartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naufaldystd.spaceartapp.ui.theme.SpaceArtAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SpaceArtAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					SpaceArtScreen()
				}
			}
		}
	}
}

@Composable
fun ImageFrame(
	@DrawableRes imageId: Int,
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 48.dp, bottom = 24.dp, start = 16.dp, end = 16.dp),
		content = {
			Image(
				painter = painterResource(id = imageId),
				contentDescription = "",
				contentScale = ContentScale.FillBounds,
				modifier = Modifier
					.border(BorderStroke(width = 2.dp, color = Color.Black))
					.padding(32.dp)
			)
		},
		horizontalArrangement = Arrangement.Center
	)
}

@Composable
fun CreatorPanel(
	@StringRes imageTitle: Int,
	@StringRes creator: Int,
	year: Int
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(start = 16.dp, end = 16.dp),
		content = {
			Card(elevation = 8.dp, modifier = Modifier.clip(RoundedCornerShape(8.dp))) {
				Column(
					horizontalAlignment = Alignment.CenterHorizontally,
					modifier = Modifier.padding(24.dp)
				) {
					Text(text = stringResource(imageTitle), fontSize = 28.sp)
					Spacer(modifier = Modifier.height(8.dp))
					Text(buildAnnotatedString {
						withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
							append(stringResource(creator))
						}
						append(" ")
						append("(${year})")
					})
				}
			}
		},
		horizontalArrangement = Arrangement.Center
	)
}

@Composable
fun ButtonPanel(
	modifier: Modifier = Modifier,
	currentArtwork: Int,
	changeArtwork: (Int) -> Unit,
) {
	Row(
		modifier = modifier
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceAround,
		verticalAlignment = Alignment.Bottom
	) {
		Button(onClick = { changeArtwork(currentArtwork - 1) }) {
			Text(text = "Previous")
		}
		Button(onClick = { changeArtwork(currentArtwork + 1) }) {
			Text(text = "Next")
		}
	}
}

@Composable
fun SpaceArtScreen() {
	var currentArtwork by remember {
		mutableStateOf(0)
	}

	Column(
		modifier = Modifier.fillMaxSize(),
		content = {
			when (currentArtwork) {
				-1 -> {
					currentArtwork = 2
				}
				0 -> {
					ImageFrame(
						imageId = R.drawable.img_20211020_033612
					)
					CreatorPanel(
						imageTitle = R.string.stellar_stellar,
						creator = R.string.hoshimachi_suisei,
						year = 2021
					)
				}
				1 -> {
					ImageFrame(
						imageId = R.drawable.img_20211020_033540
					)
					CreatorPanel(
						imageTitle = R.string.kroniiclhles,
						creator = R.string.ouro_kronii,
						year = 2021
					)
				}
				2 -> {
					ImageFrame(
						imageId = R.drawable.unknown_35
					)
					CreatorPanel(
						imageTitle = R.string.kawaiironii,
						creator = R.string.ouro_kronii,
						year = 2021
					)
				}
				3 -> {
					currentArtwork = 0
				}
			}
		},
		verticalArrangement = Arrangement.Center
	)
	ButtonPanel(
		modifier = Modifier.padding(bottom = 32.dp),
		currentArtwork,
		changeArtwork = { newArtwork ->
			currentArtwork = newArtwork
		}
	)
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
	SpaceArtAppTheme {
		SpaceArtScreen()
	}
}