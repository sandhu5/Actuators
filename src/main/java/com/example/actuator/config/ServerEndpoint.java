package com.example.actuator.config;

import java.lang.annotation.Annotation;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="server")
public class ServerEndpoint implements Endpoint {

	public List<String> invoke() {
		List<String> serverDetails = new ArrayList<String>();
		try {
			serverDetails.add("Server IP Address : " + InetAddress.getLocalHost().getHostAddress());
			serverDetails.add("Server OS : " + System.getProperty("os.name").toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverDetails;
	}

	public boolean isEnabled() {
		return true;
	}

	public boolean isSensitive() {
		return false;
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String id() {
		return "server";
	}

	@Override
	public boolean enableByDefault() {
		return true;
	}

}
