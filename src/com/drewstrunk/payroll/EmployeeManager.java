package com.drewstrunk.payroll;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

class EmployeeManager {

    ArrayList<Employee> employeeList = new ArrayList<>();
    private int employeeIDTracker = 1;

    private void createNewEmployee() throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader("U:\\Repositories\\Payroll-Application\\Employees.json"));
        Gson gson = new Gson();
        Employee employee = gson.fromJson(jsonReader, Employee.class);

        employee.employeeID = employeeIDTracker;
        employeeIDTracker++;

        employeeList.add(employee);
        System.out.println(employeeList.toString());


   /*     Scanner reader = new Scanner(System.in);
        reader.useDelimiter("\\n");

        Employee employee = new Employee();

        System.out.println("Please enter the Employee's Exempt Status (Exempt/Non-Exempt)");
        String exemptStatus = reader.next();
        if (exemptStatus.equals("Exempt")) {
            employee.exempt = true;
        } else if (exemptStatus.equals("Non-Exempt")) {
            employee.exempt = false;
        }

        System.out.println("Please enter the Employee's First Name");
        employee.firstName = reader.next();
        System.out.println("Please enter the Employee's Last Name");
        employee.lastName = reader.next();

        System.out.println("Please enter the Employee's date of birth (mm-dd-yyyy");
        String date = reader.next();
        DateTimeFormatter dateOfBirthFormat = DateTimeFormat.forPattern("M-D-Y");
        employee.dateOfBirth = dateOfBirthFormat.parseLocalDate(date);

        System.out.println("Please enter the Employee's gender (M/F)");
        employee.gender = reader.next();
        System.out.println("Please enter the Employee's Marital Status");
        employee.maritalStatus = reader.next();
        System.out.println("Please enter the Employee's Social Security Number (xxx-xx-xxxx)");
        employee.socialSecurityNumber = reader.next();
        System.out.println("Please enter the Employee's Address");
        employee.address = reader.next();

        if (employee.exempt) {
            System.out.println("Please enter the Employee's Salary");
            employee.salary = reader.nextInt();
        }

        else {
            System.out.println("Please enter the Employee's Pay Rate (xx.xx)");
            employee.payRate = reader.nextDouble();
        }

        System.out.println("Please enter the Employee's Hire Date (mm-dd-yyyy)");
        String hireDate = reader.next();
        DateTimeFormatter hireDateFormat = DateTimeFormat.forPattern("M-D-Y");
        employee.hireDate = hireDateFormat.parseLocalDate(hireDate);*/
    }

    void enterEmployees() throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter the number of employees you would like to add.");
        int numberOfEmployees = reader.nextInt();

        for (int i = 0; i < (numberOfEmployees); i++) {
            System.out.println("Enter new Employee Information");
            createNewEmployee();
        }
    }

    double calculatePTO(LocalDate hireDate) {
        double totalPTO;

        LocalDate today = LocalDate.now();
        int daysWorked = Days.daysBetween(hireDate, today).getDays();
        int yearsWorked = daysWorked/365;

        double accrualRate = 4.6; //Hours per pay period (two weeks)

        if (yearsWorked >=5 && yearsWorked <= 9) {
            accrualRate = 7.6;
        }

        else if (yearsWorked >=10) {
            accrualRate = 10.6;
        }

        totalPTO = daysWorked * accrualRate;

        return totalPTO;
    }
}