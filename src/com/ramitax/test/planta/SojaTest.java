package com.ramitax.test.planta;

import com.ramitax.objetos.planta.especies.Soja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SojaTest {

    @Test
    public void Soja_esFuerte() {
        Soja plantaSoja = new Soja(2009, 0.3);
        assertEquals(false, plantaSoja.esFuerte());

        Soja plantaSoja2 = new Soja(2009, 0.6);
        assertEquals(false, plantaSoja2.esFuerte());

        Soja plantaSoja3 = new Soja(2009, 2);
        assertEquals(false, plantaSoja3.esFuerte());
    }

    @Test
    public void Soja_HoraDeToleranciaAlSolTest(){
        Soja plantaSoja = new Soja(2009, 0.3);
        assertEquals(6, plantaSoja.horasDeToleranciaAlSol());
        Soja plantaSoja2 = new Soja(2009, 0.6);
        assertEquals(7, plantaSoja2.horasDeToleranciaAlSol());
        Soja plantaSoja3 = new Soja(2009, 2);
        assertEquals(9, plantaSoja3.horasDeToleranciaAlSol());
    }

    @Test
    public void Soja_ProporcionaSemillasTest(){
        Soja plantaSoja = new Soja(2005, 2);
        assertEquals(false, plantaSoja.proporcionaSemillas());
        Soja plantaSoja2 = new Soja(2009, 0.5);
        assertEquals(false, plantaSoja2.proporcionaSemillas());
        Soja plantaSoja3 = new Soja(2009, 2);
        assertEquals(true, plantaSoja3.proporcionaSemillas());
    }

    @Test
    public void Soja_EspacioOcupadoTest() {
        Soja plantaSoja = new Soja(2005, 2);
        assertEquals(1, plantaSoja.espacioOcupado(), 0.01);
        Soja plantaSoja2 = new Soja(2003, 0.5);
        assertEquals(0.25, plantaSoja2.espacioOcupado(), 0.01);
        Soja plantaSoja3 = new Soja(20016, 1);
        assertEquals(0.5, plantaSoja3.espacioOcupado(), 0.01);
    }
}
