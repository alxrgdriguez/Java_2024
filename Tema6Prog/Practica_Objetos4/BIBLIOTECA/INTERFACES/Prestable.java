package BIBLIOTECA.INTERFACES;

import BIBLIOTECA.ENTIDADES.Usuario;

public interface Prestable {

    void prestaAUsuario(Usuario user);

    void devuelve(Usuario user);

    boolean estaPrestado();
}
