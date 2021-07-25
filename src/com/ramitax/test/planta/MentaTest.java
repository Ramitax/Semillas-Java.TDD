package com.ramitax.test.planta;

import com.ramitax.objetos.planta.especies.Menta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MentaTest {

    @Test
    public void Menta_esFuerteTest(){
        Menta plantaMenta = new Menta(2010, 5);
        assertEquals(false, plantaMenta.esFuerte());
        Menta plantaMenta2 = new Menta(2006, 0.1);
        assertEquals(false, plantaMenta2.esFuerte());
        Menta plantaMenta3 = new Menta(2000, 0.9);
        assertEquals(false, plantaMenta3.esFuerte());
    }

    @Test
    public void Menta_HoraDeToleranciaAlSolTest(){
        Menta plantaMenta = new Menta(2010, 5);
        assertEquals(6, plantaMenta.horasDeToleranciaAlSol());
        Menta plantaMenta2 = new Menta(2006, 0.1);
        assertEquals(6, plantaMenta2.horasDeToleranciaAlSol());
        Menta plantaMenta3 = new Menta(2000, 0.9);
        assertEquals(6, plantaMenta3.horasDeToleranciaAlSol());
    }

    @Test
    public void Menta_ProporcionaSemillasTest(){
        Menta plantaMenta = new Menta(2010, 1);
        assertEquals(true, plantaMenta.proporcionaSemillas());
        Menta plantaMenta2 = new Menta(2006, 0.2);
        assertEquals(false, plantaMenta2.proporcionaSemillas());
        Menta plantaMenta3 = new Menta(2000, 0.4);
        assertEquals(false, plantaMenta3.proporcionaSemillas());
    }

    @Test
    public void Menta_EspacioOcupadoTest(){
        Menta plantaMenta = new Menta(2010, 1);
        assertEquals(3, plantaMenta.espacioOcupado(), 0.1);
        Menta plantaMenta2 = new Menta(2006, 0.2);
        assertEquals(0.6, plantaMenta2.espacioOcupado(), 0.1);
        Menta plantaMenta3 = new Menta(2000, 0.4);
        assertEquals(1.2, plantaMenta3.espacioOcupado(), 0.1);
    }
}
