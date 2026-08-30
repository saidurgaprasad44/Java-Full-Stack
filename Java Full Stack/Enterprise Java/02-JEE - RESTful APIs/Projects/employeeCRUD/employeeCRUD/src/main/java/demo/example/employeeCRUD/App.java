package demo.example.employeeCRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Employee employee = new Employee();
        Department department = new Department();    
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeCRUD");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        
        try {
        		tx.begin();
        		
        		department.setName("Engineering");
        		department.setLocation("Hyderabad");
        		em.persist(department);
            
        		employee.setFirstName("sai");
        		employee.setLastName("manda");
        		employee.setEmail("saidurgaprasad@outlook.com");
        		employee.setSalary(10000);
        		employee.setDepartment(department);
        		em.persist(employee);
            
        		tx.commit();
        }
        catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}
    }
}