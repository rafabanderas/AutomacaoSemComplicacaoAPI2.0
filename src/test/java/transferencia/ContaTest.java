package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa", "1234567890123","0987654321");
        silvioSantos = new Cliente("Silvio Santos","1234567890000","1234567890123");

        contaXuxa = new Conta("0048","15151",2500.00, xuxa);
        contaSilvio = new Conta("0020","14141",3500.00, silvioSantos);
    }

    @Test
    public void realizarTransacao(){
        contaXuxa.realizarTransferencia(1000.00, contaSilvio);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida(){
        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);
        assertFalse(resultado);
    }

}