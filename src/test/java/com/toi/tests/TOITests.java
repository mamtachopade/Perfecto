package com.toi.tests;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.toi.pages.EntertainmentPage;
import com.toi.pages.HomePages;

public class TOITests extends BaseTest {

	HomePages homePage;
	EntertainmentPage entertainmentPage;

	@Override
	@BeforeMethod
	public void startUp() {
		homePage = new HomePages();
		entertainmentPage = new EntertainmentPage();
		super.startUp();
	}

	@Override
	@AfterMethod(alwaysRun = true)
	public void quitApplication() {
		//super.quitApplication();
		new WebDriverTestBase().tearDown();
	}

	@Test
	public void verifyTopNewStories() {
		System.out.println("Done");
	    //homePage.openPage();
		homePage.validateTopStoriesTitle();
		homePage.verifyTopStoriesNewsList();
		homePage.validateTopStoriesNewsPage();

	}

	@Test
	public void verifyEntertainmnetTab() {
		entertainmentPage.verifyEntertainmentPage();
		entertainmentPage.displaylanguageList();
		entertainmentPage.verifyLanguageNewsList();
	}

}
