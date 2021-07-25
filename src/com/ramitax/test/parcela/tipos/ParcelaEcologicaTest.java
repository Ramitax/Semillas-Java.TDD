package com.ramitax.test.parcela.tipos;

import com.ramitax.objetos.parcela.tipos.ParcelaEcologica;
import com.ramitax.objetos.planta.especies.Quinoa;
import com.ramitax.objetos.planta.especies.Soja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelaEcologicaTest {

    @Test
    public void getSuperficieTest() {
        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,7);
        assertEquals(50, parcelaEcologica.getSuperficie());
        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(10,1,7);
        assertEquals(10, parcelaEcologica2.getSuperficie());
    }

    @Test
    public void getCantidadMaximaDePlantasToleradasTest() {
        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,7);
        assertEquals(26, parcelaEcologica.getCantidadMaximaDePlantasToleradas());
        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(10,5,7);
        assertEquals(10, parcelaEcologica2.getCantidadMaximaDePlantasToleradas());
    }

    @Test
    public void tieneComplicacionesTest() {
        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,6);
        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(10,10,7);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaEcologica.plantar(plantaSoja);
        parcelaEcologica.plantar(plantaQuinoa);
        parcelaEcologica2.plantar(plantaQuinoa);
        parcelaEcologica2.plantar(plantaSoja);
        assertEquals(false, parcelaEcologica.tieneComplicaciones());
        assertEquals(true, parcelaEcologica2.tieneComplicaciones());
    }

    @Test
    public void plantarTest() {
        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,6);
        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(5,10,9);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaEcologica.plantar(plantaSoja);
        parcelaEcologica.plantar(plantaQuinoa);
        assertEquals(2, parcelaEcologica.getPlantas().size());
        try{
            parcelaEcologica2.plantar(plantaSoja);
        } catch (IllegalStateException e){
            assertEquals(0, parcelaEcologica2.getPlantas().size());
        }
    }

    @Test
    public void getAlturaMaximaTest() {
        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,6);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaEcologica.plantar(plantaSoja);
        parcelaEcologica.plantar(plantaQuinoa);
        assertEquals(0.5, parcelaEcologica.getAlturaMaxima());
    }

    @Test
    public void porcentajeDePlantasBienAsociadasTest() {
        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,6);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaEcologica.plantar(plantaSoja);
        parcelaEcologica.plantar(plantaQuinoa);
        assertEquals(1, parcelaEcologica.porcentajeDePlantasBienAsociadas());

        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(5,10,5);
        parcelaEcologica2.plantar(plantaQuinoa);
        parcelaEcologica2.plantar(plantaSoja);
        assertEquals(false, parcelaEcologica2.tieneComplicaciones());
        assertEquals(false, plantaSoja.esIdealEn(parcelaEcologica2));
        assertEquals(true, plantaQuinoa.esIdealEn(parcelaEcologica2));
        assertEquals(0.5, parcelaEcologica2.porcentajeDePlantasBienAsociadas());
    }
}
