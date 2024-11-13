package Airlines;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

import Airlines.Pojos.Airline;

import static Utils.Randomdatagenerator.faker;


public class Payloads {


    public static String getpayloads(String id, String name, String country, String logo, String slogan, String headquaters, String website, String established) {

        String payload = "\"_id\":" + id + "\",\n" +
                "    \"name\": " + name + ",\n" +
                "    \"country\": " + country + ",\n" +
                "    \"logo\": " + logo + "\n" +
                "    \"slogan\": " + slogan + ",\n" +
                "    \"head_quaters\": " + headquaters + ",\n" +
                "    \"website\":" + website + ",\n" +
                "    \"established\":" + established + ",\n";
        return payload;
    }

    public static Map<String, Object> getpayload(String id, String name, String country, String logo, String slogan, String headquaters, String website, String established) {

        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("name", name);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("headquaters", headquaters);
        payload.put("website", website);
        payload.put("established", established);
        return payload;
    }

    public static Map<String, Object> getpayload() {

        Map<String, Object> payload = new HashMap<>();
        Faker faker = new Faker();
        payload.put("id", faker.number().digits(10));
        payload.put("name", faker.name().firstName());
        payload.put("country", faker.address().country());
        payload.put("logo", RandomStringUtils.randomAlphabetic(6));
        payload.put("slogan", RandomStringUtils.randomAlphabetic(6));
        payload.put("headquaters", faker.address().city());
        payload.put("website", "https://" + RandomStringUtils.randomAlphabetic(6) + ".com");
        payload.put("established", faker.number().numberBetween(1880, 1990));
        return payload;
    }

    public static Airline getcreateAirlinepayloadFromPojo() {

        return Airline.builder().id(Integer.parseInt(faker.number().digits(6))).name(faker.name().firstName()).country(faker.address().country()).logo(RandomStringUtils.randomAlphabetic(6)).slogan(RandomStringUtils.randomAlphabetic(6)).headquoters(faker.address().city()).website("https://" + RandomStringUtils.randomAlphabetic(6) + ".com").established(String.valueOf(faker.number().numberBetween(1880, 1990))).build();
    }

    public static Airline getdatafromForGetRequestFromPOJO() {

        return Airline.builder().id(Integer.parseInt(faker.number().digits(6))).name(faker.name().firstName()).country(faker.address().country()).logo(RandomStringUtils.randomAlphabetic(6)).slogan(RandomStringUtils.randomAlphabetic(6)).headquoters(faker.address().city()).website("https://" + RandomStringUtils.randomAlphabetic(6) + ".com").established(String.valueOf(faker.number().numberBetween(1880, 1990))).build();
    }
}
