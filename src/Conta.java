public abstract class Conta implements IConta{
    //atributos
    protected Banco banco;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    //metodos

    protected int getAgencia() {
        return agencia;
    }

    protected double getSaldo() {
        return saldo;
    }

    protected int getNumero() {
        return numero;
    }

    protected Banco getBanco() { return banco; }

    protected String getNomeCliente() { return cliente.getNome(); }

    public void setSaldo(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valorSaque){
        if(this.saldo>=valorSaque){
            this.saldo -= valorSaque;
            System.out.println("Saque de R$" + valorSaque + " realizado, novo saldo de R$" + this.saldo + ".");
        }else{
            System.out.println("Valor não disponível.");
        }
    }

    public void depositar(double valorDeposito){
        this.saldo += valorDeposito;
        System.out.println("Depósito de R$" + valorDeposito + " realizado, novo saldo de R$" + this.saldo + ".");
    }

    public void transferir(double valorTransferencia, Conta contaDestino){
        if(this.saldo>=valorTransferencia){
            this.saldo -= valorTransferencia;
            contaDestino.setSaldo(valorTransferencia);
            System.out.println("Transferência realizada.");
        }else{
            System.out.println("Valor não disponível.");
        }
    }

    public void verSaldo(){
        System.out.println("O Saldo da conta " + this.numero + " é de R$" + this.saldo + ".");
    }


}
