import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n_atacantes, n_defensores;
		int[] distancias_atacantes, distancias_defensores;
		n_atacantes = in.nextInt();
		n_defensores = in.nextInt();		
		
		while(true) {
			if(n_atacantes == 0 && n_defensores == 0) {
				break;
			}
			distancias_atacantes = new int[n_atacantes];
			distancias_defensores = new int[n_defensores];
			for(int i = 0; i < n_atacantes; i++) {
				distancias_atacantes[i] = in.nextInt();
			}
			for(int j = 0; j < n_defensores; j++) {
				distancias_defensores[j] = in.nextInt();
			}
			
			boolean existe = existe_impedimento(distancias_atacantes,distancias_defensores);
			String impressao =  resposta(existe);
			System.out.println(impressao);
			n_atacantes = in.nextInt();
			n_defensores = in.nextInt();		
		}
	}
	
	public static String resposta(boolean existe) {
		if(existe) {
			return "Y";
		}
			return "N";
	}
	
	public static boolean  existe_impedimento(int[] distancias_atacantes, int[] distancias_defensores) {
		boolean impedido = false;
		Arrays.sort(distancias_defensores);
		for(int i = 0; i < distancias_atacantes.length; i++) {
				if(distancias_atacantes[i] < distancias_defensores[1]) {
					impedido = true;
				}
		}
		return impedido;
	}
}
