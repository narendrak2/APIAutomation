package Airlines;

import java.util.HashMap;
import java.util.Map;

import Airlines.Pojos.Airline;
import RestUtil.RestUtils;
import io.restassured.response.Response;

import static RestUtil.RestUtils.*;

public class AirlinesAPI {
	
	
	public Response createAirline(Map<String,Object>createairlinePayload) {
		
		String endpoint=(String) Base.datafromjsonFile.get("airLineEndPoint");
		return performPost(endpoint, createairlinePayload,new HashMap<String,Object>());
	}
	public Response createAirline(Airline createairlinePayload) {


		String endpoint=(String) Base.datafromjsonFile.get("airLineEndPoint");
		return performPost(endpoint, createairlinePayload,new HashMap<String,String>());
	}
}
