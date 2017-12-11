/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "PUBLICACION")
public class Publicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PublicacionPK publicacionPK;
    @Column(name = "LIKES")
    private Long likes;
    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentarioList;
    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "COD_TIPO_PUBLICACION", referencedColumnName = "COD_TIPO_PUBLICACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoPublicacion tipoPublicacion;
    @OneToMany(mappedBy = "publicacion")
    private List<DetallePublicacion> detallePublicacionList;

    public Publicacion() {
    }

    public Publicacion(PublicacionPK publicacionPK) {
        this.publicacionPK = publicacionPK;
    }

    public Publicacion(int codPublicacion, int codUsuario, String codTipoPublicacion) {
        this.publicacionPK = new PublicacionPK(codPublicacion, codUsuario, codTipoPublicacion);
    }

    public PublicacionPK getPublicacionPK() {
        return publicacionPK;
    }

    public void setPublicacionPK(PublicacionPK publicacionPK) {
        this.publicacionPK = publicacionPK;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoPublicacion getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public List<DetallePublicacion> getDetallePublicacionList() {
        return detallePublicacionList;
    }

    public void setDetallePublicacionList(List<DetallePublicacion> detallePublicacionList) {
        this.detallePublicacionList = detallePublicacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicacionPK != null ? publicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacion)) {
            return false;
        }
        Publicacion other = (Publicacion) object;
        if ((this.publicacionPK == null && other.publicacionPK != null) || (this.publicacionPK != null && !this.publicacionPK.equals(other.publicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.Publicacion[ publicacionPK=" + publicacionPK + " ]";
    }
    
}
