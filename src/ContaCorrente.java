public class ContaCorrente extends Conta{
    //atributos
    private static int contadorNumero = 1;

    //construtor
    public ContaCorrente(Banco banco, int agencia, String cliente) {
        super.banco = banco;
        super.agencia = agencia;
        super.saldo = 0;
        super.cliente = new Cliente(cliente);
        super.numero = contadorNumero;
        contadorNumero++;
        System.out.println("Conta Corrente aberta. Cliente " + super.cliente.getNome() + " - Agência " + super.agencia + " - Número " + super.numero);
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "banco=" + banco +
                ", agencia= " + agencia +
                ", numero= " + numero +
                ", saldo= " + saldo +
                ", cliente= " + cliente +
                '}';
    }
}
