package org.example;
import java.util.ArrayList;
import java.util.List;

public class Catedratico extends Persona {
    private String profesion;
    private List<Curso> cursos;

    public Catedratico(String nombre, String id, String profesion) {
        super(nombre, id);
        this.profesion = profesion;
        this.cursos = new ArrayList<>();
    }

    public String getProfesion() {
        return profesion;
    }

    public void asignarCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Asignado al curso: " + curso.getNombre());
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Catedratico: " + getNombre() + ", ID: " + getId() + ", Profesion: " + profesion);
        System.out.println("Cursos Asignados:");
        for (Curso curso : cursos) {
            System.out.println(" - " + curso.getNombre());
        }
    }
}
