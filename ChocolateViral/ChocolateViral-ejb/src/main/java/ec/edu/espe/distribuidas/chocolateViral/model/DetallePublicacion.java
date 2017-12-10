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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "DETALLE_PUBLICACION")
@NamedQueries({
    @NamedQuery(name = "DetallePublicacion.findAll", query = "SELECT d FROM DetallePublicacion d")})
public class DetallePublicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_DETALLE_PUBLICACION")
    private Integer codDetallePublicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 512)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "COD_HASHTAG", referencedColumnName = "COD_HASHTAG")
    @ManyToOne
    private Hashtag codHashtag;
    @JoinColumns({
        @JoinColumn(name = "COD_PUBLICACION", referencedColumnName = "COD_PUBLICACION")
        , @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO")
        , @JoinColumn(name = "COD_TIPO_PUBLICACION", referencedColumnName = "COD_TIPO_PUBLICACION")})
    @ManyToOne
    private Publicacion publicacion;
    @JoinColumn(name = "COD_LOCALIZACION", referencedColumnName = "COD_LOCALIZACION")
    @ManyToOne
    private Localizacion codLocalizacion;

    public DetallePublicacion() {
    }

    public DetallePublicacion(Integer codDetallePublicacion) {
        this.codDetallePublicacion = codDetallePublicacion;
    }

    public DetallePublicacion(Integer codDetallePublicacion, Date fecha) {
        this.codDetallePublicacion = codDetallePublicacion;
        this.fecha = fecha;
    }

    public Integer getCodDetallePublicacion() {
        return codDetallePublicacion;
    }

    public void setCodDetallePublicacion(Integer codDetallePublicacion) {
        this.codDetallePublicacion = codDetallePublicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Hashtag getCodHashtag() {
        return codHashtag;
    }

    public void setCodHashtag(Hashtag codHashtag) {
        this.codHashtag = codHashtag;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Localizacion getCodLocalizacion() {
        return codLocalizacion;
    }

    public void setCodLocalizacion(Localizacion codLocalizacion) {
        this.codLocalizacion = codLocalizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetallePublicacion != null ? codDetallePublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePublicacion)) {
            return false;
        }
        DetallePublicacion other = (DetallePublicacion) object;
        if ((this.codDetallePublicacion == null && other.codDetallePublicacion != null) || (this.codDetallePublicacion != null && !this.codDetallePublicacion.equals(other.codDetallePublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.DetallePublicacion[ codDetallePublicacion=" + codDetallePublicacion + " ]";
    }
    
}
