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

def minPrice = '15000000'

def maxPrice = '19000000'

WebUI.openBrowser(GlobalVariable.baseURL + 'search?&q=' + keyword)

WebUI.setText(findTestObject('searchResultPage/input_minPrice'), minPrice)

WebUI.sendKeys(findTestObject('searchResultPage/input_minPrice'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('searchResultPage/input_maxPrice'), maxPrice)

WebUI.sendKeys(findTestObject('searchResultPage/input_maxPrice'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

path = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(path, ((('^' + GlobalVariable.baseURL) + 'search?.*pmax=') + maxPrice + '.*pmin=' + minPrice + '.*'), true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(minPrice, WebUI.getAttribute(findTestObject('searchResultPage/input_minPrice'), 'value').replace('.', ''), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(maxPrice, WebUI.getAttribute(findTestObject('searchResultPage/input_maxPrice'),'value').replace('.', ''), FailureHandling.CONTINUE_ON_FAILURE)
