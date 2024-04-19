import java.util.List;

import dao.Database;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import menaged_beans.VehicleData;

@Path("db")
public class DBRestWrapper {
	@EJB
	Database db;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VehicleData> getAllVehicles() {
		return db.getVehicleData();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getVehicleDataByID(@PathParam("id") int id) {
	    return db.getVehicleDataByID(id);
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public VehicleData addVehicleData(VehicleData newV) {
		return db.addVehicleData(newV);
	}
}
