package BIBLIOTECA.SERVICIOS;

import BIBLIOTECA.ENTIDADES.*;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Documento> documentos;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        this.documentos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    //Métodos------------
    public void addDocumento(Documento documento) {
        this.documentos.add(documento);
    }
    public void delDocumentos(Documento documento){
        this.documentos.remove(documento);
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    public void delUsuarios(Usuario usuario){
        this.usuarios.remove(usuario);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Biblioteca{");
        sb.append("documentos=").append(documentos);
        sb.append(", usuarios=").append(usuarios);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método para buscar un usuario en la lista de una biblioteca
     * @param dni comprobamos que sean iguales
     * @return al usuario si lo encuentra, si no, no devuelve nada.
     */
    private Usuario buscarUsuario(String dni){
        for (Usuario usuario : this.usuarios){
            if (usuario.getDni().equals(dni)){
                return usuario;
            }
        }
        return null;
    }

    /**
     * Comprobamos que el usuario exista, que el usuario no esté en el límite de Documentos prestados
     * y que el documento no esté prestado antes a otra persona
     * @param doc documento a prestar
     * @param dniUsuario de la persona que quiere adquirir ese documento
     * @return "false" si el usuario no existe, si no tiene el límite de prestamos alcanzados, y si el documento está prestado a otra persona
     * @return "true" si nada de lo anterior se cumple, y se le añade el documento al usuario.
     */

    public boolean prestaDocumento(Documento doc, String dniUsuario){
        //Llamamos al método para buscar al usuario
        Usuario usuario = buscarUsuario(dniUsuario);
        //No encontrado
        if (usuario == null){
            return false;
        } else if (usuario.alcanzadoLimitePrestamos()) {
            return false;
        } else if (doc.estaPrestado()){
            return false;
        } else {
            doc.prestaAUsuario(usuario);
            usuario.addDocumento(doc); //También hay que añadir el documento a la lista de documentos prestados
            return true;
        }
    }

    /**
     * Comprobamos que el documento no esté prestado
     * @param doc
     * @param usuario
     * @return "false" si el documento no esté prestado
     * @return "true" si el documento estaba prestado
     * Se llama a devuelve de documento y le pasamos el usuario que está devolviendo ese documento
     * Borramos el documento de la lista del usuario.
     */

    public boolean devuelveDocumento(Documento doc, Usuario usuario){
        //Comprobamos que el documento está en la lista
        int posicion = documentos.indexOf(doc);
        if (posicion < 0){
            return false;
        }else if (!doc.estaPrestado()){
            return false;
        } else {
            doc.devuelve(usuario);
            usuario.delDocumento(doc);
            return true;
        }
    }

    /**
     * Buscamos en los documentos y comprobamos el titulo de todos ellos
     * @param titulo pedido por teclado
     * @return el Documento si el titulo pasado por parametro coincide con alguno de nuestra lista
     * Si no encuentra nada, devuelve "null".
     */

    public Documento buscarDocumento(String titulo){
        for (Documento documento : this.documentos){
            if (documento.getTitulo().equals(titulo)){
                return documento;
            }
        }
        return null;
    }

    /**
     * Buscamos en la colección de documentos y guardamos en una nueva colección llamda resultado
     * todos los documentos que coincidan con ese texto
     * @param texto a comprobar en todos los documentos
     * @return la colección resultado, con todos los documentos introducidos
     */

    public ArrayList<Documento> buscarDocumentos(String texto){
        ArrayList<Documento> resultado = new ArrayList<>();
        for (Documento documento : this.documentos){
            if (documento.getTitulo().contains(texto)){
                resultado.add(documento);
            }
        }
        return resultado;
    }

    /**
     * Buscamos en la lista de documentos y comprobamos que contenga el autor pasado por parámetro
     * Lo añadimos a nuestra lista
     * @param autor
     * @return la lista creada donde vamos guardando los documentos que coinciden con el autor
     */

    public ArrayList<Documento> buscarDocumento(Autor autor){
        ArrayList<Documento> resultado = new ArrayList<>();
        for (Documento documento : this.documentos){
            if (documento.getAutores().contains(autor)){
                resultado.add(documento);
            }
        }
        return resultado;
    }
            
}
