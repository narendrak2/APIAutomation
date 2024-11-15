package Airlines;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Airlines.Pojos.Airline;
import Reporting.Setup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import RestUtil.RestUtils;
import Utils.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Listeners(Setup.class)
public class AirlineTest extends AirlinesAPI {

    @Test
    public void createairline() throws StreamReadException, DatabindException, IOException {

        Airline payload = Payloads.getcreateAirlinepayloadFromPojo();
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void getAirlines() {
        Airline payload = Payloads.getdatafromForGetRequestFromPOJO();
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
