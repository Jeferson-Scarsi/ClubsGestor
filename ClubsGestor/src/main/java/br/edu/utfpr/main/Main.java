package br.edu.utfpr.main;

import br.edu.utfpr.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {
    public static EntityManagerFactory emf;
    public static EntityManager em;
    public static Usuario usuarioLogado;    
    
    public static void abrirConexao(){
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ClubsGestor");
            em = emf.createEntityManager();      
        }        
    }
    
    public static void fecharConexao() {
        if (emf != null && emf.isOpen()){
            em.close();
            emf.close();
        }
    }
    
    public static boolean executaLogin(String login, String password) {
        abrirConexao();
        
        String jpql = "select u from Usuario u where u.login = :login and u.password = :password";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        
        try{
            usuarioLogado = query.getSingleResult();
            return true;
        } catch(NoResultException e){
            usuarioLogado = null;
            return false;
        }
        
    }
    
    
}
