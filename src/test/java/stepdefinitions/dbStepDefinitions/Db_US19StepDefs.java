package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Db_US19StepDefs {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Given("connect to database for DB")
    public void connectToDatabaseForDB() throws SQLException {
      connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management","select_user","43w5ijfso");

    }

    @When("get student via name")
    public void getStudentViaName() throws SQLException {
      statement = connection.createStatement();
      String query = "select * from meet";
      resultSet = statement.executeQuery(query);
    }


    @Then("validate student, date of meet, start time, stop time, description is edited")
    public void validateStudentDateOfMeetStartTimeStopTimeDescriptionIsEdited() throws SQLException {
        resultSet.next();
        String actualDate = resultSet.getString("date");
        String actualDescription = resultSet.getString("description");
        String actualId= resultSet.getString("id");
        String actualStartTime = resultSet.getString("start_time");
        String actualStopTime = resultSet.getString("stop_time");

        assertEquals("2026-09-01",actualDate);
        assertEquals("Test Results",actualDescription);
        assertEquals("534",actualId);
        assertEquals("10:19:00",actualStartTime);
        assertEquals("11:30:00",actualStopTime);

    }
}
