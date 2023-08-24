import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {


    @Test
    void depositar() {
        Conta conta = new ContaCorrente(new Banco("BB", new int[]{1244, 4556}), 1244, "Wallace");
        conta.setSaldo(1000);
    }

    @Test
    void sacar() {
        Conta conta = new ContaCorrente(new Banco("BB", new int[]{1244, 4556}), 1244, "Wallace");
        conta.setSaldo(1000);
        conta.sacar(150);
    }

    @Test
    void transferir() {
        Conta conta = new ContaCorrente(new Banco("BB", new int[]{1244, 4556}), 1244, "Wallace");
        Conta conta2 = new ContaPoupanca(new Banco("ITAU", new int[]{1452, 2245}), 2245, "Wallace");
        conta.setSaldo(1000);
        conta.transferir(500, conta2);
    }

    @Test
    void verSaldo() {
        Conta conta = new ContaCorrente(new Banco("BB", new int[]{1244, 4556}), 1244, "Wallace");
        conta.setSaldo(1000);
        conta.verSaldo();
    }
}