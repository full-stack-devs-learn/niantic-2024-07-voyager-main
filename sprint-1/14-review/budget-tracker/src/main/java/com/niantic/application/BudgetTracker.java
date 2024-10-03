package com.niantic.application;

import com.niantic.ui.UserInput;

public class BudgetTracker
{
    UserInput input = new UserInput();
    public void run()
    {

        while(true)
        {
            int choice = input.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    input.displayMessage("add transaction");
                    break;
                case 2:
                    input.displayMessage("reports");
                    break;
                case 3:
                    input.displayMessage("add user");
                    break;
                case 4:
                    input.displayMessage("add category");
                    break;
                case 5:
                    input.displayMessage("add sub category");
                    break;
                case 6:
                    input.displayMessage("add vendor");
                    break;
                case 0:
                    input.displayMessage("Thank you for using Northwind!\nGoodbye\n");
                    System.exit(0);
                default:
                    input.displayMessage("invalid selection");
                    break;
            }
        }

    }


}
