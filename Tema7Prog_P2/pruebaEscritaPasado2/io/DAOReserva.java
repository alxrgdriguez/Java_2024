package Tema7Prog_P2.pruebaEscritaPasado2.io;

import Tema7Prog_P2.pruebaEscritaPasado2.entidades.Hotel;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.HotelPlaya;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.HotelRural;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.Reserva;
import Tema7Prog_P2.pruebaEscritaPasado2.servicios.Buking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DAOReserva {


    public static Buking cargarCSV() throws Exception{

        Path rutaReservas = Paths.get(".", "Tema7Prog_P2" ,"pruebaEscritaPasado2", "recursos", "reservas.csv");
        Path rutaHoteles = Paths.get(".", "Tema7Prog_P2", "pruebaEscritaPasado2", "recursos", "reservas.csv");

        Buking buk = new Buking();

        List<Hotel> hoteles = Files.lines(rutaHoteles)

                .map(linea ->{
                    String[] cad = linea.split(",");

                    int tipoHotel = Integer.parseInt(cad[7]);
                    if (tipoHotel == 1){
                        HotelRural hr = new HotelRural(cad[0],cad[1],cad[2], cad[3], Integer.parseInt(cad[4]),
                                Double.parseDouble(cad[5]),Integer.parseInt(cad[6]), Boolean.parseBoolean(cad[8]));
                        return hr;
                    }else {
                        HotelPlaya hplya = new HotelPlaya(cad[0],cad[1],cad[2], cad[3], Integer.parseInt(cad[4]),
                                Double.parseDouble(cad[5]),Integer.parseInt(cad[6]), Boolean.parseBoolean(cad[9]));
                        return hplya;
                    }
                })
                .toList();

        buk.setHoteles(hoteles);


        Set<Reserva> reservas = Files.lines(rutaReservas)
                .map(linea -> {
                    String[] cad = linea.split(",");

                    Reserva reserva = new Reserva(LocalDate.parse(cad[0]), LocalDate.parse(cad[1]), Integer.parseInt(cad[2]),
                            Integer.parseInt(cad[3]), cad[4], cad[5], buk.findHotelById(Long.parseLong(cad[6])));

                    return reserva;

                })
                .collect(Collectors.toSet());
        buk.setReservas(reservas);

        return buk;
    }

    public static void grabarCSV(Buking booking) throws IOException {

        Path ficheroReservas = Paths.get(".", "Tema7Prog_P2" ,"pruebaEscritaPasado2", "recursos", "reservas.csv");
        Path ficheroHoteles = Paths.get(".", "Tema7Prog_P2", "pruebaEscritaPasado2", "recursos", "reservas.csv");

        Files.deleteIfExists(ficheroHoteles);
        BufferedWriter bwHotel = Files.newBufferedWriter(ficheroHoteles,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);

        StringBuffer sbHotel = new StringBuffer();
        for (Hotel hotel : booking.getHoteles()){
            if (hotel instanceof HotelRural){
                HotelRural hr = (HotelRural) hotel;
                sbHotel.append(hr.getNombre()).append(",");
                sbHotel.append(hr.getDireccion()).append(",");
                sbHotel.append(hr.getLocalidad()).append(",");
                sbHotel.append(hr.getProvincia()).append(",");
                sbHotel.append(hr.getNumHabitaciones()).append(",");
                sbHotel.append(hr.getPrecioNoche()).append(",");
                sbHotel.append(hr.getCalificacion()).append(",");
                sbHotel.append(1).append(",");
                sbHotel.append(hr.getCalefacion()).append(",");
                sbHotel. append(0).append("\n"); //Cómo los hoteles rurales no tienen aire le ponemos 0
            } else {
                HotelPlaya hp = (HotelPlaya) hotel;
                sbHotel.append(hp.getNombre()).append(",");
                sbHotel.append(hp.getDireccion()).append(",");
                sbHotel.append(hp.getLocalidad()).append(",");
                sbHotel.append(hp.getProvincia()).append(",");
                sbHotel.append(hp.getNumHabitaciones()).append(",");
                sbHotel.append(hp.getPrecioNoche()).append(",");
                sbHotel.append(hp.getCalificacion()).append(",");
                sbHotel.append(0).append(",");
                sbHotel.append(0).append(",");
                sbHotel.append(hp.getAireAcondicionado()).append("\n");
            }
        }

        bwHotel.write(sbHotel.toString());
        bwHotel.close();


        Files.deleteIfExists(ficheroReservas);
        BufferedWriter bwReservas = Files.newBufferedWriter(ficheroReservas,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);

        StringBuffer sbReservas = new StringBuffer();
        for (Reserva reserva : booking.getReservas()){
            sbReservas.append(reserva.getFechaEntrada()).append(",");
            sbReservas.append(reserva.getFechaSalida()).append(",");
            sbReservas.append(reserva.getCantidadHabitaciones()).append(",");
            sbReservas.append(reserva.getNumPersonasPorHabitacion()).append(",");
            sbReservas.append(reserva.getDni()).append(",");
            sbReservas.append(reserva.getNacionalidad()).append(",");
            sbReservas.append(reserva.getHotel().getId()).append("\n");
        }

        bwReservas.write(sbReservas.toString());
        bwReservas.close();
    }
}
