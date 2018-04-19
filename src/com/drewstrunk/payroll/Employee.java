package com.drewstrunk.payroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employee extends Person {
    double payRate;
    boolean exempt;
    Date hireDate;
    int employeeID;
    double pto;
}
