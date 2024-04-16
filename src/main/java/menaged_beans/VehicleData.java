package menaged_beans;

import dao.Database;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Named("VehicleData")
@RequestScoped
@Entity
public class VehicleData {
	@EJB
	@Transient
	Database db;

	
	@Id
	@GeneratedValue
	private int ID;
	
	private String make;
	private String model;
	private Integer maxPassangers;
	private Integer manufactureYear;
	private Integer gasUsage;
	private String color;
	private String gearboxType;


	public VehicleData() {

	}

	public VehicleData(String make, String model, int maxp, int manfY, int gasu, String color, String gearboxType) {
		this.make = make;
		this.model = model;
		this.maxPassangers = maxp;
		this.manufactureYear = manfY;
		this.gasUsage = gasu;
		this.color = color;
		this.gearboxType = gearboxType;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getMaxPassangers() {
		return maxPassangers;
	}

	public void setMaxPassangers(Integer maxPassangers) {
		this.maxPassangers = maxPassangers;
	}

	public Integer getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(Integer manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public Integer getGasUsage() {
		return gasUsage;
	}

	public void setGasUsage(Integer gasUsage) {
		this.gasUsage = gasUsage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGearboxType() {
		return gearboxType;
	}

	public void setGearboxType(String gearboxType) {
		this.gearboxType = gearboxType;
	}

	public String send() {
		//Database.addVehicleData(this);
		db.addVehicleData(this);
		return "VehicleDataIO";
	}

}
