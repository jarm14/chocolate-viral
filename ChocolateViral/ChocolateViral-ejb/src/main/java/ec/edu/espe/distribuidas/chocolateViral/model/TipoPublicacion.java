/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "TIPO_PUBLICACION")
public class TipoPublicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_TIPO_PUBLICACION", nullable = false, length = 10)
    private String codTipoPublicacion;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 512)
    private String descripcion;
    
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
