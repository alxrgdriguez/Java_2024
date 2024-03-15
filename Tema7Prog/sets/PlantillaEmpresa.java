package Tema7Prog.sets;

import java.util.TreeSet;

public class PlantillaEmpresa {

    private TreeSet<Empleado> plantilla = new TreeSet<>();

    public TreeSet<Empleado> getPlantilla() {
        return plantilla;
    }

    public void addEmpleado(Empleado e) {
        plantilla.add(e); //No añade si está repetido
    }

    public void removeEmpleado(Empleado e) {
        plantilla.remove(e);
    }

    @Override
    public String toString() {

       StringBuffer sb = new StringBuffer();
       for(Empleado e: plantilla) {
           sb.append(e.getEmail());
           sb.append(" - ");
           sb.append(e.getNombre());
           sb.append(" - ");
           sb.append(e.getPais());
           sb.append("\n");
       }
       return sb.toString();
    }
}
