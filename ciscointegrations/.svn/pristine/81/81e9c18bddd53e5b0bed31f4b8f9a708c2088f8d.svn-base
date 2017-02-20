package com.eidiko.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestCalls {

	public void restCall(String exception) {
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream(
					"ciscointegration.properties");
			prop.load(input);
			System.out.println("Exception : " + exception);
			Client client = Client.create();
			WebResource webResource = client
					.resource("https://api.ciscospark.com/v1/messages");
			String body = "{\"roomId\": " + prop.getProperty("roomid")
					+ ",\"text\": \"" + exception + "\"}";
			JSONObject jObj = new JSONObject(body);
			System.out.println(jObj.toString());
			ClientResponse response = webResource
					.header("Content-type", "application/json; charset=utf-8")
					.header("Authorization",
							"Bearer " + prop.getProperty("authentication"))
					.post(ClientResponse.class, jObj.toString());
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
