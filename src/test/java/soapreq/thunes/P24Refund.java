package soapreq.thunes;

import annotations.FrameworkAnnotation;
import constants.FrameworkConstants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import soap.SoapRequest;
import soap.SoapResponse;
import utils.PropertyUtils;

import java.io.File;

public class P24Refund
{

    Response response = null;
    private String merchantUrl = "";
    File requestBody = null;

    @Test
    @FrameworkAnnotation.FrameworkAnnotations(bddScenario = "Make a refund call with all valid values", author = "Badrinarayanan", category = "Thunes")
    public void refundRequestWithValidValues() throws Exception
    {
        response = SoapRequest.post(FrameworkConstants.getSoapPayloadDir()+"/P24-Thunes/P24RefundValidValues.xml", PropertyUtils.get("host"), "/commerce/1.x/transactionProcessor/");

        // Validating the response code
        Assert.assertEquals(response.statusCode(), 200);

        // Validating Currency in the response
        String currency = SoapResponse.getValue(response, "Envelope.Body.replyMessage.purchaseTotals.currency");
        Assert.assertEquals(currency.toUpperCase(),"PLN");

        // Validating the Request id
        String requestId = SoapResponse.getValue(response, "Envelope.Body.replyMessage.requestID");
        Assert.assertEquals(requestId.length(), 22);
        FrameworkConstants.setSaleRequestId(requestId);

        // Validating the Decision
        String decision = SoapResponse.getValue(response, "Envelope.Body.replyMessage.decision");
        Assert.assertEquals(currency.toUpperCase(),"ACCEPT");

        // Validating the Status
        String status = SoapResponse.getValue(response, "Envelope.Body.apRefundReply.status");
        Assert.assertEquals(currency.toUpperCase(),"REFUNDED");
    }
}
