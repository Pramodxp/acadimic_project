package com.shastri.service;

/** SHARAN SHAS...3 (9538180903)*/
import java.util.List;
import java.util.Map;

import com.shastri.to.AttributeBasedAccessTO;
import com.shastri.to.BGAccessTO;
import com.shastri.to.DriverTo;
import com.shastri.to.ECPTO;
import com.shastri.to.LoginTO;
import com.shastri.to.PatientTO;
import com.shastri.to.SignUpTO;
import com.shastri.to.StudentTO;

public interface CustomService {

	/** common Process */
	public String login(LoginTO to);

	public String login(LoginTO to, String type);

	/** ECP Process */
	public String ecpLogin(LoginTO to);

	public PatientTO patientDetails(String ecp);

	/** KGC process */
	public List<PatientTO> generateKey();

	public void generateKey(int id);

	public List<PatientTO> generatedKey();

	/** HIP Process */
	

	public String addPatient(PatientTO to);
	
	public String addStudent(StudentTO to);
	
	public String addDiver(DriverTo to);
	
	public void update(StudentTO to);
        
        public void updateD(DriverTo to);

	public List<PatientTO> viewPatient();
	
	public List<StudentTO> students();
        
        public List<DriverTo> drivers();
	
	public List<StudentTO> studentPickupLocation();

	public List<PatientTO> viewPatientPassword();

	public List<SignUpTO> patientPic(int id);

	public Map<PatientTO, List<String>> atributeBasedMap();

	public void aba(AttributeBasedAccessTO to);

	public List<AttributeBasedAccessTO> viewABA();

	public List<BGAccessTO> viewBGA();

	public AttributeBasedAccessTO viewABA(String patient);

	/** Patient Process */
	public PatientTO viewPatient(String patient);

	public void breakGlassKey(int id);
	
	public void permit(int id);
        
        public void cancel(int id);
	
	public void delete(int id);
	
	public void deleteD(int id);
	
	public StudentTO user(int id);
        
        public DriverTo driver(int id);

	public PatientTO viewPatient(String patient, String key);

	public String addECP(ECPTO to);

	public List<ECPTO> viewECP(String patient);

	public List<SignUpTO> ecpPic(int id);

	public void providePermission(String patientName);

	/** Doctor Process */
	public DriverTo viewDoctor(String doctor);

	public List<AttributeBasedAccessTO> assignedPatients(String doctor);

	public PatientTO bgAccess(String doctor, String kgcKey, String paKey);

	/** Cloud Process */
	public String cloudLogin(LoginTO to);

	public List<ECPTO> viewECP();

}
