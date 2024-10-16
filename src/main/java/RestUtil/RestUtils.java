package RestUtil;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

	public static Response performPost(String endPoint, Map<String, Object> createairlinePayload, Map<String, Object> headers) {

		return RestAssured.given().
				log().all().
				baseUri(endPoint).
				headers(headers)
				.contentType(ContentType.JSON)
				.body(createairlinePayload).
				post().then().
				log().all()
				.extract().
				response();
	}

	public static Response performPost(String endPoint, String createairlinePayload, HashMap<String, Object> headers) {

		return RestAssured.given().log().all().baseUri(endPoint).headers(headers)
				.contentType(ContentType.JSON).body(createairlinePayload).post().then().log().all().extract().response();
	}

	public static Response performPost(String endpoint, Map<String, Object> createairlinePayload, HashMap<String, Object> headers) {

		return RestAssured.given().log().all().baseUri(endpoint).headers(headers)
				.contentType(ContentType.JSON).body(createairlinePayload).post().then().log().all().extract().response();
	}

	public static Response performPost(String endpoint, Object createairlinePayload, HashMap<String, Object> headers) {

		return RestAssured.given().log().all().baseUri(endpoint).headers(headers)
				.contentType(ContentType.JSON).body(createairlinePayload).post().then().log().all().extract().response();
	}
}