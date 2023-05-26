package Classes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{

   String serie;
   String statusMatricula;

   String dataMatricula;

   List<Disciplina> disciplinas = new ArrayList<Disciplina>();

   public String getSerie() {
      return serie;
   }

   public void setSerie(String serie) {
      this.serie = serie;
   }

   public String getStatusMatricula() {
      return statusMatricula;
   }

   public void setStatusMatricula(String statusMatricula) {
      this.statusMatricula = statusMatricula;
   }

   public String getDataMatricula() {
      return dataMatricula;
   }

   public void setDataMatricula(String dataMatricula) {
      this.dataMatricula = dataMatricula;
   }

   public List<Disciplina> getDisciplinas() {
      return disciplinas;
   }

   public void setDisciplinas(List<Disciplina> disciplinas) {
      this.disciplinas = disciplinas;
   }

   public  double MediaALuno(){
      double media = 0.0;

      for (Disciplina disciplina: disciplinas) {
         for (int i = 0; i < disciplina.getNota().length; i++) {
            media += disciplina.getNota()[i];
         }
      }

      return media / 4;
   }

   public String statusLetivo() {
      if (MediaALuno() < 70) {
         if (MediaALuno() >= 50) {
            return "Recuperação";
         } else {
            return "Reprovado";
         }
      } else {
         return "Aprovado";
      }
   }

   @Override
   public String toString() {
      return "Aluno{" +
              super.toString() +
              "serie='" + serie + '\'' +
              ", statusMatricula='" + statusMatricula + '\'' +
              ", dataMatricula='" + dataMatricula + '\'' +
              ", disciplinas=" + disciplinas +
              "} ";
   }
}
