package pojos;

import java.util.List;

public class ResponseItem{
	private String birthDay;
	private String fatherName;
	private int advisorTeacherId;
	private String gender;
	private int studentNumber;
	private String motherName;
	private String ssn;
	private String advisorTeacherSurname;
	private String birthPlace;
	private String advisorTeacherName;
	private String phoneNumber;
	private String surname;
	private String name;
	private List<Object> programList;
	private int id;
	private String email;
	private String username;

	public void setBirthDay(String birthDay){
		this.birthDay = birthDay;
	}

	public String getBirthDay(){
		return birthDay;
	}

	public void setFatherName(String fatherName){
		this.fatherName = fatherName;
	}

	public String getFatherName(){
		return fatherName;
	}

	public void setAdvisorTeacherId(int advisorTeacherId){
		this.advisorTeacherId = advisorTeacherId;
	}

	public int getAdvisorTeacherId(){
		return advisorTeacherId;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setStudentNumber(int studentNumber){
		this.studentNumber = studentNumber;
	}

	public int getStudentNumber(){
		return studentNumber;
	}

	public void setMotherName(String motherName){
		this.motherName = motherName;
	}

	public String getMotherName(){
		return motherName;
	}

	public void setSsn(String ssn){
		this.ssn = ssn;
	}

	public String getSsn(){
		return ssn;
	}

	public void setAdvisorTeacherSurname(String advisorTeacherSurname){
		this.advisorTeacherSurname = advisorTeacherSurname;
	}

	public String getAdvisorTeacherSurname(){
		return advisorTeacherSurname;
	}

	public void setBirthPlace(String birthPlace){
		this.birthPlace = birthPlace;
	}

	public String getBirthPlace(){
		return birthPlace;
	}

	public void setAdvisorTeacherName(String advisorTeacherName){
		this.advisorTeacherName = advisorTeacherName;
	}

	public String getAdvisorTeacherName(){
		return advisorTeacherName;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public String getSurname(){
		return surname;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProgramList(List<Object> programList){
		this.programList = programList;
	}

	public List<Object> getProgramList(){
		return programList;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public ResponseItem(String birthDay, String fatherName, int advisorTeacherId, String gender, int studentNumber, String motherName, String ssn, String advisorTeacherSurname, String birthPlace, String advisorTeacherName, String phoneNumber, String surname, String name, List<Object> programList, int id, String email, String username) {
		this.birthDay = birthDay;
		this.fatherName = fatherName;
		this.advisorTeacherId = advisorTeacherId;
		this.gender = gender;
		this.studentNumber = studentNumber;
		this.motherName = motherName;
		this.ssn = ssn;
		this.advisorTeacherSurname = advisorTeacherSurname;
		this.birthPlace = birthPlace;
		this.advisorTeacherName = advisorTeacherName;
		this.phoneNumber = phoneNumber;
		this.surname = surname;
		this.name = name;
		this.programList = programList;
		this.id = id;
		this.email = email;
		this.username = username;
	}

	public ResponseItem() {
	}

	@Override
	public String toString() {
		return "ResponseItem{" +
				"birthDay='" + birthDay + '\'' +
				", fatherName='" + fatherName + '\'' +
				", advisorTeacherId=" + advisorTeacherId +
				", gender='" + gender + '\'' +
				", studentNumber=" + studentNumber +
				", motherName='" + motherName + '\'' +
				", ssn='" + ssn + '\'' +
				", advisorTeacherSurname='" + advisorTeacherSurname + '\'' +
				", birthPlace='" + birthPlace + '\'' +
				", advisorTeacherName='" + advisorTeacherName + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", surname='" + surname + '\'' +
				", name='" + name + '\'' +
				", programList=" + programList +
				", id=" + id +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}