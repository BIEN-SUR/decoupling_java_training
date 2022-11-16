package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory
{
    public static Logger getLogger(String name)
    {
        //return new ConsoleLogger();
        //return new ContextualLogger(name, new ConsoleLogger());
        //return new FileLogger(name);
        //return new ContextualLogger(name, new FileLogger(name));
        return new CompositeLogger(new ContextualLogger(name, new ConsoleLogger()), new ContextualLogger(name, new FileLogger(name)));
    }
}
