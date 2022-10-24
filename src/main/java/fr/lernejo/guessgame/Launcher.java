package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Merci de renseigner un argument: ");
            System.out.println("-interactive pour jouer vous même");
            System.out.println("-auto <nb depart> pour que l'ordinateur joue à votre place");
            System.exit(1);
        }
        else if (args[0].equalsIgnoreCase("-interactive"))
        {
            Player player = new HumanPlayer();
            Simulation sim = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            //System.out.println(randomNumber);
            sim.initialize(randomNumber);
            sim.loopUntilPlayerSucceed(100000000);
            System.exit(1);
        }
        else if(args[0].equalsIgnoreCase("-auto") && args.length == 1)
        {
            System.out.println("Merci de renseigner une valeur de départ pour l'ordinateur");
            System.exit(1);
        }
        else if (args[0].equalsIgnoreCase("-auto") && args[1] != null)
        {
            try
            {
                int nb = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Le second argument doit être un entier positif");
                System.exit(1);
            }
            Player player = new ComputerPlayer();
            Simulation sim = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            sim.initialize(randomNumber);
            sim.loopUntilPlayerSucceed(1000);
        }
        else
        {
            System.out.println("Une erreur est survenue.");
        }
    }
}
