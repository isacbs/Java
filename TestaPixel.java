package excs;

public class TestaPixel {

	public static void main(String[] args) {
		Pixel P1, P2, P3;
		
		P1 = new Pixel(10, 20);
//		P1.setCoordenadas(10, 20);
		System.out.println(P1.print());
		
		P2 = new Pixel();
		P2.setCor(255, 255, 255);
		System.out.println(P2.print());
		
		P3 = new Pixel(50,50, 255,0,0);
//		P3.setCoordenadas(50, 50);
//		P3.setCor(255,0,0)
		System.out.println(P3.print());
	}

}