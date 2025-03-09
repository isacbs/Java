package Revisao;

public class BubbleSort { 
	public static void main() { 
		int [] v = {2210, 13, 117, 1, 2, 43, 5, 7, 6, 8, 7, 9, 7, 6, 68, 345} ; 
		int aux = 0; 

		for(int n = v.length; n > 1; n--) { 
			for(int i = 0;i < (n - 1) ; i++) { 
				if(v[i] > v[i + 1]) { 
					aux = v[i]; 
					v[i] = v[i + 1]; 
					v[i + 1] = aux; 
				} 
			} 
		} 
		for(int i = 0 ; i < v.length; i++) 
			System.out.print(v[i] + " "); 
	} 
}