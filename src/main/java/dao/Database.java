package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import menaged_beans.VehicleData;

@Named("Database")
@Dependent
@Stateless
public class Database {
	@PersistenceContext(unitName ="JPADefaultDataBaseConnection")
	private EntityManager em;

	//private static ArrayList<VehicleData> vehicles = new ArrayList<VehicleData>();

//	public static ArrayList<VehicleData> getVehicleData() {
//		return vehicles;
//	}

	public VehicleData addVehicleData(VehicleData newData) {
		em.persist(newData);
		return newData;
	}
	
	public List<VehicleData> getVehicleData(){
		return em.createQuery("SELECT a FROM VehicleData a", VehicleData.class).getResultList();
	}
	
	public List<VehicleData> getVehicleDataByID(int id) {
		return em.createQuery("SELECT a FROM VehicleData a WHERE a.id = :id", VehicleData.class)
	            .setParameter("id", id)
	            .getResultList();
	}

}
