package com.anp.project;


	import java.util.List;
	import java.util.Optional;
	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityTransaction;

	public class TrainerDAO {

		private EntityManager em;

		public TrainerDAO(final EntityManager em) {

			this.em = em;
	}
		public void save(final Trainer trainer) {
			EntityTransaction tx = null;
			
			
			try {
				tx = em.getTransaction(); 

				if (!tx.isActive()) 
				{
					tx.begin();
				}
		        Trainer mergedTrainer = em.merge(trainer);

				
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		public Optional<Trainer> findById(int id) {

			Trainer t = em.find(Trainer.class, id);

			if (t != null) {
				return Optional.of(t);
			} else {
				return Optional.empty();
			}

		}
		
		public List<Trainer> findAll() {

			List<Trainer> t1 = em.createQuery("from Trainer", Trainer.class).getResultList();

			return t1;

		}
		public void updateTrainer( int id, String NfirstName, String NLastName, int Nsalary,String Nemail, String Ngender) {
			EntityTransaction tx = null; 
			try {
				tx = em.getTransaction(); 
				if (!tx.isActive()) 
				{
					tx.begin();
				}
				Trainer trainer = em.find(Trainer.class, id);
				if(trainer!=null) {
					trainer.setFirstName(NfirstName);
					trainer.setLastName(NLastName);
					trainer.setSalary(Nsalary);
					trainer.setEmail(Nemail);

					trainer.setGender(Ngender);
					
					em.merge(trainer); 
					tx.commit(); 
				}	
				
			} catch (Exception e) {
				 e.printStackTrace();
			}
				
		}
		public void remove(int id) {  
			EntityTransaction tx = null; 
			
			Trainer t = em.find(Trainer.class, id);  
			
			try {
				tx = em.getTransaction(); 

				if (!tx.isActive()) 
				{
					tx.begin();
				}
				em.remove(t);
				tx.commit();
			}
			catch (Exception e) {
				 e.printStackTrace();
			}
			
			
		}
		
		
	}

