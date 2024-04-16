package dao;

import java.util.ArrayList;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import menaged_beans.VehicleData;

@Named("Database")
@ApplicationScoped
public class Database {
	private static ArrayList<VehicleData> vehicles = new ArrayList<VehicleData>();

	public static ArrayList<VehicleData> getVehicleData() {
		return vehicles;
	}

	public static void addVehicleData(VehicleData newData) {
		vehicles.add(newData);
	}

}
