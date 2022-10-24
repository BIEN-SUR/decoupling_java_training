package fr.lernejo.logger;

public class ContextualLogger implements Logger
{

    @Override
    public void log(String message)
    {
        System.out.println(message);
    }
}
