package com.ramitax.objetos.parcela;

import com.ramitax.objetos.parcela.exception.ParcelaException;
import com.ramitax.objetos.planta.Planta;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta de la cual heredan los tipos de parcela
 * en la cual se definen todos los metodos y atributos que van a tener en comun.
 *
 * @author Ramitax
 */
public abstract class Parcela {

    private int ancho;
    private int largo;
    private int horasRecibidasDeSol;
    private List<Planta> plantas;

    /**
     * Metodo Constructor sin plantas, encargado de crear el objeto
     *
     * @param ancho                -> Ancho de la parcela, en metros
     * @param largo                -> Largo de la parcela, en metros
     * @param horasRecibidasDeSol  -> Cantidad de horas que recibe de Sol la parcela
     */
    public Parcela(int ancho, int largo, int horasRecibidasDeSol) {
        if ( (ancho > 0) && (largo > 0) && (horasRecibidasDeSol > 0) ){
            this.ancho = ancho;
            this.largo = largo;
            this.horasRecibidasDeSol = horasRecibidasDeSol;
            this.plantas = new ArrayList<>();
        } else {
            throw new IllegalArgumentException ("Oh ah ocurrido un error, recorda que: " +
                    "\n- El ancho debe ser mayor a 0" +
                    "\n- El largo debe ser mayor a 0" +
                    "\n- Las horasRecibidasDeSol debe ser mayor a 0");
        }
    }

    /**
     * Metodo Constructor, encargado de crear el objeto
     *
     * @param ancho                -> Ancho de la parcela, en metros
     * @param largo                -> Largo de la parcela, en metros
     * @param horasRecibidasDeSol  -> Cantidad de horas que recibe de Sol la parcela
     * @param plantas              -> Colleccion de plantas
     */
    public Parcela(int ancho, int largo, int horasRecibidasDeSol, List<Planta> plantas) {
        if ( (ancho > 0) && (largo > 0) && (horasRecibidasDeSol > 0) && (plantas != null) ){
            this.ancho = ancho;
            this.largo = largo;
            this.horasRecibidasDeSol = horasRecibidasDeSol;
            this.plantas = plantas;
        } else {
            throw new IllegalArgumentException ("Oh ah ocurrido un error, recorda que: " +
                                                "\n- El ancho debe ser mayor a 0" +
                                                "\n- El largo debe ser mayor a 0" +
                                                "\n- Las horasRecibidasDeSol debe ser mayor a 0" +
                                                "\n- Las plantas deben ser distintas de null");
        }
    }

    /**
     * Metodo encargado de determinar la superficie de la parcela, en metros
     *
     * @return la superficie de la parcela, en metros
     */
    public double getSuperficie(){
        return ancho * largo;
    }

    /**
     * Metodo encargado de determinar la cantidad maxima de plantas toleradas
     *
     * @return la cantidad maxima de plantas toleradas
     */
    public int getCantidadMaximaDePlantasToleradas(){
        if ( ancho > largo) {
            return (int)(getSuperficie() / 5);
        } else {
            return (int) ((getSuperficie() / 3) + largo );
        }
    }

    /**
     * Metodo encargado de determinar si la parcela va a tener complicaciones
     *
     * @return true si tiene complicaciones o false si no tiene complicaciones
     */
    public boolean tieneComplicaciones(){
        boolean complicaciones = false;
        for (Planta planta : this.plantas) {
            if (planta.horasDeToleranciaAlSol() < horasRecibidasDeSol) {
                complicaciones = planta.horasDeToleranciaAlSol() < horasRecibidasDeSol;
                break;
            }
        }
        return complicaciones;
    }


    /**
     * Metodo encargado de agregar a la colleccion en el caso de que sea posible a un objeto de tipo planta
     * Arroja un error si:
     *                      - Al agregar la planta se supera la cantidad maxima de plantas
     *                      - La parcela recibe al menos 2 horas mas de sol que lo que la planta tolera
     *
     * @param planta objeto que se desea agregar a la colleccion
     * @return true si se puede plantar o false si no se puede
     */
    public boolean plantar (Planta planta) {

        try {
            if ( plantas.size() >= getCantidadMaximaDePlantasToleradas() ) {
                throw new ParcelaException("Oh ah ocurrido un error, no se puede plantar, debido a que al plantarla se superaria la cantidad maxima de plantas que tolera la parcela");
            }
            if ( horasRecibidasDeSol >= (planta.horasDeToleranciaAlSol() + 2) ) {
                throw new ParcelaException("Oh ah ocurrido un error, no se puede plantar, debido a que la parcela recibe al menos 2 horas mas de sol que la cantidad maxima de sol que tolera la planta");
            }
            plantas.add(planta);
            return true;
        } catch (ParcelaException error) {
            System.err.println(error.getMessage());
            return false;
        }
    }

    /**
     * Metodo encargado de devolver el ancho de la parcela
     *
     * @return la altura de la planta
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Metodo encargado de cambiar el ancho de la parcela
     *
     * @param ancho -> ancho de la parcela
     */
    public void setAncho(int ancho) {
        if ( ancho > 0) {
            this.ancho = ancho;
        } else {
            throw new IllegalArgumentException("Oh ah ocurrido un error, recorda que: " +
                                                "\n- El ancho debe ser mayor a 0");
        }
    }

    /**
     * Metodo encargado de devolver el largo de la parcela
     *
     * @return la largo de la planta
     */
    public int getLargo() {
        return largo;
    }

    /**
     * Metodo encargado de cambiar el largo de la parcela
     *
     * @param largo -> largo de la parcela
     */
    public void setLargo(int largo) {
        if ( largo > 0) {
            this.largo = largo;
        } else {
            throw new IllegalArgumentException("Oh ah ocurrido un error, recorda que: " +
                                                "\n- El largo debe ser mayor a 0");
        }
    }

    /**
     * Metodo encargado de devolver las horas de sol recibidas
     *
     * @return la cantidad de horas de sol recibidas
     */
    public int getHorasRecibidasDeSol() {
        return horasRecibidasDeSol;
    }

    /**
     * Metodo encargado de cambiar las horas de sol recibidas
     *
     * @param horasRecibidasDeSol -> la cantidad de horas de sol recibidas
     */
    public void setHorasRecibidasDeSol(int horasRecibidasDeSol) {
        if ( horasRecibidasDeSol > 0){
            this.horasRecibidasDeSol = horasRecibidasDeSol;
        } else {
            throw new IllegalArgumentException("Oh ah ocurrido un error, recorda que: " +
                                                "\n- La cantidad de horas de sol recibida debe ser mayor a 0");
        }
    }
    /**
     * Metodo encargado de devolver la colleccion de plantas
     *
     * @return la colleccion de plantas
     */
    public List<Planta> getPlantas() {
        return plantas;
    }

    /**
     * Metodo encargado de cambiar la colleccion de plantas
     *
     * @param plantas -> la colleccion de plantas
     */
    public void setPlantas(List<Planta> plantas) {
        if ( ( plantas != null ) && ( !plantas.isEmpty() ) ){
            this.plantas = plantas;
        } else {
            throw new IllegalArgumentException("Oh ah ocurrido un error, recorda que: " +
                                                "\n- La collecion de plantas no tiene que estar vacia ni ser igual a null");
        }
    }

    /**
     * Metodo encargado de devolver la altura de la planta mas grande de la parcela
     *
     * @return la altura de la planta mas grande en la parcela
     */
    public double getAlturaMaxima(){
        double alturaMaxima = 0;
        for (Planta planta : plantas) {
            if( planta.getAltura() > alturaMaxima ){
                alturaMaxima = planta.getAltura();
            }
        }
        return alturaMaxima;
    }

    /**
     * Metodo encargado de determinar si una planta se asocia bien con la parcela
     *
     * @param planta -> que se quiere asociar
     * @return true si se asocia bien o false si no se asocia bien
     */
    public abstract boolean seAsociaBienCon(Planta planta);

    public double porcentajeDePlantasBienAsociadas() {
        int cantidadDePlantasBienAsociadas = 0;
        for (Planta planta : plantas) {
            if(seAsociaBienCon(planta)){
                cantidadDePlantasBienAsociadas++;
            }
        }
        return cantidadDePlantasBienAsociadas / plantas.size();
    }
}
