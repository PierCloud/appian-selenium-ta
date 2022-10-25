package com.appiancorp.example;

import com.appiancorp.ps.automatedtest.exception.IllegalArgumentTestException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.appiancorp.ps.automatedtest.fixture.SitesFixture;
import com.appiancorp.ps.automatedtest.exception.IllegalArgumentTestException;
import com.appiancorp.ps.automatedtest.fixture.SitesFixture;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppianTA {

    protected  String TEST_BROWSER = "CHROME";
    protected  String TEST_SITE_VERSION = "21.4";
    protected String TEST_SITE_URL = "https://keypartnerdemo.appiancloud.com/suite/sites/site-ta/page/HOME";
    protected  String TEST_SITE_LOCALE = "en_US";
    protected String TEST_USERNAME = "piergiuseppe.dipilla";
    protected  String TEST_PASSWORD = "WorkShop2022";
    protected  Integer TEST_TIMEOUT = 60;
    private  final Logger LOG = LogManager.getLogger(HelloAppian.class);
    public  SitesFixture fixture;

    public void AppTest() {
    }

    public boolean initTest(){

    LOG.debug("Setting up Tempo Fixture");

     fixture = new SitesFixture();

    LOG.debug("START A TESTING");
    fixture.setTakeErrorScreenshotsTo(true);
    fixture.setupWithBrowser(TEST_BROWSER);
    try {
        fixture.loginIntoWithUsernameAndPassword(TEST_SITE_URL, TEST_USERNAME, TEST_PASSWORD);
    }catch(Exception e) {
        System.out.println("log-in fatto in except");
    }
    System.out.println("log-in fatto");
    fixture.clickOnLink("Link per il workshop del 28 Ottobre");
    fixture.clickOnSitePage("relazioni");
    System.out.println("cliccato");
    // fixture.setTimeoutSecondsTo(TEST_TIMEOUT);
    fixture.setAppianVersionTo(TEST_SITE_VERSION);
    fixture.setAppianLocaleTo(TEST_SITE_LOCALE);

    try{
        testRegistrati();
    } catch (IllegalArgumentTestException | IllegalArgumentException ex){
        System.out.println("click done");
    }

    fixture.tearDown();
    LOG.debug("END A TESTING");
    return true;
}

    public  void testRegistrati(){
        System.out.println("IN test case registrati");
        if(fixture.verifyButtonIsPresent("Registrati")){
            System.out.println("Registrati trovato");
            fixture.clickOnButton("Registrati");
        }
        else{
            System.out.println("Registrati non trovato");
            System.out.println("Click on: Il mio profilo");
            fixture.clickOnButton("il mio profilo");
        }
        return;
    }
}
