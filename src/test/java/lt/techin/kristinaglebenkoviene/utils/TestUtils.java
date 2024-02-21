package lt.techin.kristinaglebenkoviene.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestUtils {

    public static String getRandomEmail() {
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";

        return RandomStringUtils.random(1, upperLetters)
                + RandomStringUtils.random(6, lowerLetters)
                + RandomStringUtils.random(2, numbers)
                + System.currentTimeMillis()
                + "@one.lt";
    }

    public static String getRandomEmailSimple() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        return ("Kristina" + randomInt + "@one.lt");
    }

    // Sugeneruoti 8 atsitiktinius raidžių simbolius
    public static String getRandomName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    // Sugeneruoti 10 atsitiktinių raidžių ir skaitmenų kombinaciją
    public static String getRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    // Sugeneruoja skaicius nuo 1 iki 99.
    public static String getRandomTwoNumbers() {
        return RandomStringUtils.randomNumeric(1, 2);
    }

    // Nuimame vienetą iš galutinio skaičiaus, kad ribos būtų nuo 1 iki 20
    public static String getRandomNumberFrom1To20() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 21));
    }

}
