package proj2.bd.BLL;

import proj2.bd.entity.Venda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class VendaBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Venda venda){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }

    public static List<Venda> readAll(){
        List<Venda> listaVenda = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produto.findAll");
        List<Object> result = q1.getResultList();

        for(Object venda : result){
            listaVenda.add((Venda) venda);
            System.out.println(venda);
        }

        return listaVenda;
    }

}
