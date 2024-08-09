package com.niantic.ui;

import com.niantic.services.DateConverter;

import java.util.Scanner;

public class UserInput
{
    Scanner userInput = new Scanner(System.in);

    public int homeScreenSelection()
    {
        System.out.println();
        System.out.println("Budget Tracker");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Add Transaction");
        System.out.println("  2) Reports");
        System.out.println("  3) Add User");
        System.out.println("  4) Add Category");
        System.out.println("  5) Add Sub Category");
        System.out.println("  6) Add Vendor");
        System.out.println("  0) Quit");
        System.out.println();

        return getUserInt("Enter an option: ");
    }

    public int reportsGetUserMonthInput()
    {
        System.out.println();
        String monthName = getUserString("Enter the month: ");
        return DateConverter.monthNameToNumber(monthName);
    }

    public void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }

    // helper methods
    private String getUserString(String message)
    {
        System.out.print(message);
        return userInput.nextLine().strip();
    }

    private int getUserInt(String message)
    {
        String input = getUserString(message);
        return Integer.parseInt(input);
    }
}
