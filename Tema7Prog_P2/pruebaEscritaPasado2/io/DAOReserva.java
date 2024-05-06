package Tema7Prog_P2.pruebaEscritaPasado2.io;

import Tema7Prog_P2.pruebaEscritaPasado2.entidades.Hotel;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.HotelPlaya;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.HotelRural;
import Tema7Prog_P2.pruebaEscritaPasado2.entidades.Reserva;
import Tema7Prog_P2.pruebaEscritaPasado2.servicios.Buking;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
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


        List<Reserva> reservas = Files.lines(rutaReservas)
                .map(linea -> {
                    String[] cad = linea.split(",");

                    Reserva reserva = new Reserva(LocalDate.parse(cad[0]), LocalDate.parse(cad[1]), Integer.parseInt(cad[2]),
                            Integer.parseInt(cad[3]), cad[4], cad[5], buk.findHotelById(Long.parseLong(cad[6])));

                    return reserva;

                })
                .toList();

        buk.setReservas(reservas.stream()
                .collect(Collectors.toSet()));

        return buk;
    }
}
