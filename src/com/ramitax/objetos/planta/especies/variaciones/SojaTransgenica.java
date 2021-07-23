package com.ramitax.objetos.planta.especies.variaciones;

import com.ramitax.objetos.parcela.Parcela;
import com.ramitax.objetos.planta.especies.Soja;

/**
 * Clase SojaTransgenica que hereda de Soja
 * Variacion de una especie de planta
 *
 * @author Ramitax
 */
public class SojaTransgenica extends Soja {

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param anioDeObtencion -> Año la semilla que le dio origen se sacó de su planta "madre"
     * @param altura          -> Altura de la semilla, medida en metros
     */
    public SojaTransgenica(int anioDeObtencion, double altura) {
        super(anioDeObtencion, altura);
    }

    @Override
    public boolean proporcionaSemillas() {
        return false;
    }

    @Override
    public boolean esIdealEn(Parcela parcela) {
        return parcela.getCantidadMaximaDePlantasToleradas() == 1;
    }
}
