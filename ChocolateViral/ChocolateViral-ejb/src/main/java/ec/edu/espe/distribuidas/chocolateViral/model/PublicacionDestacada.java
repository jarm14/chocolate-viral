/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @Column(name = "COD_PUBLICACION_DESTACADA")
    private Integer codPublicacionDestacada;

    @Column(name = "NUMERO_LIKES", nullable = false, precision = 15, scale = 0)
    private BigDecimal numeroLikes;
   
    @Column(name = "NUMERO_COMENTARIOS", nullable = false, precision = 15, scale = 0)
    private BigDecimal numeroComentarios;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacionDestacada")
    private List<Alarma> alarmaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacionDestacada")
    private List<Reporte> reporteList;
    
    @JoinColumns({
        @JoinColumn(name = "COD_PUBLICACION", referencedColumnName = "COD_PUBLICACION")
        , @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO")
        , @JoinColumn(name = "COD_TIPO_PUBLICACION", referencedColumnName = "COD_TIPO_PUBLICACION")})
    @ManyToOne
    private Publicacion publicacion;
    
    

    public PublicacionDestacada() {
    }

    public PublicacionDestacada(Integer codPublicacionDestacada) {
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    public Integer getCodPublicacionDestacada() {
        return codPublicacionDestacada;
    }

    public void setCodPublicacionDestacada(Integer codPublicacionDestacada) {
        this.codPublicacionDestacada = codPublicacionDestacada;
    }

    public BigDecimal getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(BigDecimal numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public BigDecimal getNumeroComentarios() {
        return numeroComentarios;
    }

    public void setNumeroComentarios(BigDecimal numeroComentarios) {
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
