package me.adarsh.godspunkycore.command;

public class CommandFailException extends RuntimeException
{
    public CommandFailException(String message)
    {
        super(message);
    }
}