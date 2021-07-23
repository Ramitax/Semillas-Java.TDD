package com.ramitax.test;

import com.ramitax.objetos.parcela.tipos.ParcelaIndustrial;
import com.ramitax.objetos.planta.especies.Menta;
import com.ramitax.objetos.planta.especies.Quinoa;
import com.ramitax.objetos.planta.especies.Soja;
import com.ramitax.objetos.planta.especies.variaciones.Hierbabuena;
import com.ramitax.objetos.planta.especies.variaciones.SojaTransgenica;

public class ParcelaTest {

    public Soja plantaSoja = new Soja(2009, 0.6);
    public Quinoa plantaQuinoa = new Quinoa(2010, 12);
    public Menta plantaMenta = new Menta(2010, 1);
    public SojaTransgenica plantaSojaTransgenica = new SojaTransgenica(2011, 2);
    public Hierbabuena plantaHierbabuena = new Hierbabuena(2015, 1);

    ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(20, 1, 8);
}
