package Tema7Prog_P2.practica2_stream.paisesMundo.aplicacion;

import Tema7Prog_P2.practica2_stream.paisesMundo.entidades.Ciudad;
import Tema7Prog_P2.practica2_stream.paisesMundo.entidades.Pais;
import Tema7Prog_P2.practica2_stream.paisesMundo.enums.Continente;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestPaises {

    public static void main(String[] args) {


        // ---- PAISES ----
        Pais hispania = new Pais("España", Continente.EUROPA, 47000000, 500000);
        Pais japon = new Pais("Japon", Continente.ASIA, 126500000, 377972);
        Pais argentina = new Pais("Argentina", Continente.AMERICA,44940000,2780400);
        Pais egipto = new Pais("Egipto", Continente.AFRICA,104000000, 1002450);
        Pais australia = new Pais("Australia", Continente.OCEANIA, 25670000, 7692024);
        Pais rusia = new Pais("Rusia", Continente.ASIA, 144500000, 17098242);
        Pais india = new Pais("India", Continente.ASIA, 1393000000, 3287240);
        Pais brasil = new Pais("Brasil", Continente.AMERICA, 213300000, 8515770);
        Pais nuevaZelanda = new Pais("Nueva Zelanda", Continente.OCEANIA, 206140000, 923768);
        Pais francia = new Pais("Francia", Continente.EUROPA, 67010000, 551695);

        // Añadir ciudades España
        Ciudad madrid = new Ciudad("Madrid",3000000, hispania);
        hispania.addCiudad(madrid); // Creamos la ciudad madrid y la añadimos como que es una ciudad de España
        hispania.setCapital(madrid); // Le decimos que es la capital de España

        hispania.addCiudad(new Ciudad("Murcia", 447182, hispania));
        hispania.addCiudad(new Ciudad("Almeria", 196851, hispania));
        hispania.addCiudad(new Ciudad("Granada", 500000, hispania));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a Japón
        Ciudad tokyo = new Ciudad("Tokyo", 13929286, japon);
        japon.addCiudad(tokyo);
        japon.setCapital(tokyo);

        japon.addCiudad(new Ciudad("Osaka", 2677117, japon));
        japon.addCiudad(new Ciudad("Nagoya", 2307109, japon));
        japon.addCiudad(new Ciudad("Sapporo", 1918096, japon));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a Argentina
        Ciudad buenosAires = new Ciudad("Buenos Aires", 2890000, argentina);
        argentina.addCiudad(buenosAires);
        argentina.setCapital(buenosAires);

        argentina.addCiudad(new Ciudad("Córdoba", 1330000, argentina));
        argentina.addCiudad(new Ciudad("Rosario", 1150000, argentina));
        argentina.addCiudad(new Ciudad("Mendoza", 780000, argentina));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a Egipto
        Ciudad cairo = new Ciudad("El Cairo", 9500000, egipto);
        egipto.addCiudad(cairo);
        egipto.setCapital(cairo);

        egipto.addCiudad(new Ciudad("Alejandría", 4546231, egipto));
        egipto.addCiudad(new Ciudad("Giza", 2443203, egipto));
        egipto.addCiudad(new Ciudad("Shubra El-Kheima", 1270000, egipto));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a Australia
        Ciudad sydney = new Ciudad("Sídney", 5312163, australia);
        australia.addCiudad(sydney);
        australia.setCapital(sydney);

        australia.addCiudad(new Ciudad("Melbourne", 5078193, australia));
        australia.addCiudad(new Ciudad("Brisbane", 2408220, australia));
        australia.addCiudad(new Ciudad("Perth", 2059484, australia));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a Rusia
        Ciudad moscu = new Ciudad("Moscú", 12615882, rusia);
        rusia.addCiudad(moscu);
        rusia.setCapital(moscu);

        rusia.addCiudad(new Ciudad("San Petersburgo", 5383890, rusia));
        rusia.addCiudad(new Ciudad("Novosibirsk", 1618039, rusia));
        rusia.addCiudad(new Ciudad("Ekaterimburgo", 1477734, rusia));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a India
        Ciudad nuevaDelhi = new Ciudad("Nueva Delhi", 21675304, india);
        india.addCiudad(nuevaDelhi);
        india.setCapital(nuevaDelhi);

        india.addCiudad(new Ciudad("Bombay", 18414288, india));
        india.addCiudad(new Ciudad("Bangalore", 13707084, india));
        india.addCiudad(new Ciudad("Calcuta", 14617882, india));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a Brasil
        Ciudad brasilia = new Ciudad("Brasilia", 3015268, brasil);
        brasil.addCiudad(brasilia);
        brasil.setCapital(brasilia);

        brasil.addCiudad(new Ciudad("São Paulo", 12325232, brasil));
        brasil.addCiudad(new Ciudad("Río de Janeiro", 6747815, brasil));
        brasil.addCiudad(new Ciudad("Salvador", 2886698, brasil));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a Nueva Zelanda
        Ciudad wellington = new Ciudad("Wellington", 215400, nuevaZelanda);
        nuevaZelanda.addCiudad(wellington);
        nuevaZelanda.setCapital(wellington);

        nuevaZelanda.addCiudad(new Ciudad("Auckland", 1657000, nuevaZelanda));
        nuevaZelanda.addCiudad(new Ciudad("Christchurch", 375000, nuevaZelanda));
        nuevaZelanda.addCiudad(new Ciudad("Manukau", 170600, nuevaZelanda));

        //--------------------------------------------------------------------------------------------------

        // Añadir ciudades a Francia
        Ciudad paris = new Ciudad("París", 2148000, francia);
        francia.addCiudad(paris);
        francia.setCapital(paris);

        francia.addCiudad(new Ciudad("Marsella", 861635, francia));
        francia.addCiudad(new Ciudad("Lyon", 516092, francia));
        francia.addCiudad(new Ciudad("Toulouse", 486852, francia));

        //--------------------------------------------------------------------------------------------------


        // --- STREAM ---
        List<Pais> paises = List.of(hispania, japon, argentina, egipto, australia, rusia, india, brasil, nuevaZelanda, francia);

        /**
         * 1. Menor superfice
         */
        Pais paisMenorSuperficie = paises.stream()
                .min(Comparator.comparing(Pais::getSuperficie))
                .orElse(new Pais());

        System.out.println("------------------------EJERCICIO 2------------------------------");

        /**
         * 2. Muestra los países ordenados por población (descendente). Muestra país y población
         */

        paises.stream()
                .sorted(Comparator.comparingInt(Pais::getPoblacion).reversed()) // Ordena por población descendente
                .forEach(pais -> System.out.println("País: " + pais.getNombre() + ", población: " + pais.getPoblacion() + " habitantes"));


        System.out.println("------------------------EJERCICIO 3------------------------------");

        /**
         * Muestra los 5 países con mayor superficie, nombre y superficie.
         */

        paises.stream()
                .sorted(Comparator.comparingDouble(Pais::getSuperficie).reversed()) // Ordena por superficie descendente
                .limit(5)
                .forEach(p -> System.out.println("Nombre: " + p.getNombre() + ", superficie" + p.getSuperficie()));

        System.out.println("------------------------EJERCICIO 4------------------------------");

        /**
         * Muestra los países de América del Norte y del Sur ordenados de menor a mayor población
         */

        paises.stream()
                .filter(p -> p.getContinente().equals(Continente.AMERICA))
                .sorted(Comparator.comparing(Pais::getPoblacion))
                .forEach(p -> System.out.println("Nombre: " + p.getNombre() + ", poblacion: " + p.getPoblacion() + " habitantes"));


        System.out.println("------------------------EJERCICIO 5------------------------------");
        /**
         * Muestra las capitales de todos los países ordenadas alfabéticamente
         */

        paises.stream()
                .map(p -> p.getCapital())
                .sorted(Comparator.comparing(ciudad -> ciudad.getNombre()))
                .forEach(ciudad -> System.out.println(ciudad.getNombre()));


        System.out.println("------------------------EJERCICIO 6------------------------------");

        /**
         * Muestra las tres capitales más pobladas
         */

        List<Ciudad> tresCapitales = paises.stream()
                .map(Pais::getCapital)
                .sorted(Comparator.comparing(Ciudad::getPoblacion).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Las 3 capitales mas pobladas son: ");
        tresCapitales.forEach(ciudad -> System.out.println(ciudad.getNombre() + " - población: " + ciudad.getPoblacion() + " habitantes"));

        System.out.println("------------------------EJERCICIO 7------------------------------");

        /**
         * Muestra cada continente, y seguido por ‘:’ los países de ese continente
         */

        Map<Continente, List<Pais>> paisesDeEseContinente = paises.stream()
                .collect(Collectors.groupingBy(Pais::getContinente));

        paisesDeEseContinente.forEach((continente, listaPaises) -> {
            System.out.print(continente + ": ");
            String nombresPaises = listaPaises.stream()
                    .map(Pais::getNombre)
                    .collect(Collectors.joining(", "));
            System.out.println(nombresPaises);
        });

        System.out.println("------------------------EJERCICIO 8------------------------------");

        /**
         * Muestra si todos los países tienen más de 20 millones de habitantes o no
         */

        boolean MasDe20Millones = paises.stream()
                .allMatch(pais -> pais.getPoblacion() > 20000000);

        if (MasDe20Millones == true) {
            System.out.println("Todos los países tienen más de 20 millones de habitantes.");
        } else {
            System.out.println("No todos los países tienen más de 20 millones de habitantes.");
        }

        System.out.println("------------------------EJERCICIO 9------------------------------");

        /**
         * Muestra la media de población de todos los países en conjunto
         */
        Double mediaPoblacion = paises.stream()
                .mapToDouble(Pais::getPoblacion)
                .average()
                .getAsDouble();

        System.out.print("Poblacion de todos los paises: ");
        System.out.println(mediaPoblacion);

        System.out.println("------------------------EJERCICIO 10------------------------------");

        /**
         * Muestra todos los continentes, y cuántos países has metido en cada continente
         */

        Map<Continente, Long> PaisesMetidosContinente = paises.stream()

                .collect(Collectors.groupingBy(Pais::getContinente, Collectors.counting()));
                PaisesMetidosContinente.forEach((continente, cantidadP) -> System.out.println(continente + " " + cantidadP));

        System.out.println("------------------------EJERCICIO 11------------------------------");

        /**
         * Muestra los países ordenados por superficie, y para cada país sus ciudades ordenadas por
         * población
         */

        paises.stream()
                .sorted(Comparator.comparing(Pais::getSuperficie).reversed())
                .forEach(pais -> {
                    System.out.println();
                    System.out.println(pais.getNombre());
                    paises.stream()
                            .filter(pais1 -> pais1.getIdPais().equals(pais.getIdPais()))
                            .flatMap(pais1 -> pais1.getCiudades().stream())
                            .sorted(Comparator.comparing(Ciudad::getPoblacion).reversed())
                            .forEach(ciudad -> System.out.println(ciudad.getNombre() + " poblacion: " + ciudad.getPoblacion() ));
                });





    }


  }
