package Classes;

import java.util.Arrays;

public class Disciplina {
   private String nomeDaDisciplina;
   private double[] nota = new double[4];

   public String getNomeDaDisciplina() {
      return nomeDaDisciplina;
   }

   public void setNomeDaDisciplina(String nomeDaDisciplina) {
      this.nomeDaDisciplina = nomeDaDisciplina;
   }

   public double[] getNota() {
      return nota;
   }

   public void setNota(double[] nota) {
      this.nota = nota;
   }

   @Override
   public String toString() {
      return "Disciplina{" +
              "nomeDaDisciplina='" + nomeDaDisciplina + '\'' +
              ", nota=" + Arrays.toString(nota) +
              '}';
   }
}
