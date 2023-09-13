package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//ignores unrecognized fields
public class ContactMessageResponsePojo {
    /*
    Response:
        {
            "object": {
                "name": "Robert Smith",
                "email": "abd@ab.com",
                "subject": "Registration",
                "message": "This is text",
                "date": "2023-09-13"
            },
            "message": "Contact Message Created Successfully",
            "httpStatus": "CREATED"
        }
     */
    private ContactMessagePojo object;
    private String message;
    private String httpStatus;

    //Default and parametrized constructors
    public ContactMessageResponsePojo() {
    }

    public ContactMessageResponsePojo(ContactMessagePojo object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    //Setters and Getters
    public ContactMessagePojo getObject() {
        return object;
    }

    public void setObject(ContactMessagePojo object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    //toString() method
    @Override
    public String toString() {
        return "ContactMessageResponsePojo{" +
                "object=" + object +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }

}
