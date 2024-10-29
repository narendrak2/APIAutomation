package Utils;

import com.github.javafaker.Faker;

public class Randomdatagenerator {

    public static Faker faker = new Faker();

    public static String getRandomData(RandomDataType name) {

        switch (name) {
            case firstname:
                return faker.name().firstName();

            case lastname:

                return faker.name().lastName();

            case fullname:

                return faker.name().fullName();

            case country:

                return faker.address().country();

            case city:

                return faker.address().city();
        }
        return null;

    }

}