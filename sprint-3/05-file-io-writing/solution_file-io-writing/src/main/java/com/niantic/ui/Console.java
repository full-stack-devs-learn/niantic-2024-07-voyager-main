package com.niantic.ui;

import java.util.Scanner;

public class Console
{
    protected static Scanner in = new Scanner(System.in);

    public static void waitForUser()
    {
        System.out.println();
        System.out.print("Press enter to continue...");
        in.nextLine();
    }

    public static String getStringInput(String message)
    {
        System.out.println();
        System.out.print(message);
        return in.nextLine().strip();
    }

    public static int getIntInput(String message)
    {
        var input = getStringInput(message);
        return Integer.parseInt(input);
    }
}
