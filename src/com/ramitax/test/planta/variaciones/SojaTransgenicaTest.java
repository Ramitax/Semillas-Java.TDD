package com.ramitax.test.planta.variaciones;

import com.ramitax.objetos.planta.especies.variaciones.SojaTransgenica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SojaTransgenicaTest {

    @Test
    public void SojaTransgenica_ProporcionaSemillasTest(){
        SojaTransgenica plantaSojaTransgenica = new SojaTransgenica(2011, 2);
        assertEquals(false, plantaSojaTransgenica.proporcionaSemillas());
        SojaTransgenica plantaSojaTransgenica2 = new SojaTransgenica(2005, 0.9);
        assertEquals(false, plantaSojaTransgenica2.proporcionaSemillas());
        SojaTransgenica plantaSojaTransgenica3 = new SojaTransgenica(2008, 1.5);
        assertEquals(false, plantaSojaTransgenica3.proporcionaSemillas());
    }
}
