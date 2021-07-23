package com.ramitax.objetos.planta;

import com.ramitax.objetos.parcela.Parcela;

/**
 * Clase abstracta de la cual heredan todas las plantas
 * en la cual se definen todos los metodos y atributos que van a tener en comun.
 *
 * @author Ramitax
 */
public abstract class Planta {

    private int anioDeObtencion;
    private double altura;

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param anioDeObtencion -> Año la semilla que le dio origen se sacó de su planta "madre"
     * @param altura          -> Altura de la semilla, medida en metros
     */
    public Planta(int anioDeObtencion, double altura) {
        if ( (anioDeObtencion > 0) && (altura > 0) ){
            this.anioDeObtencion = anioDeObtencion;
            this.altura = altura;
        } else {
            throw new IllegalArgumentException ("Oh ah ocurrido un error, recorda que: " +
                                                "\n- El año de obtencion debe ser mayor a 0" +
                                                "\n- La altura debe ser mayor a 0");
        }
    }

    /**
     * Metodo encargado de determinar si la planta es fuerte
     *
     * @return true en el caso de que la planta sea fuerte o false en el caso de que no lo sea
     */
    public boolean esFuerte(){
        return horasDeToleranciaAlSol() > 10;
    }

    /**
     * Metodo encargado de determinar la cantidad de horas de Sol que aguanta la planta
     * Depende de cada especie
     *
     * @return la cantidad de horas que tolera la planta bajo el Sol
     */
    public abstract int horasDeToleranciaAlSol();

    /**
     * Metodo encargado de determinar si la planta proporciona semillas
     * Depende de cada especie
     *
     * @return true en el caso de que la planta proporcione semillas o false en el caso de que no lo haga
     */
    public abstract boolean proporcionaSemillas();

    /**
     * Metodo determinado al calculo del espacio que va a ocupar la planta, medido en metros cuadrados
     * Depende de cada especie
     *
     * @return la cantidad de metros cuadrados que ocupa la planta
     */
    public abstract double espacioOcupado();

    /**
     * Metodo encargado de devolver el año de obtencion de la semilla
     *
     * @return año de obtencion de la semilla
     */
    public int getAnioDeObtencion() {
        return anioDeObtencion;
    }

    /**
     * Metodo encargado de cambiar el año de obtencion de la semilla
     *
     * @param anioDeObtencion -> año de obtencion de la semilla
     */
    public void setAnioDeObtencion(int anioDeObtencion) {
        if (anioDeObtencion > 0) {
            this.anioDeObtencion = anioDeObtencion;
        } else {
            throw new IllegalArgumentException ("Oh ah ocurrido un error, recorda que: " +
                                                "\n- El año de obtencion debe ser mayor a 0");
        }
    }

    /**
     * Metodo encargado de devolver la altura de la planta
     *
     * @return la altura de la planta
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Metodo encargado de cambiar la altura de la planta
     *
     * @param altura -> la altura de la planta
     */
    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            throw new IllegalArgumentException ("Oh ah ocurrido un error, recorda que: " +
                                                "\n- La altura debe ser mayor a 0");
        }
    }

    /**
     * Metodo encargado de determinar si la planta es ideal para una parcela
     *
     * @param parcela a la cual se intenta averiguar si es ideal
     * @return true si es ideal o false si no lo es
     */
    public abstract boolean esIdealEn (Parcela parcela);

    @Override
    public String toString() {
        return "\nPlanta:" +
                "\n-Año de obtencion: " + anioDeObtencion +
                "\n-Altura: " + altura;
    }
}
