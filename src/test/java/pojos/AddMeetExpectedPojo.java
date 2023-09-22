package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddMeetExpectedPojo implements Serializable {
	private String date;
	private String description;
	private String startTime;
	private String stopTime;
	private List<Integer> studentIds;

	public AddMeetExpectedPojo() {
	}

	public AddMeetExpectedPojo(String date, String description, String startTime, String stopTime, List<Integer> studentIds) {
		this.date = date;
		this.description = description;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.studentIds = studentIds;
	}


	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setStopTime(String stopTime){
		this.stopTime = stopTime;
	}

	public String getStopTime(){
		return stopTime;
	}

	public void setStudentIds(List<Integer> studentIds){
		this.studentIds = studentIds;
	}

	public List<Integer> getStudentIds(){
		return studentIds;
	}

	@Override
 	public String toString(){
		return 
			"AddMeetExpectedPojo{" + 
			"date = '" + date + '\'' + 
			",description = '" + description + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",stopTime = '" + stopTime + '\'' + 
			",studentIds = '" + studentIds + '\'' + 
			"}";
		}
}