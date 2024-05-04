package Tema7Prog.ejercicios_UT7.expedienteAlumnos.entidades;

import Tema7Prog.ejercicios_UT7.expedienteAlumnos.enums.Activo;
import Tema7Prog.ejercicios_UT7.expedienteAlumnos.enums.Etapa;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Expediente {

    //Atributos
    private Estudiante estudiante;
    private HashSet<NotasCurso> notas;
    private Activo activo;

    //Constructor
    public Expediente() {
    }

    public Expediente(Estudiante estudiante, Activo activo) {
        this.estudiante = estudiante;
        this.activo = activo;
        this.notas = new HashSet<>();
    }

    //Getters and Setters
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public HashSet<NotasCurso> getNotas() {
        return notas;
    }

    public void setNotas(HashSet<NotasCurso> notas) {
        this.notas = notas;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Expediente{");
        sb.append("estudiante=").append(estudiante);
        sb.append(", notas=").append(notas);
        sb.append(", activo=").append(activo);
        sb.append('}');
        return sb.toString();
    }

    //equals por estudiante
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expediente that = (Expediente) o;
        return Objects.equals(estudiante, that.estudiante);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(estudiante);
    }

    //METODOS -------------------------------------------

    /**
     * Método para añadir todas las notas de un curso al expediente de una alumno
     */
    public void addNotas (NotasCurso nc){
        this.notas.add(nc);
    }

    /**
     * Método para eliminar todas las notas de un curso al expediente de una alumno
     */
    public void elimnarNotas (NotasCurso nc){
        this.notas.remove(nc);
    }

    /**
     * Mostrará todas las notas de este estudiante para una etapa y un curso concreto
     */
    public String mostrarNotas(int curso, Etapa etapa){

        StringBuffer sb = new StringBuffer();
        sb.append("Notas estudiante: ").append(curso).append(" ").append(etapa).append("\n");

        for (NotasCurso cursoPintar : this.notas){
            if (cursoPintar.getCurso().equals(curso) && cursoPintar.getEtapaEducativa().equals(etapa)){
                for (Map.Entry<String, Double> notaPintar : cursoPintar.getNotas().entrySet()){
                    sb.append("asignatura: ").append(notaPintar.getKey()).append("\n");
                    sb.append("nota: ").append(notaPintar.getValue()).append("\n");
                }
            }
        }
        return sb.toString();
    }


}
