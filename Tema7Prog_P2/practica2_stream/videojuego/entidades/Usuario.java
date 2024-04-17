package Tema7Prog_P2.practica2_stream.videojuego.entidades;

import java.util.HashMap;

public class Usuario {

    //Propiedades
    public static Integer id = 0;
    private Integer idUsuario;
    private String nombre;
    private String email;
    private String nick;
    private HashMap<Integer, Puntuacion> puntuaciones;

    //Constructor

    public Usuario(String nombre, String email, String nick) {
        this.idUsuario = id++;
        this.nombre = nombre;
        this.email = email;
        this.nick = nick;
        this.puntuaciones = new HashMap<>();
    }

    //Getters and Setters
    public Integer getId() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public HashMap<Integer, Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(HashMap<Integer, Puntuacion> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("nick='").append(nick).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    // --- METODOS ---

    /**
     * Buscará el juego, si no
     * existe añade esa Puntuacion, si existe incrementará las partidas jugadas, las ganadas o
     * perdidas, y sumará los puntos a la puntuación de ese juego.
     * @param idJuego
     * @param haGanado
     * @param puntosObtenidos
     */
    public void addPuntuacion(Integer idJuego, Boolean haGanado, Integer puntosObtenidos){


        if (this.puntuaciones.get(idJuego) == null){
            this.puntuaciones.put(idJuego, new Puntuacion());
            this.puntuaciones.get(idJuego).setPuntosObtenidos(0);
            this.puntuaciones.get(idJuego).setPartidasJugadas(0);
            this.puntuaciones.get(idJuego).setPartidasGanadas(0);
            this.puntuaciones.get(idJuego).setPartidasPerdidas(0);
        }

        this.puntuaciones.forEach((idjuego, puntuacion) -> {

            if (idjuego.equals(idJuego)){
                puntuacion.setPartidasJugadas(puntuacion.getPartidasJugadas()+1);

                if (haGanado){
                    puntuacion.setPartidasGanadas(puntuacion.getPartidasGanadas()+1);
                }else {
                    puntuacion.setPartidasPerdidas(puntuacion.getPartidasPerdidas()+1);
                }
                puntuacion.setPuntosObtenidos(puntuacion.getPuntosObtenidos()+puntosObtenidos);

                return; //Salimos del bucle
            }

        });

    }

    /**
     * @param idJuego
     * @return únicamente los puntos de ese juego.
     */
    public Integer getPuntuacion(Integer idJuego){
        return this.puntuaciones.get(idJuego).getPuntosObtenidos();
    }

}
