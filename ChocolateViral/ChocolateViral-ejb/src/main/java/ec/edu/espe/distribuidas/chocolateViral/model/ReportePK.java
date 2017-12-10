/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joel
 */
@Embeddable
public class ReportePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COD_REPORTE")
    private int codReporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PUBLICACION_DESTACADA")
    private int codPublicacionDestacada;

    public ReportePK() {
    }

    public ReportePK(int codReporte, int codPublicacionDestacada) {
        this.codReporte = codReporte;
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    public int getCodReporte() {
        return codReporte;
    }

    public void setCodReporte(int codReporte) {
        this.codReporte = codReporte;
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
        hash += (int) codReporte;
        hash += (int) codPublicacionDestacada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportePK)) {
            return false;
        }
        ReportePK other = (ReportePK) object;
        if (this.codReporte != other.codReporte) {
            return false;
        }
        if (this.codPublicacionDestacada != other.codPublicacionDestacada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.ReportePK[ codReporte=" + codReporte + ", codPublicacionDestacada=" + codPublicacionDestacada + " ]";
    }
    
}
