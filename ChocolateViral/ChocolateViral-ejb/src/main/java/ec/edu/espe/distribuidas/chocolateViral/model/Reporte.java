/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "REPORTE")
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportePK reportePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "COD_PUBLICACION_DESTACADA", referencedColumnName = "COD_PUBLICACION_DESTACADA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PublicacionDestacada publicacionDestacada;

    public Reporte() {
    }

    public Reporte(ReportePK reportePK) {
        this.reportePK = reportePK;
    }

    public Reporte(ReportePK reportePK, String descripcion, Date fecha) {
        this.reportePK = reportePK;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Reporte(int codReporte, int codPublicacionDestacada) {
        this.reportePK = new ReportePK(codReporte, codPublicacionDestacada);
    }

    public ReportePK getReportePK() {
        return reportePK;
    }

    public void setReportePK(ReportePK reportePK) {
        this.reportePK = reportePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (reportePK != null ? reportePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.reportePK == null && other.reportePK != null) || (this.reportePK != null && !this.reportePK.equals(other.reportePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.Reporte[ reportePK=" + reportePK + " ]";
    }
    
}
