package com.drewstrunk.payroll;

import java.text.DecimalFormat;
import java.util.Scanner;

import static com.sun.tools.javac.util.Constants.format;

class TimeCard {

    double calculateGrossPay(double hoursWorked, double payRate, int salary, boolean exempt) {
        double grossPay = payRate * hoursWorked;

        if (exempt) {
            grossPay = (salary/24);
        }

        return grossPay;
    }

    void createTimeCard(int employeeID, String employeeName, double pto, double grossPay, boolean exempt, double hoursWorked) {
        Scanner reader = new Scanner(System.in);
        reader.useDelimiter("\\n");

        double ptoUsed;

        System.out.println("Please enter the amount of PTO " + employeeName + " used in this pay period.");
        ptoUsed = reader.nextDouble();

        System.out.println("-----TIMECARD-----");
        System.out.println();

        System.out.println(employeeName + "(" + employeeID + ")");
        if (exempt) {
            System.out.println("Salary");
        }

        else {
            System.out.print("Hourly");
        }
        System.out.println();

        DecimalFormat twoDecimalFormat = new DecimalFormat("#0.00");
        double ptoRemaining = (pto - ptoUsed);

        System.out.println("Hours Worked: " + twoDecimalFormat.format(hoursWorked));
        System.out.println("PTO Remaining: " + twoDecimalFormat.format(ptoRemaining));
        System.out.println("Gross Pay: " + twoDecimalFormat.format(grossPay));
    }
}
