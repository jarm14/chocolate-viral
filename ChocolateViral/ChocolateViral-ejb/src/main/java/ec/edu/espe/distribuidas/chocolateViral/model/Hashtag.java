/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "HASHTAG")
@NamedQueries({
    @NamedQuery(name = "Hashtag.findAll", query = "SELECT h FROM Hashtag h")})
public class Hashtag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_HASHTAG")
    private Integer codHashtag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "codHashtag")
    private List<DetallePublicacion> detallePublicacionList;

    public Hashtag() {
    }

    public Hashtag(Integer codHashtag) {
        this.codHashtag = codHashtag;
    }

    public Hashtag(Integer codHashtag, String descripcion) {
        this.codHashtag = codHashtag;
        this.descripcion = descripcion;
    }

    public Integer getCodHashtag() {
        return codHashtag;
    }

    public void setCodHashtag(Integer codHashtag) {
        this.codHashtag = codHashtag;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (codHashtag != null ? codHashtag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hashtag)) {
            return false;
        }
        Hashtag other = (Hashtag) object;
        if ((this.codHashtag == null && other.codHashtag != null) || (this.codHashtag != null && !this.codHashtag.equals(other.codHashtag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.Hashtag[ codHashtag=" + codHashtag + " ]";
    }
    
}
