/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "USUARIO_DESTACADO")
@NamedQueries({
    @NamedQuery(name = "UsuarioDestacado.findAll", query = "SELECT u FROM UsuarioDestacado u")})
public class UsuarioDestacado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioDestacadoPK usuarioDestacadoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_SEGUIDORES")
    private long numeroSeguidores;
    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioDestacado() {
    }

    public UsuarioDestacado(UsuarioDestacadoPK usuarioDestacadoPK) {
        this.usuarioDestacadoPK = usuarioDestacadoPK;
    }

    public UsuarioDestacado(UsuarioDestacadoPK usuarioDestacadoPK, long numeroSeguidores) {
        this.usuarioDestacadoPK = usuarioDestacadoPK;
        this.numeroSeguidores = numeroSeguidores;
    }

    public UsuarioDestacado(int codUsuarioDestacado, int codUsuario) {
        this.usuarioDestacadoPK = new UsuarioDestacadoPK(codUsuarioDestacado, codUsuario);
    }

    public UsuarioDestacadoPK getUsuarioDestacadoPK() {
        return usuarioDestacadoPK;
    }

    public void setUsuarioDestacadoPK(UsuarioDestacadoPK usuarioDestacadoPK) {
        this.usuarioDestacadoPK = usuarioDestacadoPK;
    }

    public long getNumeroSeguidores() {
        return numeroSeguidores;
    }

    public void setNumeroSeguidores(long numeroSeguidores) {
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
