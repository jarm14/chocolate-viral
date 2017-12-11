/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author joel
 */
@Embeddable
public class AlarmaPK implements Serializable {

    @Column(name = "COD_ALARMA")
    private int codAlarma;
    @Column(name = "COD_PUBLICACION_DESTACADA",  nullable = false)
    private int codPublicacionDestacada;

    public AlarmaPK() {
    }

    public AlarmaPK(int codAlarma, int codPublicacionDestacada) {
        this.codAlarma = codAlarma;
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    public int getCodAlarma() {
        return codAlarma;
    }

    public void setCodAlarma(int codAlarma) {
        this.codAlarma = codAlarma;
    }

    public int getCodPublicacionDestacada() {
        return codPublicacionDestacada;
    }

    public void setCodPublicacionDestacada(int codPublicacionDestacada) {
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codAlarma;
        hash += (int) codPublicacionDestacada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlarmaPK)) {
            return false;
        }
        AlarmaPK other = (AlarmaPK) object;
        if (this.codAlarma != other.codAlarma) {
            return false;
        }
        if (this.codPublicacionDestacada != other.codPublicacionDestacada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.AlarmaPK[ codAlarma=" + codAlarma + ", codPublicacionDestacada=" + codPublicacionDestacada + " ]";
    }
    
}
