package day04;

import com.github.javafaker.Faker;

public class FakerTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        //create an object of Faker class
        String fact = faker.chuckNorris().fact();
        //create a string of random methods

        System.out.println(fact);
        System.out.println(faker.artist().name());
        //another method of Faker class

        String str=faker.hitchhikersGuideToTheGalaxy().character();

    }
}