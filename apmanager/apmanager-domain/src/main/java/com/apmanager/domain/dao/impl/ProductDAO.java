package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Product;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author luis
 */
public class ProductDAO extends GenericDAO<Product> {

    public ProductDAO(EntityManager em) {
        super(em);
    }

    @Override
    public List<Product> search(String search) {

        if (search == null || search.equals("")) {
            search = "%";
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
                + "FROM "
                + "public.produtos p, "
                + "public.aplicacoes ap, "
                + "public.marcas_de_produtos mp, "
                + "public.veiculos_modelos vm, "
                + "public.veiculos v, "
                + "public.prateleiras s, "
                + "public.marcas_de_veiculos mv "
                + "WHERE "
                + "p.produto_marca_id = mp.id AND "
                + "p.prateleira_id = s.id AND "
                + "ap.produto_id = p.id AND "
                + "ap.modelo_id = vm.id AND "
                + "vm.veiculo_id = v.id AND "
                + "v.marca_id = mv.id "
                + "AND "
                + "( ";
        for (int i = 0; i < pieces.length; i++) {
            int param = i + 1;
            if (i != 0) {
                sql += "or ";
            }
            sql += "( "
                    + "p.descricao ilike ?" + param + " "
                    + "or p.codigo ilike ?" + param + " "
                    + "or p.codigo_de_barras ilike ?" + param + " "
                    + "or p.codigo_adicional ilike ?" + param + " "
                    + "or p.nome ilike ?" + param + " "
                    + "or ap.descricao ilike ?" + param + " "
                    + "or mp.nome ilike ?" + param + " "
                    + "or mv.nome ilike ?" + param + " "
                    + "or s.codigo ilike ?" + param + " "
                    + "or v.nome ilike ?" + param + " "
                    + "or cast(vm.potencia as character varying) ilike ?1 "
                    + "or vm.ano ilike ?" + param + " "
                    + ") ";
        }

        sql += ")";

        Query q = em.createNativeQuery(sql, Product.class);

        int param;
        for (int i = 0; i < pieces.length; i++) {
            param = i + 1;
            q.setParameter(param, "%" + pieces[i] + "%");
        }
        List<Product> products = q.getResultList();
        return products;
    }

    @Override
    public void save(Product object) {
        object.setRegisterDate(new Date());
        super.save(object);
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
}
