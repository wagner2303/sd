/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.sd.server.resources.controller;

import br.ufmt.sd.server.resources.Cliented;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.ufmt.sd.server.resources.DescricaoArquivo;
import br.ufmt.sd.server.resources.controller.exceptions.NonexistentEntityException;
import br.ufmt.sd.server.resources.controller.exceptions.PreexistingEntityException;
import br.ufmt.sd.server.resources.controller.exceptions.RollbackFailureException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 *
 * @author adrian
 */
public class ClientedJpaController implements Serializable {

 
    private UserTransaction utx = null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServerSDPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliented cliented) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (cliented.getDescricaoArquivoList() == null) {
            cliented.setDescricaoArquivoList(new ArrayList<DescricaoArquivo>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<DescricaoArquivo> attachedDescricaoArquivoList = new ArrayList<DescricaoArquivo>();
            for (DescricaoArquivo descricaoArquivoListDescricaoArquivoToAttach : cliented.getDescricaoArquivoList()) {
                descricaoArquivoListDescricaoArquivoToAttach = em.getReference(descricaoArquivoListDescricaoArquivoToAttach.getClass(), descricaoArquivoListDescricaoArquivoToAttach.getMd5arquivo());
                attachedDescricaoArquivoList.add(descricaoArquivoListDescricaoArquivoToAttach);
            }
            cliented.setDescricaoArquivoList(attachedDescricaoArquivoList);
            em.persist(cliented);
            for (DescricaoArquivo descricaoArquivoListDescricaoArquivo : cliented.getDescricaoArquivoList()) {
                descricaoArquivoListDescricaoArquivo.getClientedList().add(cliented);
                descricaoArquivoListDescricaoArquivo = em.merge(descricaoArquivoListDescricaoArquivo);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCliented(cliented.getEndereco()) != null) {
                throw new PreexistingEntityException("Cliented " + cliented + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliented cliented) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cliented persistentCliented = em.find(Cliented.class, cliented.getEndereco());
            List<DescricaoArquivo> descricaoArquivoListOld = persistentCliented.getDescricaoArquivoList();
            List<DescricaoArquivo> descricaoArquivoListNew = cliented.getDescricaoArquivoList();
            List<DescricaoArquivo> attachedDescricaoArquivoListNew = new ArrayList<DescricaoArquivo>();
            for (DescricaoArquivo descricaoArquivoListNewDescricaoArquivoToAttach : descricaoArquivoListNew) {
                descricaoArquivoListNewDescricaoArquivoToAttach = em.getReference(descricaoArquivoListNewDescricaoArquivoToAttach.getClass(), descricaoArquivoListNewDescricaoArquivoToAttach.getMd5arquivo());
                attachedDescricaoArquivoListNew.add(descricaoArquivoListNewDescricaoArquivoToAttach);
            }
            descricaoArquivoListNew = attachedDescricaoArquivoListNew;
            cliented.setDescricaoArquivoList(descricaoArquivoListNew);
            cliented = em.merge(cliented);
            for (DescricaoArquivo descricaoArquivoListOldDescricaoArquivo : descricaoArquivoListOld) {
                if (!descricaoArquivoListNew.contains(descricaoArquivoListOldDescricaoArquivo)) {
                    descricaoArquivoListOldDescricaoArquivo.getClientedList().remove(cliented);
                    descricaoArquivoListOldDescricaoArquivo = em.merge(descricaoArquivoListOldDescricaoArquivo);
                }
            }
            for (DescricaoArquivo descricaoArquivoListNewDescricaoArquivo : descricaoArquivoListNew) {
                if (!descricaoArquivoListOld.contains(descricaoArquivoListNewDescricaoArquivo)) {
                    descricaoArquivoListNewDescricaoArquivo.getClientedList().add(cliented);
                    descricaoArquivoListNewDescricaoArquivo = em.merge(descricaoArquivoListNewDescricaoArquivo);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cliented.getEndereco();
                if (findCliented(id) == null) {
                    throw new NonexistentEntityException("The cliented with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cliented cliented;
            try {
                cliented = em.getReference(Cliented.class, id);
                cliented.getEndereco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliented with id " + id + " no longer exists.", enfe);
            }
            List<DescricaoArquivo> descricaoArquivoList = cliented.getDescricaoArquivoList();
            for (DescricaoArquivo descricaoArquivoListDescricaoArquivo : descricaoArquivoList) {
                descricaoArquivoListDescricaoArquivo.getClientedList().remove(cliented);
                descricaoArquivoListDescricaoArquivo = em.merge(descricaoArquivoListDescricaoArquivo);
            }
            em.remove(cliented);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliented> findClientedEntities() {
        return findClientedEntities(true, -1, -1);
    }

    public List<Cliented> findClientedEntities(int maxResults, int firstResult) {
        return findClientedEntities(false, maxResults, firstResult);
    }

    private List<Cliented> findClientedEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliented.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliented findCliented(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliented.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientedCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliented> rt = cq.from(Cliented.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
