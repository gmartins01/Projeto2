package proj2.bd.BLL;

import proj2.bd.entity.Utilizador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class UtilizadorBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    private static List<Utilizador> userLogado = new ArrayList<>();

    public static List<Utilizador> getuserLogado() {
        return userLogado;
    }

    public static void create(Utilizador user){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public static List<Utilizador> readAll(){
        List<Utilizador> listaUtilizador = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Utilizador.findAll");
        List<Object> result = q1.getResultList();

        for(Object user : result){
            listaUtilizador.add((Utilizador) user);
            System.out.println(user);
        }

        return listaUtilizador;
    }

    public static Utilizador efetuarLogin(String username, String password) {
        List<Utilizador> utilizadores = new ArrayList<>();
        utilizadores = readAll();

        for (Utilizador u : utilizadores) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }

        return null;
    }

    public static void delete(Utilizador user){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

}
