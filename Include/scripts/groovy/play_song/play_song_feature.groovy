package play_song
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import org.openqa.selenium.Keys as Keys

class play_song_feature {
	@Given("User success access Youtube Music")
	def success_accessYoutubeMusic() {
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//div[@id='left-content']/ytmusic-logo/a/picture/img)[1]"), 3)
		WebUI.takeFullPageScreenshot()
	}

	@When("User find girl group name")
	def find_girlGroupName() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id='input']"), "New Jeans")
		WebUI.sendKeys(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id='input']"), Keys.chord(Keys.ENTER))
		WebUI.takeFullPageScreenshot()
	}

	@And("User click Shuffle button")
	def click_shuffleButton() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='actions']//button[@class='yt-spec-button-shape-next yt-spec-button-shape-next--filled yt-spec-button-shape-next--mono yt-spec-button-shape-next--size-m yt-spec-button-shape-next--icon-leading']//div[@class='yt-spec-touch-feedback-shape__fill']"))
		WebUI.takeFullPageScreenshot()
	}

	@Then("Verify music playing successfully")
	def verify_musicPlayingSuccessfully() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//div[@id='song-media-window'])[2]"), 40)
		WebUI.takeFullPageScreenshot()
	}
}