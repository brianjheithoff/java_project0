package org.example.Exception;

/**
 * Exception that is thrown upon the creation of a invalid recipe.
 * For instance:
 * Servings of 0 or less,
 * or empty values for the title or instructions.
 */
public class TrackerException extends Exception {
    public TrackerException(String message){
        super(message);
    }
}
