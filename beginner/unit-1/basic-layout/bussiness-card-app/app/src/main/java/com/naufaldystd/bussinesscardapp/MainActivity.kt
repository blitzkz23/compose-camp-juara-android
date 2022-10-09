package com.naufaldystd.bussinesscardapp

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naufaldystd.bussinesscardapp.ui.theme.BussinessCardAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			BussinessCardAppTheme {
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
fun ContactSection(modifier: Modifier = Modifier, @DrawableRes iconId: Int, contactText: String) {
	Row(
		modifier = modifier.padding(top = 8.dp),
		horizontalArrangement = Arrangement.Center,
	) {
		Icon(
			painter = painterResource(id = iconId),
			contentDescription = null,
			tint = Color(0xFF3ddc84)
		)
		Spacer(modifier = Modifier.width(16.dp))
		Text(text = contactText, color = Color.White)
	}
}

@Composable
fun BusinessCard() {
	val androidLogo = painterResource(id = R.drawable.android_logo)
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color(0xFF003A4A)),
		content = {
			Row(modifier = Modifier.weight(0.8F)) {
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.fillMaxHeight(),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.Center
				) {
					Image(
						painter = androidLogo,
						contentDescription = "Android Logo",
						Modifier.size(90.dp)
					)
					Text(
						text = "Naufal Aldy Pradana",
						fontSize = 48.sp,
						color = Color.White,
						textAlign = TextAlign.Center,
						modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
					)
					Text(
						"Android Developer Extraordinaire",
						fontSize = 16.sp,
						color = Color(0xFF3ddc84)
					)
				}
			}
			Divider(color = Color.White, thickness = 1.dp)
			ContactSection(
				modifier = Modifier
					.weight(0.05F)
					.fillMaxSize(),
				iconId = R.drawable.ic_baseline_local_phone_24,
				contactText = "+11 (123) 556 666"
			)
			Divider(color = Color.White, thickness = 1.dp)
			ContactSection(
				modifier = Modifier
					.weight(0.05F)
					.fillMaxSize(),
				iconId = R.drawable.ic_baseline_share_24,
				contactText = "@AndroidDev"
			)
			Divider(color = Color.White, thickness = 1.dp)
			ContactSection(
				modifier = Modifier
					.weight(0.1F)
					.fillMaxSize(),
				iconId = R.drawable.ic_baseline_email_24,
				contactText = "jen.doe@android.com"
			)
		}
	)
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
	BussinessCardAppTheme {
		BusinessCard()
	}
}