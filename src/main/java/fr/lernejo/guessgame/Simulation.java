package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation
{
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private int numberToGuess;

    public Simulation(Player player)
    {
        this.player = player;
    }

    public void initialize(long numberToGuess)
    {
        this.numberToGuess = (int) numberToGuess;
    }

    private boolean nextRound()
    {
        long guess = player.askNextGuess();
        //logger.log("Guess: " + guess);
        if (guess == numberToGuess)
        {
            return true;
        }
        if (guess > numberToGuess)
            player.respond(false);
        else
            player.respond(true);
        return false;
    }

    public void loopUntilPlayerSucceed(int maxTry)
    {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < maxTry; i++) {
            if(nextRound()) {
                long endTime = System.currentTimeMillis();
                long duration = (endTime - startTime) / 1000;
                logger.log("Bravo, vous avez trouvé le nombre mystère !");
                logger.log("Vous avez trouvé " + numberToGuess + " en " + (i + 1) + " coups et " + duration + " secondes");
                return;
            }
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime) / 1000;
        logger.log("Vous avez perdu, le nombre mystère était " + numberToGuess);
        logger.log("Vous n'avez pas trouvé en " + maxTry + " coups , cela vous a pris " + duration + " secondes");
    }
}


