import Classes.Aluno;
import Classes.Disciplina;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) {


      List<Aluno> alunos = new ArrayList<Aluno>();

      for (int i = 0; i < 1; i++) {

         String nome = JOptionPane.showInputDialog("Digite o nome:");
//         String idade = JOptionPane.showInputDialog("Digite a idade:");
//         String cpf = JOptionPane.showInputDialog("Digite o CPF:");
//         String serie = JOptionPane.showInputDialog("Digite a serie atual:");
//         String dataMatricula = JOptionPane.showInputDialog("Digite a data da matricula:");


         Aluno aluno1 = new Aluno();
         aluno1.setNome(nome);
//         aluno1.setIdade(Integer.parseInt(idade));
//         aluno1.setCpf(cpf);
//         aluno1.setSerie(serie);
//         aluno1.setDataMatricula(dataMatricula);

         String disciplina = JOptionPane.showInputDialog("Digite o nome da disciplina:");
         Disciplina disciplina1 = new Disciplina();
         disciplina1.setNomeDaDisciplina(disciplina);

         for (int j = 0; j < disciplina1.getNota().length; j++) {
            String nota = JOptionPane.showInputDialog("Digite a nota: " + (j + 1));
            disciplina1.getNota()[j] = Double.parseDouble(nota);

         }

         aluno1.getDisciplinas().add(disciplina1);

         alunos.add(aluno1);

         for (Disciplina disciplinaAtual : aluno1.getDisciplinas()) {
            for (int j = 0; j < disciplinaAtual.getNota().length; j++) {
               System.out.println("A nota "+(j+1)+" é: "+disciplinaAtual.getNota()[j]);
            }
         }

         // System.out.println("Media: "+aluno1.getDisciplinas());
         //  System.out.println("Media: "+aluno1.statusLetivo());


      }
      //  System.out.println(alunos.toString());


   }
}