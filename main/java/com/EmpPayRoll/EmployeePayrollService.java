package com.EmpPayRoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    public List<EmployeePayroll> employeePayrollList;

    public EmployeePayrollService(List<EmployeePayroll> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Service program");
        ArrayList<EmployeePayroll> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleINputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayroll(consoleINputReader);
        employeePayrollService.writeEmployeePayroll();
    }

    void writeEmployeePayroll() {
        System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
    }

    private void readEmployeePayroll(Scanner consoleINputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleINputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleINputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleINputReader.nextDouble();
        employeePayrollList.add(new EmployeePayroll(id,name,salary));
    }
    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }
}
