package com.herokuapp.theinternet.checkboxespagetest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {
        log.info ( "Starting selectingTwoCheckboxesTest" );

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject ( driver, log );
        welcomePage.openPage ( );

        // Click on Checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink ( );
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException ( e );
        }
        // Select All Checkboxes
        checkboxesPage.selectAllCheckboxes ( );
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException ( e );
        }
        // Verify all checkboxes are checked
        Assert.assertTrue ( checkboxesPage.areAllCheckboxesChecked ( ), "Not all checkboxes are checked" );

    }
}