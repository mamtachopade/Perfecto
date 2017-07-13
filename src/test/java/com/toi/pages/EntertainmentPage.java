package com.toi.pages;

import java.util.List;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class EntertainmentPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	HomePages homepage = new HomePages();

	@FindBy(locator = "entertainment.title.text")
	private QAFWebElement entertainmentTitleText;
	@FindBy(locator = "entertainment.language.list")
	private List<QAFWebElement> entertainmentlanguageList;
	@FindBy(locator = "page.back.button")
	private QAFWebElement pageBackButton;
	@FindBy(locator = "news.list")
	private List<QAFWebElement> newslist;

	public List<QAFWebElement> getEntertainmentlanguageList() {
		return entertainmentlanguageList;
	}

	public QAFWebElement getEntertainmentTitleText() {
		return entertainmentTitleText;
	}

	public QAFWebElement getPageBackButton() {
		return pageBackButton;
	}

	public List<QAFWebElement> getNewslist() {
		return newslist;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	public void verifyEntertainmentPage() {
		homepage.clickOnUpButton();
		homepage.clickOnEntertainmentTab();
		getEntertainmentTitleText().verifyPresent("Entertainment tilte");
	}

	public void displaylanguageList() {
		
		for (QAFWebElement element : getEntertainmentlanguageList()) {
			
			Reporter.log(element.getText());
		}
	}

	public void verifyLanguageNewsList() {
		for (int i = 0; i < getEntertainmentlanguageList().size(); i++) {
			Reporter.log("News For Language "+getEntertainmentlanguageList().get(i).getText());
			getEntertainmentlanguageList().get(i).click();
			
			QAFTestBase.pause(8000);
			
			for (QAFWebElement element : getNewslist()) {
				Reporter.log(element.getText());
			}
			getPageBackButton().click();
			getEntertainmentTitleText().verifyPresent();
		}
	}
	

}
