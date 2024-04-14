package Tema7Prog_P2.practica2_stream.videojuego.entidades;

public class Puntuacion {

    //Propiedades
    private Integer puntosObtenidos;
    private Integer partidasJugadas;
    private Integer partidosGanados;
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

    public Integer getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(Integer partidosGanados) {
        this.partidosGanados = partidosGanados;
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
        sb.append(", PG=").append(partidosGanados);
        sb.append(", PP=").append(partidasPerdidas);
        sb.append('}');
        return sb.toString();
    }
}
