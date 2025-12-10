package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{

    private final By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private final By checkboxesLinkLocator = By.linkText("Checkboxes");
    private final By dropdownLinkLocator = By.linkText("Dropdown");
    private final By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private final By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private final By editorLinkLocator = By.linkText("WYSIWYG Editor");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super (driver, log );
    }

    /** Open WelcomePage with it's url */
    public void openPage() {
        String pageUrl = "https://the-internet.herokuapp.com/";
        log.info("Opening page: " + pageUrl );
        openUrl( pageUrl );
        log.info("Page opened!");
    }

    /** Open LoginPage by clicking on Form Authentication Link */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }
    /** Open CheckboxesPage by clicking on Checkboxes Link */
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver, log);
    }
    public WindowsPage clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new WindowsPage(driver, log);
    }
    public EditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking WYSIWYG Editor link on Welcome Page");
        click(editorLinkLocator);
        return new EditorPage(driver, log);
    }
}
