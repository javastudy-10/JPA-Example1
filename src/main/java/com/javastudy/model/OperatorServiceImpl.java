package com.javastudy.model;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Created by Maxim Sambulat
 */
@Service("jpaOperatorService")
@Repository
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @PersistenceContext
    private EntityManager em;

    public Operator findById(int id) {
        TypedQuery<Operator> typeQuery = em.createNamedQuery("Operator.findWithDetails", Operator.class).setParameter("id", 1);

        try {
            return typeQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
