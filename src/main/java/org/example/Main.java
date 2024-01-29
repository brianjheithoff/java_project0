package org.example;

import org.example.Exception.CLIException;
import org.example.Exception.TrackerException;
import org.example.View.CLIParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Scanner;



public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);





    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        CLIParser cliParser = new CLIParser();

        while(true){
            System.out.println("add / view / search");
            String input = sc.nextLine();
            try {
//                this block of code is potenitally dangerous (it can throw an exception)
//                if the exception is thrown during the execution of the code within 'try', then
//                the code will switch over to running the matching 'catch' block.
                String output = cliParser.parseCommandReturnOutput(input);
                System.out.println(output);
            }catch(CLIException exception){
                System.out.println("You caused a CLIException! Probably, you misused the CLI");
                exception.printStackTrace();
//                this block within 'catch' handles an exception in the event that it occurs.
            }catch(TrackerException exception){
                System.out.println("You caused a TrackerException! Probably, you had bad input for your run.");
                exception.printStackTrace();
            }catch(NumberFormatException exception){
                System.out.println("Your distance input couldn't be parsed to a number");
                exception.printStackTrace();
            }

        }
    }
}
