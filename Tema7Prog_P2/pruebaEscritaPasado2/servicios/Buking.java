package Tema7Prog_P2.pruebaEscritaPasado2.servicios;

import Tema7Prog.ejercicios.hotel.Zona;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.Hotel;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.HotelPlaya;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.HotelRural;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.Reserva;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Buking {

    private List<Hotel> hoteles;
    private Set<Reserva> reservas;

    public Buking() {

        this.hoteles = new ArrayList<>();
        this.reservas = new HashSet<>();
    }

    public List<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Buking{");
        sb.append("hoteles=").append(hoteles);
        sb.append(", reservas=").append(reservas);
        sb.append('}');
        return sb.toString();
    }

    public void addHotel(Hotel hotel){
        this.hoteles.add(hotel);
    }

    public void deleteHotel(Hotel hotel){
        this.hoteles.remove(hotel);
    }

    public void addReserva(LocalDate fechaEntrada, LocalDate fechaSalida, Integer cantidadHabitaciones, Integer numPersonasPorHabitacion, String dni,
                           String nacionalidad, Hotel hotel){

        Reserva reserva = new Reserva(fechaEntrada, fechaSalida, cantidadHabitaciones, numPersonasPorHabitacion, dni,nacionalidad, hotel);
        this.reservas.add(reserva);
    }

    public Reserva removeReserva(Long idReserva){
        return this.reservas.stream()
                .filter(reserva -> reserva.getId().equals(idReserva))
                .findFirst()
                .orElse(null);
    }

    public Hotel findHotelById(Long id){
        return this.hoteles.stream()
                .filter(hotel -> hotel.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Hotel> findHotelByProvincia(String provincia){
        return this.hoteles.stream()
                .filter(hotel -> hotel.getProvincia().equals(provincia))
                .toList();
    }

    public List<Hotel> getHotelesPequenios(){
        return this.hoteles.stream()
                .filter(hotel -> hotel.getNumHabitaciones() < 20)
                .sorted(Comparator.comparing(Hotel::getPrecioNoche).reversed())
                .toList();
    }

    public List<Hotel> getHotelesCaros(){
        return this.hoteles.stream()
                .sorted(Comparator.comparing(Hotel::getPrecioNoche).reversed())
                .limit(2)
                .toList();
    }


    public HashMap<String, List<Hotel>> getHotelesLocalidad(){
        HashMap<String, List<Hotel>> hotelesAgrupados = (HashMap<String, List<Hotel>>) this.hoteles.stream()
                .collect(Collectors.groupingBy(Hotel::getLocalidad));

                hotelesAgrupados.forEach((k,v) -> {
                    v.sort(Comparator.comparing(Hotel::getPrecioNoche));
                });

                return hotelesAgrupados;
    }

    public Set<Hotel> getHotelPlaya(){
        return this.hoteles.stream()
                .filter(hotel -> hotel instanceof HotelPlaya)
                .collect(Collectors.toSet());
    }

    public Set<Hotel> getHotelRural(){
        return this.hoteles.stream()
                .filter(hotel -> hotel instanceof HotelRural)
                .collect(Collectors.toSet());
    }

    public HashMap<String, Long> getReservasPais(){
        return (HashMap<String, Long>) this.reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getNacionalidad, Collectors.counting()));

    }

    public Reserva findReservaById(Long id){
       return this.reservas.stream()
                .filter(reserva -> reserva.getId().equals(id))
                .findFirst()
                .orElse(null);
    }



    /*public double getImporteReserva(Long idReserva){
        Reserva reserva = new Reserva(this.findReservaById(idReserva));
        int numDias = Period.between(reserva.getFechaEntrada(), reserva.getFechaSalida()).getDays())
        return reserva.getNumPersonasPorHabitacion() * reserva.getHotel().getPrecioNoche() * numDias;
    }*/

    public List<Reserva> getReservasActivas(Long idHotel){
        return this.reservas.stream()
                .filter(reserva -> reserva.getHotel().getId().equals(idHotel) && reserva.getFechaSalida().isAfter(LocalDate.now()))
                .filter(reserva -> reserva.getFechaEntrada().isBefore(LocalDate.now()) ||
                        reserva.getFechaSalida().equals(LocalDate.now()))
                .filter(reserva -> reserva.getFechaSalida().isAfter(LocalDate.now()) ||
                        reserva.getFechaSalida().equals(LocalDate.now()))
                .toList();
    }

    public List<Reserva> getReservasOrdenadas(){
        return this.reservas.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    /**
     * Saca las reservas de un hotel finalizadas (fecha de
     * salida anterior a hoy de este año), y suma el importe de todas ellas
     * @param idHotel
     * @return
     */
    public Double getImporteReservasFinalizadas(Long idHotel){
        return this.reservas.stream()
                .filter(reserva -> reserva.getHotel().equals(idHotel))
                .filter(reserva -> reserva.getFechaSalida().isBefore(LocalDate.now()))
                .mapToDouble(reservas -> { //Si se abre llave hay que meter el return al ser un map
                     int numDias = Period.between(reservas.getFechaEntrada(), reservas.getFechaSalida()).getDays();
                     return reservas.getNumPersonasPorHabitacion() * reservas.getHotel().getPrecioNoche() * numDias;
                })
                .sum();

    }



}
