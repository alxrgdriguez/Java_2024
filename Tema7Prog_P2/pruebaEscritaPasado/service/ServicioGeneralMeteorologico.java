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

    /**
     * Añadir una estacion
     */
    public void nuevaEstacion(EstacionMeteorologica estacion) {
        this.estacionesMeteo.add(estacion);
    }

    /**
     * Eliminar una estacion
     */
    public void eliminarEstacion(EstacionMeteorologica estacion) {
        this.estacionesMeteo.remove(estacion);
    }

    /**
     * Buscar una EstacionMeteorologica por nombre
     */
    public EstacionMeteorologica buscarEstacion(java.lang.String nombre) {
        return this.estacionesMeteo.stream()
                .filter(estacion -> estacion.getNombre().equals(nombre))
                .findFirst()
                .orElse(new EstacionMeteorologica());
    }

    /**
     * Devuelve una lista con todos los registros tomados en
     * una determinada estación meteorológica ordenados por fecha. Puedes usar flatmap para
     * juntar todos los registros
     */
    public List<RegistroDatosDia> getTempPorEstacion(int i){

        return this.estacionesMeteo.stream()
                .filter(estacionMeteorologica -> estacionMeteorologica.getId().equals(i))
                .flatMap(estacionMeteorologica -> estacionMeteorologica.getRegistrosDia().stream())
                .sorted(Comparator.comparing(RegistroDatosDia::getFecha))
                .toList();
    }

    /**
     * Devuelve una lista con todas los
     * registros tomados en un determinado año en una estación, ordenados por temperatura media. Puedes
     * usar flatmap para juntar todos los registros
     */
    public List<RegistroDatosDia> getTempPorAnioEstacion(){
        return this.estacionesMeteo.stream()
                .flatMap(estacionMeteorologica -> estacionMeteorologica.getRegistrosDia().stream())
                .sorted(Comparator.comparing(RegistroDatosDia::getTempMedia))
                .toList();
    }

    /**
     * Devuelve una lista con todos los registros tomados en esa comunidad ordenados por fecha. Pista: flatmap
     */
    public List<RegistroDatosDia> getTempPorComunidad(String string){
        return this.estacionesMeteo.stream()
                .filter(estacionMeteorologica -> estacionMeteorologica.getComunidad().equals(string))
                .flatMap(estacionMeteorologica -> estacionMeteorologica.getRegistrosDia().stream())
                .sorted(Comparator.comparing(RegistroDatosDia::getFecha))
                .toList();
    }

    /**
     *  Devuelve la temperatura más alta que se haya registrado
     * @return
     */
    public RegistroDatosDia getTempMaxRegistrada(){
        return this.estacionesMeteo.stream()
                .flatMap(estacionMeteorologica -> estacionMeteorologica.getRegistrosDia().stream())
                .max(Comparator.comparing(RegistroDatosDia::getTempMax))
                .orElse(new RegistroDatosDia());
    }

    /**
     * Devuelve un mapa que agrupe por comunidad todas las estaciones en esa comunidad.
     */
    public Map<String, List<EstacionMeteorologica>> getEstacionesPorComunidad(){
        return new HashMap<>(this.estacionesMeteo.stream()
                .collect(Collectors.groupingBy(EstacionMeteorologica::getComunidad)));
    }

    /**
     * Devuelve true si alguna temperatura media supera 30 grados
     */
    public Boolean isTemperaturaMediaAlta(){
        return this.estacionesMeteo.stream()
                .flatMap(estacionMeteorologica -> estacionMeteorologica.getRegistrosDia().stream())
                .anyMatch(registroDatosDia -> registroDatosDia.getTempMedia() > 30);
    }

    /**
     *  Devuelve un map agrupando por comunidad que contenga la comunidad
     *  y la lectura con la temperatura máxima en esa comunidad
     */
    public Map<String, Double> getTemperaturaMaxPorComunidad(){
        return this.estacionesMeteo.stream()
                .collect(Collectors.toMap(EstacionMeteorologica::getComunidad ,
                        estacion -> estacion.getRegistrosDia().stream()
                                .mapToDouble(RegistroDatosDia::getTempMax)
                                .max()
                                .orElseThrow()));
    }

    /**
     * Borrar todas las estaciones que estén en una comunidad
     */
    public void borrarEstacionesPorComunidad(String string){
        this.estacionesMeteo.removeIf(estacionMeteorologica -> estacionMeteorologica.getComunidad().equals(string));
    }

    /**
     * Para una estación pinta sus temperaturas en Farenheit
     * Pista: puedes llamar a getTempPorEstacion(int id).
     */
    public void pintarTempEstacionFarenheit(Integer id){
        this.estacionesMeteo.stream()
                .filter(estacionMeteorologica -> estacionMeteorologica.getId().equals(id))
                .flatMap(estacionMeteorologica -> estacionMeteorologica.getRegistrosDia().stream())
                .forEach(registroDatosDia -> System.out.println(registroDatosDia.getTempMedia() * 1.8 + 32));

    }

    /**
     * Devuelve un Map agrupando por estación, cuyo valor sea
     * el número de registros de temperatura tomados en esa estación
     */
    public Map<java.lang.String, Integer> getNumRegistros(){
        return this.estacionesMeteo.stream()
                .collect(Collectors.toMap(EstacionMeteorologica::getNombre,
                        estacion -> estacion.getRegistrosDia().size()));
    }
}
