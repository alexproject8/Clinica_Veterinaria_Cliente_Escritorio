/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Alex
 */
public class Cita implements Serializable {
    static final long serialVersionUID=43L;
    
    private int idcita;

    private String motivo;

    private Date fecha;

    private int idcliente;

    private int idmascota;

    public Cita(String motivo, Date fecha,int idcliente, int idmascota) {
        this.motivo = motivo;
        this.fecha = fecha;
        this.idcliente = idcliente;
        this.idmascota = idmascota;
    }

    public int getIdcita() {
        return idcita;
    }

    public String getMotivo() {
        return motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public int getIdmascota() {
        return idmascota;
    }
    
    
}
