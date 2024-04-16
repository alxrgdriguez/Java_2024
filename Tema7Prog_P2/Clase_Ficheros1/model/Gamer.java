package Tema7Prog_P2.Clase_Ficheros1.model;

import java.util.Objects;

public class Gamer {

    //Atributos
    private Long id;
    private String nick;
    private String email;
    private String juego;
    private  Nivel nivel;

    //Constructor
    public Gamer(Long id, String nick, String email, String juego, Nivel nivel) {
        this.id = id;
        this.nick = nick;
        this.email = email;
        this.juego = juego;
        this.nivel = nivel;
    }

    //Getters and Setters
    public Gamer() {
    }

    public Long getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Gamer{");
        sb.append("id=").append(id);
        sb.append(", nick='").append(nick).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", juego='").append(juego).append('\'');
        sb.append(", nivel=").append(nivel);
        sb.append('}');
        return sb.toString();
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(email, gamer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
