package com.naufaldystd.happybirthdayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naufaldystd.happybirthdayapp.ui.theme.HappyBirthdayAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			HappyBirthdayAppTheme {
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
fun BirthdayGreetingWithText(message: String, from: String) {
	Column(
		// Content composable bisa dipass sebagai lambda function selain function scope biasa.
		content = {
			Text(
				text = message, fontSize = 32.sp,
				modifier = Modifier
					.fillMaxWidth()
					.wrapContentWidth(Alignment.CenterHorizontally)
					.padding(start = 16.dp, top = 16.dp)

			)
			Text(
				text = from, fontSize = 24.sp, modifier = Modifier
					.fillMaxWidth()
					.wrapContentWidth(Alignment.CenterHorizontally)
					.padding(start = 16.dp, end = 16.dp)
			)
		},

		)
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
	val image = painterResource(id = R.drawable.androidparty)

	// Box digunakan untuk stack element
	Box {
		Image(
			painter = image,
			contentDescription = "Gambar bg",
			modifier = Modifier
				.fillMaxHeight()
				.fillMaxWidth(),
			contentScale = ContentScale.Crop
		)
		BirthdayGreetingWithText(message = message, from = from)
	}
}

@Preview(name = "Sebuah Preview", showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
	HappyBirthdayAppTheme {
		BirthdayGreetingWithImage(
			message = stringResource(R.string.txt_hbd), from = stringResource(
				R.string.txt_from
			)
		)
	}
}