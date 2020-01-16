package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SearchTest  extends BaseTest {



    @Test
    @Parameters({"keyword"})
    public void search(String keyword)  {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.goTo();


        //this.driver.findElement(By.xpath("//input[@id='search_form_input_homepage'] ")).sendKeys("Java");
      searchPage.doSearch(keyword);
       searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
    }


}
