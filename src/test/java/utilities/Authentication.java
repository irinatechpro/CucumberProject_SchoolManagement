package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    static   String url = ConfigReader.getProperty("authenticationURL");
    //admin
    public static String generateTokenAdmin(){
        Map<String, Object> body = new HashMap<>();
        body.put("username",ConfigReader.getProperty("adminUserName"));
        body.put("password",ConfigReader.getProperty("adminPassword"));
        body.put("rememberMe",true);
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return  response.jsonPath().getString("token");
    }
    //dean
    public static String generateTokenDean(){
        Map<String, Object> body = new HashMap<>();
        body.put("username",ConfigReader.getProperty("deanUserName"));
        body.put("password",ConfigReader.getProperty("deanPassword"));
        body.put("rememberMe",true);
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return  response.jsonPath().getString("token");
    }
    //vice dean
    public static String generateTokenViceDean() {
        Map<String, Object> body = new HashMap<>();
        body.put("username", ConfigReader.getProperty("viceDeanUserName"));
        body.put("password", ConfigReader.getProperty("viceDeanPassword"));
        body.put("rememberMe",true);
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return response.jsonPath().getString("token");
    }
    //teacher
    public static String generateTokenTeacher() {
        Map<String, Object> body = new HashMap<>();
        body.put("username", ConfigReader.getProperty("teacherUserName"));
        body.put("password", ConfigReader.getProperty("teacherPassword"));
        body.put("rememberMe",true);
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return response.jsonPath().getString("token");
    }
    //student
    public static String generateTokenStudent(){
        Map<String, Object> body = new HashMap<>();
        body.put("username",ConfigReader.getProperty("studentUserName"));
        body.put("password",ConfigReader.getProperty("studentPassword"));
        body.put("rememberMe",true);
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return  response.jsonPath().getString("token");
    }


    public static void main(String[] args) {
        System.out.println("generateTokenAdmin() = " + generateTokenAdmin());
        System.out.println("generateTokenDean() = " + generateTokenDean());
        System.out.println("generateTokenViceDean() = " + generateTokenViceDean());
        System.out.println("generateTokenTeacher() = " + generateTokenTeacher());
        System.out.println("generateTokenStudent() = " + generateTokenStudent());
    }


}