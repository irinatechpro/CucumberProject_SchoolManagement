package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.US15_StepDefs.*;

public class Db_US15StepDefs {
    ResultSet resultSet;

    @Given("get Student Data by username")
    public void get_Student_Data_by_username() throws SQLException {
        String query = "select * from student where username = '" + StudentUserName + "'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();
    }

    @Then("validate  username")
    public void validate_username() throws SQLException {
        String actualUsername = resultSet.getString("username");
        assertEquals(StudentUserName, actualUsername);
    }
    @Then("validate Student data")
    public void validate_Student_data () throws SQLException {
        String actualUsername = resultSet.getString("username");
        String actualName = resultSet.getString("name");
        String actualSurname = resultSet.getString("surname");
        String actualSSN = resultSet.getString("ssn");
        String actualBirthDate = resultSet.getString("birth_day");
        String actualBirthPlace = resultSet.getString("birth_place");
        String actualPhoneNumber = resultSet.getString("phone_number");
        String actualGender = resultSet.getString("gender");
        String actualMotherName = resultSet.getString("mother_name");
        String actualFatherName = resultSet.getString("father_name");
        String actualStudentNumber = resultSet.getString("student_number");
        assertEquals(StudentUserName, actualUsername);
        assertEquals(fakeSsn, actualSSN);
        assertEquals(fakerName, actualName);
        assertEquals(fakerSurname, actualSurname);
        assertEquals(formattedDate, actualBirthDate);
        assertEquals(fakerBirthPlace, actualBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actualPhoneNumber);
        assertEquals("0", actualGender);
        assertEquals(studentMotherName, actualMotherName);
        assertEquals(studentFatherName, actualFatherName);
        assertEquals(numberText, actualStudentNumber);

    }
}
