package Fila;

import java.util.*;

public class InverteFila {
	public static void main(String[] args) {
		Queue<String> fila = new LinkedList();
		fila.offer("Leticia");
		fila.offer("Karina");
		fila.offer("Ellen");
		fila.offer("Ana Clara");
		fila.offer("Isadora");
		System.out.println(fila);
		System.out.println("OS ÚLTIMOS SERÃO OS PRIMEIROS!");
		Stack<String> pilha = new Stack();
		// da fila para pilha
		while (!fila.isEmpty()) {
			pilha.push(fila.poll());
		}
		// da pilha para fila
		while (!pilha.isEmpty()) {
			fila.offer(pilha.pop());
		}
		System.out.println(fila);
	}
}