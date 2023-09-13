package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//ignores unrecognized fields
public class ContactMessagePojo {

    //Create private fields
    private String email;
    private String message;
    private String name;
    private String subject;

    //Create default and parameterized constructors
    public ContactMessagePojo() {
    }

    public ContactMessagePojo(String email, String message, String name, String subject) {
        this.email = email;
        this.message = message;
        this.name = name;
        this.subject = subject;
    }

    //Create setters and getters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    //Create toString() method
    @Override
    public String toString() {
        return "ContactMessagePojo{" +
                "email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
