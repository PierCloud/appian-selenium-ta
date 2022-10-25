package com.appiancorp.example;

import com.appiancorp.ps.automatedtest.exception.GenericTestException;
import com.appiancorp.ps.automatedtest.exception.IllegalArgumentTestException;
import com.appiancorp.ps.automatedtest.exception.TimeoutStopTestException;
import com.appiancorp.ps.automatedtest.exception.TimeoutTestException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.appiancorp.ps.automatedtest.fixture.SitesFixture;
import org.openqa.selenium.TimeoutException;

import java.sql.SQLOutput;

public class HelloAppian {
  protected static String TEST_BROWSER = "CHROME";
  protected static String TEST_SITE_VERSION = "21.4";
  protected static String TEST_SITE_URL = "https://keypartnerdemo.appiancloud.com/suite/sites/site-ta/page/HOME";
  protected static String TEST_SITE_LOCALE = "en_US";
  protected static String TEST_USERNAME = "piergiuseppe.dipilla";
  protected static String TEST_PASSWORD = "WorkShop2022";
  protected static Integer TEST_TIMEOUT = 60;

  private static final Logger LOG = LogManager.getLogger(HelloAppian.class);
  public static SitesFixture fixture;

  public static void main(String[] args) {
    LOG.debug("Setting up Tempo Fixture");

    fixture = new SitesFixture();

    LOG.debug("START A TESTING");
    // fixture.setTakeErrorScreenshotsTo(true);
    fixture.setupWithBrowser(TEST_BROWSER);
    try {
      fixture.loginIntoWithUsernameAndPassword(TEST_SITE_URL, TEST_USERNAME, TEST_PASSWORD);
    } catch (GenericTestException ex) {
      LOG.debug("ERROR TIME BUT LOG-IN DONE");
    }
    fixture.clickOnLink("Link per il workshop del 28 Ottobre");
    fixture.clickOnSitePage("relazioni");

    fixture.setTimeoutSecondsTo(TEST_TIMEOUT);
    fixture.setAppianVersionTo(TEST_SITE_VERSION);
    fixture.setAppianLocaleTo(TEST_SITE_LOCALE);

    try {
      testRegistrati();
    } catch (IllegalArgumentException ex) {
      LOG.debug("ERROR TIME BUT CLICK DONE");
    }

    // fixture.tearDown();
    LOG.debug("END A TESTING");
    System.out.println("END A TESTING");
  }

  public static void testRegistrati() {
    System.out.println("IN test case registrati");
    try {
      if (fixture.verifyButtonIsPresent("Registrati")) {

        System.out.println("Registrati trovato");
        try {
          fixture.clickOnButton("Registrati");
        } catch (IllegalArgumentTestException | IllegalArgumentException ex) {
          LOG.debug("ERROR TIME BUT CLICK DONE");
        }
      }
      }catch(TimeoutException | TimeoutTestException er){
      System.out.println("in");
        LOG.debug("REGISTRATI NON TROVATO");
        LOG.debug("START CLICK ON : il mio profilo");
        try{
          fixture.clickOnCard("il mio profilo");
        } catch (IllegalArgumentTestException | IllegalArgumentException test){
          LOG.debug("error time");
        }


      }

    }

  }

