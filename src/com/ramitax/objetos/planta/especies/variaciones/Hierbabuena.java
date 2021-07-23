package com.ramitax.objetos.planta.especies.variaciones;

import com.ramitax.objetos.planta.especies.Menta;

/**
 * Clase Hierbabuena que hereda de Menta
 * Variacion de una especie de planta
 *
 * @author Ramitax
 */
public class Hierbabuena extends Menta {

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param anioDeObtencion -> Año la semilla que le dio origen se sacó de su planta "madre"
     * @param altura          -> Altura de la semilla, medida en metros
     */
    public Hierbabuena(int anioDeObtencion, double altura) {
        super(anioDeObtencion, altura);
    }

    @Override
    public double espacioOcupado() {
        return super.espacioOcupado() * 2;
    }
}
