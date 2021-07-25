package com.ramitax.test.parcela.tipos;

import com.ramitax.objetos.parcela.tipos.ParcelaEcologica;
import com.ramitax.objetos.parcela.tipos.ParcelaIndustrial;
import com.ramitax.objetos.planta.especies.Quinoa;
import com.ramitax.objetos.planta.especies.Soja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelaIndustrialTest {

    @Test
    public void getSuperficieTest() {
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,7);
        assertEquals(50, parcelaIndustrial.getSuperficie());
        ParcelaIndustrial parcelaIndustrial2 = new ParcelaIndustrial(10,1,7);
        assertEquals(10, parcelaIndustrial2.getSuperficie());
    }

    @Test
    public void getCantidadMaximaDePlantasToleradasTest() {
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,7);
        assertEquals(26, parcelaIndustrial.getCantidadMaximaDePlantasToleradas());
        ParcelaIndustrial parcelaIndustrial2 = new ParcelaIndustrial(10,5,7);
        assertEquals(10, parcelaIndustrial2.getCantidadMaximaDePlantasToleradas());
    }

    @Test
    public void tieneComplicacionesTest() {
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,6);
        ParcelaIndustrial parcelaIndustrial2 = new ParcelaIndustrial(10,10,7);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaQuinoa);
        parcelaIndustrial2.plantar(plantaQuinoa);
        parcelaIndustrial2.plantar(plantaSoja);
        assertEquals(false, parcelaIndustrial.tieneComplicaciones());
        assertEquals(true, parcelaIndustrial2.tieneComplicaciones());
    }

    @Test
    public void plantarTest() {
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,6);
        ParcelaIndustrial parcelaIndustrial2 = new ParcelaIndustrial(5,10,9);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaQuinoa);
        assertEquals(2, parcelaIndustrial.getPlantas().size());
        try{
            parcelaIndustrial2.plantar(plantaSoja);
        } catch (IllegalStateException e){
            assertEquals(0, parcelaIndustrial2.getPlantas().size());
        }
    }

    @Test
    public void getAlturaMaximaTest() {
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,6);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaQuinoa);
        assertEquals(0.5, parcelaIndustrial.getAlturaMaxima());
    }

    @Test
    public void porcentajeDePlantasBienAsociadasTest() {
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,6);
        Quinoa plantaQuinoa = new Quinoa(2005, 15);
        Quinoa plantaQuinoa2 = new Quinoa(2010, 11);
        parcelaIndustrial.plantar(plantaQuinoa);
        parcelaIndustrial.plantar(plantaQuinoa2);
        assertEquals(1, parcelaIndustrial.porcentajeDePlantasBienAsociadas());

        ParcelaIndustrial parcelaIndustrial2 = new ParcelaIndustrial(5,10,6);
        Quinoa plantaQuinoa3 = new Quinoa(2005, 5);
        Quinoa plantaQuinoa4 = new Quinoa(2010, 11);
        parcelaIndustrial2.plantar(plantaQuinoa3);
        parcelaIndustrial2.plantar(plantaQuinoa4);
        assertEquals(0.5, parcelaIndustrial2.porcentajeDePlantasBienAsociadas());
    }
}
