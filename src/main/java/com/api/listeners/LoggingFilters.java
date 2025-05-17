package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.utilities.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

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

	private void logRequest(FilterableRequestSpecification requestSpec) {
		StringBuilder reqLog = new StringBuilder();

		reqLog.append("<div style='border:2px solid #3498db; border-radius:5px; padding:10px; margin-bottom:10px;'>")
				.append("<h3 style='color:#2980b9;'>📤 Request Details</h3></div>");

		reqLog.append("<div style='border:1px solid #2980b9; border-radius:5px; padding:8px; margin-bottom:8px;'>")
				.append("<b>URI:</b><br>").append(requestSpec.getURI()).append("</div>");

		reqLog.append("<div style='border:1px solid #2980b9; border-radius:5px; padding:8px; margin-bottom:8px;'>")
				.append("<b>Method:</b><br>").append(requestSpec.getMethod()).append("</div>");

		reqLog.append("<div style='border:1px solid #2980b9; border-radius:5px; padding:8px; margin-bottom:8px;'>")
				.append("<b>Headers:</b><br><ul>");
		requestSpec.getHeaders().asList().forEach(header -> reqLog.append("<li>").append(header.getName()).append(": ")
				.append(header.getValue()).append("</li>"));
		reqLog.append("</ul></div>");

		reqLog.append("<div style='border:1px solid #2980b9; border-radius:5px; padding:8px; margin-bottom:8px;'>")
				.append("<b>Content-Type:</b><br>").append(requestSpec.getContentType()).append("</div>");

		reqLog.append("<div style='border:1px solid #2980b9; border-radius:5px; padding:8px; margin-bottom:8px;'>")
				.append("<b>Body:</b><br><pre>")
				.append(requestSpec.getBody() == null ? "No Body" : requestSpec.getBody()).append("</pre></div>");

		// Console log (plain text only)
		logger.info(reqLog.toString().replaceAll("<[^>]+>", ""));

		// Extent report
		ExtentTest test = ExtentManager.getExtentTest();
		if (test != null) {
			test.info(reqLog.toString());
		}
	}

	private void logResponse(Response response) {
		StringBuilder resLog = new StringBuilder();

		resLog.append("<div style='border:2px solid #27ae60; border-radius:5px; padding:10px; margin-bottom:10px;'>")
				.append("<h3 style='color:#27ae60;'>📥 Response Details</h3></div>");

		resLog.append("<div style='border:1px solid #2ecc71; border-radius:5px; padding:8px; margin-bottom:8px;'>")
				.append("<b>Status Code:</b><br>").append(response.statusCode()).append("</div>");

		resLog.append("<div style='border:1px solid #2ecc71; border-radius:5px; padding:8px; margin-bottom:8px;'>")
				.append("<b>Headers:</b><br><ul>");
		response.getHeaders().asList().forEach(header -> resLog.append("<li>").append(header.getName()).append(": ")
				.append(header.getValue()).append("</li>"));
		resLog.append("</ul></div>");

		resLog.append("<div style='border:1px solid #2ecc71; border-radius:5px; padding:8px; margin-bottom:8px;'>")
				.append("<b>Body:</b><br><pre>").append(response.getBody().prettyPrint()).append("</pre></div>");

		// Console log
		logger.info(resLog.toString().replaceAll("<[^>]+>", ""));

		// Extent report
		ExtentTest test = ExtentManager.getExtentTest();
		if (test != null) {
			test.info(resLog.toString());
		}
	}
}
