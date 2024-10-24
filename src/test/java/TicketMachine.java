package br.calebe.ticketmachine.core;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {

    @Test
    public void testInserirValorValido() throws PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(100);
        tm.inserir(50);
        assertEquals(50, tm.getSaldo());
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void testInserirValorInvalido() throws PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(100);
        tm.inserir(3); // Valor não permitido
    }

    @Test
    public void testSaldoInicial() {
        TicketMachine tm = new TicketMachine(100);
        assertEquals(0, tm.getSaldo());
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testImprimirSemSaldoSuficiente() throws SaldoInsuficienteException {
        TicketMachine tm = new TicketMachine(100);
        tm.imprimir(); // Deve lançar a exceção
    }

    @Test
    public void testImprimirComSaldoSuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(100);
        tm.inserir(100);
        String expectedOutput = "*****************\n*** R$ 100,00 ****\n*****************\n";
        assertEquals(expectedOutput, tm.imprimir());
    }
}
