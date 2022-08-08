package app.gamebase.interfaces;
/**
 * Interfaz para manejar la logica/metodos de "vidas"
 */
public interface IGameLives {
    //Una funcion que te regrese el numero de vidas restantes
    int getLivesLeft();
    //Una funcion que te reste una vida
    void decreaseLiveNum();
}
