import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    @Test
    void getNome() {
        Banco banco = new Banco("Banco do Brasil", new int[]{1244, 4556});
        Assertions.assertEquals("Banco do Brasil", banco.getNome());
    }

    @Test
    void getAgencias() {
        Banco banco = new Banco("Banco do Brasil", new int[]{1244, 4556});
        Assertions.assertArrayEquals(new int[]{1244, 4556}, banco.getAgencias());
    }

    @Test
    void escolheAgencia() {
        Banco banco = new Banco("Banco do Brasil", new int[]{1244, 4556});
        Assertions.assertEquals(4556, banco.escolheAgencia(1));
    }
}