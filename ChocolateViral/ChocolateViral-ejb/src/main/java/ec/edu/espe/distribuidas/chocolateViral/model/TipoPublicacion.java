/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "TIPO_PUBLICACION")
@NamedQueries({
    @NamedQuery(name = "TipoPublicacion.findAll", query = "SELECT t FROM TipoPublicacion t")})
public class TipoPublicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 10)
    @Column(name = "COD_TIPO_PUBLICACION", nullable = false, length = 10)
    private String codTipoPublicacion;
    
    //@Basic(optional = false)
    //@NotNull
   // @Size(min = 1, max = 512)
    @Column(name = "DESCRIPCION", nullable = false, length = 512)
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPublicacion")
    private List<Publicacion> publicacionList;

    public TipoPublicacion() {
    }

    public TipoPublicacion(String codTipoPublicacion) {
        this.codTipoPublicacion = codTipoPublicacion;
    }

    public TipoPublicacion(String codTipoPublicacion, String descripcion) {
        this.codTipoPublicacion = codTipoPublicacion;
        this.descripcion = descripcion;
    }

    public String getCodTipoPublicacion() {
        return codTipoPublicacion;
    }

    public void setCodTipoPublicacion(String codTipoPublicacion) {
        this.codTipoPublicacion = codTipoPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Publicacion> getPublicacionList() {
        return publicacionList;
    }

    public void setPublicacionList(List<Publicacion> publicacionList) {
        this.publicacionList = publicacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoPublicacion != null ? codTipoPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPublicacion)) {
            return false;
        }
        TipoPublicacion other = (TipoPublicacion) object;
        if ((this.codTipoPublicacion == null && other.codTipoPublicacion != null) || (this.codTipoPublicacion != null && !this.codTipoPublicacion.equals(other.codTipoPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.TipoPublicacion[ codTipoPublicacion=" + codTipoPublicacion + " ]";
    }
    
}
