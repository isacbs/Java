import java.util.Scanner;

public class Zero {
	
	public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        System.out.print("Quantidade de elementos do conjunto: ");
        int vetor = ent.nextInt();
        int[] conj = new int[vetor];

        for (int i = 0; i < vetor; i++) {
            System.out.print("Informe o " + (i + 1) + "º elemento: ");
            conj[i] = ent.nextInt();
        }

        System.out.print("Dados na ordem original: ");
        for (int i = 0; i < conj.length; i++) {
            System.out.print(conj[i]);
            if (i < conj.length - 1) 
                System.out.print(", ");
        }

        int o = 0;
        for (int i = 0; i < conj.length; i++) {
            if (conj[i] != 0) {
                int j = conj[i];
                conj[i] = conj[o];
                conj[o] = j;
                o++;
            }
        }

        System.out.print("\nDados reorganizados: ");
        for (int i = 0; i < conj.length; i++) {
            System.out.print(conj[i]);
            if (i < conj.length - 1) 
                System.out.print(", ");  
        }
      ent.close();
    }
}