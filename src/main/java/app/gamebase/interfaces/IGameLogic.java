package app.gamebase.interfaces;
//Interfaz con los metodos que permiten validar las reglas o logica del juego
// Como se si ya gane?
// Estoy cerca de adivinar?
// Como y cuando empieza el juego?
public interface IGameLogic<T> {
    // Metodo void donde se debe implementar la logica de validacion segun el tipo
    // de variable a usar (int,String,arreglo u Objecto).
    void validateGuess(T userGuess);

    // Funcion principal donde se inicia el juego (como el main function de la clase)
    void startGame();

    // Metodo que dermina la logica del juego cuando el usuario ha ganado.
    void showVictory();

    // Metodo que dermina la logica del juego cuando el usuario se ha quedado sin vidas.
    // Es decir, que el usuario perdio.
    void showDefeat();

}
