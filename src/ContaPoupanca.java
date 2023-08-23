public class ContaPoupanca extends Conta{
    //atributos
    private static int contadorNumero = 100;

    //construtor
    public ContaPoupanca(Banco banco, int agencia, String cliente) {
        super.banco = banco;
        super.agencia = agencia;
        super.saldo = 0;
        super.cliente = new Cliente(cliente);
        super.numero = contadorNumero;
        contadorNumero++;
        System.out.println("Conta Poupança aberta. Cliente " + super.cliente.getNome() + " - Agência " + super.agencia + " - Número " + super.numero);
    }

}
