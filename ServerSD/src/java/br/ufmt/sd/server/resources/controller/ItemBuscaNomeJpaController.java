/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.sd.server.resources.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.ufmt.sd.server.resources.DescricaoArquivo;
import br.ufmt.sd.server.resources.ItemBuscaNome;
import br.ufmt.sd.server.resources.controller.exceptions.NonexistentEntityException;
import br.ufmt.sd.server.resources.controller.exceptions.RollbackFailureException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 *
 * @author adrian
 */
public class ItemBuscaNomeJpaController implements Serializable {

    private UserTransaction utx = null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServerSDPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemBuscaNome itemBuscaNome) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            DescricaoArquivo md5arquivo = itemBuscaNome.getMd5arquivo();
            if (md5arquivo != null) {
                md5arquivo = em.getReference(md5arquivo.getClass(), md5arquivo.getMd5arquivo());
                itemBuscaNome.setMd5arquivo(md5arquivo);
            }
            em.persist(itemBuscaNome);
            if (md5arquivo != null) {
                md5arquivo.getItemBuscaNomeList().add(itemBuscaNome);
                md5arquivo = em.merge(md5arquivo);
            }
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

    public void edit(ItemBuscaNome itemBuscaNome) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ItemBuscaNome persistentItemBuscaNome = em.find(ItemBuscaNome.class, itemBuscaNome.getIditembuscanome());
            DescricaoArquivo md5arquivoOld = persistentItemBuscaNome.getMd5arquivo();
            DescricaoArquivo md5arquivoNew = itemBuscaNome.getMd5arquivo();
            if (md5arquivoNew != null) {
                md5arquivoNew = em.getReference(md5arquivoNew.getClass(), md5arquivoNew.getMd5arquivo());
                itemBuscaNome.setMd5arquivo(md5arquivoNew);
            }
            itemBuscaNome = em.merge(itemBuscaNome);
            if (md5arquivoOld != null && !md5arquivoOld.equals(md5arquivoNew)) {
                md5arquivoOld.getItemBuscaNomeList().remove(itemBuscaNome);
                md5arquivoOld = em.merge(md5arquivoOld);
            }
            if (md5arquivoNew != null && !md5arquivoNew.equals(md5arquivoOld)) {
                md5arquivoNew.getItemBuscaNomeList().add(itemBuscaNome);
                md5arquivoNew = em.merge(md5arquivoNew);
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
                Integer id = itemBuscaNome.getIditembuscanome();
                if (findItemBuscaNome(id) == null) {
                    throw new NonexistentEntityException("The itemBuscaNome with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ItemBuscaNome itemBuscaNome;
            try {
                itemBuscaNome = em.getReference(ItemBuscaNome.class, id);
                itemBuscaNome.getIditembuscanome();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemBuscaNome with id " + id + " no longer exists.", enfe);
            }
            DescricaoArquivo md5arquivo = itemBuscaNome.getMd5arquivo();
            if (md5arquivo != null) {
                md5arquivo.getItemBuscaNomeList().remove(itemBuscaNome);
                md5arquivo = em.merge(md5arquivo);
            }
            em.remove(itemBuscaNome);
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

    public List<ItemBuscaNome> findItemBuscaNomeEntities() {
        return findItemBuscaNomeEntities(true, -1, -1);
    }

    public List<ItemBuscaNome> findItemBuscaNomeEntities(int maxResults, int firstResult) {
        return findItemBuscaNomeEntities(false, maxResults, firstResult);
    }

    private List<ItemBuscaNome> findItemBuscaNomeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemBuscaNome.class));
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

    public ItemBuscaNome findItemBuscaNome(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemBuscaNome.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemBuscaNomeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemBuscaNome> rt = cq.from(ItemBuscaNome.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
