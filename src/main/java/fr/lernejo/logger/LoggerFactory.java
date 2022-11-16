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
        Predicate<String> condition = msg -> msg.contains("simulation");

        //return new FilteredLogger(new ContextualLogger(name, new ConsoleLogger()), condition);
        return new ContextualLogger(name, new CompositeLogger(new ConsoleLogger(), new FilteredLogger(new FileLogger(name), condition)));

        //return new CompositeLogger(new ContextualLogger(name, new ConsoleLogger()), new ContextualLogger(name, new FileLogger(name)));
    }
}
