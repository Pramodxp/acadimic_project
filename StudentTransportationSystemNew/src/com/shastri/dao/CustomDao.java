package com.shastri.dao;

/** SHARAN SHAS...3 (9538180903)*/
import java.util.List;

import com.shastri.to.AttributeBasedAccessTO;
import com.shastri.to.BGAccessTO;
import com.shastri.to.DriverTo;
import com.shastri.to.ECPTO;
import com.shastri.to.LoginTO;
import com.shastri.to.PatientTO;
import com.shastri.to.SignUpTO;
import com.shastri.to.StudentTO;

public interface CustomDao {

	/** common Process */
	public String login(LoginTO to);

	public String login(LoginTO to, String type);

	/** ECP Process */
	public String ecpLogin(LoginTO to);

	public String viewKGCByECP(String ecp);

	/** KGC Process */
	public void generateKey(int id, String key);

	/** HIP Process */
	

	

	public String addPatient(PatientTO to);

	public String addStudent(StudentTO to);
	
	public String addDriver(DriverTo to);
	
	public void update(StudentTO to);
        
        public void updateD(DriverTo to);

	public List<PatientTO> viewPatient();

	public List<StudentTO> students();
        
        public List<DriverTo> drivers();

	public List<StudentTO> studentPickupLocation();

	public List<SignUpTO> patientPic(int id);

	public void aba(AttributeBasedAccessTO to);

	public List<AttributeBasedAccessTO> viewABA();

	public List<BGAccessTO> viewBGA();

	/** Patient Process */
	public void breakGlassKey(int id, String key);

	public void permit(int id);

        public void cancel(int id);
	
	public void delete(int id);
	
	public void deleteD(int id);

	public String addECP(ECPTO to);

	public List<ECPTO> viewECP(String kgc);

	public List<SignUpTO> ecpPic(int id);

	public void providePermission(String patientName, String kgcKey);

	/** Doctor Process */
	public void createBGAccess(BGAccessTO bgAccessTO);

	/** Cloud Process */
	public String cloudLogin(LoginTO to);

	public List<ECPTO> viewECP();

}
