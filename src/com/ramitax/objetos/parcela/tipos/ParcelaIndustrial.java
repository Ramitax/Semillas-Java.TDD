package com.ramitax.objetos.parcela.tipos;

import com.ramitax.objetos.parcela.Parcela;
import com.ramitax.objetos.planta.Planta;

import java.util.List;

/**
 * Clase ParcelaIndustrial que hereda de Parcela
 * Variacion de un tipo de Parcela
 *
 * @author Ramitax
 */
public class ParcelaIndustrial extends Parcela {

    /**
     * Metodo Constructor sin plantas, encargado de crear el objeto
     *
     * @param ancho                -> Ancho de la parcela, en metros
     * @param largo                -> Largo de la parcela, en metros
     * @param horasRecibidasDeSol  -> Cantidad de horas que recibe de Sol la parcela
     */
    public ParcelaIndustrial(int ancho, int largo, int horasRecibidasDeSol) {
        super(ancho, largo, horasRecibidasDeSol);
    }

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param ancho                -> Ancho de la parcela, en metros
     * @param largo                -> Largo de la parcela, en metros
     * @param horasRecibidasDeSol  -> Cantidad de horas que recibe de Sol la parcela
     * @param plantas              -> Colleccion de plantas
     */
    public ParcelaIndustrial(int ancho, int largo, int horasRecibidasDeSol, List<Planta> plantas) {
        super(ancho, largo, horasRecibidasDeSol, plantas);
    }

    @Override
    public boolean seAsociaBienCon(Planta planta) {
        return ( ( getPlantas().size() <= 2 ) && ( planta.esFuerte() ) );
    }
}
