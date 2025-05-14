package com.api.services;

import com.api.models.requests.TokenRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {

	private static final String BASE_PATH = "auth";

	public Response createToken(TokenRequest payload) {

		return postRequest(payload, BASE_PATH);
	}
}
