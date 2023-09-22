package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;

import java.sql.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class Db_US19StepDefs {
    //Connection connection;
    //Statement statement;
    ResultSet resultSet;
    @Given("connect to database for DB")
    public void connectToDatabaseForDB() throws SQLException {
      //connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management","select_user","43w5ijfso");

    }

    @When("get students")
    public void getStudents() throws SQLException {
      //statement = connection.createStatement();
      String query = "select * from meet";
      resultSet = DBUtils.executeQuery(query);
    }


    @Then("validate studentID, date, start time, stop time, description is edited")
    public void validateStudentIDDateStartTimeStopTimeDescriptionIsEdited() throws SQLException {
        resultSet.next();
        String actualDate = resultSet.getString("date");
        String actualDescription = resultSet.getString("description");
        String actualId= resultSet.getString("id");
        String actualStartTime = resultSet.getString("start_time");
        String actualStopTime = resultSet.getString("stop_time");

        assertFalse(actualDate.isEmpty());
        assertFalse(actualDescription.isEmpty());
        assertFalse(actualId.isEmpty());
        assertFalse(actualStartTime.isEmpty());
        assertFalse(actualStopTime.isEmpty());
    }

    @And("close the connection for US19")
    public void closeTheConnection() {
        DBUtils.closeConnection();
    }
}
