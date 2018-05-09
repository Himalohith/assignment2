package com;
import java.io.Serializable;

public class TimeSheetList  implements Serializable {
	
		 private Employee employee;
		 private String date;
		 private int numberOfLeave;
		 private int setOfDays;
		 private int workingHours;
		 private int totalHours;
		 public int getTotalHours() {
		 	return totalHours;
		 }

		 public void setTotalHours(int totalHours) {
		 	this.totalHours = totalHours;
		 }
		 private int totalLeaves;

		 public TimeSheetList(Employee employee, String date, int numberOfLeave, int setOfDays, int workingHours) {
		 	super();
		 	this.employee = employee;
		 	this.date = date;
		 	this.numberOfLeave = numberOfLeave;
		 	this.setOfDays = setOfDays;
		 	this.workingHours = workingHours;
		 }

		 public int getTotalLeaves() {
		 	return totalLeaves;
		 }

		 public void setTotalLeaves(int totalLeaves) {
		 	this.totalLeaves = totalLeaves;
		 }

		 TimeSheetList(){}
		 public Employee getEmployee() {
		 	return employee;
		 }
		 public void setEmployee(Employee employee) {
		 	this.employee = employee;
		 }
		 public String getdate() {
		 	return date;
		 }
		 public void setdate(String date) {
		 	this.date = date;
		 }
		 public int getNumberOfLeave() {
		 	return numberOfLeave;
		 }
		 public void setNumberOfLeave(int numberOfLeave) {
		 	this.numberOfLeave = numberOfLeave;
		 }
		 public int getSetOfDays() {
		 	return setOfDays;
		 }
		 public void setSetOfDays(int setOfDays) {
		 	this.setOfDays = setOfDays;
		 }
		 public int getWorkingHours() {
		 	return workingHours;
		 }
		 public void setWorkingHours(int workingHours) {
		 	this.workingHours = workingHours;
		 }

		 }

	
