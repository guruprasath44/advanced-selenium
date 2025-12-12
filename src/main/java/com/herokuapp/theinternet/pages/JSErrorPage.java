package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class JSErrorPage extends BasePageObject {

    public JSErrorPage(WebDriver driver, Logger log) {
       super(driver, log);
    }

    /** Open JSErrorPage with it's url */
    public void openPage() {
        String pageUrl = "http://the-internet.herokuapp.com/javascript_error";
        log.info("Opening page: " + pageUrl );
        openUrl( pageUrl );
        log.info("Page opened!");
    }
}
