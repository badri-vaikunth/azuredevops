package soapreq.thunes;

import annotations.FrameworkAnnotation;
import constants.FrameworkConstants;
import driver.DriverManager;
import driver.SeleniumDriver;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.p24Sale;
import reporting.ExtentLogger;
import soap.SoapRequest;
import soap.SoapResponse;
import utils.PropertyUtils;

public class P24Sale
{
    Response response = null;
    RequestSpecification requestSpecification = null;

    private String merchantUrl = "";
    private String requestBody = "";
    //File requestBody = null;

    @BeforeClass(alwaysRun = true)
    public void initSelenimDriver()
    {
        try
        {
            SeleniumDriver.initDriver(System.getProperty("Browser"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a Sale call with all valid values", author = "Badrinarayanan", category = "Thunes")
    public void saleRequestWithValidValues()
    {
        requestBody = p24Sale.getp24SalePayload();
        response = SoapRequest.post(p24Sale.getp24SalePayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SalePayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Fetching the Merchant URL
        merchantUrl = SoapResponse.getValue(response, "Envelope.Body.replyMessage.apSaleReply.merchantURL");
        Assert.assertNotEquals(merchantUrl,"");
        DriverManager.getDriver().get(merchantUrl);


        // Validating Currency in the response
        String currency = SoapResponse.getValue(response, "Envelope.Body.replyMessage.purchaseTotals.currency");
        Assert.assertEquals(currency.toUpperCase(),"PLN");

        // Validating the Request id
        String requestId = SoapResponse.getValue(response, "Envelope.Body.replyMessage.requestID");
        Assert.assertEquals(requestId.length(), 22);
        FrameworkConstants.setSaleRequestId(requestId);

    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a sale call with empty currency", author = "Badrinarayanan", category = "Thunes")
    public void saleRequestWithEmptyCurrency()
    {
        requestBody = p24Sale.getp24SaleEmptyCurrencyPayload();
        response = SoapRequest.post(p24Sale.getp24SaleEmptyCurrencyPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SaleEmptyCurrencyPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a sale call with invalid currency", author = "Shayma", category = "Thunes")
    public void saleRequestWithInvalidCurrency()
    {
        requestBody = p24Sale.getp24SaleinvalidCurrencyPayload();
        response = SoapRequest.post(p24Sale.getp24SaleinvalidCurrencyPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SaleinvalidCurrencyPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a sale call with negative amount", author = "Shayma", category = "Thunes")
    public void saleRequestWithNegativeAmount()
    {
        requestBody = p24Sale.getp24SaleNegativeAmountPayload();
        response = SoapRequest.post(p24Sale.getp24SaleNegativeAmountPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SaleNegativeAmountPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a sale call with empty apPayment Type", author = "Shayma", category = "Thunes")
    public void saleRequestWithEmptyApPaymentType()
    {
        requestBody = p24Sale.getp24SaleEmptyPaymentTypePayload();
        response = SoapRequest.post(p24Sale.getp24SaleEmptyPaymentTypePayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SaleEmptyPaymentTypePayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an sale call with  empty billTo fields", author = "Shayma", category = "Thunes")
    public void saleRequestWithEmptyBillToFields()
    {
        requestBody = p24Sale.getp24SaleEmptyBillToPayload();
        response = SoapRequest.post(p24Sale.getp24SaleEmptyBillToPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SaleEmptyBillToPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an sale call with  empty shipTo fields", author = "Shayma", category = "Thunes")
    public void saleRequestWithEmptyShipToFields()
    {
        requestBody = p24Sale.getp24SaleEmptyShipToPayload();
        response = SoapRequest.post(p24Sale.getp24SaleEmptyShipToPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SaleEmptyShipToPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a sale call with firstName value.length > 60", author = "Shayma", category = "Thunes")
    public void saleRequestWithLongerFirstNameLength()
    {
        requestBody = p24Sale.getp24SaleLongerFirstNamePayload();
        response = SoapRequest.post(requestBody, PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SaleLongerFirstNamePayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a sale call with phoneNumber value.length > 15", author = "Shayma", category = "Thunes")
    public void saleRequestWithLongerPhoneNumberLength()
    {
        requestBody = p24Sale.getp24SaleLongerPhoneNumberPayload();
        response = SoapRequest.post(requestBody, PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");
        requestSpecification = SoapRequest.exportToReport(p24Sale.getp24SaleLongerPhoneNumberPayload(), PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        if (result.getStatus() == ITestResult.FAILURE)
        {
            ExtentLogger.fail("Endpoint is : " + queryableRequestSpecification.getBaseUri());
            ExtentLogger.fail("Headers are : " + queryableRequestSpecification.getHeaders());
            ExtentLogger.fail("Request is:<br> " + "<textarea>" + requestBody + "</textarea>");
            ExtentLogger.fail("Response is:<br>" + "<textarea>" + response.prettyPrint() + "</textarea>");
        }
        else
        {
            ExtentLogger.pass("Endpoint is : " + queryableRequestSpecification.getBaseUri());
            ExtentLogger.pass("Headers are : " + queryableRequestSpecification.getHeaders());
            ExtentLogger.pass("Request is:<br> " + "<textarea>" + requestBody + "</textarea>");
            ExtentLogger.pass("Response is:<br>" + "<textarea>" + response.prettyPrint() + "</textarea>");
        }
    }

    @AfterClass(alwaysRun = true)
    public void quitSelenimDriver()
    {
        SeleniumDriver.quitDriver();
    }

}


