package net.javaaee.restapp.appexceptions;

public class UserCreationException extends RuntimeException 
{
    public UserCreationException(String message) 
    {
        super(message);
    }
}
