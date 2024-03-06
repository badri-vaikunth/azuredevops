package soap;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.File;

public class SoapResponse
{
    static XmlPath xmlObj = null;
    static String value = "";

    public static String getValue(Response response,String parameter)
    {
        value = "";
        xmlObj = new XmlPath(response.asString());
        value = xmlObj.getString(parameter);
        return value.trim();
    }
}
