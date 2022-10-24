package fr.lernejo.guessgame;

public class ComputerPlayer implements Player
{

    public int min = 0;
    public int max = 100;
    public int guess = (min + max) / 2;

    @Override
    public long askNextGuess() {
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        //System.out.println("Tentative: " + guess);
        if (lowerOrGreater) {
            min = guess;
        } else {
            max = guess;
        }
        guess = (min + max) / 2;
    }
}
