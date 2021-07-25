package com.ramitax.objetos.planta.especies;

import com.ramitax.objetos.parcela.Parcela;
import com.ramitax.objetos.planta.Planta;

/**
 * Clase Soja que hereda de Planta
 * Especie de planta
 *
 * @author Ramitax
 */
public class Soja extends Planta {

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param anioDeObtencion -> Año la semilla que le dio origen se sacó de su planta "madre"
     * @param altura          -> Altura de la semilla, medida en metros
     */
    public Soja(int anioDeObtencion, double altura) {
        super(anioDeObtencion, altura);
    }

    @Override
    public int horasDeToleranciaAlSol() {
        if (getAltura() < 0.5) {
            return 6;
        } else if ( (getAltura() > 0.5) && (getAltura() < 1)) {
            return 7;
        } else {
            return 9;
        }
    }

    @Override
    public boolean proporcionaSemillas() {
        return ( esFuerte() || ( (getAnioDeObtencion() > 2007) && (getAltura() > 1) ) );
    }

    @Override
    public double espacioOcupado() {
        return getAltura() / 2;
    }

    @Override
    public boolean esIdealEn(Parcela parcela) {
        return parcela.getHorasRecibidasDeSol() == horasDeToleranciaAlSol();
    }
}
