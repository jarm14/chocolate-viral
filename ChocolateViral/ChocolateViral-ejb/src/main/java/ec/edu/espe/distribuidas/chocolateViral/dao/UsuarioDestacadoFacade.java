/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.chocolateViral.dao;

import ec.edu.espe.distribuidas.chocolateViral.model.UsuarioDestacado;
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
public class UsuarioDestacadoFacade extends AbstractFacade<UsuarioDestacado> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas.chocolateViral_ChocolateViral-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioDestacadoFacade() {
        super(UsuarioDestacado.class);
    }

    public List<UsuarioDestacado> findTop10Usuario() {
        Query qry = this.em.createQuery("SELECT obj FROM UsuarioDestacado obj ORDER BY obj.numeroSeguidores LIMIT 10");
        return qry.getResultList();
    }
}
