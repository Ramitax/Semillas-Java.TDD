package com.ramitax.test.inta;

import com.ramitax.objetos.inta.INTA;
import com.ramitax.objetos.parcela.Parcela;
import com.ramitax.objetos.parcela.tipos.ParcelaEcologica;
import com.ramitax.objetos.parcela.tipos.ParcelaIndustrial;
import com.ramitax.objetos.planta.especies.Quinoa;
import com.ramitax.objetos.planta.especies.Soja;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class INTATest {

    @Test
    public void promedioDePlantasTest () {
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,6);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaQuinoa);
        assertEquals(2, parcelaIndustrial.getPlantas().size());
        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,6);
        Soja plantaSoja2 = new Soja(2009, 0.3);
        Quinoa plantaQuinoa2 = new Quinoa(2010, 7);
        parcelaEcologica.plantar(plantaSoja2);
        parcelaEcologica.plantar(plantaQuinoa2);
        assertEquals(2, parcelaEcologica.getPlantas().size());
        List<Parcela> parcelas = new ArrayList<>();
        parcelas.add(parcelaIndustrial);
        parcelas.add(parcelaEcologica);
        INTA inta = new INTA(parcelas);
        assertEquals(2, inta.promedioDePlantas());

        ParcelaIndustrial parcelaIndustrial2 = new ParcelaIndustrial(5,10,6);
        parcelaIndustrial2.plantar(plantaSoja);
        parcelaIndustrial2.plantar(plantaQuinoa);
        assertEquals(2, parcelaIndustrial2.getPlantas().size());
        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(5,10,6);
        parcelaEcologica2.plantar(plantaSoja2);
        assertEquals(1, parcelaEcologica2.getPlantas().size());
        List<Parcela> parcelas2 = new ArrayList<>();
        parcelas2.add(parcelaIndustrial2);
        parcelas2.add(parcelaEcologica2);
        INTA inta2 = new INTA(parcelas2);
        assertEquals(1.5, inta2.promedioDePlantas());
    }

    @Test
    public void parcelaMasSustentable () {
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,6);
        Soja plantaSoja = new Soja(2009, 0.3);
        Quinoa plantaQuinoa = new Quinoa(2010, 7);
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaQuinoa);
        parcelaIndustrial.plantar(plantaSoja);
        parcelaIndustrial.plantar(plantaQuinoa);
        parcelaIndustrial.plantar(plantaSoja);
        assertEquals(5, parcelaIndustrial.getPlantas().size());
        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,6);
        Soja plantaSoja2 = new Soja(2009, 0.3);
        Quinoa plantaQuinoa2 = new Quinoa(2010, 7);
        parcelaEcologica.plantar(plantaSoja2);
        parcelaEcologica.plantar(plantaQuinoa2);
        parcelaEcologica.plantar(plantaSoja2);
        parcelaEcologica.plantar(plantaQuinoa2);
        parcelaEcologica.plantar(plantaSoja2);
        assertEquals(5, parcelaEcologica.getPlantas().size());
        List<Parcela> parcelas = new ArrayList<>();
        parcelas.add(parcelaIndustrial);
        parcelas.add(parcelaEcologica);
        INTA inta = new INTA(parcelas);
        assertEquals(parcelaEcologica, inta.parcelaMasSustentable());

        assertEquals(5, parcelaIndustrial.getPlantas().size());
        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(5,10,6);
        parcelaEcologica2.plantar(plantaSoja2);
        parcelaEcologica2.plantar(plantaQuinoa2);
        parcelaEcologica2.plantar(plantaSoja2);
        parcelaEcologica2.plantar(plantaQuinoa2);
        assertEquals(4, parcelaEcologica2.getPlantas().size());
        List<Parcela> parcelas2 = new ArrayList<>();
        parcelas2.add(parcelaEcologica2);
        parcelas2.add(parcelaEcologica);
        INTA inta2 = new INTA(parcelas2);
        assertEquals(parcelaEcologica, inta2.parcelaMasSustentable());
    }
}
