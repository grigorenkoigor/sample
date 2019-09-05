package reqres.api.dataHelpers;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {

    private static Faker faker = new Faker();

    public static int getFakerRandomNumberInt(int length) {
        String number = "";
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            number += String.valueOf(rand.nextInt(8) + 1);
        }
        return Integer.parseInt(number);
    }


    public static String getFakerUserName() {
        return faker.name().firstName();
    }

    public static String getFakerUserJob() {
        return faker.job().position();
    }

}
