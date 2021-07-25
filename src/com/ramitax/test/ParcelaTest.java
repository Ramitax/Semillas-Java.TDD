package com.ramitax.test;

import com.ramitax.objetos.parcela.tipos.ParcelaEcologica;
import com.ramitax.objetos.parcela.tipos.ParcelaIndustrial;
import com.ramitax.objetos.planta.especies.Menta;
import com.ramitax.objetos.planta.especies.Quinoa;
import com.ramitax.objetos.planta.especies.Soja;
import com.ramitax.objetos.planta.especies.variaciones.Hierbabuena;
import com.ramitax.objetos.planta.especies.variaciones.SojaTransgenica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelaTest {

    public Soja plantaSoja = new Soja(2009, 0.6);
    public Quinoa plantaQuinoa = new Quinoa(2010, 12);
    public Menta plantaMenta = new Menta(2010, 1);
    public SojaTransgenica plantaSojaTransgenica = new SojaTransgenica(2011, 2);
    public Hierbabuena plantaHierbabuena = new Hierbabuena(2015, 1);

    ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(20, 1, 5);
    ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,7);


    @Test
    public void ParcelaIndustrial_getSuperficieTest() {
        assertEquals(20, parcelaIndustrial.getSuperficie());
    }

    @Test
    public void ParcelaEcologica_getSuperficieTest() {
        assertEquals(50, parcelaEcologica.getSuperficie());
    }

    @Test
    public void ParcelaIndustrial_getCantidadMaximaDePlantasToleradas(){
        assertEquals(4, parcelaIndustrial.getCantidadMaximaDePlantasToleradas(), 0.1);
    }

    @Test
    public void ParcelaEcologica_getCantidadMaximaDePlantasToleradas(){
        assertEquals(26, parcelaEcologica.getCantidadMaximaDePlantasToleradas(), 0.7);
    }

    @Test
    public void ParcelaIndustrial_tieneComplicaciones(){
        parcelaIndustrial.plantar(plantaSojaTransgenica);
        parcelaIndustrial.plantar(plantaHierbabuena);

        assertEquals(9, plantaSojaTransgenica.horasDeToleranciaAlSol());
        assertEquals(6, plantaHierbabuena.horasDeToleranciaAlSol());
        assertEquals(true, parcelaEcologica.tieneComplicaciones());
    }

    @Test
    public void ParcelaEcologica_tieneComplicaciones(){
        parcelaEcologica.plantar(plantaSoja);
        parcelaEcologica.plantar(plantaMenta);

        assertEquals(7, plantaSoja.horasDeToleranciaAlSol());
        assertEquals(6, plantaMenta.horasDeToleranciaAlSol());
        assertEquals(true, parcelaEcologica.tieneComplicaciones());
    }

    @Test
    public void ParcelaEcologica_plantar(){
        parcelaEcologica.plantar(plantaSoja);
        parcelaEcologica.plantar(plantaMenta);

        assertEquals(2, parcelaEcologica.getPlantas().size());
    }

    @Test
    public void ParcelaIndustrial_plantar(){
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaMenta);

        assertEquals(2, parcelaIndustrial.getPlantas().size());
    }

    @Test
    public void ParcelaEcologica_getAlturaMaxima(){
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaMenta);

        assertEquals(1, parcelaIndustrial.getAlturaMaxima());
    }

    @Test
    public void ParcelaIndustrial_getAlturaMaxima(){
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaMenta);

        assertEquals(1, parcelaIndustrial.getAlturaMaxima());
    }


}
