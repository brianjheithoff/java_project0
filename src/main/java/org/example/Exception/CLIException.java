package org.example.Exception;

/**
 * Exception that is thrown when the user misuses the CLI.
 * "extends Exception means that this is a type of Exception"
 */
public class CLIException extends Exception {
    public CLIException(String message){
        super(message);
    }
}
