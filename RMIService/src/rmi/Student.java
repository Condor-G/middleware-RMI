package rmi;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String stuNo = "";
	private String stuName = "";
	private float grade = 0.0f;
	public Student() {}
	public Student(String stuNo,String stuName,float grade) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.grade = grade;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public String toString() {
		return stuNo + " " + stuName + " " + grade; 
	}
}