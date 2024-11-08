package Airlines;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import Utils.JsonUtils;

public class Base {

    public static Map<String, Object> datafromjsonFile;

    static {

        try {
            datafromjsonFile = JsonUtils.getJsonDataMap("Testdata/Test.json");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
