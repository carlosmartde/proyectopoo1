package org.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManagerAlumno {
    private String BDAlumno;
    public FileManagerAlumno(String BDAlumno) {
        this.BDAlumno = BDAlumno;
    }
    public void writeToFileAlumno(String nombre,String id, String carrera) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BDAlumno, true))) {
            bw.write(nombre);
            bw.newLine();
            bw.write(id);
            bw.newLine();
            bw.write(carrera);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void asignacionCursos(String cursos, String codigoCurso){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BDAlumno, true))) {
            bw.write(cursos);
            bw.newLine();
            bw.write(codigoCurso);
            bw.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromFileAlumno() {
        try (BufferedReader br = new BufferedReader(new FileReader(BDAlumno))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}