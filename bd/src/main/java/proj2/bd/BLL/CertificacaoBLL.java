package proj2.bd.BLL;

import proj2.bd.entity.Certificacao;
import proj2.bd.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CertificacaoBLL {

    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Certificacao cert){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cert);
        em.getTransaction().commit();
    }

    public static List<Certificacao> readAll(){
        List<Certificacao> listaCertificacoes = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Certificacao.findAll");
        List<Object> result = q1.getResultList();

        for(Object cert : result){
            listaCertificacoes.add((Certificacao) cert);
        }

        return listaCertificacoes;
    }

}
