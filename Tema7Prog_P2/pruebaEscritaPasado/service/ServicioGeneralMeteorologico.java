package Tema7Prog_P2.pruebaEscritaPasado.service;

import Tema7Prog_P2.pruebaEscritaPasado.model.EstacionMeteorologica;
import Tema7Prog_P2.pruebaEscritaPasado.model.RegistroDatosDia;

import java.util.*;
import java.util.stream.Collectors;

public class ServicioGeneralMeteorologico {

    //Atributos
    private ArrayList<EstacionMeteorologica> estacionesMeteo;

    //Constructor
    public ServicioGeneralMeteorologico() {
        this.estacionesMeteo = new ArrayList<>();
    }

    //Getters and Setters
    public ArrayList<EstacionMeteorologica> getEstacionesMeteo() {
        return estacionesMeteo;
    }

    public void setEstacionesMeteo(ArrayList<EstacionMeteorologica> estacionesMeteo) {
        this.estacionesMeteo = estacionesMeteo;
    }

    //toString
    @Override
    public java.lang.String toString() {
        final StringBuffer sb = new StringBuffer("ServicioGeneralMeteorologico{");
        sb.append("Estaciones=").append(estacionesMeteo);
        sb.append('}');
        return sb.toString();
    }

    //METODOS ------------------------

    //Metodo para añadir una estacion

    public void nuevaEstacion(EstacionMeteorologica estacion){

        this.estacionesMeteo.add(estacion);
    }

    //Eliminar una estacion

    public void eliminarEstacion(EstacionMeteorologica estacion){
        this.estacionesMeteo.remove(estacion);
    }

    //Buscar una estacion por nombre
    public EstacionMeteorologica buscarEstacion(String nombre) {

       return this.estacionesMeteo.stream()
                .filter(estacion -> estacion.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    //Devuelve una lista con todos los registros
    //tomados en una determinada estación meteorológica ordenados por fecha. Puedes usar flatmap para
    //juntar todos los registros
    public List<RegistroDatosDia> getTempPorEstacion(Integer id){

        return this.estacionesMeteo.stream()
                .filter(estacion -> estacion.getId().equals(id))
                .flatMap(estacion -> estacion.getRegistrosDia().stream())
                .sorted(Comparator.comparing(RegistroDatosDia::getFecha))
                .toList();
    }

    // Devuelve una lista con todas los
    //registros tomados en un determinado año en una estación, ordenados por temperatura media. Puedes
    //usar flatmap para juntar todos los registros
    public List<RegistroDatosDia> getTempPorAnioEstacion(Integer id, Integer anio){
        return this.estacionesMeteo.stream()
                .filter(estacion -> estacion.getId().equals(id))
                .filter(estacionMeteorologica -> estacionMeteorologica.getRegistrosDia().equals(anio))
                .flatMap(estacionMeteorologica -> estacionMeteorologica.getRegistrosDia().stream())
                .sorted(Comparator.comparing(RegistroDatosDia::getTempMedia))
                .toList();

    }


    //Devuelve una lista con todos los registros tomados en esa comunidad ordenados por fecha. Pista: flatmap
    public List<RegistroDatosDia> getTempPorComunidad(String comunidad){

        return this.estacionesMeteo.stream()
                .filter(es -> es.getComunidad().equals(comunidad))
                .flatMap(es -> es.getRegistrosDia().stream())
                .sorted(Comparator.comparing(RegistroDatosDia::getFecha))
                .toList();
    }

    // Devuelve la temperatura más alta que se haya registrado
    public RegistroDatosDia getTempPorComunidad(){
        return this.estacionesMeteo.stream()
                .flatMap(estacion -> estacion.getRegistrosDia().stream())
                .max(Comparator.comparing(RegistroDatosDia::getTempMax))
                .orElse(null);
    }

    //Devuelve un mapa que agrupe por comunidad todas las estaciones en esa comunidad.
    public Map<String, List<EstacionMeteorologica>> getEstacionesPorComunidad(){
        return this.estacionesMeteo.stream()
                .collect(Collectors.groupingBy(EstacionMeteorologica::getComunidad));
    }

    // Devuelve true si alguna temperatura media supera 30 grados
    public Boolean isTempMediaAlta () {
        return this.estacionesMeteo.stream()
                .flatMap(em -> em.getRegistrosDia().stream())
                .anyMatch(r -> r.getTempMedia() > 30);
    }

   // Metodo para borrar todas las estaciones de una comunidad
    public void borrarEstacionesComunidad(EstacionMeteorologica comunidad){
        this.estacionesMeteo.removeIf(estacionMeteorologica -> estacionMeteorologica.getComunidad().equals(comunidad));
    }

    // Metodo para mostrar las temperaturas de una estacion en grados farenheit
    public void pintaTempEstacionFarenheit(Integer id){
        this.getTempPorEstacion(id).stream()
                .map(RegistroDatosDia::getTempMax)
                .forEach(tempMax -> {
                    System.out.println((tempMax * 1.08) +32);
                });

    }

    // Metodo para obtener los numeros de registros por estacion
    public Map<String, Long> getNumRegistros(){
        return this.estacionesMeteo.stream()
                .collect(Collectors.toMap(EstacionMeteorologica::getNombre,
                        estacion -> estacion.getRegistrosDia().stream()
                                .count()));
    }

}