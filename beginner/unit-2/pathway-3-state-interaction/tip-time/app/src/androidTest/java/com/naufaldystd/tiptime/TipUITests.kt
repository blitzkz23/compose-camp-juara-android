package com.naufaldystd.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.naufaldystd.tiptime.ui.theme.TipTImeTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {
	@get:Rule
	val composeTestRule = createComposeRule()

	@Test
	fun calculate_20_percent_tip() {
		composeTestRule.setContent {
			TipTImeTheme {
				TipTimeScreen()
			}
		}
		composeTestRule.onNodeWithText("Cost Of Service")
			.performTextInput("10")
		composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
		composeTestRule.onNodeWithText("Tip Amount: $2.00").assertExists()
	}
}