import java.util.Scanner;

public class AC1 {
    public static void main(String[] args) {
        //inicialize as variaveis
        Scanner scn = new Scanner(System.in);
        double ac1,ac2,ag,af,notaMinima = 0.0;
      
        //receba as notas do usuario
        System.out.println("Digite sua nota na AC1: ");
        ac1 = scn.nextDouble();
        System.out.println("Digite sua nota na AC2: ");
        ac2 = scn.nextDouble();
        System.out.println("Digite sua nota na AG: ");
        ag = scn.nextDouble();
        System.out.println("Digite sua nota na AF: ");
        af = scn.nextDouble();

        //recaba a nota minima para aprovacao
        System.out.println("Digite a nota mínima para aprovação: ");
        notaMinima = scn.nextDouble();

        //calcule a media final
        double mediafinal = (ac1 * 0.15) + (ac2 *0.30) + (ag * 0.10) + (af * 0.45);

        //mostre as notas de cada avaliacao
        System.out.println("AC1: " + ac1);
        System.out.println("AC2: " + ac2);
        System.out.println("AG: " + ag);
        System.out.println("AF: " + af);

        //mostre a media final e se foi aprovado ou não
        System.out.println("Sua média final é: " + mediafinal);
        if(mediafinal >= notaMinima){
            System.out.println("Aprovado! :D");
        }else{
            System.out.println("Reprovado! :C");
        }

        //feche scanner
        scn.close();
    }
}