package com.drewstrunk.payroll;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Payroll {
    private static Scanner reader = new Scanner(System.in);
    private static EmployeeManager employeeManager = new EmployeeManager();

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("----- PAYROLL SYSTEM -----");
        if(addEmployees()) {
            employeeManager.enterEmployees();
        }

        else {
            System.out.println("Thanks and have a nice day!");
        }

        for(Employee employee: employeeManager.employeeList) {
            employee.pto = employeeManager.calculatePTO(employee.hireDate);
        }

        if(startPayroll()) {
            runPayroll();
        }
    }

    private static boolean addEmployees() {
        System.out.println("Would you like to add new employees? (Y/N)");
        String answer = reader.next();
        return(answer.equals("Y"));
    }

    private static boolean startPayroll() {
        System.out.println("Would you like to run Payroll? (Y/N)");
        String answer = reader.next();
        return(answer.equals("Y"));
    }

    private static void runPayroll() {
        for (Employee employee: employeeManager.employeeList) {
            TimeCard timeCard = new TimeCard();

            System.out.println("Please enter " + employee.firstName + " " + employee.lastName + "'s hours worked.");
            double hoursWorked = reader.nextDouble();

            double grossPay = timeCard.calculateGrossPay(hoursWorked, employee.payRate, employee.salary, employee.exempt);

            timeCard.createTimeCard(employee.employeeID, (employee.firstName + " " + employee.lastName), employee.pto, grossPay, employee.exempt, hoursWorked);
        }
    }
}
