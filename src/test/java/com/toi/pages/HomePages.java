package com.toi.pages;

import java.util.List;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class HomePages extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "toi.homepage.header")
	private QAFWebElement pageTitle;

	@FindBy(locator = "toi.top.stories.title")
	private QAFWebElement topStoriesTitle;

	@FindBy(locator = "toi.stories.news.list")
	private List<QAFWebElement> topStoriesNewsList;
	
	@FindBy(locator="top.stories.new.page.back.button")
	private QAFWebElement topStoriesNewsPageBackButton;
	
	@FindBy(locator="top.stories.news.title")
	private QAFWebElement topStoriesNewsTitle;
	
	@FindBy(locator="home.page.category.button")
	private QAFWebElement homePageCategoryButton;
	
	@FindBy(locator="home.page.category.list")
	private List<QAFWebElement> homePageCategoryList;
	
	

	public QAFWebElement getPageTitle() {
		return pageTitle;
	}

	public QAFWebElement getTopStoriesTitle() {
		return topStoriesTitle;
	}

	public List<QAFWebElement> getTopStoriesNewsList() {
		return topStoriesNewsList;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
	}

    public void pageActive() {
		getTopStoriesTitle().waitForPresent(40000);
	}

	public void openPage() {
		getPageTitle().verifyPresent("Page Title");
	}

	public QAFWebElement getTopStoriesNewsPageBackButton() {
		return topStoriesNewsPageBackButton;
	}

	public QAFWebElement getTopStoriesNewsTitle() {
		return topStoriesNewsTitle;
	}

	public QAFWebElement getHomePageCategoryButton() {
		return homePageCategoryButton;
	}

	public List<QAFWebElement> getHomePageCategoryList() {
		return homePageCategoryList;
	}
    
	public void validateTopStoriesTitle() {
		getTopStoriesTitle().verifyPresent("Verifying Title");
		Reporter.log("Top Stories text titile is" + getTopStoriesTitle().getText(), MessageTypes.Info);
		Validator.verifyThat("The Top new Stories Title ", getTopStoriesTitle().getText(),
				Matchers.containsString("TOP STORIES"));

	}
    public void verifyTopStoriesNewsList()
    { 
    	for(int i=0;i<getTopStoriesNewsList().size();i++)
    	{
    	  Reporter.log("Top Stories News "+i+ getTopStoriesNewsList().get(i).getText(), MessageTypes.Info);
    	}
    	
    }
    public void validateTopStoriesNewsPage()
    {
    	for(int i=0;i<getTopStoriesNewsList().size();i++)
    	{
    	   getTopStoriesNewsList().get(i).click();
    	   getTopStoriesNewsTitle().waitForPresent(50000);
    	   Reporter.log("news Page is "+getTopStoriesNewsTitle().getText(), MessageTypes.Info);
    	   getTopStoriesNewsPageBackButton().click();
    	   getTopStoriesTitle().verifyPresent("Verifying Title");
       	   Validator.verifyThat("The Top new Stories Title ", getTopStoriesTitle().getText(),
   				Matchers.containsString("TOP STORIES"));

    	}
    	
    }
    public void clickOnUpButton()
    {
    	getHomePageCategoryButton().verifyPresent("App drawer");
    	getHomePageCategoryButton().click();
    }
    public void clickOnEntertainmentTab()
    {
    	for(int i=0;i<getHomePageCategoryList().size();i++)
		{
			if(getHomePageCategoryList().get(i).getText().contains("Entertainment"))
				getHomePageCategoryList().get(i).click();
		}
		
    }
}
