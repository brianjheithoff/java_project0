package org.example.View;

import org.example.Exception.CLIException;
import org.example.Exception.TrackerException;
import org.example.Model.Tracker;
import org.example.Service.TrackerService;

import java.util.List;
import java.util.Scanner;


public class CLIParser {

    TrackerService trackerService;
    public CLIParser(){
        trackerService = new TrackerService();
    }
    //    abstract away as much code as possible
//    (abstraction)
    public String parseCommandReturnOutput(String command) throws CLIException, TrackerException {
        if(command.equals("add")){
            return interpretAddAction();
        }else if(command.equals("view")){
            return interpretViewAction();
        }else if(command.equals("search")) {
            return interpretSearchAction();
        }else{
            /**
             * Checked exceptions are ones where the compiler must know if a method
             * can hypothetically throw an exception - if so, the 'throws' declaration
             * must be added
             *
             * What happens if the exception is that the exception is tossed to the
             * method that called this one - and that method can either handle the
             * exception (which we'll get to in a bit) or it can continue to throw
             * the exception
             *
             * "what part of our program is best suited to respond to this particular
             * issue?"
             */
            throw new CLIException("not a valid command");
        }
    }
    public String interpretAddAction() throws TrackerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("input name of runner");
        String nameInput = sc.nextLine();
        System.out.println("input details about weather and temperature");
        String detailsInput = sc.nextLine();
        System.out.println("input number of miles completed (must be integer)");
//        obtain the text version of the # of servings the user wants
        String distanceInputString = sc.nextLine();
//        convert the text version of servings into a numeric variable
        int numDistance = Integer.parseInt(distanceInputString);

        trackerService.addTracker(nameInput, detailsInput, numDistance);
        return "Run added";
    }
    public String interpretViewAction(){
        List<Tracker> trackers = trackerService.getAllTracker();
        return "Here are your runs: " + trackers.toString();
    }
    public String interpretSearchAction(){
        Scanner sc = new Scanner(System.in);
        String nameInput = sc.nextLine();
        Tracker matchingTracker = trackerService.getTrackerByName(nameInput);

        if(matchingTracker == null){
            return "There was no matching run found.";
        }else{
            return "Here is the matching run: " + matchingTracker.toString();
        }

    }
}