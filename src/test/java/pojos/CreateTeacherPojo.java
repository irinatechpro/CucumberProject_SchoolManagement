package pojos;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.testng.annotations.Test;

public class CreateTeacherPojo {

    /***********************************
     *        LIBRARIES
     ***********************************/
    Faker faker;

    /***********************************
     *        FIELDS
     ***********************************/
    private String birthday;
    private String birthPlace;
    private String email;
    private String gender;
    private boolean isAdvisorTeacher;
    private String name;
    private String password;
    private String phoneNumber;
    private String socialSecurityNumber;
    private String surname;
    private String username;
    private int lessonId;

    /***********************************
     *        Getters
     ***********************************/
    public String getBirthday() {
        return birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public boolean isAdvisorTeacher() {
        return isAdvisorTeacher;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public int getLessonId() {
        return lessonId;
    }

    /***********************************
     *        SETTERS
     ***********************************/
    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    private void setAdvisorTeacher(boolean advisorTeacher) {
        isAdvisorTeacher = advisorTeacher;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    /***********************************
     *        GENERATE PAYLOAD
     ***********************************/
    public void createTeacher() {
        faker = new Faker();

        //number representation of birthdate
        int dayNumber = faker.number().numberBetween(1, 28);
        int monthNumber = faker.number().numberBetween(1, 12);

        //String representation of date + formatting for API
        String day;
        String month;
        String year = String.valueOf(faker.number().numberBetween(1950, 1999) );

        /**
         * Formatting day / month numbers if they fall below 10
         * This will add a zero digit in the beginning to properly format for API input
         */

        //days below 10
        if (dayNumber < 10) {
            day = "0" + dayNumber;
        } else {
            day = String.valueOf(dayNumber);
        }

        //months below 10
        if (monthNumber < 10) {
            month = "0" + monthNumber;
        } else {
            month = String.valueOf(monthNumber);
        }

        //Format Birthday
        setBirthday(year + "-" + month + "-" + day);

        //Create BirthPlace
        setBirthPlace(faker.country().name() );

        //Create name + surname + email
        setName(faker.name().firstName() );
        setSurname(faker.name().lastName() );

        //split name and surname + combine first two characters + add some numbers
        String[] nameSplit = getName().split("");
        String[] surnameSplit = getSurname().split("");

        //Modifications made to String
        StringBuilder buildEmail = new StringBuilder();

        for (int i = 0; i < 2; i ++) {
            buildEmail.append(nameSplit[i]);
            buildEmail.append(surnameSplit[i]);
            buildEmail.append(faker.number().numberBetween(1,9) );
        }

        //put outside so does not repeat in loop
        buildEmail.append("@gmail.com");

        //convert SB to String to store for this object
        setEmail(buildEmail.toString() );

        //Choose Gender
        String[] gender = new String[2];
        gender[0] = "MALE";
        gender[1] = "FEMALE";

        setGender(gender[faker.number().numberBetween(0, 2)] );

        //set isAdvisorTeacher true or false
        boolean[] isAdvisorTeacherBoolean = new boolean[2];
        isAdvisorTeacherBoolean[0] = false;
        isAdvisorTeacherBoolean[1] = true;

        setAdvisorTeacher(isAdvisorTeacherBoolean[faker.number().numberBetween(0, 2)] );

        /**
         * Lesson IDs
         * 5[Java], 6[JavaScript], 7[Selenium], 8[Roma Hukuku], 11[Psychology], 17[Fluid]
         */

        //choose lesson for teacher
        int[] lessonId = {5, 6, 7, 8, 11, 17};
        setLessonId(lessonId[faker.number().numberBetween(0, 6)] );

        //set password - keep same for all teachers for purpose of testing
        setPassword("Admin123");

        //set a username
        //combine first name character + 3 characters from surname + 3 numbers (can be random order)
        StringBuilder buildUsername = new StringBuilder();
        buildUsername.append(nameSplit[0] );

        for (int i = 0; i <= 2; i++) {
            buildUsername.append(surnameSplit[i] );
            buildUsername.append(faker.number().numberBetween(1, 10) );

            if (buildUsername.length() == 3) {
                buildUsername.append(".");
            }
        }
        setUsername(buildUsername.toString() );

        //phoneNumber XXX-XXX-XXXX
        StringBuilder buildPhoneNumber = new StringBuilder();
        buildPhoneNumber.append(faker.number().numberBetween(100, 999) );
        buildPhoneNumber.append("-");
        buildPhoneNumber.append(faker.number().numberBetween(100, 999) );
        buildPhoneNumber.append("-");
        buildPhoneNumber.append(faker.number().numberBetween(1000, 9999) );

        setPhoneNumber(buildPhoneNumber.toString() );

        //Social Security Number XXX-XX-XXXX
        StringBuilder buildSocialSecurityNumber = new StringBuilder();
        buildSocialSecurityNumber.append(faker.number().numberBetween(100, 999) );
        buildSocialSecurityNumber.append("-");
        buildSocialSecurityNumber.append(faker.number().numberBetween(0, 99) );
        buildSocialSecurityNumber.append("-");
        buildSocialSecurityNumber.append(faker.number().numberBetween(1000, 9999) );

        setSocialSecurityNumber(buildSocialSecurityNumber.toString() );
    }

    public String createTeacherPayLoad() {

        StringBuilder buildPayLoad = new StringBuilder();

        buildPayLoad.append("{");
        buildPayLoad.append("\"birthDay\": \"").append(getBirthday() ).append("\"").append(",");
        buildPayLoad.append("\"birthPlace\": \"").append(getBirthPlace() ).append("\"").append(",");
        buildPayLoad.append("\"email\": \"").append(getEmail() ).append("\"").append(",");
        buildPayLoad.append("\"gender\": \"").append(getGender() ).append("\"").append(",");
        buildPayLoad.append("\"isAdvisorTeacher\": ").append(isAdvisorTeacher() ).append(",");
        buildPayLoad.append("\"lessonsIdList\": ").append("[").append(getLessonId() ).append("]").append(",");
        buildPayLoad.append("\"name\": \"").append(getName() ).append("\"").append(",");
        buildPayLoad.append("\"password\": \"").append(getPassword() ).append("\"").append(",");
        buildPayLoad.append("\"phoneNumber\": \"").append(getPhoneNumber() ).append("\"").append(",");
        buildPayLoad.append("\"ssn\": \"").append(getSocialSecurityNumber() ).append("\"").append(",");
        buildPayLoad.append("\"surname\": \"").append(getSurname() ).append("\"").append(",");
        buildPayLoad.append("\"username\": \"").append(getUsername() ).append("\"");
        buildPayLoad.append("}");

        return buildPayLoad.toString();
    }

    /***********************************
     *        EXAMPLE BODY RESPONSE
     ***********************************/

    /**
     * {
     *   "birthDay": "yyyy-MM-dd",
     *   "birthPlace": "string",
     *   "email": "string",
     *   "gender": "MALE",
     *   "isAdvisorTeacher": true,
     *   "lessonsIdList": [
     *     0
     *   ],
     *   "name": "string",
     *   "password": "string",
     *   "phoneNumber": "string",
     *   "ssn": "string",
     *   "surname": "string",
     *   "username": "string"
     * }
     */
}
