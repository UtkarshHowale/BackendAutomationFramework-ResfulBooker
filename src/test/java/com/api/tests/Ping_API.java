package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.services.PingService;

import io.restassured.response.Response;

@Listeners(com.api.filters.TestListener.class)
public class Ping_API {

	@Test
	public void testHealthCheckAPI() {

		PingService pingService = new PingService();
		Response response = pingService.healthCheck();
		System.out.println(response.asPrettyString());
	}
}
