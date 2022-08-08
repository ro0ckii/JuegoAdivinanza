package app.gamebase;
//
public abstract class Game<T> {
    protected T randomObject;
    public Game(){
        generateRandom();
    }
    // El metodo que genera un valor aleatorio segun el el tipo de variable a usar
    public abstract void generateRandom();
}
