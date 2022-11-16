package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger
{
    private final String callerClass;
    private final Logger delegateLogger;
    public ContextualLogger (String callerClass, Logger delegateLogger)
    {
        this.callerClass = callerClass;
        this.delegateLogger = delegateLogger;
    }
    public void log(String message)
    {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);
    }

}
