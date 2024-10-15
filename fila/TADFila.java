package fila;

public class ProjFila {

    public static void main(String[] args) throws Exception{
        
        Queue fila1 = new Queue(10);
        fila1.enqueue("MARIA");
        fila1.enqueue("PEDRO");
        fila1.enqueue("JOANA");
        System.out.println("Primeiro da fila: " + fila1.front());
        fila1.dequeue();
        System.out.println("Primeiro da fila: " + fila1.front());
        
        
       
    }
    
}
