package proj2.bd.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proj2.bd.entity.*;
import proj2.bd.entity.Produto;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class ProdutoBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Produto prod){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();
    }

    public static Produto read(int idProduto){
        Produto produto = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produto.findAllById");
        q1.setParameter("idproduto", idProduto);
        Object obj = q1.getSingleResult();

        if(obj != null){
            produto = ((Produto)obj);
        }
        else
            return null;

        return produto;
    }

    public static List<Produto> readAll(){
        List<Produto> listaProduto = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produto.findAll");
        List<Object> result = q1.getResultList();

        for(Object prod : result){
            listaProduto.add((Produto) prod);
            System.out.println(prod);
        }

        return listaProduto;
    }

}
