import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def keyword = 'oppo find x6 pro'

def path

def appliedSearchKeyword

WebUI.openBrowser(GlobalVariable.baseURL)

WebUI.setText(findTestObject('header/input_SeachProduct'), 'oppo find x6 pro')

WebUI.sendKeys(findTestObject('header/input_SeachProduct'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

path = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE)

appliedSearchKeyword = WebUI.getAttribute(findTestObject('header/input_SeachProduct'), 'value')

WebUI.verifyMatch(path, ((('^' + GlobalVariable.baseURL) + 'search?.*q=') + keyword.split(' ').join('%20')) + '.*', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(appliedSearchKeyword, 'oppo find x6 pro', FailureHandling.CONTINUE_ON_FAILURE)

