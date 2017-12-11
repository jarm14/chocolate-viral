/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
    
    //@Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 512)
    @Column(name = "DESCRIPCION", nullable = false, length = 512)
    private String descripcion;
    
    //@Basic(optional = false)
    //@NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "COD_PUBLICACION_DESTACADA", referencedColumnName = "COD_PUBLICACION_DESTACADA", insertable = false, updatable = false) 
    private PublicacionDestacada publicacionDestacada;

    public Reporte() {
    }

    public Reporte(ReportePK reportePK) {
        this.reportePK = reportePK;
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
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.reportePK);
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
        final Reporte other = (Reporte) obj;
        if (!Objects.equals(this.reportePK, other.reportePK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reporte{" + "reportePK=" + reportePK + ", descripcion=" + descripcion + ", fecha=" + fecha + ", publicacionDestacada=" + publicacionDestacada + '}';
    }

    
    
}
