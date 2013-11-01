package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Appliance;
import com.apmanager.domain.entity.Product;
import com.apmanager.domain.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public class ProductDAO extends GenericDAO<Product> {

    private static final Logger log = LoggerFactory.getLogger(ProductDAO.class);

    public ProductDAO(EntityManager em) {
        super(em, Product.class);
    }

    @Override
    public List<Product> search(String search) {
        return search(search, null, null);
    }

    public List<Product> search(String search, Integer maxResults) {
        return search(search, maxResults, null);
    }

    public List<Product> search(String search, Integer maxResults, Integer firstResult) {

        if (search == null || search.equals("")) {
            // Avoid to return all table
            search = "";
            maxResults = 30;
        }

        String[] pieces = search.split(" ");
        /**
         * A ordem do select deve manter a mesma ordem dos atributos na classes,
         * exeto os items que são um para muitos ou muitos para muitos.
         */
        String sql = "SELECT distinct  p.ID, "
                + "p.NOME, "
                + "p.PRODUTO_MARCA_ID, "
                + "p.DATA_DE_REGISTRO, "
                + "p.DESCRICAO, "
                + "p.CODIGO, "
                + "p.CODIGO_DE_BARRAS, "
                + "p.CODIGO_ADICIONAL, "
                + "p.PERCENTUAL_DESC_MAX, "
                + "p.PRECO_VENDA, "
                + "p.PRECO_COMPRA, "
                + "p.QUANTIDADE, "
                + "p.PRATELEIRA_ID, "
                + "p.QUANTIDADE_MIN, "
                + "p.STATUS "
                + "FROM public.produtos p ";
        for (int i = 0; i < pieces.length; i++) {
            int param = i + 1;
            sql += "JOIN produto_palavras_chave p" + param + " on (p.id = p" + param + ".produto_id and p" + param + ".palavra ilike ?" + param + " ) ";
        }
        
        sql += "WHERE p.status = true";

        Query q = em.createNativeQuery(sql, Product.class);

        int param;
        for (int i = 0; i < pieces.length; i++) {
            param = i + 1;
            q.setParameter(param, "%" + pieces[i] + "%");
        }

        if (maxResults != null) {
            q.setMaxResults(maxResults.intValue());
        }

        if (firstResult != null) {
            q.setFirstResult(firstResult.intValue());
        }

        List<Product> products = q.getResultList();

        return products;
    }

    @Override
    public void save(Product object) {
        object.setRegisterDate(new Date());
        super.save(object);
        saveKeyWords(object);
    }

    @Override
    public void update(Product object) {
        save(object);
        super.update(object);
        saveKeyWords(object);
    }

    public String getNextValidCode() {
        String jpql = "select max(p.additionalCode) from Product p";
        Query q = em.createQuery(jpql);
        String code = (String) q.getSingleResult();
        if (code != null && !code.equals("")) {
            Long oldCode = Long.valueOf(code);
            oldCode++;
            code = String.format("%06d", oldCode);
        } else {
            code = String.format("%06d", 1);
        }
        return code;
    }

    public List<Product> getProductsLessQuantity() {
        String jpql = "select p from Product p where p.status = true and p.quantity <= p.minQuantity ";
        Query q = em.createQuery(jpql);
        return q.getResultList();
    }

    private void saveKeyWords(Product object) {

        List<String> keyWords = new ArrayList<>();
        String jpql = "delete from ProductKeyWord k where k.product = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, object);
        int affected = query.executeUpdate();
        log.info("Deleted {} keywords to produtct {}", affected, object.getId());

        addKeyWord(keyWords, object.getDescription());
        addKeyWord(keyWords, object.getCode());
        addKeyWord(keyWords, object.getBarcode());
        addKeyWord(keyWords, object.getAdditionalCode());
        addKeyWord(keyWords, object.getName());

        if (object.getAppliances() != null) {
            for (Appliance a : object.getAppliances()) {
                addKeyWord(keyWords, a.getDescription());
                addKeyWord(keyWords, a.getModel().getVehicle().getBrand().getName());
                addKeyWord(keyWords, a.getModel().getVehicle().getName());
                addKeyWord(keyWords, a.getModel().getName());
                addKeyWord(keyWords, a.getModel().getYear());

            }
        }

        addKeyWord(keyWords, object.getBrand().getName());
        addKeyWord(keyWords, object.getShelf().getCode());
        String sql = "INSERT INTO produto_palavras_chave( "
                + "id, palavra, produto_id) "
                + "VALUES (nextval('produto_palavras_chave_id_seq'), ?, ?) ";
        Query q = em.createNativeQuery(sql);
        for (String k : keyWords) {
            q.setParameter(1, k);
            q.setParameter(2, object.getId());
            q.executeUpdate();
        }
    }

    private void addKeyWord(List<String> keys, String keyWord) {
        String aux;
        if (keyWord != null && !keyWord.equals("")) {
            String[] keyWords = keyWord.split(" ");

            for (String string : keyWords) {
                if (!keys.contains(string)) {
                    keys.add(string);
                }
                // Remove Especial Caracters
                aux = StringUtils.normalize(string);
                // If has difference add to
                if (!aux.equals(string)) {
                    if (!keys.contains(aux)) {
                        keys.add(aux);
                    }
                }
            }
        }
    }
}
