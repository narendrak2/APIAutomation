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
                headers(headers).contentType(ContentType.JSON)
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
        Extentreportmanager.loginfoDetails("Method name is " + queryableRequestSpecification.getHeaders().asList().toString());
        Extentreportmanager.loginfoDetails("request body is ");
        Extentreportmanager.logjosn(queryableRequestSpecification.getBody());
    }
    private static void printLogInResponseReport(Response response) {

        System.out.println("Response status code is " + response.getStatusCode());
        System.out.println("Response headers are " + response.headers());
        System.out.println("Response headers are " + response.getBody().prettyPrint());
        Extentreportmanager.loginfoDetails("Resposne status code is " + response.getStatusCode());
        Extentreportmanager.loginfoDetails("Response headers are " + response.headers().asList().toString());
        Extentreportmanager.loginfoDetails("Response body is");
        Extentreportmanager.logjosn(response.getBody().prettyPrint());
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