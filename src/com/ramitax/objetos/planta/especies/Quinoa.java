package com.ramitax.objetos.planta.especies;

import com.ramitax.objetos.parcela.Parcela;
import com.ramitax.objetos.planta.Planta;

/**
 * Clase Quinoa que hereda de Planta
 * Especie de planta
 *
 * @author Ramitax
 */
public class Quinoa extends Planta {

    private int horasDeToleranciaAlSol;

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param anioDeObtencion        -> Año la semilla que le dio origen se sacó de su planta "madre"
     * @param horasDeToleranciaAlSol -> Horas de tolerancia al Sol de la planta
     */
    public Quinoa(int anioDeObtencion, int horasDeToleranciaAlSol) {
        super(anioDeObtencion, 0.5);
        this.horasDeToleranciaAlSol = horasDeToleranciaAlSol;
    }

    @Override
    public int horasDeToleranciaAlSol() {
        return horasDeToleranciaAlSol;
    }

    @Override
    public boolean proporcionaSemillas() {
        return ( (esFuerte()) || (getAnioDeObtencion() < 2005) );
    }

    @Override
    public double espacioOcupado() {
        return 0.5;
    }

    @Override
    public boolean esIdealEn(Parcela parcela) {
        return parcela.getAlturaMaxima() < 1.5;
    }

}
