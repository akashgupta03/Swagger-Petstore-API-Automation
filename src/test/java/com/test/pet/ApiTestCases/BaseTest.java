package com.test.pet.ApiTestCases;


import com.test.pet.reports.ExtentReport;
import com.test.pet.reports.LogStatus;
import com.test.pet.utils.Constants;
import io.restassured.RestAssured;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.Properties;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {

    protected StringWriter writer;
    protected PrintStream captor;


    /*
     * Initializing the extent report
     * @author Akash Gupta
     */
    //LoginPage loginPage;
    @BeforeSuite
    public void setUpSuite() {
        ExtentReport.initialize();
    }

    /*
     * Flushing the extent report
     * Opening the extent report automatically after the test suite execution.
     * @author akash gupta
     */

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReport.report.flush();
        File htmlFile = new File(Constants.EXTENTREPORTPATH);
        Desktop.getDesktop().browse(htmlFile.toURI());

    }

    /*
     * This method helps to write the request and response to the extent report
     * @author akash gupta
     */
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = Properties.baseUri;
        writer = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writer), true);
    }


    protected void formatAPIAndLogInReport(String content) {

        String prettyPrint = content.replace("\n", "<br>");
        LogStatus.info("<pre>" + prettyPrint + "</pre>");

    }


    /*
     * Read the json file and convert to String
     * @author : akash gupta
     * @param  : filepath
     */
    public String generateStringFromResource(String path) throws IOException {
        String temp = "";
        try {
            temp = new String(Files.readAllBytes(Paths.get(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;

    }

    public void
    writeRequestAndResponseInReport(String request, String response) {

        LogStatus.info("---- Request ---");
        formatAPIAndLogInReport(request);
        LogStatus.info("---- Response ---");
        formatAPIAndLogInReport(response);
    }

}
