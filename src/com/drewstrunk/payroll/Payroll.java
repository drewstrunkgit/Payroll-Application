package com.drewstrunk.payroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {
        System.out.println("----- ELITE PAYROLL SYSTEM -----");

    }

    public void enterEmployees() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter the number of employees you would like to enter");
        int numberOfEmployees = reader.nextInt();

        for (int i = 0; i < (numberOfEmployees - 1); i++) {
            System.out.println("Enter new Employee Information");
            createNewEmployee();
        }

    }

    private void createNewEmployee() {
        Scanner reader = new Scanner(System.in);
        Person person = new Person();
        Employee employee = new Employee();

        System.out.println("Please enter the Employee's First Name");
        person.firstName = reader.next();
        System.out.println("Please enter the Employee's Last Name");
        person.lastName = reader.next();

        System.out.println("Please enter the Employee's date of birth (mm-dd-yyyy");
        String date = reader.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
        person.dateOfBirth = null;
        try {
            person.dateOfBirth = dateFormat.parse(date);
        }

        catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Please enter the Employee's gender (M/F)");
        person.gender = reader.next();
        System.out.println("Please enter the Employee's Marital Status");
        person.maritalStatus = reader.next();
        System.out.println("Please enter the Employee's Social Security Number (xxx-xx-xxxx");
        person.socialSecurityNumber = reader.next();
        System.out.println("Please enter the Employee's Address");
        person.address = reader.next();
        System.out.println("Please enter the Employee's Pay Rate (xx.xx");
        employee.payRate = reader.nextDouble();
        System.out.println("Please enter the Employee's Exempt Status (Exempt/Non-Exempt)");

        String exemptStatus = reader.next();
        if (exemptStatus.equals("Exempt")) {
            employee.exempt = true;
        }

        else if (exemptStatus.equals("Non-Exempt")) {
            employee.exempt = false;
        }

        System.out.println("Please enter the Employee's Hire Date (mm-dd-yyyy)");
        String hireDate = reader.next();
        SimpleDateFormat hireDateFormat = new SimpleDateFormat("mm-dd-yyyy");
        employee.hireDate = null;
        try {
            employee.hireDate = hireDateFormat.parse(hireDate);
        }

        catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Please enter the Employee's Employee ID");
        employee.employeeID = reader.nextInt();

    }
}
