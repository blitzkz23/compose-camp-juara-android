package com.naufaldystd.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naufaldystd.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ComposeBasicsTheme {
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

/**
 * Compose Article
 *
 */
@Composable
fun ArticleSection() {
	Text(
		text = stringResource(R.string.txt_article_header),
		modifier = Modifier.padding(16.dp),
		fontSize = 24.sp
	)
	Text(
		stringResource(R.string.txt_paragraph1),
		modifier = Modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify
	)
	Text(
		text = stringResource(id = R.string.txt_paragraph2),
		modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
		textAlign = TextAlign.Justify
	)
}

@Composable
fun ComposeArticle() {
	val headerImage = painterResource(R.drawable.bg_compose_background)
	Column(modifier = Modifier.fillMaxSize(), content = {
		Image(
			painter = headerImage,
			contentDescription = "Header Image",
			modifier = Modifier.fillMaxWidth()
		)
		ArticleSection()
	})
}

/**
 * Task Manager
 *
 */
@Composable
fun TaskManager() {
	val completedIcon = painterResource(id = R.drawable.ic_task_completed)

	Column(
		modifier = Modifier.fillMaxSize(),
		content = {
			Image(
				painter = completedIcon,
				contentDescription = "Icon Completed"
			)
			Text(
				text = "All tasks completed",
				fontWeight = FontWeight.Bold,
				modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
				fontSize = 24.sp
			)
			Text(
				text = "Nice work!",
				fontSize = 16.sp
			)
		},
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	)
}

/**
 * Compose Quadrant
 *
 */
@Composable
fun ComposeQuadrant() {
	Column(
		modifier = Modifier.fillMaxSize(),
		content = {
			Row(
				modifier = Modifier.weight(0.5F),
				content = {
					Column(
						modifier = Modifier
							.fillMaxHeight()
							.weight(0.5F)
							.background(color = Color.Green),
						content = {
							Text(text = "Text Composable", fontWeight = FontWeight.Bold)
							Text(
								text = "Displays text and follows Material Design guidelines.",
								textAlign = TextAlign.Justify,
								modifier = Modifier.padding(start = 16.dp, end = 16.dp)
							)
						},
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Center
					)
					Column(
						modifier = Modifier
							.fillMaxHeight()
							.weight(0.5F)
							.background(color = Color.Yellow),
						content = {
							Text(text = "Text Composable", fontWeight = FontWeight.Bold)
							Text(
								text = "Displays text and follows Material Design guidelines.",
								textAlign = TextAlign.Justify,
								modifier = Modifier.padding(start = 16.dp, end = 16.dp)
							)
						},
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Center
					)
				})
			Row(
				modifier = Modifier.weight(0.5F),
				content = {
					Column(
						modifier = Modifier
							.fillMaxHeight()
							.weight(0.5F)
							.background(color = Color.Cyan),
						content = {
							Text(text = "Text Composable", fontWeight = FontWeight.Bold)
							Text(
								text = "Displays text and follows Material Design guidelines.",
								textAlign = TextAlign.Justify,
								modifier = Modifier.padding(start = 16.dp, end = 16.dp)
							)
						},
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Center
					)
					Column(
						modifier = Modifier
							.fillMaxHeight()
							.weight(0.5F)
							.background(color = Color.LightGray),
						content = {
							Text(text = "Text Composable", fontWeight = FontWeight.Bold)
							Text(
								text = "Displays text and follows Material Design guidelines.",
								textAlign = TextAlign.Justify,
								modifier = Modifier.padding(start = 16.dp, end = 16.dp)
							)
						},
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Center
					)
				}
			)
		}
	)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeArticlePreview() {
	ComposeBasicsTheme {
		ComposeArticle()
	}
}

@Preview(showSystemUi = true)
@Composable
fun TaskManagerPreview() {
	ComposeBasicsTheme {
		TaskManager()
	}
}

@Preview(showSystemUi = true)
@Composable
fun ComposeQuadrantPreview() {
	ComposeBasicsTheme {
		ComposeQuadrant()
	}
}