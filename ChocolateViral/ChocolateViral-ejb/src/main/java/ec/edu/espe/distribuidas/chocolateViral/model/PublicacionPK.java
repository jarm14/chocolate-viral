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
import javax.validation.constraints.Size;

/**
 *
 * @author joel
 */
@Embeddable
public class PublicacionPK implements Serializable {

    //@Basic(optional = false)
    @Column(name = "COD_PUBLICACION", nullable = false)
    private Integer codPublicacion;
    
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codUsuario;
    
    //@Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 10)
    @Column(name = "COD_TIPO_PUBLICACION", nullable = false, length = 10)
    private String codTipoPublicacion;

    public PublicacionPK() {
    }

    public PublicacionPK(int codPublicacion, int codUsuario, String codTipoPublicacion) {
        this.codPublicacion = codPublicacion;
        this.codUsuario = codUsuario;
        this.codTipoPublicacion = codTipoPublicacion;
    }

    public int getCodPublicacion() {
        return codPublicacion;
    }

    public void setCodPublicacion(int codPublicacion) {
        this.codPublicacion = codPublicacion;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodTipoPublicacion() {
        return codTipoPublicacion;
    }

    public void setCodTipoPublicacion(String codTipoPublicacion) {
        this.codTipoPublicacion = codTipoPublicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPublicacion;
        hash += (int) codUsuario;
        hash += (codTipoPublicacion != null ? codTipoPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicacionPK)) {
            return false;
        }
        PublicacionPK other = (PublicacionPK) object;
        if (this.codPublicacion != other.codPublicacion) {
            return false;
        }
        if (this.codUsuario != other.codUsuario) {
            return false;
        }
        if ((this.codTipoPublicacion == null && other.codTipoPublicacion != null) || (this.codTipoPublicacion != null && !this.codTipoPublicacion.equals(other.codTipoPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.PublicacionPK[ codPublicacion=" + codPublicacion + ", codUsuario=" + codUsuario + ", codTipoPublicacion=" + codTipoPublicacion + " ]";
    }
    
}
