package me.dio.digitalbank;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Dio");

        Conta cc = new ContaCorrente(cliente);
        cc.depositar(100.0);

        Conta cp = new ContaPoupanca(cliente);

        cc.transferir(50.0, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

    }
}
