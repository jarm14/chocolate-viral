/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "ALARMA")
public class Alarma implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlarmaPK alarmaPK;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "COD_PUBLICACION_DESTACADA", referencedColumnName = "COD_PUBLICACION_DESTACADA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PublicacionDestacada publicacionDestacada;

    public Alarma() {
    }

    public Alarma(AlarmaPK alarmaPK) {
        this.alarmaPK = alarmaPK;
    }

    public Alarma(AlarmaPK alarmaPK, String descripcion) {
        this.alarmaPK = alarmaPK;
        this.descripcion = descripcion;
    }

    public Alarma(int codAlarma, int codPublicacionDestacada) {
        this.alarmaPK = new AlarmaPK(codAlarma, codPublicacionDestacada);
    }

    public AlarmaPK getAlarmaPK() {
        return alarmaPK;
    }

    public void setAlarmaPK(AlarmaPK alarmaPK) {
        this.alarmaPK = alarmaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PublicacionDestacada getPublicacionDestacada() {
        return publicacionDestacada;
    }

    public void setPublicacionDestacada(PublicacionDestacada publicacionDestacada) {
        this.publicacionDestacada = publicacionDestacada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alarmaPK != null ? alarmaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alarma)) {
            return false;
        }
        Alarma other = (Alarma) object;
        if ((this.alarmaPK == null && other.alarmaPK != null) || (this.alarmaPK != null && !this.alarmaPK.equals(other.alarmaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.Alarma[ alarmaPK=" + alarmaPK + " ]";
    }
    
}
