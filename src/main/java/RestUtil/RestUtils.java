package RestUtil;

import java.util.HashMap;
import java.util.Map;

import Reporting.Extentreportmanager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class RestUtils {


    private static RequestSpecification getRequestSpecification(String endPoint, Object createairlinePayload, Map<String, String> headers) {

        return RestAssured.given().
                baseUri(endPoint).
                headers(headers)
                .contentType(ContentType.JSON)
                .body(createairlinePayload);

    }

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


    private static void PrintrequestloginReport(RequestSpecification requestSpecification) {

        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        Extentreportmanager.loginfoDetails("End point is " + queryableRequestSpecification.getBaseUri());
        Extentreportmanager.loginfoDetails("Method name is " + queryableRequestSpecification.getMethod());
    }

    private static void printLogInResponseReport(Response response) {

        Extentreportmanager.loginfoDetails("Resposne status code is " + response.getStatusCode());
        Extentreportmanager.loginfoDetails("Response headers are " + response.headers());
        Extentreportmanager.loginfoDetails("Response headers are " + response.body());
    }

    //public static Response performPost(String endPoint, String createairlinePayload, HashMap<String, Object> headers) {

    //return RestAssured.given().log().all().baseUri(endPoint).headers(headers)
    // .contentType(ContentType.JSON).body(createairlinePayload).post().then().log().all().extract().response();
    //}

    public static Response performPost(String endpoint, Map<String, Object> createairlinePayload, HashMap<String, Object> headers) {
        return RestAssured.given().log().all().baseUri(endpoint).headers(headers)
                .contentType(ContentType.JSON).body(createairlinePayload).post().then().log().all().extract().response();
    }

    //public static Response performPost(String endpoint, Object createairlinePayload, HashMap<String, Object> headers) {
        //return RestAssured.given().log().all().baseUri(endpoint).headers(headers)
                //.contentType(ContentType.JSON).body(createairlinePayload).post().then().log().all().extract().response();
    //}

    public static Response performPost(String endpoint, Object createairlinePayload, HashMap<String, String> headers) {
        RequestSpecification specification = getRequestSpecification(endpoint, createairlinePayload, headers);
		Response response=specification.post();
        PrintrequestloginReport(specification);
		printLogInResponseReport(response);
		return response;
    }
}