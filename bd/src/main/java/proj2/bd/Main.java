package proj2.bd;

import proj2.bd.entity.*;
import proj2.bd.BLL.*;
import proj2.bd.BLL.ClienteBLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();
/*
        Cliente cli=new Cliente();
        Codpostais cod=new Codpostais();
        Utilizador user=new Utilizador();
        cli.setNome("Gonçalo");
        cli.setNif(23444224);
        String dataString = "2001-06-24";
        SimpleDateFormat DataFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date data = DataFormat.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cli.setDtnascimento(java.sql.Date.valueOf(dataString));
        cli.setEmail("gmartins@ipvc.pt");
        cli.setNporta("209");
        cli.setRua("Rua das Ruas");
        cli.setTelefone("9834843843");
        user.setIdutilizador((short) 161);
        cod.setCodpostal("4100");
        cli.setUtilizadorByIdutilizador(user);
        cli.setCodpostaisByCodpostal(cod);

        ClienteBLL.create(cli);*/

        System.out.println(CodpostaisBLL.readAll());

    }

}