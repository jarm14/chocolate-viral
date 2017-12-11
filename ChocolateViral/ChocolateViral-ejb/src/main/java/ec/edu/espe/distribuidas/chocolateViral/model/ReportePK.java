/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.util.Objects;
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

    //@Basic(optional = false)
    @Column(name = "COD_REPORTE", nullable = false)
    private Integer codReporte;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "COD_PUBLICACION_DESTACADA", nullable = false)
    private Integer codPublicacionDestacada;

    public ReportePK() {
    }

    public ReportePK(Integer codReporte, Integer codPublicacionDestacada) {
        this.codReporte = codReporte;
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    public int getCodReporte() {
        return codReporte;
    }

    public void setCodReporte(Integer codReporte) {
        this.codReporte = codReporte;
    }

    public Integer getCodPublicacionDestacada() {
        return codPublicacionDestacada;
    }

    public void setCodPublicacionDestacada(Integer codPublicacionDestacada) {
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.codReporte);
        hash = 73 * hash + Objects.hashCode(this.codPublicacionDestacada);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReportePK other = (ReportePK) obj;
        if (!Objects.equals(this.codReporte, other.codReporte)) {
            return false;
        }
        if (!Objects.equals(this.codPublicacionDestacada, other.codPublicacionDestacada)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReportePK{" + "codReporte=" + codReporte + ", codPublicacionDestacada=" + codPublicacionDestacada + '}';
    }
  
}
