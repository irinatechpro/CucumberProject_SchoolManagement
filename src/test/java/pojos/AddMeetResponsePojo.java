package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddMeetResponsePojo implements Serializable {
	private String message;
	private int statusCode;
	private String path;
	private long timeStamp;

	public AddMeetResponsePojo() {
	}

	public AddMeetResponsePojo(String message, int statusCode, String path, long timeStamp) {
		this.message = message;
		this.statusCode = statusCode;
		this.path = path;
		this.timeStamp = timeStamp;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setTimeStamp(long timeStamp){
		this.timeStamp = timeStamp;
	}

	public long getTimeStamp(){
		return timeStamp;
	}

	@Override
 	public String toString(){
		return 
			"AddMeetResponsePojo{" + 
			"message = '" + message + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			",path = '" + path + '\'' + 
			",timeStamp = '" + timeStamp + '\'' + 
			"}";
		}
}