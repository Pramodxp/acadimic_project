package com.shastri.serviceImpl;

/** SHARAN SHAS...3 (9538180903)*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shastri.daoImpl.CustomDaoImpl;
import com.shastri.service.CustomService;
import com.shastri.to.AttributeBasedAccessTO;
import com.shastri.to.BGAccessTO;
import com.shastri.to.DriverTo;
import com.shastri.to.ECPTO;
import com.shastri.to.LoginTO;
import com.shastri.to.PatientTO;
import com.shastri.to.SignUpTO;
import com.shastri.to.StudentTO;
import com.shastri.util.CustomDateUtil;
import com.shastri.util.CustomEncryption;
import com.shastri.util.CustomKey;

public class CustomServiceImpl implements CustomService {

	String status = "";
	String loginStatus = "";
	String signUpStatus = "";

	CustomDaoImpl dao = new CustomDaoImpl();

	/** common Process */
	@Override
	public String login(LoginTO to) {
		return dao.login(to);
	}

	@Override
	public String login(LoginTO to, String type) {
		return dao.login(to, type);
	}

	/** ECP Process */
	public String ecpLogin(LoginTO to) {
		return dao.ecpLogin(to);
	}

	@Override
	public PatientTO patientDetails(String ecp) {
		List<PatientTO> list = dao.viewPatient();
		String kgc = dao.viewKGCByECP(ecp);

		for (PatientTO patientTO : list) {

			PatientTO patientTO2 = new PatientTO();

			if (patientTO.getKgc().equals(kgc)) {

				patientTO2.setSlNo(patientTO.getSlNo());
				patientTO2.setPatientname(patientTO.getPatientname());
				patientTO2.setMobileNumber(patientTO.getMobileNumber());
				patientTO2.setEmailId(CustomEncryption.fileDecryption(patientTO
						.getEmailId()));
				patientTO2.setKgc(CustomEncryption.fileDecryption(patientTO
						.getKgc()));

				return patientTO2;
			}
		}

		return null;
	}

	/** KGC Process */
	public List<PatientTO> generateKey() {
		List<PatientTO> to = dao.viewPatient();
		List<PatientTO> to1 = new ArrayList<PatientTO>();
		for (PatientTO patientTO : to) {
			PatientTO patientTO2 = new PatientTO();
			if (patientTO.getKgc().equals("NA")) {

				patientTO2.setSlNo(patientTO.getSlNo());
				patientTO2.setPatientname(patientTO.getPatientname());
				patientTO2.setMobileNumber(patientTO.getMobileNumber());
				patientTO2.setKgc(patientTO.getKgc());
				to1.add(patientTO2);
			}
		}
		return to1;
	}

	@Override
	public void generateKey(int id) {
		dao.generateKey(id,
				CustomEncryption.fileEncryption(CustomKey.generateKey()));

	}

	public List<PatientTO> generatedKey() {
		List<PatientTO> to = dao.viewPatient();
		List<PatientTO> to1 = new ArrayList<PatientTO>();
		for (PatientTO patientTO : to) {
			PatientTO patientTO2 = new PatientTO();
			if (!patientTO.getKgc().equals("NA")) {

				patientTO2.setSlNo(patientTO.getSlNo());
				patientTO2.setPatientname(patientTO.getPatientname());
				patientTO2.setMobileNumber(patientTO.getMobileNumber());
				patientTO2.setKgc(patientTO.getKgc());
				to1.add(patientTO2);
			}
		}
		return to1;
	}

	/** HIP Process */
	

	public String addPatient(PatientTO to) {

		to.setType(CustomEncryption.fileEncryption(to.getType()));
		to.setDescription(CustomEncryption.fileEncryption(to.getDescription()));
		to.setAddress(CustomEncryption.fileEncryption(to.getAddress()));
		to.setDob(CustomEncryption.fileEncryption(to.getDob()));
		to.setEmailId(CustomEncryption.fileEncryption(to.getEmailId()));

		try {
			to.setProfilePicContent(to.getProfilePic().getInputStream());
		} catch (IOException e) {
			System.err.println(e);
		}
		return dao.addPatient(to);

	}

	@Override
	public String addStudent(StudentTO to) {

		return dao.addStudent(to);

	}
	@Override
	public String addDiver(DriverTo to) {
		
		return dao.addDriver(to);

		
	
	}
	
	@Override
	public void update(StudentTO to) {

		 dao.update(to);

	}
        
        @Override
	public void updateD(DriverTo to) {

		 dao.updateD(to);

	}

	public List<PatientTO> viewPatient() {
		return dao.viewPatient();
	}

	public List<StudentTO> students() {
		return dao.students();
	}
        
        public List<DriverTo> drivers() {
		return dao.drivers();
	}
        

	public List<StudentTO> studentPickupLocation() {
		return dao.studentPickupLocation();
	}

	public List<PatientTO> viewPatientPassword() {
		return dao.viewPatient();
	}

	@Override
	public List<SignUpTO> patientPic(int id) {
		return dao.patientPic(id);
	}

	
	public void aba(AttributeBasedAccessTO to) {
		dao.aba(to);
	}

	public List<AttributeBasedAccessTO> viewABA() {
		return dao.viewABA();
	}

	public List<BGAccessTO> viewBGA() {
		return dao.viewBGA();
	}

	/** Patient Process */
	@Override
	public PatientTO viewPatient(String patient) {
		List<PatientTO> to = dao.viewPatient();

		for (PatientTO patientTO : to) {
			PatientTO patientTO2 = new PatientTO();
			if (patientTO.getPatientname().equals(patient)) {

				patientTO2.setSlNo(patientTO.getSlNo());
				patientTO2.setPatientname(patientTO.getPatientname());
				patientTO2.setMobileNumber(patientTO.getMobileNumber());
				if (patientTO.getKgc().equals("NA")) {
					patientTO2.setKgc(patientTO.getKgc());
				} else {
					patientTO2.setKgc(CustomEncryption.fileDecryption(patientTO
							.getKgc()));
				}
				if (patientTO.getPakey().equals("NA")) {
					patientTO2.setPakey(patientTO.getPakey());
				} else {
					patientTO2.setPakey(CustomEncryption
							.fileDecryption(patientTO.getPakey()));
				}
				return patientTO2;
			}
		}
		return null;
	}

	@Override
	public void permit(int id) {
		dao.permit(id);

	}
        
        @Override
	public void cancel(int id) {
		dao.cancel(id);

	}

	@Override
	public StudentTO user(int id) {

		List<StudentTO> list = dao.students();
		StudentTO to = new StudentTO();
		for (StudentTO studentTO : list) {
			if (studentTO.getSlNo() == id) {
				to.setSlNo(studentTO.getSlNo());
				to.setStuname(studentTO.getStuname());
				to.setStuusn(studentTO.getStuusn());
				to.setStuemail(studentTO.getStuemail());
				to.setStupass(studentTO.getStupass());
				return to;
			}
		}
		return null;
	}
        
        @Override
	public DriverTo driver(int id) {
		List<DriverTo> list = dao.drivers();
		
		DriverTo to = new DriverTo();
		for (DriverTo driverTo : list) {
			if (driverTo.getDriverID()== id ) {
				to.setDriverID(driverTo.getDriverID());
				to.setdName(driverTo.getdName());
				to.setdEmail(driverTo.getdEmail());
				to.setDriverPass(driverTo.getDriverPass());
				to.setdActive(driverTo.getdActive());
		
				return to;
			}
		}
		return null;
	}

	@Override
	public void delete(int id) {
		dao.delete(id);

	}
	@Override
	public void deleteD(int id) {
		dao.deleteD(id);

	}
	

	@Override
	public void breakGlassKey(int id) {
		dao.breakGlassKey(
				id,
				CustomEncryption.fileEncryption(CustomKey.generateKey() + " "
						+ new Date()));

	}

	@Override
	public PatientTO viewPatient(String patient, String key) {
		List<PatientTO> to = dao.viewPatient();

		for (PatientTO patientTO : to) {
			PatientTO patientTO2 = new PatientTO();

			patientTO2.setSlNo(patientTO.getSlNo());
			patientTO2.setPatientname(patientTO.getPatientname());
			patientTO2.setType(patientTO.getType());
			patientTO2.setDescription(patientTO.getDescription());
			patientTO2.setAddress(patientTO.getAddress());
			patientTO2.setDob(patientTO.getDob());
			patientTO2.setEmailId(patientTO.getEmailId());
			patientTO2.setMobileNumber(patientTO.getMobileNumber());

			if (CustomEncryption.fileDecryption(patientTO.getKgc()).equals(key)) {

				patientTO2.setType(CustomEncryption.fileDecryption(patientTO
						.getType()));
				patientTO2.setDescription(CustomEncryption
						.fileDecryption(patientTO.getDescription()));
				patientTO2.setAddress(CustomEncryption.fileDecryption(patientTO
						.getAddress()));
				patientTO2.setDob(CustomEncryption.fileDecryption(patientTO
						.getDob()));
				patientTO2.setEmailId(CustomEncryption.fileDecryption(patientTO
						.getEmailId()));

			}

			return patientTO2;
		}
		return null;
	}

	public String addECP(ECPTO to) {

		List<PatientTO> to1 = dao.viewPatient();

		for (PatientTO patientTO : to1) {

			if (patientTO.getPatientname().equals(to.getPatientName())) {
				to.setKgc(patientTO.getKgc());
			}
		}

		try {
			to.setProfilePicContent(to.getProfilePic().getInputStream());
		} catch (IOException e) {
			System.err.println(e);
		}
		return dao.addECP(to);

	}

	public List<ECPTO> viewECP(String patient) {

		List<PatientTO> to1 = dao.viewPatient();

		for (PatientTO patientTO : to1) {

			if (patientTO.getPatientname().equals(patient)) {
				return dao.viewECP(patientTO.getKgc());
			}
		}
		return null;
	}

	@Override
	public List<SignUpTO> ecpPic(int id) {
		return dao.ecpPic(id);
	}

	public AttributeBasedAccessTO viewABA(String patient) {
		List<AttributeBasedAccessTO> list = dao.viewABA();
		AttributeBasedAccessTO accessTO = new AttributeBasedAccessTO();
		for (AttributeBasedAccessTO attributeBasedAccessTO : list) {
			if (attributeBasedAccessTO.getPatientname().equals(patient)) {
				accessTO.setpSlNo(attributeBasedAccessTO.getpSlNo());
				accessTO.setPatientname(attributeBasedAccessTO.getPatientname());
				accessTO.setType(attributeBasedAccessTO.getType());
				accessTO.setDrName(attributeBasedAccessTO.getDrName());
				accessTO.setPatientPermission(attributeBasedAccessTO
						.getPatientPermission());
			}
		}
		return accessTO;
	}

	@Override
	public void providePermission(String patientName) {
		List<PatientTO> to = dao.viewPatient();
		for (PatientTO patientTO : to) {
			if (patientTO.getPatientname().equals(patientName)) {

				dao.providePermission(patientName,
						CustomEncryption.fileDecryption(patientTO.getKgc()));

			}
		}

	}

	/** Doctor Process */
	
	@Override
	public List<AttributeBasedAccessTO> assignedPatients(String doctor) {
		List<AttributeBasedAccessTO> list = dao.viewABA();
		List<AttributeBasedAccessTO> list1 = new ArrayList<AttributeBasedAccessTO>();
		for (AttributeBasedAccessTO attributeBasedAccessTO : list) {
			AttributeBasedAccessTO accessTO = new AttributeBasedAccessTO();
			if (attributeBasedAccessTO.getDrName().equals(doctor)) {
				accessTO.setpSlNo(attributeBasedAccessTO.getpSlNo());
				accessTO.setPatientname(attributeBasedAccessTO.getPatientname());
				accessTO.setType(attributeBasedAccessTO.getType());
				accessTO.setPatientPermission(attributeBasedAccessTO
						.getPatientPermission());
				list1.add(accessTO);
			}
		}
		return list1;
	}

	@Override
	public PatientTO bgAccess(String doctor, String kgcKey, String paKey) {
		List<PatientTO> to = dao.viewPatient();

		BGAccessTO bgAccessTO = new BGAccessTO();

		for (PatientTO patientTO : to) {

			PatientTO patientTO2 = new PatientTO();

			patientTO2.setSlNo(patientTO.getSlNo());
			patientTO2.setPatientname(patientTO.getPatientname());
			patientTO2.setType(patientTO.getType());
			patientTO2.setDescription(patientTO.getDescription());
			patientTO2.setAddress(patientTO.getAddress());
			patientTO2.setDob(patientTO.getDob());
			patientTO2.setEmailId(patientTO.getEmailId());
			patientTO2.setMobileNumber(patientTO.getMobileNumber());

			if (CustomEncryption.fileDecryption(patientTO.getKgc()).equals(
					kgcKey)
					&& CustomEncryption.fileDecryption(patientTO.getPakey())
							.equals(paKey)) {

				patientTO2.setType(CustomEncryption.fileDecryption(patientTO
						.getType()));
				patientTO2.setDescription(CustomEncryption
						.fileDecryption(patientTO.getDescription()));
				patientTO2.setAddress(CustomEncryption.fileDecryption(patientTO
						.getAddress()));
				patientTO2.setDob(CustomEncryption.fileDecryption(patientTO
						.getDob()));
				patientTO2.setEmailId(CustomEncryption.fileDecryption(patientTO
						.getEmailId()));

				bgAccessTO.setPatientName(patientTO.getPatientname());
				bgAccessTO.setDoctorName(doctor);
				bgAccessTO.setKGCKey(kgcKey);
				bgAccessTO.setPaKey(paKey);
				bgAccessTO.setDate(CustomDateUtil.customDate());

				dao.createBGAccess(bgAccessTO);

			}

			return patientTO2;
		}
		return null;
	}

	/** Cloud Process */
	@Override
	public String cloudLogin(LoginTO to) {
		return dao.cloudLogin(to);
	}

	public List<ECPTO> viewECP() {

		return dao.viewECP();

	}

	

	@Override
	public Map<PatientTO, List<String>> atributeBasedMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverTo viewDoctor(String doctor) {
		// TODO Auto-generated method stub
		return null;
	}

}
