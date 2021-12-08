package br.edu.utfpr.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClubsGestor");
        EntityManager em = emf.createEntityManager();
        
        //Inserir Registro de Usuário no Banco de Dados
        
        //inserirUsuario(em);
        //buscarUsuario(em,2L);
        //alterarUsuario(em, 2L);
        //removerUsuario(em, 1L);
        //buscarUsuario(em,2L);
        
        inserirCategoriaSocio(em);
        
        em.close();
        emf.close();
    }
    
    public static void inserirCategoriaSocio(EntityManager em) {
        Usuario user = new Usuario(1L, null, null, null, true, true);
        Categorias_Socios cat = new Categorias_Socios(null, "Patrimonial", 0, true);
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
        
    }
    
    private static void inserirUsuario(EntityManager em){
        Usuario user = new Usuario(null, "Administrador", "admin", "admin", true, true);
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
    
    private static void buscarUsuario(EntityManager em, Long id){
        Usuario user = em.find(Usuario.class, id);
        
        if (user != null){
            System.out.println(user);
        }
    }
    
    private static void alterarUsuario(EntityManager em, Long id){
        Usuario user = em.find(Usuario.class, id);
        
        if (user != null){
            user.setNome("Administrador do Sistema");
            
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
        
        
    }
    
    private static void removerUsuario(EntityManager em, Long id){
        Usuario user = em.find(Usuario.class, id);
        
        if (user != null){
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
        
        
    }    
    
}
