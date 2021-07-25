package com.ramitax.objetos.inta;

import com.ramitax.objetos.parcela.Parcela;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de Instituto Nacional de Tecnología Agropecuaria (INTA)
 * en la cual se definen los tipos de estadisticas que se van a realizar sobre las parcelas
 *
 * @author Ramitax
 */
public class INTA {

    private List<Parcela> parcelas;

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param parcelas  -> colleccion de parcelas
     */
    public INTA(List<Parcela> parcelas) {
        if ( parcelas != null) {
            this.parcelas = parcelas;
        } else {
            throw new IllegalArgumentException ("Oh ah ocurrido un error, recorda que: " +
                                                "\n- Las lista de parcelas no pueden ser null");
        }
    }

    /**
     * Metodo encargado de determinar el promedio de plantas por parcela
     *
     * @return la suma de todas las plantas de todas las parcelas, divido las parcelas
     */
    public double promedioDePlantas() {
        int cantidadDePlantasTotales = 0;
        for (Parcela parcela : parcelas) {
            cantidadDePlantasTotales += parcela.getPlantas().size();
        }
        return (float) cantidadDePlantasTotales / parcelas.size();
    }

    public Parcela parcelaMasSustentable () {
        Parcela parcelaMasSustentable = null;
        double mayorPorcentaje = 0;
        for (Parcela parcela : parcelas) {
            if (parcela.getPlantas().size() > 4) {
                if ( parcela.porcentajeDePlantasBienAsociadas() > mayorPorcentaje) {
                    mayorPorcentaje = parcela.porcentajeDePlantasBienAsociadas();
                    parcelaMasSustentable = parcela;
                }
            }
        }
        return parcelaMasSustentable;
    }
}
