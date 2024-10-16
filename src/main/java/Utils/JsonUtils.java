package Utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {


    private static ObjectMapper objectmapper = new ObjectMapper();

    public static Map<String, Object> getJsonDataMap(String jsonFileName) throws StreamReadException, DatabindException, IOException {

        System.out.println("some extra");
        System.out.println("some extra");
        System.out.println("some extra");
        System.out.println("some extra"1);
        String completeJsonPath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        Map<String, Object> data = objectmapper.readValue(new File(completeJsonPath), new TypeReference<Map<String, Object>>() {
        });
        return data;

    }
}
