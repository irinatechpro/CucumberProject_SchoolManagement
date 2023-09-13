package utilities;
import com.github.javafaker.Faker;

public class FakerUtils {

    public static Faker faker = new Faker();
    public static String phoneNumberFaker(){
        String phone=faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999);
        return phone;
    }

    public static String ssnFaker(){
        String ssn=faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999);
        return ssn;
    }

    public static String nameFaker(){
        String name = faker.name().firstName();
        return name;
    }
    public static String surnameFaker(){
        String surname = faker.name().lastName();
        return surname;
    }

    public static String usernameFaker(){
        String username = (faker.name().username()+"team01").substring(0,10);
        return username;
    }

    public static String emailFaker(){
        String email = faker.name().username() + "@gmail.com";
        return email;
    }

    public static String passwordFaker(){
        String password = faker.internet().password(8,10).substring(0,8);
        return password;
    }
    public static String birthPlaceFaker(){
        String birthPlace = faker.country().capital();
        return birthPlace;
    }

    public static String birthDayFaker(){
        String birthDay = "1980-01-01"; //faker.number().numberBetween(1970,2000) + "-01-01";
        return birthDay;
    }
    public static Integer creditScoreFaker(){
        return Faker.instance().number().numberBetween(1,100);
    }
    public static String lessonFaker(){
        return Faker.instance().programmingLanguage().name();
    }

    public static Integer lessonIDFaker(){
        return Faker.instance().number().randomDigit();
    }

    public static void main(String[] args) {
        System.out.println("passwordFaker() = " + passwordFaker());
        System.out.println("emailFaker() = " + emailFaker());
        System.out.println("usernameFaker() = " + usernameFaker());
        System.out.println("birthPlaceFaker() = " + birthPlaceFaker());
        System.out.println("phoneNumberFaker() = " + phoneNumberFaker());
        System.out.println("ssnFaker() = " + ssnFaker());
        System.out.println("nameFaker() = " + nameFaker());
        System.out.println("surnameFaker() = " + surnameFaker());
        System.out.println("birthDayFaker() = " + birthDayFaker());


    }

}
