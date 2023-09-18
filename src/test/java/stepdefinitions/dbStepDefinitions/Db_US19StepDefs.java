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

    @When("get students")
    public void getStudents() throws SQLException {
      statement = connection.createStatement();
      String query = "select * from meet";
      resultSet = statement.executeQuery(query);
    }


    @Then("validate studentID {string}, date {string}, start time {string}, stop time {string}, description {string} is edited")
    public void validateStudentIDDateStartTimeStopTimeDescriptionIsEdited(String studentId, String date, String startTime, String stopTime, String description) throws SQLException {
        resultSet.next();
        String actualDate = resultSet.getString("date");
        String actualDescription = resultSet.getString("description");
        String actualId= resultSet.getString("id");
        String actualStartTime = resultSet.getString("start_time");
        String actualStopTime = resultSet.getString("stop_time");

        assertEquals(date,actualDate);
        assertEquals(description,actualDescription);
        assertEquals(studentId,actualId);
        assertEquals(startTime,actualStartTime);
        assertEquals(stopTime,actualStopTime);

    }
}
