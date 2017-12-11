/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "COMENTARIO")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COMENTARIO", nullable = false)
    private Integer codComentario;
    @Column(name = "DESCRIPCION", length = 512, nullable = false)
    private String descripcion;
    @JoinColumns({
        @JoinColumn(name = "COD_PUBLICACION", referencedColumnName = "COD_PUBLICACION")
        , @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO")
        , @JoinColumn(name = "COD_TIPO_PUBLICACION", referencedColumnName = "COD_TIPO_PUBLICACION")})
    @ManyToOne
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(Integer codComentario) {
        this.codComentario = codComentario;
    }

    public Comentario(Integer codComentario, String descripcion) {
        this.codComentario = codComentario;
        this.descripcion = descripcion;
    }

    public Integer getCodComentario() {
        return codComentario;
    }

    public void setCodComentario(Integer codComentario) {
        this.codComentario = codComentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComentario != null ? codComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.codComentario == null && other.codComentario != null) || (this.codComentario != null && !this.codComentario.equals(other.codComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.Comentario[ codComentario=" + codComentario + " ]";
    }
    
}
