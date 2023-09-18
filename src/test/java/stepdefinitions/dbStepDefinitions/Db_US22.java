package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.JDBCUtils;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class Db_US22 {

    private ResultSet resultSet;
    private static String fakePhoneNumber;
    private static String fakeSsn;
    private static String fakeUsername;

    @Given("connect to database")
    public void connect_to_database() throws SQLException {
        //connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:6982/school_management", "select_user", "43w5ijfso");
        //The connection will be created when we call executeQuery() method from JDBCUtils class.
    }

    @When("get admin user via username {string}")
    public void get_admin_user_via_username(String username) throws SQLException {

        //Statement statement = connection.createStatement();

        String query = "select * from guest_user where username = '" + fakeUsername + "'";

        resultSet = JDBCUtils.executeQuery(query);
        resultSet.next();//To move the pointer to the records, we need to call next()

    }


    @Then("validate  username {string} gender {string}  name {string} phone_number {string}  ssn {string} surname {string}")
    public void validateUsernameBirth_dayBirth_placeGenderNamePhone_numberSsnSurname(String username, String gender, String name, String phone_number, String ssn, String surname) throws SQLException {

        String actualUsername = resultSet.getString("username");
        String actualGender = resultSet.getString("gender");
        String actualName = resultSet.getString("name");
        String actualPhone_number = resultSet.getString("phone_number");
        String actualSsn = resultSet.getString("ssn");
        String actualSurname = resultSet.getString("surname");

        assertEquals(fakeUsername, actualUsername);//fakeUsername will be generated on UI part and will be validated here
        assertEquals(gender, actualGender);
        assertEquals(name, actualName);
        assertEquals(fakePhoneNumber, actualPhone_number);
        assertEquals(fakeSsn, actualSsn);
        assertEquals(surname, actualSurname);
    }

    @Then("close the connection")
    public void close_the_connection() throws SQLException {

        //resultSet.close();
        //connection.close();
        JDBCUtils.closeConnection();

    }
}
