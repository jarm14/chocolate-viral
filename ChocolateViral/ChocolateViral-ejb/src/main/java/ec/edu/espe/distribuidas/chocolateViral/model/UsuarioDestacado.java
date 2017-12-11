/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "USUARIO_DESTACADO")
public class UsuarioDestacado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected UsuarioDestacadoPK usuarioDestacadoPK;
    
    @Column(name = "NUMERO_SEGUIDORES", nullable = false, length = 10)
    private BigDecimal numeroSeguidores;
    
    @ManyToOne
    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false) 
    private Usuario usuario;

    public UsuarioDestacado() {
    }

    public UsuarioDestacado(UsuarioDestacadoPK usuarioDestacadoPK) {
        this.usuarioDestacadoPK = usuarioDestacadoPK;
    }

    public UsuarioDestacadoPK getUsuarioDestacadoPK() {
        return usuarioDestacadoPK;
    }

    public void setUsuarioDestacadoPK(UsuarioDestacadoPK usuarioDestacadoPK) {
        this.usuarioDestacadoPK = usuarioDestacadoPK;
    }

    public BigDecimal getNumeroSeguidores() {
        return numeroSeguidores;
    }

    public void setNumeroSeguidores(BigDecimal numeroSeguidores) {
        this.numeroSeguidores = numeroSeguidores;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioDestacadoPK != null ? usuarioDestacadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDestacado)) {
            return false;
        }
        UsuarioDestacado other = (UsuarioDestacado) object;
        if ((this.usuarioDestacadoPK == null && other.usuarioDestacadoPK != null) || (this.usuarioDestacadoPK != null && !this.usuarioDestacadoPK.equals(other.usuarioDestacadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.UsuarioDestacado[ usuarioDestacadoPK=" + usuarioDestacadoPK + " ]";
    }
    
}
