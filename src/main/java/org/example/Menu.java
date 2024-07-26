package org.example;
import javax.lang.model.util.AbstractElementVisitor9;
import javax.tools.JavaFileManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Alumno> alumnos;
    private List<Catedratico> catedraticos;
    private List<Curso> cursos;

    public Menu() {
        alumnos = new ArrayList<>();
        catedraticos = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Registrar Catedrático");
            System.out.println("3. Inscribir Alumno en Curso");
            System.out.println("4. Asignar Curso a Catedrático");
            System.out.println("5. Mostrar Alumnos");
            System.out.println("6. Mostrar Catedráticos");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarAlumno(scanner);
                    break;
                case 2:
                    registrarCatedratico(scanner);
                    break;
                case 3:
                    inscribirAlumnoEnCurso(scanner);
                    break;
                case 4:
                    asignarCursoACatedratico(scanner);
                    break;
                case 5:
                    mostrarAlumnos();
                    break;
                case 6:
                    mostrarCatedraticos();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
    String BDAlumno="C:\\Users\\carlo\\IdeaProjects\\proyecto1\\alumnos.txt";
    FileManagerAlumno fileManagerAlumno=new FileManagerAlumno(BDAlumno);
    String BDCatedratico="C:\\Users\\carlo\\IdeaProjects\\proyecto1\\catedraticos.txt";
    FileManagerCatedratico fileManagerCatedratico=new FileManagerCatedratico(BDCatedratico);


    public void registrarAlumno(Scanner scanner) {
        while (true) {
            System.out.print("Nombre del Alumno: ");
            String nombre="nombre: ";
            nombre = nombre+scanner.nextLine();
            System.out.print("ID del Alumno: ");
            String id="id: ";
            id =id+ scanner.nextLine();
            System.out.print("Carrera del Alumno: ");
            String carrera="carrera: ";
            carrera =carrera+ scanner.nextLine();
            System.out.println("Alumno registrado exitosamente.\n");
            fileManagerAlumno.writeToFileAlumno(nombre,id,carrera);
            Alumno alumno = new Alumno(nombre, id, carrera);
            alumnos.add(alumno);
            break;
        }
    }

    private void registrarCatedratico(Scanner scanner) {
        System.out.print("Nombre del Catedrático: ");
        String nombre="nombre: ";
        nombre = nombre+scanner.nextLine();
        System.out.print("ID del Catedrático: ");
        String id="id: ";
        id =id+ scanner.nextLine();
        System.out.print("Profesion del Catedrático: ");
        String profesion="carrera: ";
        profesion =profesion+ scanner.nextLine();
        System.out.println("Catedrático registrado exitosamente.\n");
        fileManagerCatedratico.writeToFileCatedratico(nombre,id,profesion);
        Catedratico catedratico = new Catedratico(nombre, id, profesion);
        catedraticos.add(catedratico);
    }

    private void inscribirAlumnoEnCurso(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno: ");
        int numAlumno = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        alumnos.get(numAlumno).inscribirCurso(curso);
        cursos.add(curso);
        fileManagerAlumno.asignacionCursos(nombreCurso, codigoCurso);

    }

    private void asignarCursoACatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático: ");
        int numCatedratico = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        catedraticos.get(numCatedratico).asignarCurso(curso);
        cursos.add(curso);
        fileManagerCatedratico.asignacionCursos(nombreCurso, codigoCurso);
    }

    private void mostrarAlumnos() {
       System.out.println("----- Lista de Alumnos -----");
            fileManagerAlumno.readFromFileAlumno();
    }

    private void mostrarCatedraticos() {
            System.out.println("----- Lista de Catedráticos -----");
            fileManagerCatedratico.readFromFileCatedratico();
    }
}