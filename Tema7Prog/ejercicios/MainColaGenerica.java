package Tema7Prog.ejercicios;

public class MainColaGenerica {

    public static void main(String[] args) {

        ColaGenerica<String> colaS = new ColaGenerica<>();
        colaS.insertar("Hola");
        colaS.insertar("Mundo");

        colaS.pintar();

        System.out.println(colaS.mostrarPrimero());

        colaS.sacar();

        colaS.pintar();
    }
}
