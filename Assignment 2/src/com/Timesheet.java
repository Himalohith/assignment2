package com;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Timesheet {
	public static void main(String args[]) {
		int workingHour = 9;
		int noOfDays = 0;
		int noOfLeave = 0;
		String usrId, password;
		boolean flag = false;
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("Swetha", "swetha"));
		employeeList.add(new Employee("Hima", "hima"));
		System.out.println("Enter the employee id and password");
		Scanner s = new Scanner(System.in);
		usrId = s.nextLine();
		password = s.nextLine();
		Employee e = new Employee(usrId, password);
		TimeSheetList temp = new TimeSheetList(e, "0", 0, 0, 0);

		ArrayList<TimeSheetList> timesheetlist = new ArrayList<TimeSheetList>();
		for (Employee emp : employeeList) {
			if (emp.getUsrId().equals(e.getUsrId()) && emp.getPassword().equals(e.getPassword())) {
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Please enter the correct Employee-ID/Password");
		}
		if (flag == true) {
			System.out.println("Please fill the time_sheet");

			System.out.println("Enter the Date(DD-MM-YYYY) ");

			String date = s.nextLine();
			System.out.println("Working or leave");
			String working = s.nextLine();
			if (working.equalsIgnoreCase("working")) {
				System.out.println("please enter set of days :");
				noOfDays = s.nextInt();
				System.out.println("please enter working hours :");
				workingHour = s.nextInt();
			} else {
				System.out.println("please enter no of days on leave :");
				noOfLeave = s.nextInt();
			}

			TimeSheetList TSL = new TimeSheetList(new Employee(usrId, password), date, noOfLeave, noOfDays,
					workingHour);
			TSL.setTotalLeaves((TSL.getTotalLeaves() + noOfLeave));
			TSL.setTotalHours(TSL.getTotalHours() + workingHour);
			timesheetlist.add(TSL);

			try {

				File file = new File("F:/MyTestFile.txt");
				String drive = "";

				// if file does'nt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);

				for (TimeSheetList t : timesheetlist) {
					drive = "Today's time-sheet of " + t.getEmployee().getUsrId() + " : \n " + "Number of leaves taken:"
							+ " " + t.getNumberOfLeave() + "  \n set of days :" + t.getSetOfDays() + "\n total hours worked :" + t.getWorkingHours()
							+ "\t";

					bw.write(drive);
					bw.newLine();
				}
				
				Scanner s2 = new Scanner(System.in);
				System.out.println("EFFICIENCY CALCULATION \n Enter the Employee Name");
				String name = s2.nextLine();
				for (TimeSheetList t : timesheetlist) {
					if (t.getEmployee().getUsrId().equalsIgnoreCase(name)) {
						temp.setEmployee(t.getEmployee());
						temp.setdate(t.getdate());
						temp.setNumberOfLeave(t.getNumberOfLeave());
						temp.setSetOfDays(t.getSetOfDays());
						temp.setTotalHours(t.getTotalHours());
						temp.setTotalLeaves(t.getTotalLeaves());
						temp.setWorkingHours(t.getWorkingHours());
						;
					}
				}
				bw.newLine();
				if (temp != null) {
					//bw.write("The effeciency of the employee " + temp.getEmployee().getUsrId() + " is \n total hours worked : "
							//+ temp.getTotalHours() + " \n number of leaves taken : " + temp.getTotalLeaves());
					System.out.println("The effeciency of the employee " + temp.getEmployee().getUsrId() + " is \n total hours worked : "
							+ temp.getWorkingHours()*temp.getSetOfDays() + " \n number of leaves taken : " + temp.getNumberOfLeave());
				}
				if(temp==null)
					System.out.println("No employee was found");
				bw.close();
				System.out.println("Done: " + drive);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
		s.close();
	}

}
