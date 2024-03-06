package soapreq.thunes;

import annotations.FrameworkAnnotation;
import constants.FrameworkConstants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import soap.SoapRequest;
import soap.SoapResponse;
import utils.PropertyUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class OneyAuth
{
    Response response = null;

    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an auth call with all valid values", author = "Badrinarayanan", category = "Thunes")
    @Test
    public void authWithAllValidValues() throws Exception
    {

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.parse(new File(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/authValidFields.xml"));

        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/authValidFields.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Currency in the response
        String currency = SoapResponse.getValue(response, "Envelope.Body.replyMessage.purchaseTotals.currency");
        Assert.assertEquals(currency.toUpperCase(),"EUR");

        // Validating the Request id
        String requestId = SoapResponse.getValue(response, "Envelope.Body.replyMessage.requestID");
        Assert.assertEquals(requestId.length(), 22);
        FrameworkConstants.setSessionRequestId(requestId);
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an auth call with  empty currency", author = "Shayma", category = "Thunes")
    public void authRequestWithEmptyCurrency()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/AuthEmptyCurrency.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an auth call with  empty apPaymentType", author = "Shayma", category = "Thunes")
    public void authRequestWithEmptyApPaymentType()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/EmptyApPaymentType.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }



    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an auth call with  invalid preApproval Token", author = "Shayma", category = "Thunes")
    public void authRequestWithInvalidPreApprovalToken()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/AuthInvalidPreApprovalToken.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an auth call with empty preApproval Token", author = "Shayma", category = "Thunes")
    public void authRequestWithEmptyPreApprovalToken()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/AuthEmptyPreApprovalToken.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an auth call with  invalid currencyCode", author = "Shayma", category = "Thunes")
    public void authRequestWithInvalidCurrency()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/AuthInvalidCurrency.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make an auth call with  empty billTo fields", author = "Shayma", category = "Thunes")
    public void authRequestWithEmptyBillToFields()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/AuthEmptyBillToFields.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "MMake an auth call with  empty shipTo fields", author = "Shayma", category = "Thunes")
    public void authRequestWithEmptyShipToFields()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/AuthEmptyShipToFields.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }


    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a auth call with firstName value.length > 60", author = "Shayma", category = "Thunes")
    public void authRequestWithLongFirstName()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/AuthLongerFirstName.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a auth call with phoneNumber value.length > 15", author = "Shayma", category = "Thunes")
    public void authRequestWithLongPhoneNumber()
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/Oney-Thunes/AuthLongerPhoneNumber.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Decision in the response
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(decision.toUpperCase(),"REJECT");
    }

}
