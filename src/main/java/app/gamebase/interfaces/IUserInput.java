package app.gamebase.interfaces;

// Interfaz con los metodos para validar lo que el usuario registre en el juego
// Si lo que escribio es un int, un double o un String, etc.
// T significa que de Tipo dinamico (Puede funcionar con Clases)
public interface IUserInput<T> {
    T validateInput(String userInput);
}
