package org.example;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona {
    private String carrera;
    private List<Curso> cursos;

    public Alumno(String nombre, String id, String carrera) {
        super(nombre, id);
        this.carrera = carrera;
        this.cursos = new ArrayList<>();
    }

    public String getCarrera() {
        return carrera;
    }

    public void inscribirCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Inscrito en el curso: " + curso.getNombre());
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Alumno: " + getNombre() + ", ID: " + getId() + ", Carrera: " + carrera);
        System.out.println("Cursos Inscritos:");
        for (Curso curso : cursos) {
            System.out.println(" - " + curso.getNombre());
        }
    }
}
