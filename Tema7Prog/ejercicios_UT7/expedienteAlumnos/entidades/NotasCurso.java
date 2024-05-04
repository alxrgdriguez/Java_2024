package Tema7Prog.ejercicios_UT7.expedienteAlumnos.entidades;

import Tema7Prog.ejercicios_UT7.expedienteAlumnos.enums.Etapa;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class NotasCurso {

    //Atributos
    private Etapa etapaEducativa;
    private String nombreCiclo;
    private Integer curso;
    private HashMap<String, Double> notas;
    private Integer anio;

    //Constructor

    public NotasCurso(Etapa etapaEducativa, String nombreCiclo, Integer curso, Integer anio) {
        this.etapaEducativa = etapaEducativa;
        this.nombreCiclo = nombreCiclo;
        this.curso = curso;
        this.notas = new HashMap<>();
        this.anio = anio;
    }

    //Getters and Setters
    public Etapa getEtapaEducativa() {
        return etapaEducativa;
    }

    public void setEtapaEducativa(Etapa etapaEducativa) {
        this.etapaEducativa = etapaEducativa;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public HashMap<String, Double> getNotas() {
        return notas;
    }

    public void setNotas(HashMap<String, Double> notas) {
        this.notas = notas;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("NotasCurso{");
        sb.append("etapaEducativa=").append(etapaEducativa);
        sb.append(", nombreCiclo='").append(nombreCiclo).append('\'');
        sb.append(", curso=").append(curso);
        sb.append(", notas=").append(notas);
        sb.append(", anio=").append(anio);
        sb.append('}');
        return sb.toString();
    }

    //equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotasCurso that = (NotasCurso) o;
        return etapaEducativa == that.etapaEducativa && Objects.equals(nombreCiclo, that.nombreCiclo) && Objects.equals(curso, that.curso) && Objects.equals(anio, that.anio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etapaEducativa, nombreCiclo, curso, anio);
    }

    // METODOS ---------------------------------------

    /**
     * Metodo para añadir una nota
     */
    public void addNota (String asignatura, Double nota){
        this.notas.put(asignatura, nota);
    }

    /**
     * Metodo eliminar una nota
     */
    public void eliminarNota (String asignatura){
        this.notas.remove(asignatura);
    }

    /**
     * Método para buscar una nota
     * @return la nota de una materia
     */
    public Double buscarNota (String asignatura){
        return this.notas.get(asignatura);

    }

    /**
     * Método para pintar las notas ordenadas por asignatura
     */
    public String pintar (){

        TreeMap<String, Double> ordenado = new TreeMap<>(this.notas);
        //ordenado.putAll(this.notas); para meterlo dentro del TreeMap sino esta pasado por los parentesis
        StringBuffer sb = new StringBuffer();
        sb.append("Notas del Curso: " ).append("\n");
        for (Map.Entry<String, Double> pintarNota : this.notas.entrySet()){
            sb.append("Asignatura: ").append(pintarNota.getKey()).append("\n");
            sb.append("Nota: ").append(pintarNota.getValue()).append("\n");
        }
        return sb.toString();
    }
}
