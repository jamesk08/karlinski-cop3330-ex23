/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 James Karlinski
 */

package org.example;

import java.text.MessageFormat;
import java.util.Scanner;

public class CarTroubleshooter
{
    Scanner scanner = new Scanner(System.in);

    public void Troubleshoot()
    {
        if(getResponse("Is the car silent when you turn the key?")) {
            if (getResponse("Are the battery terminals corroded?")) {
                OutputMessageAndStop("Clean terminals and try starting again.");
            }
            else {
                OutputMessageAndStop("Replace cables and try again.");
            }
        }
        else {
            if(getResponse("Does the car make a slicking noise?")) {
                OutputMessageAndStop("Replace the battery.");
            }
            else {
                if(getResponse("Does the car crank up but fail to start?")){
                    OutputMessageAndStop("Check spark plug connections.");
                }
                else {
                    if(getResponse("Does the engine start and then die?")){
                        if(getResponse("Does you car have fuel injection?")){
                            OutputMessageAndStop("Get it in for service.");
                        }
                        else{
                            OutputMessageAndStop("Check to ensure the choke is opening and closing.");
                        }
                    }
                    else {
                        OutputMessageAndStop("This should not be possible.");
                    }
                }
            }
        }
    }

    private boolean getResponse(String message)
    {
        boolean response = false;
        System.out.print(MessageFormat.format("{0} (y/n): ", message));
        String textInput = scanner.nextLine();
        if(textInput.equalsIgnoreCase("y"))
        {
            response = true;
        }
        else if (textInput.equalsIgnoreCase("n"))
        {
            response = false;
        }
        else
        {
            System.out.println("Invalid entry was received.");
            System.exit(0);
        }
        return response;
    }

    private void OutputMessageAndStop(String message)
    {
        System.out.println(message);
        System.exit(0);
    }
}
