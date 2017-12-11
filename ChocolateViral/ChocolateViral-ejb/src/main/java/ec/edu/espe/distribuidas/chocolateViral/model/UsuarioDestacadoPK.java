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
public class UsuarioDestacadoPK implements Serializable {

    //@Basic(optional = false)
    @Column(name = "COD_USUARIO_DESTACADO",nullable = false)
    private Integer codUsuarioDestacado;
    
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codUsuario;

    public UsuarioDestacadoPK() {
    }

    public UsuarioDestacadoPK(Integer codUsuarioDestacado, Integer codUsuario) {
        this.codUsuarioDestacado = codUsuarioDestacado;
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codUsuarioDestacado);
        hash = 97 * hash + Objects.hashCode(this.codUsuario);
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
        final UsuarioDestacadoPK other = (UsuarioDestacadoPK) obj;
        if (!Objects.equals(this.codUsuarioDestacado, other.codUsuarioDestacado)) {
            return false;
        }
        if (!Objects.equals(this.codUsuario, other.codUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioDestacadoPK{" + "codUsuarioDestacado=" + codUsuarioDestacado + ", codUsuario=" + codUsuario + '}';
    }

    
    
}
