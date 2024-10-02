import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Libro libro1=new Libro("Cien años de soledad", "Gabriel García Márquez", "978-3-16-148410-0", 39.90, 5.00);
        Libro libro2= new Libro("1984", "George Orwell", "978-0-452-28423-4", 29.99, 3.00);
        Libro libro3=new Libro("El Principito", "Antoine de Saint-Exupéry", "978-3-16-148410-1", 19.95, 2.00);

        ArrayList<Libro> libros= new ArrayList<Libro>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        Biblioteca biblioteca=new Biblioteca();
        biblioteca.agregarLibros(libros);

        System.out.println("Libros sin serializar");
        for(Libro libro:libros){
            System.out.println(libro.toString());
        }

        biblioteca.seriailazrlibros();

        biblioteca.deserializarlibros();
    }
}