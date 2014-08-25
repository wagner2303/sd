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
import br.ufmt.sd.server.resources.Cliented;
import br.ufmt.sd.server.resources.DescricaoArquivo;
import java.util.ArrayList;
import java.util.List;
import br.ufmt.sd.server.resources.ItemBuscaNome;
import br.ufmt.sd.server.resources.controller.exceptions.IllegalOrphanException;
import br.ufmt.sd.server.resources.controller.exceptions.NonexistentEntityException;
import br.ufmt.sd.server.resources.controller.exceptions.PreexistingEntityException;
import br.ufmt.sd.server.resources.controller.exceptions.RollbackFailureException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 *
 * @author adrian
 */
public class DescricaoArquivoJpaController implements Serializable {

    private UserTransaction utx = null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServerSDPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DescricaoArquivo descricaoArquivo) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (descricaoArquivo.getClientedList() == null) {
            descricaoArquivo.setClientedList(new ArrayList<Cliented>());
        }
        if (descricaoArquivo.getItemBuscaNomeList() == null) {
            descricaoArquivo.setItemBuscaNomeList(new ArrayList<ItemBuscaNome>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Cliented> attachedClientedList = new ArrayList<Cliented>();
            for (Cliented clientedListClientedToAttach : descricaoArquivo.getClientedList()) {
                clientedListClientedToAttach = em.getReference(clientedListClientedToAttach.getClass(), clientedListClientedToAttach.getEndereco());
                attachedClientedList.add(clientedListClientedToAttach);
            }
            descricaoArquivo.setClientedList(attachedClientedList);
            List<ItemBuscaNome> attachedItemBuscaNomeList = new ArrayList<ItemBuscaNome>();
            for (ItemBuscaNome itemBuscaNomeListItemBuscaNomeToAttach : descricaoArquivo.getItemBuscaNomeList()) {
                itemBuscaNomeListItemBuscaNomeToAttach = em.getReference(itemBuscaNomeListItemBuscaNomeToAttach.getClass(), itemBuscaNomeListItemBuscaNomeToAttach.getIditembuscanome());
                attachedItemBuscaNomeList.add(itemBuscaNomeListItemBuscaNomeToAttach);
            }
            descricaoArquivo.setItemBuscaNomeList(attachedItemBuscaNomeList);
            em.persist(descricaoArquivo);
            for (Cliented clientedListCliented : descricaoArquivo.getClientedList()) {
                clientedListCliented.getDescricaoArquivoList().add(descricaoArquivo);
                clientedListCliented = em.merge(clientedListCliented);
            }
            for (ItemBuscaNome itemBuscaNomeListItemBuscaNome : descricaoArquivo.getItemBuscaNomeList()) {
                DescricaoArquivo oldMd5arquivoOfItemBuscaNomeListItemBuscaNome = itemBuscaNomeListItemBuscaNome.getMd5arquivo();
                itemBuscaNomeListItemBuscaNome.setMd5arquivo(descricaoArquivo);
                itemBuscaNomeListItemBuscaNome = em.merge(itemBuscaNomeListItemBuscaNome);
                if (oldMd5arquivoOfItemBuscaNomeListItemBuscaNome != null) {
                    oldMd5arquivoOfItemBuscaNomeListItemBuscaNome.getItemBuscaNomeList().remove(itemBuscaNomeListItemBuscaNome);
                    oldMd5arquivoOfItemBuscaNomeListItemBuscaNome = em.merge(oldMd5arquivoOfItemBuscaNomeListItemBuscaNome);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findDescricaoArquivo(descricaoArquivo.getMd5arquivo()) != null) {
                throw new PreexistingEntityException("DescricaoArquivo " + descricaoArquivo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DescricaoArquivo descricaoArquivo) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            DescricaoArquivo persistentDescricaoArquivo = em.find(DescricaoArquivo.class, descricaoArquivo.getMd5arquivo());
            List<Cliented> clientedListOld = persistentDescricaoArquivo.getClientedList();
            List<Cliented> clientedListNew = descricaoArquivo.getClientedList();
            List<ItemBuscaNome> itemBuscaNomeListOld = persistentDescricaoArquivo.getItemBuscaNomeList();
            List<ItemBuscaNome> itemBuscaNomeListNew = descricaoArquivo.getItemBuscaNomeList();
            List<String> illegalOrphanMessages = null;
            for (ItemBuscaNome itemBuscaNomeListOldItemBuscaNome : itemBuscaNomeListOld) {
                if (!itemBuscaNomeListNew.contains(itemBuscaNomeListOldItemBuscaNome)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItemBuscaNome " + itemBuscaNomeListOldItemBuscaNome + " since its md5arquivo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Cliented> attachedClientedListNew = new ArrayList<Cliented>();
            for (Cliented clientedListNewClientedToAttach : clientedListNew) {
                clientedListNewClientedToAttach = em.getReference(clientedListNewClientedToAttach.getClass(), clientedListNewClientedToAttach.getEndereco());
                attachedClientedListNew.add(clientedListNewClientedToAttach);
            }
            clientedListNew = attachedClientedListNew;
            descricaoArquivo.setClientedList(clientedListNew);
            List<ItemBuscaNome> attachedItemBuscaNomeListNew = new ArrayList<ItemBuscaNome>();
            for (ItemBuscaNome itemBuscaNomeListNewItemBuscaNomeToAttach : itemBuscaNomeListNew) {
                itemBuscaNomeListNewItemBuscaNomeToAttach = em.getReference(itemBuscaNomeListNewItemBuscaNomeToAttach.getClass(), itemBuscaNomeListNewItemBuscaNomeToAttach.getIditembuscanome());
                attachedItemBuscaNomeListNew.add(itemBuscaNomeListNewItemBuscaNomeToAttach);
            }
            itemBuscaNomeListNew = attachedItemBuscaNomeListNew;
            descricaoArquivo.setItemBuscaNomeList(itemBuscaNomeListNew);
            descricaoArquivo = em.merge(descricaoArquivo);
            for (Cliented clientedListOldCliented : clientedListOld) {
                if (!clientedListNew.contains(clientedListOldCliented)) {
                    clientedListOldCliented.getDescricaoArquivoList().remove(descricaoArquivo);
                    clientedListOldCliented = em.merge(clientedListOldCliented);
                }
            }
            for (Cliented clientedListNewCliented : clientedListNew) {
                if (!clientedListOld.contains(clientedListNewCliented)) {
                    clientedListNewCliented.getDescricaoArquivoList().add(descricaoArquivo);
                    clientedListNewCliented = em.merge(clientedListNewCliented);
                }
            }
            for (ItemBuscaNome itemBuscaNomeListNewItemBuscaNome : itemBuscaNomeListNew) {
                if (!itemBuscaNomeListOld.contains(itemBuscaNomeListNewItemBuscaNome)) {
                    DescricaoArquivo oldMd5arquivoOfItemBuscaNomeListNewItemBuscaNome = itemBuscaNomeListNewItemBuscaNome.getMd5arquivo();
                    itemBuscaNomeListNewItemBuscaNome.setMd5arquivo(descricaoArquivo);
                    itemBuscaNomeListNewItemBuscaNome = em.merge(itemBuscaNomeListNewItemBuscaNome);
                    if (oldMd5arquivoOfItemBuscaNomeListNewItemBuscaNome != null && !oldMd5arquivoOfItemBuscaNomeListNewItemBuscaNome.equals(descricaoArquivo)) {
                        oldMd5arquivoOfItemBuscaNomeListNewItemBuscaNome.getItemBuscaNomeList().remove(itemBuscaNomeListNewItemBuscaNome);
                        oldMd5arquivoOfItemBuscaNomeListNewItemBuscaNome = em.merge(oldMd5arquivoOfItemBuscaNomeListNewItemBuscaNome);
                    }
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
                String id = descricaoArquivo.getMd5arquivo();
                if (findDescricaoArquivo(id) == null) {
                    throw new NonexistentEntityException("The descricaoArquivo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            DescricaoArquivo descricaoArquivo;
            try {
                descricaoArquivo = em.getReference(DescricaoArquivo.class, id);
                descricaoArquivo.getMd5arquivo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The descricaoArquivo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ItemBuscaNome> itemBuscaNomeListOrphanCheck = descricaoArquivo.getItemBuscaNomeList();
            for (ItemBuscaNome itemBuscaNomeListOrphanCheckItemBuscaNome : itemBuscaNomeListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DescricaoArquivo (" + descricaoArquivo + ") cannot be destroyed since the ItemBuscaNome " + itemBuscaNomeListOrphanCheckItemBuscaNome + " in its itemBuscaNomeList field has a non-nullable md5arquivo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Cliented> clientedList = descricaoArquivo.getClientedList();
            for (Cliented clientedListCliented : clientedList) {
                clientedListCliented.getDescricaoArquivoList().remove(descricaoArquivo);
                clientedListCliented = em.merge(clientedListCliented);
            }
            em.remove(descricaoArquivo);
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

    public List<DescricaoArquivo> findDescricaoArquivoEntities() {
        return findDescricaoArquivoEntities(true, -1, -1);
    }

    public List<DescricaoArquivo> findDescricaoArquivoEntities(int maxResults, int firstResult) {
        return findDescricaoArquivoEntities(false, maxResults, firstResult);
    }

    private List<DescricaoArquivo> findDescricaoArquivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DescricaoArquivo.class));
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

    public DescricaoArquivo findDescricaoArquivo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DescricaoArquivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getDescricaoArquivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DescricaoArquivo> rt = cq.from(DescricaoArquivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
