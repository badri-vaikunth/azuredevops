package utils;

import java.time.Instant;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;

public class InfluxUtils 
{
	private InfluxUtils()
	{
		
	}
	
	
	public static String token = "XvCaQ4PWPp7HoquQB-GLINwxbMRpyqIUa_UhVxSQUOYsomSvI0VUVJ-9sds_pdgFINRoqyXgswcpVh7Utixgmg==";
	public static String bucket = "selenium";
	public static String org = "altpay";
	
	public static void sendDataToInflux(String testName,String status,String author)
	{
		

	    InfluxDBClient client = InfluxDBClientFactory.create("http://localhost:8086", token.toCharArray());

	    
	    String data = "mem,host=host1 used_percent=23.43234543";

	    com.influxdb.client.write.Point point = com.influxdb.client.write.Point
	    		  .measurement("TestAutomation")
	    		  .addTag("host", "altpay.com")
	    		  .addField("testName", testName)
	    		  .addField("author", author)
	    		  .addField("status", status)
	    		  .time(Instant.now(), WritePrecision.NS);

	    		WriteApiBlocking writeApi = client.getWriteApiBlocking();
	    		writeApi.writePoint(bucket, org, point);
	}
}
