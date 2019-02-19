package com.shastri.daoImpl;

/** @author SHARAN SHAS...3 (9538180903)*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.shastri.dao.CustomDao;
import com.shastri.to.AttributeBasedAccessTO;
import com.shastri.to.BGAccessTO;
import com.shastri.to.DriverTo;
import com.shastri.to.ECPTO;
import com.shastri.to.LoginTO;
import com.shastri.to.PatientTO;
import com.shastri.to.SignUpTO;
import com.shastri.to.StudentTO;
import com.shastri.util.CustomEncryption;
import com.shastri.util.DBUtil;

public class CustomDaoImpl implements CustomDao {

	String loginStatus = "";
	String status = "";
	int value = 0;

	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	ResultSet rs1 = null;

	/************* DBConnection Process *************/
	public CustomDaoImpl() {
		con = DBUtil.getConnection();
	}

	/** common Process */
	@Override
	public String login(LoginTO to) {
		String checkLogin = "SELECT password FROM admin WHERE username='"
				+ to.getUserName() + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(checkLogin);
			if (rs.next()) {
				if (rs.getString(1).equals(to.getPassword())) {
					loginStatus = "SUCCESS";
				} else {
					loginStatus = "sorry password invalid";
				}
			} else {
				loginStatus = "sorry username invalid";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return loginStatus;
	}

	@Override
	public String login(LoginTO to, String type) {
		String checkLogin = null;
		if (type.equals("doctor")) {
			checkLogin = "SELECT drname FROM doctor WHERE drname='"
					+ to.getUserName() + "' ";
		}
		if (type.equals("patient")) {
			checkLogin = "SELECT patientname FROM patient WHERE patientname='"
					+ to.getUserName() + "' ";
		}

		try {
			st = con.createStatement();
			rs = st.executeQuery(checkLogin);
			if (rs.next()) {
				if (rs.getString(1).equals(to.getPassword())) {
					loginStatus = "SUCCESS";
				} else {
					loginStatus = "sorry password invalid";
				}
			} else {
				loginStatus = "sorry username invalid";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return loginStatus;
	}

	/** ECP Process */
	@Override
	public String ecpLogin(LoginTO to) {
		String checkLogin = "SELECT name FROM ecp WHERE name='"
				+ to.getUserName() + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(checkLogin);
			if (rs.next()) {
				if (rs.getString(1).equals(to.getPassword())) {
					loginStatus = "SUCCESS";
				} else {
					loginStatus = "sorry password invalid";
				}
			} else {
				loginStatus = "sorry username invalid";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return loginStatus;
	}

	@Override
	public String viewKGCByECP(String ecp) {

		String getDoctors = "select kgc from ecp where name='" + ecp + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getDoctors);
			if (rs.next()) {

				return rs.getString(1);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return null;
	}

	/** KGC Process */
	@Override
	public void generateKey(int id, String key) {
		try {
			con.createStatement().executeUpdate(
					"update patient set kgc='" + key + "' where id=" + id + "");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

	/** HIP Process */
	

	

	

	@Override
	public String addPatient(PatientTO to) {

		String regQuery = "INSERT INTO patient(patientname, type, description, address, dob, emailId, mobileNumber, pic, kgc, pakey) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {

			pst = con.prepareStatement(regQuery);

			pst.setString(1, to.getPatientname());
			pst.setString(2, to.getType());
			pst.setString(3, to.getDescription());
			pst.setString(4, to.getAddress());
			pst.setString(5, to.getDob());
			pst.setString(6, to.getEmailId());
			pst.setLong(7, to.getMobileNumber());
			pst.setBinaryStream(8, to.getProfilePicContent());
			pst.setString(9, "NA");
			pst.setString(10, "NA");
			value = pst.executeUpdate();

			status = "Patient " + to.getPatientname() + " added Successfully";

		} catch (SQLException e) {
			System.out.println(e);
			status = "Failed to add Patient " + to.getPatientname();
		}

		return status;
	}

	@Override
	public String addStudent(StudentTO to) {

		String regQuery = "INSERT INTO students(stuname, stuusn, stuemailid, stupass, stuisactive) VALUES(?,?,?,?,?)";

		try {

			pst = con.prepareStatement(regQuery);

			pst.setString(1, to.getStuname());
			pst.setString(2, to.getStuusn());
			pst.setString(3, to.getStuemail());
			pst.setString(4, to.getStupass());
			pst.setString(5, "1");

			value = pst.executeUpdate();

			status = "Student " + to.getStuname() + " added Successfully";

		} catch (SQLException e) {
			System.out.println(e);
		}

		return status;
	}
	
	
	
	public String addDriver(DriverTo to) {

		String regQuery = "INSERT INTO driverdetails(driverid, drivername, driveremail, driverpass, isdriveractive) VALUES(?,?,?,?,?)";

		try {

			pst = con.prepareStatement(regQuery);

			pst.setInt(1, to.getDriverID());
			pst.setString(2, to.getdName());
			pst.setString(3, to.getdEmail());
			pst.setString(4, to.getDriverPass());
			pst.setString(5, "0");

			value = pst.executeUpdate();

			status = "Driver" + to.getdName() + " added Successfully";

		} catch (SQLException e) {
			System.out.println(e);
		}

		return status;
	}

	
	
	
	@Override
	public void update(StudentTO to) {

		try {
			con.createStatement().executeUpdate(
					"update students set stuname='" + to.getStuname()
							+ "', stuusn='" + to.getStuusn()
							+ "', stuemailid='" + to.getStuemail()
							+ "', stupass='" + to.getStupass()
							+ "' where stuid=" + to.getSlNo() + "");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

        
        
	@Override
	public void updateD(DriverTo to) {

		try {
			con.createStatement().executeUpdate(
					"update driverdetails set drivername='" + to.getdName()
							+ "', driveremail='" + to.getdEmail()
							+ "', driverpass='" + to.getDriverPass()
							+ "', isdriveractive='" + to.getdActive()
							+ "' where driverid=" + to.getDriverID() + "");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}
	@Override
	public List<PatientTO> viewPatient() {
		List<PatientTO> list = new ArrayList<PatientTO>();
		String getDoctors = "select * from patient";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getDoctors);
			while (rs.next()) {

				PatientTO to = new PatientTO();

				to.setSlNo(rs.getLong(1));
				to.setPatientname(rs.getString(2));
				to.setType(rs.getString(3));
				to.setDescription(rs.getString(4));
				to.setAddress(rs.getString(5));
				to.setDob(rs.getString(6));
				to.setEmailId(rs.getString(7));
				to.setMobileNumber(rs.getLong(8));
				to.setKgc(rs.getString(10));
				to.setPakey(rs.getString(11));

				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	@Override
	public List<StudentTO> students() {
		List<StudentTO> list = new ArrayList<StudentTO>();
		String getDoctors = "select * from students";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getDoctors);
			while (rs.next()) {

				StudentTO to = new StudentTO();

				to.setSlNo(rs.getLong(1));
				to.setStuname(rs.getString(2));
				to.setStuusn(rs.getString(3));
				to.setStuemail(rs.getString(4));
				to.setStupass(rs.getString(5));

				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}
        
        
        
        @Override
	public List<DriverTo> drivers() {
		List<DriverTo> list = new ArrayList<DriverTo>();
		String getDrivers = "select * from driverdetails";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getDrivers);
			while (rs.next()) {

				DriverTo to = new DriverTo();
				String s=rs.getString(2);
				to.setDriverID(rs.getInt(1));
				to.setdName(rs.getString(2));
				to.setdEmail(rs.getString(3));
				to.setDriverPass(rs.getString(4));
				to.setdActive(rs.getString(5));
                                 
                                        
                                
				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}
        
        
        

	@Override
	public List<StudentTO> studentPickupLocation() {
		List<StudentTO> list = new ArrayList<StudentTO>();
		String getDoctors = "select * from stupickuplocation";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getDoctors);
			while (rs.next()) {

				StudentTO to = new StudentTO();

				to.setSlNo(rs.getLong(1));
				to.setStuname(rs.getString(2));
				to.setLat(rs.getString(3));
				to.setLon(rs.getString(4));
				to.setAddress(rs.getString(5));
				to.setStdPermission(rs.getString(6));
				to.setDriver(rs.getString(8));
				to.setDate(rs.getString(9));

				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	@Override
	public List<SignUpTO> patientPic(int id) {
		List<SignUpTO> list = new ArrayList<>();

		String getPicQuery = "select pic from patient where id=" + id + " ";
		try {

			st = con.createStatement();
			rs = st.executeQuery(getPicQuery);
			if (rs.next()) {
				SignUpTO to = new SignUpTO();
				to.setProfilePicContent(rs.getBinaryStream(1));
				to.setPicLength(rs.getString(1));
				list.add(to);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	@Override
	public void aba(AttributeBasedAccessTO to) {
		String regQuery = "INSERT INTO attributebasedaccess(patientid, patientname, drname, type, patientpermission) VALUES(?,?,?,?,?)";

		try {

			pst = con.prepareStatement(regQuery);
			pst.setLong(1, to.getpSlNo());
			pst.setString(2, to.getPatientname());
			pst.setString(3, to.getDrName());
			pst.setString(4, to.getType());
			pst.setString(5, to.getPatientPermission());

			value = pst.executeUpdate();

		} catch (SQLException e) {
		}
	}

	@Override
	public List<AttributeBasedAccessTO> viewABA() {
		List<AttributeBasedAccessTO> list = new ArrayList<AttributeBasedAccessTO>();
		String getABA = "select * from attributebasedaccess";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getABA);
			while (rs.next()) {

				AttributeBasedAccessTO to = new AttributeBasedAccessTO();

				to.setpSlNo(rs.getLong(1));
				to.setPatientname(rs.getString(2));
				to.setDrName(rs.getString(3));
				to.setType(rs.getString(4));
				to.setPatientPermission(rs.getString(5));

				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	@Override
	public List<BGAccessTO> viewBGA() {
		List<BGAccessTO> list = new ArrayList<BGAccessTO>();
		String getABA = "select * from bgaccess";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getABA);
			while (rs.next()) {

				BGAccessTO to = new BGAccessTO();

				to.setSl(rs.getLong(1));
				to.setPatientName(rs.getString(2));
				to.setDoctorName(rs.getString(3));
				to.setKGCKey(rs.getString(4));
				to.setPaKey(rs.getString(5));
				to.setDate(rs.getString(6));

				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	/** Patient Process */
	@Override
	public void breakGlassKey(int id, String key) {
		try {
			con.createStatement().executeUpdate(
					"update patient set pakey='" + key + "' where id=" + id
							+ "");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

	@Override
	public void permit(int id) {
		try {
			con.createStatement().executeUpdate(
					"update stupickuplocation set stupikisadminact='1' where stupikid="
							+ id + "");
                         ResultSet resultSet = con.createStatement().executeQuery("SELECT stuemailid FROM students, stupickuplocation "
                                 + "WHERE students.stuusn = stupickuplocation.stupikusn AND stupickuplocation.stupikid=" +id+"");
                         String emailID="";
                         while(resultSet.next()){
                             emailID = resultSet.getString("stuemailid");
                         }
                        Properties properties = System.getProperties();
                        properties.put("mail.smtp.starttls.enable", "true");
                        properties.put("mail.smtp.host", "smtp.gmail.com");
                        //properties.put("mail.smtp.user","");
                        //properties.put("mail.smtp.password","");
                        properties.put("mail.smtp.port","587");
                        properties.put("mail.smtp.auth","true");
                        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                        
                       Session session =  Session.getInstance(properties, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("pramodnitya798@gmail.com", "8147504881");
					}
				});
                       MimeMessage mimeMessage = new MimeMessage(session);
                       try {
                       mimeMessage.setFrom(new InternetAddress("pramodnitya798@gmail.com"));
                       mimeMessage.setRecipients(Message.RecipientType.TO,emailID);
                       mimeMessage.setSubject("Acceptance of pickup request");
                       mimeMessage.setText("Dear User," + "\n\n Your request is accepted");
                       
                           Transport.send(mimeMessage);
                           
                       } catch(Exception e){
                        System.err.println(e);  
                        e.printStackTrace();
                       }
		} catch (SQLException e) {
			System.err.println(e);
		}

	}
        
        @Override
	public void cancel(int id) {
		try {
			con.createStatement().executeUpdate(
					"update stupickuplocation set stupikisadminact='0' where stupikid="
							+ id + "");
                         ResultSet resultSet = con.createStatement().executeQuery("SELECT stuemailid FROM students, stupickuplocation "
                                 + "WHERE students.stuusn = stupickuplocation.stupikusn AND stupickuplocation.stupikid=" +id+"");
                         String emailID="";
                         while(resultSet.next()){
                             emailID = resultSet.getString("stuemailid");
                         }
                        Properties properties = System.getProperties();
                        properties.put("mail.smtp.starttls.enable", "true");
                        properties.put("mail.smtp.host", "smtp.gmail.com");
                        //properties.put("mail.smtp.user","");
                        //properties.put("mail.smtp.password","");
                        properties.put("mail.smtp.port","587");
                        properties.put("mail.smtp.auth","true");
                        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                        
                       Session session =  Session.getInstance(properties, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("pramodnitya798@gmail.com", "8147504881");
					}
				});
                       MimeMessage mimeMessage = new MimeMessage(session);
                       try {
                       mimeMessage.setFrom(new InternetAddress("pramodnitya798@gmail.com"));
                       mimeMessage.setRecipients(Message.RecipientType.TO,emailID);
                       mimeMessage.setSubject("Cancel of pickup request");
                       mimeMessage.setText("Dear User," + "\n\n Your request is canceled");
                       
                           Transport.send(mimeMessage);
                           
                       } catch(Exception e){
                        System.err.println(e);  
                        e.printStackTrace();
                       }
		} catch (SQLException e) {
			System.err.println(e);
		}

	}
        
	@Override
	public void delete(int id) {
		try {
			con.createStatement().executeUpdate(
					"delete from students where stuid=" + id + "");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}
	@Override
	public void deleteD(int id) {
		try {
			con.createStatement().executeUpdate(
					"delete from driverdetails where driverid=" + id + "");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

	@Override
	public String addECP(ECPTO to) {

		String regQuery = "INSERT INTO ecp(name, address, emailId, mobileNumber, pic, kgc) VALUES(?,?,?,?,?,?)";

		try {

			pst = con.prepareStatement(regQuery);

			pst.setString(1, to.getName());
			pst.setString(2, to.getAddress());
			pst.setString(3, to.getEmailId());
			pst.setLong(4, to.getMobileNumber());
			pst.setBinaryStream(5, to.getProfilePicContent());
			pst.setString(6, to.getKgc());
			pst.executeUpdate();

			status = "ECP " + to.getName() + " added Successfully";

		} catch (SQLException e) {
			System.out.println(e);
			status = "Failed to add ECP " + to.getName();
		}

		return status;
	}

	@Override
	public List<ECPTO> viewECP(String kgc) {
		List<ECPTO> list = new ArrayList<ECPTO>();
		String getDoctors = "select * from ecp where kgc='" + kgc + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getDoctors);
			while (rs.next()) {

				ECPTO to = new ECPTO();

				to.setSlNo(rs.getLong(1));
				to.setName(rs.getString(2));
				to.setAddress(rs.getString(3));
				to.setEmailId(rs.getString(4));
				to.setMobileNumber(rs.getLong(5));
				to.setKgc(CustomEncryption.fileDecryption(rs.getString(7)));

				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	@Override
	public List<SignUpTO> ecpPic(int id) {
		List<SignUpTO> list = new ArrayList<>();

		String getPicQuery = "select pic from ecp where id=" + id + " ";
		try {

			st = con.createStatement();
			rs = st.executeQuery(getPicQuery);
			if (rs.next()) {
				SignUpTO to = new SignUpTO();
				to.setProfilePicContent(rs.getBinaryStream(1));
				to.setPicLength(rs.getString(1));
				list.add(to);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	@Override
	public void providePermission(String patientName, String kgcKey) {
		try {
			con.createStatement().executeUpdate(
					"update AttributeBasedAccess set patientpermission='"
							+ kgcKey + "' where patientname='" + patientName
							+ "'");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

	/** Doctor Process */
	public void createBGAccess(BGAccessTO to) {

		String regQuery = "INSERT INTO bgaccess(patientname, doctorname, kgckey, pakey, date) VALUES(?,?,?,?,?)";

		try {

			pst = con.prepareStatement(regQuery);

			pst.setString(1, to.getPatientName());
			pst.setString(2, to.getDoctorName());
			pst.setString(3, to.getKGCKey());
			pst.setString(4, to.getPaKey());
			pst.setString(5, to.getDate());

			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	/** Cloud Process */
	@Override
	public String cloudLogin(LoginTO to) {
		String checkLogin = "SELECT password FROM cloud WHERE username='"
				+ to.getUserName() + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(checkLogin);
			if (rs.next()) {
				if (rs.getString(1).equals(to.getPassword())) {
					loginStatus = "SUCCESS";
				} else {
					loginStatus = "sorry password invalid";
				}
			} else {
				loginStatus = "sorry username invalid";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return loginStatus;
	}

	@Override
	public List<ECPTO> viewECP() {
		List<ECPTO> list = new ArrayList<ECPTO>();
		String getDoctors = "select * from ecp ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(getDoctors);
			while (rs.next()) {

				ECPTO to = new ECPTO();

				to.setSlNo(rs.getLong(1));
				to.setName(rs.getString(2));
				to.setAddress(rs.getString(3));
				to.setEmailId(rs.getString(4));
				to.setMobileNumber(rs.getLong(5));
				to.setKgc(CustomEncryption.fileDecryption(rs.getString(7)));

				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

}
