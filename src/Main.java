import Classes.Aluno;
import Classes.Disciplina;
import Classes.Pessoa;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) throws IOException {


      List<Aluno> alunos = new ArrayList<Aluno>();

      for (int i = 0; i < 2; i++) {

         String nome = JOptionPane.showInputDialog("Digite o nome do aluno " + i + ":");
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


         int escolha = 0;
         do {
            String disciplina = JOptionPane.showInputDialog("Digite o nome da disciplina:");
            Disciplina disciplina1 = new Disciplina();
            disciplina1.setNomeDaDisciplina(disciplina);

            for (int j = 0; j < disciplina1.getNota().length; j++) {
               String nota = JOptionPane.showInputDialog("Digite a nota: " + (j + 1));
               disciplina1.getNota()[j] = Double.parseDouble(nota);
            }

            aluno1.getDisciplinas().add(disciplina1);
            escolha = JOptionPane.showConfirmDialog(null, "deseja cadastrar outra disciplina?");
         } while (escolha == 0);

         alunos.add(aluno1);

         for (Disciplina disciplinaAtual : aluno1.getDisciplinas()) {
            for (int j = 0; j < disciplinaAtual.getNota().length; j++) {
               System.out.println("A nota " + (j + 1) + " é: " + disciplinaAtual.getNota()[j]);
            }
         }
         System.out.println("Media: " + aluno1.getDisciplinas());
         System.out.println("Status do aluno: " + aluno1.statusLetivo());
      }

      //*------------------------------Escrever no arquivo------------------------------*/

      int escolha = JOptionPane.showConfirmDialog(null, "deseja gerar o relatório de alunos?");
      if (escolha == 0) {

         File arquivo = new File("/home/felipe-cpd/Documentos/SistemaEscolar/src/Alunos.csv");

         if (!arquivo.exists()) {
            arquivo.createNewFile();
         }

         FileWriter escrever_no_arquivo = new FileWriter(arquivo);


         for (Aluno aluno : alunos) {

            for (Disciplina disciplinaAtual : aluno.getDisciplinas()) {
               for (int j = 0; j < disciplinaAtual.getNota().length; j++) {

                  escrever_no_arquivo.write(aluno.getNome() + ";" + disciplinaAtual.getNomeDaDisciplina() + ";" + "nota " + (j + 1) + ";" + disciplinaAtual.getNota()[j] + "\n");

               }
            }
         }

         escrever_no_arquivo.flush();
         escrever_no_arquivo.close();
         JOptionPane.showMessageDialog(null, "relatório gerado com sucesso!");
      }

      System.out.println(alunos.toString());


   }
}