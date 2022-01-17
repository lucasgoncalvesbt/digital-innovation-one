package me.dio.digitalbank;

public  abstract class Conta implements IConta{

    private static final Integer AGENCIA_PADRAO = 1;
    private static Integer sequencial = 1;

    private Integer agencia;
    private Integer numero;
    private Double saldo = 0.0;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(Double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(Double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

}
