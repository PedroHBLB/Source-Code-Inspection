package br.calebe.ticketmachine.core;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

public class TrocoTest {

    @Test
    public void testTrocoDistribuicaoNotas() {
        Troco troco = new Troco(287); // Exemplo de valor para verificar a distribuição
        PapelMoeda[] esperado = new PapelMoeda[] {
            new PapelMoeda(100, 2),
            new PapelMoeda(50, 1),
            new PapelMoeda(20, 1),
            new PapelMoeda(10, 1),
            new PapelMoeda(5, 1),
            new PapelMoeda(2, 1)
        };

        for (int i = 0; i < esperado.length; i++) {
            assertEquals(esperado[i].getValor(), troco.papeisMoeda[i].getValor());
            assertEquals(esperado[i].getQuantidade(), troco.papeisMoeda[i].getQuantidade());
        }
    }

    @Test
    public void testTrocoIterator() {
        Troco troco = new Troco(287);
        Iterator<PapelMoeda> iterator = troco.getIterator();
        int[] valoresEsperados = {100, 50, 20, 10, 5, 2};
        int[] quantidadesEsperadas = {2, 1, 1, 1, 1, 1};

        int index = 0;
        while (iterator.hasNext()) {
            PapelMoeda papelMoeda = iterator.next();
            assertNotNull(papelMoeda);
            assertEquals(valoresEsperados[index], papelMoeda.getValor());
            assertEquals(quantidadesEsperadas[index], papelMoeda.getQuantidade());
            index++;
        }
        assertEquals(valoresEsperados.length, index);
    }
    
    @Test
    public void testTrocoIteratorSemValor() {
        Troco troco = new Troco(0);
        Iterator<PapelMoeda> iterator = troco.getIterator();
        assertFalse(iterator.hasNext());
    }
}
