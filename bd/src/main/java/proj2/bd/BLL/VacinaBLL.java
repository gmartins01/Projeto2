package proj2.bd.BLL;

import proj2.bd.entity.Vacina;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class VacinaBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Vacina vacina){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(vacina);
        em.getTransaction().commit();
    }

    public static Vacina read(int idVacina){
        Vacina vacina = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Vacina.findById");
        q1.setParameter("idvacina", idVacina);
        Object obj = q1.getSingleResult();

        if(obj != null){
            vacina = ((Vacina)obj);
        }
        else
            return null;

        return vacina;
    }

    public static List<Vacina> readAll(){
        List<Vacina> listaVacina = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produto.findAll");
        List<Object> result = q1.getResultList();

        for(Object vacina : result){
            listaVacina.add((Vacina) vacina);
            System.out.println(vacina);
        }

        return listaVacina;
    }

}
