package projarraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ProjArrayList {

	public static void main(String[] args) throws IOException {
		ArrayList <Produto> lista = new ArrayList<>();
		
		FileReader arg = new FileReader("produtos.txt");
		BufferedReader linha = new BufferedReader(arg);
		
		String aux = linha.readLine();
		
		while(aux != null) {
			String[] vet = aux.split(";");
			Produto p1 = new Produto(Integer.parseInt(vet [0]), 
					vet[1],
					Double.parseDouble(vet [2]),
					Integer.parseInt(vet[3]));
			
			lista.add(p1);
			aux = linha.readLine();
		}

		linha.close();
		
		for (int i=0;i<lista.size();i++) {
			lista.get(i).mostraProduto();
		}
		
		System.out.println("Fim da Lista!!");
		
		System.out.println("Produtos com Estoque Baixo");
		for (int i=0;i<lista.size();i++)   {
			if(lista.get(i).qtdEstoque < 5)
				lista.get(i).mostraProduto();
		}
	}
}
