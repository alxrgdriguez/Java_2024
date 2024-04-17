package Tema7Prog_P2.practica2_stream.videojuego.entidades;

public class Puntuacion {

    //Propiedades
    private Integer puntosObtenidos;
    private Integer partidasJugadas;
    private Integer partidasGanadas;
    private Integer partidasPerdidas;

    //Contructor

    /**
     * Constructor vacio
     */
    public Puntuacion() {

    }

    //Getters and Setters

    public Integer getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(Integer puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public Integer getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(Integer partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public Integer getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(Integer partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public Integer getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(Integer partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Puntuacion{");
        sb.append("Puntos=").append(puntosObtenidos);
        sb.append(", PJ=").append(partidasJugadas);
        sb.append(", PG=").append(partidasGanadas);
        sb.append(", PP=").append(partidasPerdidas);
        sb.append('}');
        return sb.toString();
    }
}
