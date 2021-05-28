/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alex
 */
public class Cliente implements Serializable{
    static final long serialVersionUID=34L;
    
    private int idcliente;
    private String dni,nombre,apellidos,direccion,poblacion,telefono,email,clave;
    Date baja;
            
    public Cliente() {
    }

    public Cliente(int idcliente, String dni, String nombre, String apellidos, String direccion, String poblacion, String telefono, String email, Date baja) {
        this.idcliente = idcliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telefono = telefono;
        this.email = email;
        this.clave = "1234";
        this.baja = baja;
    }

    public Cliente(String dni, String nombre, String apellidos, String direccion, String poblacion, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telefono = telefono;
        this.email = email;
        this.clave = "1234";
        this.baja=null;
    }
    
    public Cliente(String dni, String nombre, String apellidos, String direccion, String poblacion,String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telefono = telefono;
        this.clave = "1234";
        this.baja=null;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public Date getBaja() {
        return baja;
    }

    public int getIdcliente() {
        return idcliente;
    }
}
