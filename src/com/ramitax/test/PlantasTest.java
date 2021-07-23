package com.ramitax.test;

import com.ramitax.objetos.planta.especies.Menta;
import com.ramitax.objetos.planta.especies.Quinoa;
import com.ramitax.objetos.planta.especies.Soja;
import com.ramitax.objetos.planta.especies.variaciones.Hierbabuena;
import com.ramitax.objetos.planta.especies.variaciones.SojaTransgenica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantasTest {

    public Soja plantaSoja = new Soja(2009, 0.6);
    public Quinoa plantaQuinoa = new Quinoa(2010, 12);
    public Menta plantaMenta = new Menta(2010, 1);
    public SojaTransgenica plantaSojaTransgenica = new SojaTransgenica(2011, 2);
    public Hierbabuena plantaHierbabuena = new Hierbabuena(2015, 1);

    @Test
    public void Soja_HoraDeToleranciaAlSolTest(){
        assertEquals(7, plantaSoja.horasDeToleranciaAlSol());
    }

    @Test
    public void Soja_ProporcionaSemillasTest(){
        assertEquals(false, plantaSoja.proporcionaSemillas());
    }

    @Test
    public void Soja_EspacioOcupadoTest(){
        assertEquals(0.3, plantaSoja.espacioOcupado(), 0.05);
    }

    @Test
    public void Quinoa_HoraDeToleranciaAlSolTest(){
        assertEquals(12, plantaQuinoa.horasDeToleranciaAlSol());
    }

    @Test
    public void Quinoa_ProporcionaSemillasTest(){
        assertEquals(true, plantaQuinoa.proporcionaSemillas());
    }

    @Test
    public void Quinoa_EspacioOcupadoTest(){
        assertEquals(0.5, plantaQuinoa.espacioOcupado());
    }

    @Test
    public void Menta_HoraDeToleranciaAlSolTest(){
        assertEquals(6, plantaMenta.horasDeToleranciaAlSol());
    }

    @Test
    public void Menta_ProporcionaSemillasTest(){
        assertEquals(true, plantaMenta.proporcionaSemillas());
    }

    @Test
    public void Menta_EspacioOcupadoTest(){
        assertEquals(3, plantaMenta.espacioOcupado());
    }

    @Test
    public void SojaTransgenica_HoraDeToleranciaAlSolTest(){
        assertEquals(9, plantaSojaTransgenica.horasDeToleranciaAlSol());
    }

    @Test
    public void SojaTransgenica_ProporcionaSemillasTest(){
        assertEquals(false, plantaSojaTransgenica.proporcionaSemillas());
    }

    @Test
    public void SojaTransgenica_EspacioOcupadoTest(){
        assertEquals(1, plantaSojaTransgenica.espacioOcupado());
    }

    @Test
    public void Hierbabuena_HoraDeToleranciaAlSolTest(){
        assertEquals(6, plantaHierbabuena.horasDeToleranciaAlSol());
    }

    @Test
    public void Hierbabuena_ProporcionaSemillasTest(){
        assertEquals(true, plantaHierbabuena.proporcionaSemillas());
    }

    @Test
    public void Hierbabuena_EspacioOcupadoTest(){
        assertEquals(6, plantaHierbabuena.espacioOcupado());
    }
}
