package proj2.bd.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proj2.bd.entity.*;
import proj2.bd.entity.Veterinario;


import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class VeterinarioBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Veterinario vet){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(vet);
        em.getTransaction().commit();
    }

    public static List<Veterinario> readAll(){
        List<Veterinario> listaVeterinario = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produto.findAll");
        List<Object> result = q1.getResultList();

        for(Object vet : result){
            listaVeterinario.add((Veterinario) vet);
            System.out.println(vet);
        }

        return listaVeterinario;
    }

}
