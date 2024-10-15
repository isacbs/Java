package fila;

public class ProjFila {

    public static void main(String[] args) throws Exception{
        
        Queue fila1 = new Queue(10);
        fila1.enqueue("Isadora");
        fila1.enqueue("Ana Clara");
        fila1.enqueue("Ellen");
        System.out.println("Primeiro da fila: " + fila1.front());
        fila1.dequeue();
        System.out.println("Primeiro da fila: " + fila1.front());
        
        
       
    }
    
}
