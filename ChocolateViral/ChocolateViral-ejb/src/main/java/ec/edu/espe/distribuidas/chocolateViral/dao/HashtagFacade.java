/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.dao;

import ec.edu.espe.distribuidas.chocolateViral.model.Hashtag;
import java.util.Date;
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
public class HashtagFacade extends AbstractFacade<Hashtag> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas.chocolateViral_ChocolateViral-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HashtagFacade() {
        super(Hashtag.class);
    }
    
    public List<Hashtag> findByLocalizacion(Integer codLocalizacion)
    {
        Query qry = this.em.createQuery("SELECT objD, objH FROM DetallePublicacion objD, Hashtag objH "
                + "WHERE objD.codLocalizacion = ?1 AND objH.codHashtag = objD.codHashtag");
        qry.setParameter(1, codLocalizacion);
        return qry.getResultList();
    }
    
    public List<Hashtag> findByDiaHora(Date fecha)
    {
        Query qry = this.em.createQuery("SELECT objD, objH FROM DetallePublicacion objD, Hashtag objH "
                + "WHERE objD.fecha = ?1 AND objH.codHashtag = objD.codHashtag");
        qry.setParameter(1, fecha);
        return qry.getResultList();
    }
    
}
