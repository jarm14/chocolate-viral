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
public class UsuarioDestacadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COD_USUARIO_DESTACADO")
    private int codUsuarioDestacado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_USUARIO")
    private int codUsuario;

    public UsuarioDestacadoPK() {
    }

    public UsuarioDestacadoPK(int codUsuarioDestacado, int codUsuario) {
        this.codUsuarioDestacado = codUsuarioDestacado;
        this.codUsuario = codUsuario;
    }

    public int getCodUsuarioDestacado() {
        return codUsuarioDestacado;
    }

    public void setCodUsuarioDestacado(int codUsuarioDestacado) {
        this.codUsuarioDestacado = codUsuarioDestacado;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codUsuarioDestacado;
        hash += (int) codUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDestacadoPK)) {
            return false;
        }
        UsuarioDestacadoPK other = (UsuarioDestacadoPK) object;
        if (this.codUsuarioDestacado != other.codUsuarioDestacado) {
            return false;
        }
        if (this.codUsuario != other.codUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.UsuarioDestacadoPK[ codUsuarioDestacado=" + codUsuarioDestacado + ", codUsuario=" + codUsuario + " ]";
    }
    
}
