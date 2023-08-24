import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Conta conta = new ContaCorrente(new Banco("BB", new int[]{1244, 4556}), 1244, "Wallace");
    Conta conta2 = new ContaPoupanca(new Banco("ITAU", new int[]{1452, 2245}), 2245, "Wallace");



    @Test
    void depositar() {
        conta.depositar(1000);
    }

    @Test
    void sacar() {
        depositar();
        conta.sacar(150);
    }

    @Test
    void transferir() {
        depositar();
        conta.transferir(500, conta2);
    }

    @Test
    void verSaldo() {
        depositar();
        conta.verSaldo();
    }
}