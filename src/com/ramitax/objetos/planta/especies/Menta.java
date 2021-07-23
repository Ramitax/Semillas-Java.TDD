package com.ramitax.objetos.planta.especies;

import com.ramitax.objetos.parcela.Parcela;
import com.ramitax.objetos.planta.Planta;

/**
 * Clase Menta que hereda de Planta
 * Especie de planta
 *
 * @author Ramitax
 */
public class Menta extends Planta {

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param anioDeObtencion -> Año la semilla que le dio origen se sacó de su planta "madre"
     * @param altura          -> Altura de la semilla, medida en metros
     */
    public Menta(int anioDeObtencion, double altura) {
        super(anioDeObtencion, altura);
    }

    @Override
    public int horasDeToleranciaAlSol() {
        return 6;
    }

    @Override
    public boolean proporcionaSemillas() {
        return ( esFuerte() || (getAltura() > 0.4) );
    }

    @Override
    public double espacioOcupado() {
        return getAltura() * 3;
    }

    @Override
    public boolean esIdealEn(Parcela parcela) {
        return parcela.getSuperficie() > 6;
    }
}
