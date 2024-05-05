package Tema7Prog_P2.pruebaEscritaPasado.io;

import Tema7Prog_P2.pruebaEscritaPasado.model.EstacionMeteorologica;
import Tema7Prog_P2.pruebaEscritaPasado.model.RegistroDatosDia;
import Tema7Prog_P2.pruebaEscritaPasado.service.ServicioGeneralMeteorologico;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MeteoFile {

    private static ServicioGeneralMeteorologico sgm = new ServicioGeneralMeteorologico();

    private static Path rutaEstaciones = Paths.get("Tema7Prog_P2", "pruebaEscritaPasado","recursos","estaciones.csv");
    private static Path rutaRegistros = Paths.get("Tema7Prog_P2", "pruebaEscritaPasado","recursos","registros.csv");


    public static ServicioGeneralMeteorologico getSgm() {
        return sgm;
    }

    public static void cargarDatosCSV() throws Exception{

        ArrayList<EstacionMeteorologica> estaciones = new ArrayList<>();

        //Cargamos los registros
        List<RegistroDatosDia> registrosFicheros = Files.lines(rutaRegistros)
            .map(str -> {
                String[] cad = str.split(",");

                return new RegistroDatosDia(Integer.parseInt(cad[0]), cad[1],Double.parseDouble(cad[2]),
                        Double.parseDouble(cad[3]), Double.parseDouble(cad[4]), Integer.parseInt(cad[5]));
            }).toList();


        //Cargamos las estaciones
        List<EstacionMeteorologica> estacionesFichero = Files.lines(rutaEstaciones)
                .map(str -> {
                    String[] cad = str.split(",");

                    //Los registros que se van a buscar para guardarlos dentro de la estacion
                    TreeSet<RegistroDatosDia> registrosParaGuardar = new TreeSet<>();

                    //Recorremos los registros recuperados anteriormente
                    for(RegistroDatosDia registro: registrosFicheros){
                        //Si el id de la estacion del registro es igual a el id de la estacion actual, añadimos ese registro
                        if (Integer.parseInt(cad[0]) == (registro.getIdEstacion())){
                            registrosParaGuardar.add(registro);
                        }
                    }

                    return new EstacionMeteorologica(Integer.parseInt(cad[0]), cad[1], cad[2], Double.parseDouble(cad[3]), Double.parseDouble(cad[4]), registrosParaGuardar);
                })

                .toList();

        estaciones.addAll(estacionesFichero);

        //Metemos las estaciones del fichero en el objeto ServicioGeneralMeteorologico
        sgm.setEstacionesMeteo(new ArrayList<>(estaciones));// new ArrayList<>(estacionesFichero) --> Convierte la lista estacionesFichero a una ArrayList

        //return estaciones;
    }

    public static void grabarCSV() throws IOException {

        //Guardamos las estaciones
        BufferedWriter bw = Files.newBufferedWriter(rutaEstaciones,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.CREATE);

        //Guardamos los registros
        BufferedWriter bw2 = Files.newBufferedWriter(rutaRegistros,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.CREATE);

        for (EstacionMeteorologica estacion : sgm.getEstacionesMeteo()){
            StringBuffer sb = new StringBuffer();
            sb.append(estacion.getId()).append(",");
            sb.append(estacion.getNombre()).append(",");
            sb.append(estacion.getComunidad()).append(",");
            sb.append(estacion.getLatitud()).append(",");
            sb.append(estacion.getLongitud());


            for (RegistroDatosDia registros : estacion.getRegistrosDia()){
                StringBuffer sb2 = new StringBuffer();
                sb2.append(registros.getId()).append(",");
                sb2.append(registros.getFecha()).append(",");
                sb2.append(registros.getTempMax()).append(",");
                sb2.append(registros.getTempMin()).append(",");
                sb2.append(registros.getTempMedia()).append(",");
                sb2.append(registros.getIdEstacion());

                bw2.write(sb2.toString());
                bw2.newLine();

            }

            bw.write(sb.toString());
            bw.newLine();

        }

        //Cerramos los BufferedWriter !!IMPORTANTE¡¡
        bw.close();
        bw2.close();

    }

}
