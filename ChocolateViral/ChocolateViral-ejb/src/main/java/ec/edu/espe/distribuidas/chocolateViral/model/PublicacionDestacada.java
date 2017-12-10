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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "PUBLICACION_DESTACADA")
@NamedQueries({
    @NamedQuery(name = "PublicacionDestacada.findAll", query = "SELECT p FROM PublicacionDestacada p")})
public class PublicacionDestacada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_PUBLICACION_DESTACADA")
    private Integer codPublicacionDestacada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_LIKES")
    private long numeroLikes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_COMENTARIOS")
    private long numeroComentarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacionDestacada")
    private List<Alarma> alarmaList;
    @JoinColumns({
        @JoinColumn(name = "COD_PUBLICACION", referencedColumnName = "COD_PUBLICACION")
        , @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO")
        , @JoinColumn(name = "COD_TIPO_PUBLICACION", referencedColumnName = "COD_TIPO_PUBLICACION")})
    @ManyToOne
    private Publicacion publicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacionDestacada")
    private List<Reporte> reporteList;

    public PublicacionDestacada() {
    }

    public PublicacionDestacada(Integer codPublicacionDestacada) {
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    public PublicacionDestacada(Integer codPublicacionDestacada, long numeroLikes, long numeroComentarios) {
        this.codPublicacionDestacada = codPublicacionDestacada;
        this.numeroLikes = numeroLikes;
        this.numeroComentarios = numeroComentarios;
    }

    public Integer getCodPublicacionDestacada() {
        return codPublicacionDestacada;
    }

    public void setCodPublicacionDestacada(Integer codPublicacionDestacada) {
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    public long getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(long numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public long getNumeroComentarios() {
        return numeroComentarios;
    }

    public void setNumeroComentarios(long numeroComentarios) {
        this.numeroComentarios = numeroComentarios;
    }

    public List<Alarma> getAlarmaList() {
        return alarmaList;
    }

    public void setAlarmaList(List<Alarma> alarmaList) {
        this.alarmaList = alarmaList;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public List<Reporte> getReporteList() {
        return reporteList;
    }

    public void setReporteList(List<Reporte> reporteList) {
        this.reporteList = reporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPublicacionDestacada != null ? codPublicacionDestacada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicacionDestacada)) {
            return false;
        }
        PublicacionDestacada other = (PublicacionDestacada) object;
        if ((this.codPublicacionDestacada == null && other.codPublicacionDestacada != null) || (this.codPublicacionDestacada != null && !this.codPublicacionDestacada.equals(other.codPublicacionDestacada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.PublicacionDestacada[ codPublicacionDestacada=" + codPublicacionDestacada + " ]";
    }
    
}
