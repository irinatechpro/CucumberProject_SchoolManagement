package pojos;

import java.util.List;

public class ProgramListItem{
	private List<LessonItem> lesson;
	private String startTime;
	private String stopTime;
	private int id;
	private String day;

	public void setLesson(List<LessonItem> lesson){
		this.lesson = lesson;
	}

	public List<LessonItem> getLesson(){
		return lesson;
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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	public ProgramListItem(List<LessonItem> lesson, String startTime, String stopTime, int id, String day) {
		this.lesson = lesson;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.id = id;
		this.day = day;
	}

	public ProgramListItem() {
	}

	@Override
	public String toString() {
		return "ProgramListItem{" +
				"lesson=" + lesson +
				", startTime='" + startTime + '\'' +
				", stopTime='" + stopTime + '\'' +
				", id=" + id +
				", day='" + day + '\'' +
				'}';
	}
}