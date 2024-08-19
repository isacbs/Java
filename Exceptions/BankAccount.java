package Exceptions;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0; 
    }

    // Método para Depósito
    public void deposit(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor do depósito não pode ser menor que 0!!!");
        }
        balance += valor;
        System.out.println("Depósito de " + valor + " reais realizado com sucesso. O valor do saldo atual é R$ " + balance  + ".");
    }

    // Método para Saque
    public void withdraw(double valor) throws InsufficientFundsException {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do saque não pode ser menor que 0!!!");
        }
        if (valor > balance) {
            throw new InsufficientFundsException(valor, balance);
        }
        balance -= valor;
        System.out.println("Saque de " + valor + " reais realizado com sucesso. O valor do saldo atual é R$ " + balance  + ".");
    }

    // Getters
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

       public String getAccountHolderName() {
        return accountHolderName;
    }
       
}