package proj2.bd.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proj2.bd.entity.*;
import proj2.bd.entity.Racao;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class RacaoBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Racao racao){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(racao);
        em.getTransaction().commit();
    }

    public static Racao read(int idRacao){
        Racao racao = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Racao.findById");
        q1.setParameter("idracao", idRacao);
        Object obj = q1.getSingleResult();

        if(obj != null){
            racao = ((Racao)obj);
        }
        else
            return null;

        return racao;
    }

    public static List<Racao> readAll(){
        List<Racao> listaRacao = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produtor.findAll");
        List<Object> result = q1.getResultList();

        for(Object racao : result){
            listaRacao.add((Racao) racao);
            System.out.println(racao);
        }

        return listaRacao;
    }

}
