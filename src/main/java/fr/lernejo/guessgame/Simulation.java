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
        if (guess == numberToGuess)
        {
            logger.log("Bravo, vous avez trouvé le nombre mystère !");
            return true;
        }
        if(guess > numberToGuess)
            player.respond(false);
        else
            player.respond(true);
        return false;
    }

    public void loopUntilPlayerSucceed()
    {
        while (!nextRound())
        {
            nextRound();
        }
    }
}

