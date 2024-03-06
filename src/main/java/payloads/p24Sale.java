package payloads;

import utils.AppDataUtils;
import utils.PropertyUtils;

public class p24Sale
{
    private static String salePayload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName>Badri</firstName>\n" +
            "                <lastName>R</lastName>\n" +
            "                <street1>Bangalore</street1>\n" +
            "                <city>CHENNAI</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "                <email>test@thunes.com</email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName>Badrinarayanan</firstName>\n" +
            "                <lastName>Raj</lastName>\n" +
            "                <street1>KR</street1>\n" +
            "                <city>Bangalore</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency>"+AppDataUtils.get("currency")+"</currency>\n" +
            "                <grandTotalAmount>20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType>"+AppDataUtils.get("apPaymentType")+"</apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";


    private static String emptyBillToFields = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName></firstName>\n" +
            "                <lastName></lastName>\n" +
            "                <street1></street1>\n" +
            "                <city></city>\n" +
            "                <state></state>\n" +
            "                <postalCode></postalCode>\n" +
            "                <country></country>\n" +
            "                <phoneNumber></phoneNumber>\n" +
            "                <email></email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName>Badrinarayanan</firstName>\n" +
            "                <lastName>Raj</lastName>\n" +
            "                <street1>KR</street1>\n" +
            "                <city>Bangalore</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency>"+AppDataUtils.get("currency")+"</currency>\n" +
            "                <grandTotalAmount>20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType>"+AppDataUtils.get("apPaymentType")+"</apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";


    private static String emptyCurrency = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName>Badri</firstName>\n" +
            "                <lastName>R</lastName>\n" +
            "                <street1>Bangalore</street1>\n" +
            "                <city>CHENNAI</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "                <email>test@thunes.com</email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName>Badrinarayanan</firstName>\n" +
            "                <lastName>Raj</lastName>\n" +
            "                <street1>KR</street1>\n" +
            "                <city>Bangalore</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency></currency>\n" +
            "                <grandTotalAmount>20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType>"+AppDataUtils.get("apPaymentType")+"</apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";



    private static String emptyShipTo = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName>Badri</firstName>\n" +
            "                <lastName>R</lastName>\n" +
            "                <street1>Bangalore</street1>\n" +
            "                <city>CHENNAI</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "                <email>test@thunes.com</email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName></firstName>\n" +
            "                <lastName></lastName>\n" +
            "                <street1></street1>\n" +
            "                <city></city>\n" +
            "                <state></state>\n" +
            "                <postalCode></postalCode>\n" +
            "                <country></country>\n" +
            "                <phoneNumber></phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency>"+AppDataUtils.get("currency")+"</currency>\n" +
            "                <grandTotalAmount>20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType>"+AppDataUtils.get("apPaymentType")+"</apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";


    private static String invalidCurrency = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName>Badri</firstName>\n" +
            "                <lastName>R</lastName>\n" +
            "                <street1>Bangalore</street1>\n" +
            "                <city>CHENNAI</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "                <email>test@thunes.com</email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName>Badrinarayanan</firstName>\n" +
            "                <lastName>Raj</lastName>\n" +
            "                <street1>KR</street1>\n" +
            "                <city>Bangalore</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency>ABC</currency>\n" +
            "                <grandTotalAmount>20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType>"+AppDataUtils.get("apPaymentType")+"</apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";



    private static String longerFirstName = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName>Badrijergjerngjerbgjrebgjerbgrjebgrehjbgerbgujrehbgjuerhjuhreuhguerhguerhguerghujrebreujgbuerhfguerhgfurehfguerjhnvujervbuejrbvujerbhvujrehguherugfherugh</firstName>\n" +
            "                <lastName>R</lastName>\n" +
            "                <street1>Bangalore</street1>\n" +
            "                <city>CHENNAI</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "                <email>test@thunes.com</email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName>Badrinarayanan</firstName>\n" +
            "                <lastName>Raj</lastName>\n" +
            "                <street1>KR</street1>\n" +
            "                <city>Bangalore</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency>"+AppDataUtils.get("currency")+"</currency>\n" +
            "                <grandTotalAmount>20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType>"+AppDataUtils.get("apPaymentType")+"</apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";


    private static String longerPhoneNumber = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName>Badri</firstName>\n" +
            "                <lastName>R</lastName>\n" +
            "                <street1>Bangalore</street1>\n" +
            "                <city>CHENNAI</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789847368546846476847568457698469348538475386847683443873485734856346458684567458674586745867</phoneNumber>\n" +
            "                <email>test@thunes.com</email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName>Badrinarayanan</firstName>\n" +
            "                <lastName>Raj</lastName>\n" +
            "                <street1>KR</street1>\n" +
            "                <city>Bangalore</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency>"+AppDataUtils.get("currency")+"</currency>\n" +
            "                <grandTotalAmount>20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType>"+AppDataUtils.get("apPaymentType")+"</apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";



    private static String negativeAmount = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName>Badri</firstName>\n" +
            "                <lastName>R</lastName>\n" +
            "                <street1>Bangalore</street1>\n" +
            "                <city>CHENNAI</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "                <email>test@thunes.com</email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName>Badrinarayanan</firstName>\n" +
            "                <lastName>Raj</lastName>\n" +
            "                <street1>KR</street1>\n" +
            "                <city>Bangalore</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency>"+AppDataUtils.get("currency")+"</currency>\n" +
            "                <grandTotalAmount>-20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType>"+AppDataUtils.get("apPaymentType")+"</apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";


    private static String emptyPaymentType = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:schemas-cybersource-com:transaction-data-1.{{WSDLVersion}}\">\n" +
            "    <soapenv:Header>\n" +
            "        <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
            "            <wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "                <wsse:Username>"+AppDataUtils.get("soapUsername")+"</wsse:Username>\n" +
            "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+AppDataUtils.get("soapPassword")+"</wsse:Password>\n" +
            "            </wsse:UsernameToken>\n" +
            "        </wsse:Security>\n" +
            "    </soapenv:Header>\n" +
            "    <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "        <requestMessage xmlns=\"urn:schemas-cybersource-com:transaction-data-1.211\">\n" +
            "            <merchantID>"+AppDataUtils.get("soapUsername")+"</merchantID>\n" +
            "            <merchantReferenceCode>refnumb1234</merchantReferenceCode>\n" +
            "            <invoiceHeader>\n" +
            "                <merchantDescriptor>Online Store</merchantDescriptor>\n" +
            "            </invoiceHeader>\n" +
            "            <billTo>\n" +
            "                <firstName>Badri</firstName>\n" +
            "                <lastName>R</lastName>\n" +
            "                <street1>Bangalore</street1>\n" +
            "                <city>CHENNAI</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "                <email>test@thunes.com</email>\n" +
            "            </billTo>\n" +
            "            <shipTo>\n" +
            "                <firstName>Badrinarayanan</firstName>\n" +
            "                <lastName>Raj</lastName>\n" +
            "                <street1>KR</street1>\n" +
            "                <city>Bangalore</city>\n" +
            "                <state>AR</state>\n" +
            "                <postalCode>75001</postalCode>\n" +
            "                <country>FR</country>\n" +
            "                <phoneNumber>+33623456789</phoneNumber>\n" +
            "            </shipTo>\n" +
            "            <purchaseTotals>\n" +
            "                <currency>"+AppDataUtils.get("currency")+"</currency>\n" +
            "                <grandTotalAmount>20</grandTotalAmount>\n" +
            "            </purchaseTotals>\n" +
            "            <apPaymentType></apPaymentType>\n" +
            "            <apSaleService run=\"true\">\n" +
            "                <cancelURL>"+AppDataUtils.get("cancelURL")+"</cancelURL>\n" +
            "                <successURL>"+AppDataUtils.get("successURL")+"</successURL>\n" +
            "                <failureURL>"+AppDataUtils.get("failureURL")+"</failureURL>\n" +
            "            </apSaleService>\n" +
            "        </requestMessage>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";


    public static String getp24SalePayload()
    {
        return salePayload;
    }
    public static String getp24SaleEmptyBillToPayload()
    {
        return emptyBillToFields;
    }
    public static String getp24SaleEmptyCurrencyPayload()
    {
        return emptyCurrency;
    }
    public static String getp24SaleEmptyShipToPayload()
    {
        return emptyShipTo;
    }
    public static String getp24SaleinvalidCurrencyPayload()
    {
        return invalidCurrency;
    }
    public static String getp24SaleLongerFirstNamePayload()
    {
        return longerFirstName;
    }

    public static String getp24SaleLongerPhoneNumberPayload()
    {
        return longerPhoneNumber;
    }

    public static String getp24SaleNegativeAmountPayload()
    {
        return negativeAmount;
    }

    public static String getp24SaleEmptyPaymentTypePayload()
    {
        return emptyPaymentType;
    }
}
