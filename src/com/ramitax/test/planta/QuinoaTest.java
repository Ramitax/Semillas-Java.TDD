package com.ramitax.test.planta;

import com.ramitax.objetos.planta.especies.Quinoa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuinoaTest {

    @Test
    public void Quinoa_esFuerteTest() {
        Quinoa plantaQuinoa = new Quinoa(2010, 11);
        assertEquals(true, plantaQuinoa.esFuerte());
        Quinoa plantaQuinoa2 = new Quinoa(2000, 6);
        assertEquals(false, plantaQuinoa2.esFuerte());
        Quinoa plantaQuinoa3 = new Quinoa(2019, 9);
        assertEquals(false, plantaQuinoa3.esFuerte());
    }

    @Test
    public void Quinoa_HoraDeToleranciaAlSolTest(){
        Quinoa plantaQuinoa = new Quinoa(2016, 11);
        assertEquals(11, plantaQuinoa.horasDeToleranciaAlSol());
        Quinoa plantaQuinoa2 = new Quinoa(2000, 6);
        assertEquals(6, plantaQuinoa2.horasDeToleranciaAlSol());
        Quinoa plantaQuinoa3 = new Quinoa(2019, 9);
        assertEquals(9, plantaQuinoa3.horasDeToleranciaAlSol());
    }

    @Test
    public void Quinoa_ProporcionaSemillasTest(){
        Quinoa plantaQuinoa = new Quinoa(2004, 8);
        assertEquals(true, plantaQuinoa.proporcionaSemillas());
        Quinoa plantaQuinoa2 = new Quinoa(2018, 11);
        assertEquals(true, plantaQuinoa2.proporcionaSemillas());
        Quinoa plantaQuinoa3 = new Quinoa(2002, 16);
        assertEquals(true, plantaQuinoa3.proporcionaSemillas());
        Quinoa plantaQuinoa4 = new Quinoa(2019, 9);
        assertEquals(false, plantaQuinoa4.proporcionaSemillas());
    }

    @Test
    public void Quinoa_EspacioOcupadoTest(){
        Quinoa plantaQuinoa = new Quinoa(2004, 8);
        assertEquals(0.5, plantaQuinoa.espacioOcupado());
        Quinoa plantaQuinoa2 = new Quinoa(2018, 11);
        assertEquals(0.5, plantaQuinoa2.espacioOcupado());
        Quinoa plantaQuinoa3 = new Quinoa(2002, 16);
        assertEquals(0.5, plantaQuinoa3.espacioOcupado());
    }

}
