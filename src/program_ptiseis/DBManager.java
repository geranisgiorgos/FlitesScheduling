/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_ptiseis;

import javax.persistence.EntityManager;

/**
 *
 * @author antonis
 */
public class DBManager {
    public static final EntityManager em=javax.persistence.Persistence.createEntityManagerFactory("Program_PtiseisPU").createEntityManager();

        
        public static boolean saveObject(Object o){
            try{
                em.getTransaction().begin();
                em.persist(o);
                em.getTransaction().commit();
                return true;
            }catch(Exception e){
                System.out.println("Σφάλμα αποθήκευσης δεδομένων");
                em.getTransaction().rollback();
                return false;
            }
        }
        
        // Διαγραφή αντικειμένου από τη Βάση 
        public static boolean deleteObject(Object o){
            try{
                em.getTransaction().begin();
                Object obj = em.merge(o);
                em.remove(obj);
                em.getTransaction().commit();
                return true;
            }catch(Exception e){
                System.out.println("Σφάλμα διαγραφής Αντικειμένου");
                em.getTransaction().rollback();
                return false;
            }
        }
        // Αποθήκευση αντικειμένου που έχουμε επεξεργαστεί
        public static boolean modifyObject(Object o){
            try{
                em.getTransaction().begin();
                em.merge(o);
                em.getTransaction().commit();
                return true;
            }catch(Exception e){
                System.out.println("Σφάλμα τροποποίησης Αντικειμένου");
                em.getTransaction().rollback();
                return false;
            }
        }
}
