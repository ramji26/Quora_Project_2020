package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.AnswerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class AnswerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public AnswerEntity createAnswer(AnswerEntity newAnswer) {
        entityManager.persist(newAnswer);
        return newAnswer;
    }

    public AnswerEntity getAnswerById(final long id) {
        try{
            return entityManager.createNamedQuery("AnswerById", AnswerEntity.class).setParameter("answerId", id).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public AnswerEntity getAnswerByUuid(final String answerUuid) {
        try{
            return entityManager.createNamedQuery("AnswerByUuid", AnswerEntity.class).setParameter("answerUuid", answerUuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public AnswerEntity updateAnswer(AnswerEntity updatedAnswer) {
        return entityManager.merge(updatedAnswer);
    }

}
