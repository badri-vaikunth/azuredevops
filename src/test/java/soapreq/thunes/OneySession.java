package soapreq.thunes;

import annotations.FrameworkAnnotation;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import driver.DriverManager;
import driver.SeleniumDriver;
import io.restassured.path.xml.XmlPath;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.Test;

import constants.FrameworkConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import reporting.ExtentLogger;
import reporting.ExtentManager;
import soap.SoapRequest;
import soap.SoapResponse;
import utils.PropertyUtils;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import static io.restassured.RestAssured.given;

public class OneySession
{
    Response response = null;
    private String merchantUrl = "";
    File requestBody = null;

    @BeforeClass(alwaysRun = true)
    public void initSelenimDriver()
    {
//        try
//        {
//            SeleniumDriver.initDriver(System.getProperty("Browser"));
//        }
//        catch (MalformedURLException e)
//        {
//            e.printStackTrace();
//        }
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a session call with all valid values", author = "Badrinarayanan", category = "Thunes")
    public void sessionRequestWithValidValues()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/session.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Currency in the response
        String currency = SoapResponse.getValue(response, "Envelope.Body.replyMessage.purchaseTotals.currency");
        Assert.assertEquals(currency.toUpperCase(),"EUR");

        // Validating the Request id
        String requestId = SoapResponse.getValue(response, "Envelope.Body.replyMessage.requestID");
        Assert.assertEquals(requestId.length(), 22);
        FrameworkConstants.setSessionRequestId(requestId);

        // Validating the Processor Token
        String processorToken = SoapResponse.getValue(response, "Envelope.Body.replyMessage.requestID");
        Assert.assertEquals(requestId.length(), 22);
        FrameworkConstants.setSessionRequestId(requestId);

//        // Make the payment
//        String merchantUrl = SoapResponse.getValue(response, "Envelope.Body.replyMessage.apSaleReply.merchantURL");
//        DriverManager.getDriver().get(merchantUrl);
//        try
//        {
//            Thread.sleep(10000);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }

    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a session call with empty currency", author = "Badrinarayanan", category = "Thunes")
    public void sessionRequestWithEmptyCurrency()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/EmptyCurrency.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a session call with invalid currency", author = "Shayma", category = "Thunes")
    public void sessionRequestWithInvalidCurrency()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/InvalidCurrency.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a session call with negative amount", author = "Shayma", category = "Thunes")
    public void sessionRequestWithNegativeAmount()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/NegativeAmount.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a session call with empty apPayment Type", author = "Shayma", category = "Thunes")
    public void sessionRequestWithEmptyApPaymentType()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/EmptyApPayment.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an session call with  empty billTo fields", author = "Shayma", category = "Thunes")
    public void sessionRequestWithEmptyBillToFields()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/SessionEmptyBillToFields.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an session call with  empty shipTo fields", author = "Shayma", category = "Thunes")
    public void sessionRequestWithEmptyShipToFields()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/SessionEmptyShipToFields.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a session call with firstName value.length > 60", author = "Shayma", category = "Thunes")
    public void sessionRequestWithLongerFirstNameLength()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/LongerFirstName.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a session call with phoneNumber value.length > 15", author = "Shayma", category = "Thunes")
    public void sessionRequestWithLongerPhoneNumberLength()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/LongerPhoneNumber.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }
    @AfterClass(alwaysRun = true)
    public void quitSelenimDriver()
    {
        //SeleniumDriver.quitDriver();
    }

}
