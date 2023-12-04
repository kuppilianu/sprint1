package com.anp.project;


	
	import java.util.List;
	import java.util.Optional;
	import org.hibernate.HibernateException;
	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.Persistence;

	public class TrainerApp {

	public static void main(String[] args) {
			
	EntityManagerFactory factory = null;
			
			
	try { 
				
		factory  = Persistence.createEntityManagerFactory("Uv");
				
		EntityManager em = factory.createEntityManager();
							
		System.out.println("------WELCOME TO TrainerManagementSystem------");
				
				Trainer t1 = new Trainer(1, "anusha", "sree", 50000,"anusha@email.com",  "Female");
				Trainer t2 = new Trainer(2, "chinnu", "sagar",  80000,"chinnu@email.com",  "Male");
				Trainer t3 = new Trainer(3, "hyma", "patel", 45000,"hyma@email.com", "Male");
				
				TrainerDAO tDAO = new TrainerDAO(em);
				tDAO.save(t1);
				tDAO.save(t2);
				tDAO.save(t3);
				
				System.out.println("Data added successfully");

				System.out.println("--------------------------");
				
				System.out.println(" Trainer  details based on the id :");
				Optional<Trainer> TrainerById = tDAO.findById(1);
				System.out.println(TrainerById);
				 
				
				System.out.println("--------------------------");
				
				System.out.println(" All Details of Trainer ");	 
				List<Trainer> alltr = tDAO.findAll();
				System.out.println(alltr);
				
				
				
				System.out.println("------------------");
			
				
				int  Nid = 3;
				String NfirstName ="anusha" ;
				String NLastName = "chinnu" ;
				int Nsalary =  50000 ;
				String Nemail = "chinnu@gmail.com";
				String Ngender  ="Female";
				
				tDAO.updateTrainer(Nid, NfirstName, NLastName,Nsalary, Nemail, Ngender);
				
				System.out.println("Data updated sucessfully");
				
				
				System.out.println("------------------"); 
				
				System.out.println("Removeing based on the id :");
				
				tDAO.remove(2);
				
				System.out.println("2nd record is removed");
				
				
			}
			catch (HibernateException e) {
				 e.printStackTrace();
			}
			catch (Exception e) {
			 e.printStackTrace();
			}

		}


		}


