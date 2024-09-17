package com.employeePayroll_IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	
	public enum IOService {CONSOLE_IO , FILE_IO,DB_IO,REST_IO};
    private List<EmployeePayrollData> employeePayrollList;
	public EmployeePayrollService() {}

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
	  this.employeePayrollList = employeePayrollList;
	}
	
	public static void main(String[] args) {
	   ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
       EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
       Scanner consoleInputReader = new Scanner(System.in);
       employeePayrollService.readEmployeePayroll(consoleInputReader);
       employeePayrollService.writeEmployeePayrollData();
       
       
	}

	private void writeEmployeePayrollData() {
		System.out.println(" \nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
		
	}

	private void readEmployeePayroll(Scanner consoleInputReader) {
		System.out.println("Enter Employeee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter Employee Salary: ");
		double salary = consoleInputReader.nextDouble();
		
		employeePayrollList.add(new EmployeePayrollData(id,name, salary));
		
		
	}
	
	

}
