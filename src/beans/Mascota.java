/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Alex
 */
public class Mascota implements Serializable {
    static final long serialVersionUID=35L;

    private int idmascota;

    private String numerochip;

    private String nombre;

    private int anionacimiento;

    private String especie;

    private double peso;

    private int idcliente;
    
    public Mascota() {
    }

    public Mascota(String numerochip, String nombre, String especie, int idcliente) {
        this.numerochip = numerochip;
        this.nombre = nombre;
        this.especie = especie;
        this.idcliente = idcliente;
    }

    public Mascota(String numerochip, String nombre, int aniocimiento, String especie, double peso, int idcliente) {
        this.numerochip = numerochip;
        this.nombre = nombre;
        this.anionacimiento = aniocimiento;
        this.especie = especie;
        this.peso = peso;
        this.idcliente = idcliente;
    }

    public int getIdmascota() {
        return idmascota;
    }

    public String getNumerochip() {
        return numerochip;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnionacimiento() {
        return anionacimiento;
    }

    public String getEspecie() {
        return especie;
    }

    public double getPeso() {
        return peso;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setNumerochip(String numerochip) {
        this.numerochip = numerochip;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnionacimiento(int anionacimiento) {
        this.anionacimiento = anionacimiento;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    
    
}
