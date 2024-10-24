package br.calebe.ticketmachine.core;
import org.junit.Test;
import static org.junit.Assert.*;

public class PapelMoedaTest {

    @Test
    public void testGetValor() {
        PapelMoeda papelMoeda = new PapelMoeda(100, 5);
        int valorEsperado = 100;
        assertEquals(valorEsperado, papelMoeda.getValor());
    }

    @Test
    public void testGetQuantidade() {
        PapelMoeda papelMoeda = new PapelMoeda(100, 5);
        int quantidadeEsperada = 5;
        assertEquals(quantidadeEsperada, papelMoeda.getQuantidade());
    }

    @Test
    public void testConstrutorValoresNegativos() {
        // Testa se valores negativos são tratados
        PapelMoeda papelMoeda = new PapelMoeda(-50, -10);
        int valorEsperado = -50;
        int quantidadeEsperada = -10;
        assertEquals(valorEsperado, papelMoeda.getValor());
        assertEquals(quantidadeEsperada, papelMoeda.getQuantidade());
    }

    @Test
    public void testConstrutorValoresZero() {
        // Testa se valores zero são tratados
        PapelMoeda papelMoeda = new PapelMoeda(0, 0);
        int valorEsperado = 0;
        int quantidadeEsperada = 0;
        assertEquals(valorEsperado, papelMoeda.getValor());
        assertEquals(quantidadeEsperada, papelMoeda.getQuantidade());
    }
}
