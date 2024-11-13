package Airlines;

import Airlines.Pojos.Airline;
import Airlines.Pojos.AirlinePoiji;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

import java.io.File;
import java.util.List;

public class Poijitest {

    public static void main(String args[]) {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().addListDelimiter(";").build();
        List<AirlinePoiji> data = Poiji.fromExcel(new File("/Users/narendra/eclipse-workspace/APIAutomation/src/main/resources/Aldar User Stories & Data Table Design - v2.xlsx"), AirlinePoiji.class);
        System.out.println(data);
    }
}
