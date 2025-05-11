import java.util.Scanner;
import java.util.ArrayList;

public class AC2 {

    static class Aluno {
        String nome;
        double media;

        Aluno(String nome, double media) {
            this.nome = nome;//parâmetro (nome) é atribuido a "nome" deste objeto atual (this.nome).
            this.media = media;//parâmetro (media) é atribuido a "media" deste objeto atual (this.media).
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        int alunosRegistrados = 0;
        int aprovados = 0;
        int excelencia = 0;
        int recuperacao = 0;
        int reprovados = 0;
        double somaMedias = 0;

        double notaMinima = 0.0;
        double[] pesos = new double[4];
        int tamanhoTurma = 0;

        //recebe os pesos das avaliação
        System.out.println("Digite os pesos das 4 avaliações AC1, AC2, AG & AF na mesma ordem: ");
        for(int i = 0; i < 4; i++){
            System.out.print("Peso " + (i + 1) + ": ");
            pesos[i] = s.nextDouble();
        }

        //recebe o tamanho da turma
        System.out.print("Digite o tamanho da turma: ");
        tamanhoTurma = s.nextInt();

        //receber nota mínima para aprovação
        do{
            System.out.print("Digite a nota mínima para a aprovação(maior ou igual a 3): ");
            notaMinima = s.nextDouble();
        }while (notaMinima < 3);

        s.nextLine();//limpa o buffer para o programa não encerrar sozinho

        // while para registrar alunos funciona enquanto o numero de alunos registrados for MENOR que o tamanhoTurma
        while (alunosRegistrados < tamanhoTurma) {
            System.out.print("Deseja inserir notas para um novo aluno? (s/n): ");
            String continuar = s.nextLine();
        
            //se "continuar" for qualquer coisa diferente de "s" ou "S", o programa para
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }

            //solicita e armazena o nome do aluno e suas notas
            System.out.print("Nome do aluno: ");
            String nome = s.nextLine();

            //cria um vetor(array) para as notas e preenche com o "for"
            double[] notas = new double[4];
            for (int i = 0; i < 4; i++) {
                System.out.print("Nota " + (i + 1) + ": ");
                notas[i] = s.nextDouble();
            }

            //calcular média ponderada das notas armazenadas
            double somaPesos = 0, somaNotas = 0;//inicia variaveis para soma de pesos e notas
            for (int i = 0; i < 4; i++) {
                somaNotas += notas[i] * pesos[i];//notas X pesos, o resultado é somado a variavel "somaNotas"
                somaPesos += pesos[i];//soma dos pesos digitados no começo para posteriormente atuar como divisor
            }
            double media = somaNotas / somaPesos;//faz a divisão e armazena na variável "media"

            //mostrar resultados
            System.out.println("\nNotas inseridas:");
            for (int i = 0; i < 4; i++) {//usa o "for" para percorrer as notas e pesos de cada avaliação
                System.out.println("Nota " + (i + 1) + ": " + notas[i] + " (Peso: " + pesos[i] + ")");
            }
            System.out.printf("Média: %.2f\n", media);//exibe a media com duas casas decimais

            //classificação do aluno com "else if", "switch" não trabalha com expressões booleanas
            if (media == 10) {
                System.out.println("Situação: Aprovado com Excelência");
                excelencia++;//se "media" == 10 ele é adicionado a duas classificações, "aprovado" e "aprovado com excelência" 
                aprovados++;
            } else if (media >= notaMinima) {
                System.out.println("Situação: Aprovado");
                aprovados++;//se for menor que 10 e maior que "notaMinima", é adicionado apenas a "aprovado"
            } else if (media >= notaMinima - 1) {
                System.out.println("Situação: Recuperação");
                recuperacao++;//se for menor que a notaMinima e maior que notaMinima - 1, é adicionado a recuperação
            } else {
                System.out.println("Situação: Reprovado");
                reprovados++;//se não não for nenhum dos casos acima, é adicionado a reprovado
            }
            
            //cria um novo objeto Aluno com nome e média e o adiciona na lista(array) e na contagem de alunos registrados
            alunos.add(new Aluno(nome, media));
            alunosRegistrados++;

            s.nextLine(); // limpar qualquer possivel resto no buffer
            System.out.println("--------------------------------------");//linha para estética
        }//todo esse while se repete enquanto alunosRegistrados < tamanhoTurma || continuar == sim

        //exibir os resultados finais
        System.out.println("\n==== RESULTADO FINAL ====");

        if (alunosRegistrados < tamanhoTurma) {
            System.out.println("Turma incompleta.");
        } else {
            for (Aluno aluno : alunos) {//este ":"(for-each) significa = para cada objeto "aluno" contido na lista "alunos", execute o bloco de código
                System.out.printf("Aluno: %-20s Média: %.2f\n", aluno.nome, aluno.media);//formata o "print" com 20 espaços para nome(%-20s) e media apenas com duas casas decimais(%.2f)
                somaMedias += aluno.media;
            }

            //calcula e exibe as estatistícas da turma apenas se todos os alunos forem registrados
            double mediaGeral = somaMedias / alunosRegistrados;
            double percAprovados = (double) aprovados / alunosRegistrados * 100;
            double percExcelencia = (double) excelencia / alunosRegistrados * 100;
            double percRecuperacao = (double) recuperacao / alunosRegistrados * 100;
            double percReprovados = (double) reprovados / alunosRegistrados * 100;

            System.out.printf("\nMédia geral da turma: %.2f\n", mediaGeral);
            System.out.printf("Aprovados: %.2f\n", percAprovados);
            System.out.printf("Aprovado Com Excelência: %.2f\n", percExcelencia);
            System.out.printf("Recuperação: %.2f\n", percRecuperacao);
            System.out.printf("Reprovados: %.2f\n", percReprovados);
        }

        s.close();
    }
}