public class Main {
    public static void main(String[] args) {

        ContaPoupanca cpw = new ContaPoupanca(1244, "wallace");
        ContaPoupanca cps = new ContaPoupanca(1244, "stevan");

        ContaCorrente ccw = new ContaCorrente(4556, "wallace");
        ContaCorrente ccs = new ContaCorrente(4556, "stevan");

        cpw.verSaldo();
        cps.verSaldo();
        ccw.verSaldo();
        ccs.verSaldo();

        cpw.depositar(1500);
        cps.depositar(200);
        ccw.depositar(8457);
        ccs.depositar(12);

        cpw.sacar(1501);
        cps.sacar(150);
        ccw.sacar(8000);
        ccs.sacar(2);

        cpw.transferir(1499, ccs);

        cpw.verSaldo();
        cps.verSaldo();
        ccw.verSaldo();
        ccs.verSaldo();










    }
}