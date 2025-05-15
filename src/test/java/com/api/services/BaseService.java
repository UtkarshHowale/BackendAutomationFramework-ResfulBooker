package com.api.services;

import static io.restassured.RestAssured.*;

import com.api.listeners.LoggingFilters;

import static com.constants.Environments.*;
import static com.utilities.PropertiesUtil.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URL = readProperty(PROD, "BASE_URL");
	private RequestSpecification requestSpecification;
	
	static {
		
		RestAssured.filters(new LoggingFilters());
	}

	public BaseService() {

		requestSpecification = given().baseUri(BASE_URL);
	}

	protected Response getRequest(String endpoint) {

		return requestSpecification.get(endpoint);
	}

	// Object is a parent class of all model classes, so this will work same for all
	// the classes of model package
	protected Response postRequest(Object payload, String endpoint) {

		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response putRequest(Object payload, String endpoint) {

		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

	protected Response deleteRequest(String endpoint) {

		return requestSpecification.delete(endpoint);
	}

	protected void setAuthToken(String token) {

		requestSpecification.cookie("token", token);
	}
}
