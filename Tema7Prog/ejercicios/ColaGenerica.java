package Tema7Prog.ejercicios;

import java.util.LinkedList;

public class ColaGenerica<T> {

    private LinkedList<T> cola = new LinkedList<>();

    public void insertar(T t) {
        //cola.add(t);
        cola.addLast(t);
    }

    public T sacar() {
        //return cola.poll();
        return cola.pollFirst();
    }

    public T mostrarPrimero() {
        //return cola.peek();
        return cola.peekFirst();
    }

    public void pintar() {
        for(T t: cola) {
            System.out.println(t);
        }
    }

}
