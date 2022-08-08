package app.numguessgame;

import app.gamebase.Game;
import app.gamebase.interfaces.IGameLives;
import app.gamebase.interfaces.IGameLogic;
import app.gamebase.interfaces.IUserInput;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

/**
 * <p>Title: Game With Numbers</p>
 * <p>Description: This class represents all pre-game configurations set by the user to run a Guess Based Game with
 * a random Integer. It also provides methods
 * to get and modify (if it is allow) those game attributes/parameters.
 * <p>Copyright: Copyright (c) 2022</p>
 * <p>Company: Accenture</p>
 *
 * @author Cristian C. & Jose R.
 * @version 1.0
 * @see Game
 * @see IGameLogic
 */
public class GameWNumbers extends Game<Integer> implements IGameLogic<Integer>, IGameLives, IUserInput<Integer> {
    //Numero de vidas
    private int livesNum;
    //Una "Flag" que me indica si el usuario ha ganado
    private boolean hasWon = false;

    @Override
    public int getLivesLeft() {
        return livesNum;
    }

    @Override
    public void decreaseLiveNum() {
        if (livesNum > 0) {
            livesNum--;
        }
    }

    private static final int MAX_RND_VALUE = 100;

    /**
     * Returns a Game Intance with the user configurations.
     */
    public GameWNumbers() {
        livesNum = 5;
    }

    /**
     * Returns a Game Intance with the user configurations.
     *
     * @param livesNum The maximum number of attempts a user has to guess the random number.
     *                 (Optional. By default, the value its equal to 5).
     */
    public GameWNumbers(int livesNum) {
        this.livesNum = livesNum;
    }

    @Override
    public void generateRandom() {
        Random r = new SecureRandom();
        super.randomObject = r.nextInt(MAX_RND_VALUE);
    }

    @Override
    public Integer validateInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            System.out.println("Ese no es un numero valido, intenta otra vez.\n");
            return -1;
        }
        int parsedValue = Integer.parseInt(userInput);
        if (parsedValue < 0 || parsedValue > MAX_RND_VALUE) {
            System.out.println("El valor es menor a 0 o mayor al maximo permitido (" + MAX_RND_VALUE + ")");
            return -1;
        } else {
            return parsedValue;
        }
    }

    @Override
    public void validateGuess(Integer userGuess) {
        if (userGuess > randomObject) {
            System.out.println("¡Huy! te pasaste, el numero a adivinar es menor a " + userGuess);
            this.decreaseLiveNum();
        } else if (userGuess < randomObject) {
            System.out.println("¡Uff! te falta, el numero  a adivinar es mayor a " + userGuess);
            this.decreaseLiveNum();
        } else {
            hasWon = true;
        }
    }

    @Override
    public void startGame() {
        Scanner stream = new Scanner(System.in);
        String userInput;
        int parsedValue = -1;
        while (getLivesLeft() > 0 && !hasWon) {

            while (parsedValue == -1) {
                System.out.println("Ingresa tu numero: ");
                userInput = stream.next();
                parsedValue = validateInput(userInput);
            }
            validateGuess(parsedValue);
            System.out.println("OJO, te quedan " + this.getLivesLeft() + " vidas.");
            parsedValue = -1;
        }
        if (hasWon) {
            showVictory();
        } else {
            showDefeat();
        }
    }

    @Override
    public void showVictory() {
        System.out.println("¡Ding, ding, ding, ding!");
        System.out.println("Felicidades has ganado. El numero era " + randomObject);
    }

    @Override
    public void showDefeat() {
        System.out.println("¡Demasiados intentos!");
        System.out.println("Lo siento,ya no te quedan vidas. El numero era " + randomObject);
    }

}
