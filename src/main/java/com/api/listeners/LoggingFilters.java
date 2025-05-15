package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilters implements Filter {

	private static final Logger logger = LogManager.getLogger(LoggingFilters.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {

		logger.info("Base Uri: " + requestSpec.getBaseUri());
		logger.info("Request Header: " + requestSpec.getHeaders());
		logger.info("Request Payload: " + requestSpec.getBody());

	}

	public void logResponse(Response response) {

		logger.info("Status Code: " + response.statusCode());
		logger.info("Response Header: " + response.headers());
		logger.info("Response Body: " + response.getBody().prettyPrint());

	}

}
