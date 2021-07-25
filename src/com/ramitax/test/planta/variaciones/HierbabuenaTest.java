package com.ramitax.test.planta.variaciones;

import com.ramitax.objetos.planta.especies.variaciones.Hierbabuena;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HierbabuenaTest {

    @Test
    public void Hierbabuena_EspacioOcupadoTest(){
        Hierbabuena plantaHierbabuena = new Hierbabuena(2015, 1);
        assertEquals(6, plantaHierbabuena.espacioOcupado());
        Hierbabuena plantaHierbabuena2 = new Hierbabuena(2001, 2);
        assertEquals(12, plantaHierbabuena2.espacioOcupado());
        Hierbabuena plantaHierbabuena3 = new Hierbabuena(1999, 3);
        assertEquals(18, plantaHierbabuena3.espacioOcupado());
    }
}
