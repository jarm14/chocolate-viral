/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.dao;

import ec.edu.espe.distribuidas.chocolateViral.model.DetallePublicacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author joel
 */
@Stateless
public class DetallePublicacionFacade extends AbstractFacade<DetallePublicacion> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas.chocolateViral_ChocolateViral-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallePublicacionFacade() {
        super(DetallePublicacion.class);
    }

    public List<DetallePublicacion> findByHashtag(Integer codHashtag) {
        Query qry = this.em.createQuery("SELECT obj FROM DetallePublicacion obj WHERE obj.codHashtag = ?1");
        qry.setParameter(1, codHashtag);
        return qry.getResultList();
    }

}
