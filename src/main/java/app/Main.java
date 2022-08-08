package app;
import app.numguessgame.GameWNumbers;

public class Main {
    public static void main(String[] args) {
        //  Create an instance (game1) with only 5 Lives
        GameWNumbers gameDemo1 = new GameWNumbers();
        //  Get the lives remaining from that instance (Game1)
        System.out.println("Vidas restantes game1 : " + gameDemo1.getLivesLeft());
        //  Remove a life from the previously created
        //   instance and get the number of lives remaining
        gameDemo1.decreaseLiveNum();
        System.out.println("Vidas restantes: " + gameDemo1.getLivesLeft());
        //  Create another "Game" instance, game2, passing 5 as the parameter for the number of lives.
        GameWNumbers gameDemo2 = new GameWNumbers(5);
        //  Show the remaining number of lives for both "Game" instances.
        System.out.println("Game1, Lives Remaining: " + gameDemo1.getLivesLeft());
        System.out.println("Game2, Lives Remaining: " + gameDemo2.getLivesLeft());
        gameDemo2.startGame();


    }
}
