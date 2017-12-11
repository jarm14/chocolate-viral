/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "LOCALIZACION")
public class Localizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_LOCALIZACION", nullable = false)
    private Integer codLocalizacion;
    @Column(name = "LONGITUD", nullable = false)
    private BigDecimal longitud;
    @Column(name = "LATITUD", nullable = false)
    private BigDecimal latitud;
    @JoinColumn(name = "COD_CIUDAD", referencedColumnName = "COD_CIUDAD")
    @ManyToOne
    private Ciudad codCiudad;
    @OneToMany(mappedBy = "codLocalizacion")
    private List<DetallePublicacion> detallePublicacionList;

    public Localizacion() {
    }

    public Localizacion(Integer codLocalizacion) {
        this.codLocalizacion = codLocalizacion;
    }

    public Localizacion(Integer codLocalizacion, BigDecimal longitud, BigDecimal latitud) {
        this.codLocalizacion = codLocalizacion;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Integer getCodLocalizacion() {
        return codLocalizacion;
    }

    public void setCodLocalizacion(Integer codLocalizacion) {
        this.codLocalizacion = codLocalizacion;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public Ciudad getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Ciudad codCiudad) {
        this.codCiudad = codCiudad;
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
        hash += (codLocalizacion != null ? codLocalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacion)) {
            return false;
        }
        Localizacion other = (Localizacion) object;
        if ((this.codLocalizacion == null && other.codLocalizacion != null) || (this.codLocalizacion != null && !this.codLocalizacion.equals(other.codLocalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.chocolateViral.model.Localizacion[ codLocalizacion=" + codLocalizacion + " ]";
    }
    
}
