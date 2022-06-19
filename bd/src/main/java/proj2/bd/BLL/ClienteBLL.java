package proj2.bd.BLL;

import proj2.bd.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class ClienteBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Cliente cli){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
    }

    public static Cliente read(int idCliente){
        Cliente cli = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Cliente.findByIdCliente");
        q1.setParameter("idCliente", idCliente);
        Object obj = q1.getSingleResult();

        if(obj != null){
            cli = ((Cliente)obj);
        }
        else
            return null;

        return cli;
    }

    public static List<Cliente> readAll(){
        List<Cliente> listaClientes = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Cliente.findAll");
        List<Object> result = q1.getResultList();

        for(Object cli : result){
            listaClientes.add((Cliente) cli);
            System.out.println(cli);
        }

        return listaClientes;
    }

}
