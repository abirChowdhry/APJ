package com;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
    public class Calculator
    {
        public static void main(String args[])
        {
            System.out.print("Enter date of birth in YYYY-MM-DD format: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            scanner.close();
            LocalDate dob = LocalDate.parse(input);

            System.out.println("You are " + calculateAge(dob)+" years old.");
        }
        public static int calculateAge(LocalDate dob)
        {
            LocalDate today = LocalDate.now();
            if ((dob != null) && (today != null))
            {
                return Period.between(dob,today).getYears();
            }
            else
            {
                return 0;
            }
        }
    }

