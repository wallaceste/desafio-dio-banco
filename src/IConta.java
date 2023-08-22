public interface IConta {

    public void sacar(double valorSaque);
    public void depositar(double valorDeposito);
    public void transferir(double valorTransferencia, Conta conta);
    public void verSaldo();


}
