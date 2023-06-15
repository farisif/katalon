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

def baseURL = 'https://www.tokopedia.com/'

def keyword = 'oppo find x6 pro'

def path

WebUI.openBrowser((baseURL + 'search?&q=') + keyword)

WebUI.click(findTestObject('searchResultPage/button_sortResult'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('searchResultPage/sortItemButton_biggestPrice'), FailureHandling.STOP_ON_FAILURE)

path = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(path, (('^' + baseURL) + 'search?.*ob=4') + '.*', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual("Harga Tertinggi", WebUI.getText(findTestObject('searchResultPage/button_sortResult')), FailureHandling.CONTINUE_ON_FAILURE)

