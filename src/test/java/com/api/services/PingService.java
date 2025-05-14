package com.api.services;

import io.restassured.response.Response;

public class PingService extends BaseService {

	public Response healthCheck() {
		
		return getRequest("ping");
	}
	
}
