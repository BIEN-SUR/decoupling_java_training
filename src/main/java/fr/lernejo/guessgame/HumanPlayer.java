package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player
{

    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scanner = new java.util.Scanner(System.in);

    @Override
    public long askNextGuess()
    {
        logger.log("Entrez un nombre : ");
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater)
    {
        if(lowerOrGreater)
            logger.log("C'est plus !");
        else
            logger.log("C'est moins !");
    }
}

