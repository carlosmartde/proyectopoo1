package org.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManagerCatedratico {
        private String BDCatedratico;
        public FileManagerCatedratico(String BDCatedratico) {
            this.BDCatedratico = BDCatedratico;
        }
    public void writeToFileCatedratico(String nombre,String id, String profesion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BDCatedratico, true))) {
            bw.write(nombre);
            bw.newLine();
            bw.write(id);
            bw.newLine();
            bw.write(profesion);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void asignacionCursos(String cursos, String codigoCurso){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BDCatedratico, true))) {
            bw.write(cursos);
            bw.newLine();
            bw.write(codigoCurso);
            bw.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromFileCatedratico() {
        try (BufferedReader br = new BufferedReader(new FileReader(BDCatedratico))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
