import java.io.*;
import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> libros = new ArrayList<Libro>();

    public void agregarLibros(ArrayList<Libro> nuevosLibros) {
        libros.addAll(nuevosLibros);
    }

    public void mostrarlibros(ArrayList<Libro> libros){
        for(Libro libro :libros) {
            System.out.println(libro.toString());
        }
    }

    public void seriailazrlibros(){
        try (FileOutputStream fileOutput = new FileOutputStream("biblioteca.ser");
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {

            objectOutput.writeObject(libros);

            System.out.println("Los libros han sido almacenados en el archivo libros.dat.");

        } catch (IOException e) {
            System.err.println("Error al almacenar los libros: " + e.getMessage());
        }
    }

    public void deserializarlibros(){
        try (FileInputStream fileInput = new FileInputStream("biblioteca.ser");
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

            while (true) {
                try {
                    // Leer y deserializar la lista completa de libros
                    ArrayList<Libro> libros = (ArrayList<Libro>) objectInput.readObject();
                    System.out.println("\nInformación del libro:");
                    mostrarlibros(libros);
                }catch (EOFException e) {
                    System.err.println("Alcanzado el final del archivo");
                    break; // Se alcanzó el final del archivo
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo libros.dat: " + e.getMessage());
        }
    }

}
