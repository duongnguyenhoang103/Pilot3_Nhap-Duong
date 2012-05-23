/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.core.access.spi;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.core.access.api.IAccessData;
import vn.com.hkt.em.core.api.IEntity;

/**
 * Thực hiện các việc truy xuất cơ sở dữ liệu
 * @author BinLe
 */
@ServiceProvider(service = IAccessData.class)
public class AccessData<E> implements IAccessData<E> {

    private EntityManager em;
    private EntityManagerFactory emf = null;
    private Class typeClass = null;

    @Override
    public void setAccessData(EntityManagerFactory emf, Class typeClass) {
        this.emf = emf;
        this.typeClass = typeClass;
    }

    @Override
    public boolean insert(E obj) {
        if (emf == null || typeClass == null || (!(obj instanceof IEntity))) {
            return false;
        }
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean update(E obj) {
        if (emf == null || typeClass == null || (!(obj instanceof IEntity))) {
            return false;
        }
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean delete(E obj) {
        if (emf == null || typeClass == null || (!(obj instanceof IEntity))) {
            return false;
        }
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.find(typeClass, ((IEntity) obj).getId()));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean deleteById(long id) {
        if (emf == null || typeClass == null) {
            return false;
        }
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.find(typeClass, id));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public E getById(long id) {
        if (emf == null || typeClass == null) {
            return null;
        }
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            E obj = (E) em.find(typeClass, id);
            em.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Object> queryList(String query) {
        try {
            em = emf.createEntityManager();
            return em.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return (List<Object>) new ArrayList<E>();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<E> selectAll() {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl ";
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> selectAll(String typeOrder, String fieldNameOrder) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl "
                + "order by tbl." + fieldNameOrder + " " + typeOrder;
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> select(String fieldName, String wordSearch) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl "
                + "where tbl." + fieldName + " = '" + wordSearch + "'";
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> select(String fieldName, String wordSearch, String typeOrder, String fieldNameOrder) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl "
                + " where tbl." + fieldName + " = '" + wordSearch + "' "
                + " order by tbl." + fieldNameOrder + " " + typeOrder;
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> filter(String fieldName, String wordFilter) {
        String serchWord = "%" + wordFilter.toLowerCase() + "%";
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl "
                + "where lower(tbl." + fieldName + ") like '" + serchWord + "'";
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> filter(String fieldName, String wordFilter, String typeOrder, String fieldNameOrder) {
        String serchWord = "%" + wordFilter.toLowerCase() + "%";
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl "
                + "where (lower(tbl." + fieldName + ") like '" + serchWord + "')"
                + " order by tbl." + fieldNameOrder + " " + typeOrder;
        return (List<E>) queryList(queryString);
    }
   

    @Override
    public List<E> select(List<String> fieldNames, List<String> wordSearchs) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl ";
        if (fieldNames != null && wordSearchs != null && fieldNames.size() == wordSearchs.size()) {
            queryString += " where ";
            for (int i = 0; i < fieldNames.size(); i++) {
                queryString += " tbl." + fieldNames.get(i) + " = '" + wordSearchs.get(i) + "' ";
                if (i < fieldNames.size() - 1) {
                    queryString += " and ";
                }
            }
        }
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> select(List<String> fieldNames, List<String> wordSearchs, String typeOrder, String fieldNameOrder) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl ";
        if (fieldNames != null && wordSearchs != null && fieldNames.size() == wordSearchs.size()) {
            queryString += " where ";
            for (int i = 0; i < fieldNames.size(); i++) {
                queryString += " tbl." + fieldNames.get(i) + " = '" + wordSearchs.get(i) + "' ";
                if (i < fieldNames.size() - 1) {
                    queryString += " and ";
                }
            }
        }
        queryString += " order by tbl." + fieldNameOrder + " " + typeOrder;
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> filter(List<String> fieldNames, List<String> wordFilters) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl ";
        if (fieldNames != null && wordFilters != null && fieldNames.size() == wordFilters.size()) {
            queryString += " where ";
            for (int i = 0; i < fieldNames.size(); i++) {
                String serchWord = "%" + wordFilters.get(i).toLowerCase() + "%";
                queryString += "lower(tbl." + fieldNames.get(i) + ") like '" + serchWord + "'";
                if (i < fieldNames.size() - 1) {
                    queryString += " and ";
                }
            }
        }
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> filter(List<String> fieldNames, List<String> wordFilters, String typeOrder, String fieldNameOrder) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl ";
        if (fieldNames != null && wordFilters != null && fieldNames.size() == wordFilters.size()) {
            queryString += " where ";
            for (int i = 0; i < fieldNames.size(); i++) {
                String serchWord = "%" + wordFilters.get(i).toLowerCase() + "%";
                queryString += "lower(tbl." + fieldNames.get(i) + ") like '" + serchWord + "'";
                if (i < fieldNames.size() - 1) {
                    queryString += " and ";
                }
            }
        }
        queryString += " order by tbl." + fieldNameOrder + " " + typeOrder;
        return (List<E>) queryList(queryString);
    }

    @Override
    public List<E> selectOrCondition(List<String> fieldNames, List<String> wordSearchs) {
        String queryString = "Select tbl from " + typeClass.getSimpleName() + " tbl ";
        if (fieldNames != null && wordSearchs != null && fieldNames.size() == wordSearchs.size()) {
            queryString += " where ";
            for (int i = 0; i < fieldNames.size(); i++) {
                queryString += " tbl." + fieldNames.get(i) + " = '" + wordSearchs.get(i) + "' ";
                if (i < fieldNames.size() - 1) {
                    queryString += " or ";
                }
            }
        }
        return (List<E>) queryList(queryString);
    }
}