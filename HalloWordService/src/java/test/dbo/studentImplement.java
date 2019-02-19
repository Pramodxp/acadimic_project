/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dbo;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import test.database.DBService;

/**
 *
 * @author Sachin
 */
public class studentImplement implements studentInterface {

    @Override
    public boolean addstudent(String stuname, String stuusn, String stupass, String stuemail, int stuisactive) {

        boolean flag = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        try {
            DBService database = new DBService();
            connection = DBService.getconnection();
            statement = connection.createStatement();
            String query = "INSERT INTO students \n"
                    + "	(stuusn, \n"
                    + "	stuname, \n"
                    + "	stupass, \n"
                    + "	stuemailid, \n"
                    + "	stuisactive\n"
                    + "	)\n"
                    + "	VALUES\n"
                    + "	('" + stuusn + "', \n"
                    + "	'" + stuname + "', \n"
                    + "	'" + stupass + "', \n"
                    + "	'" + stuemail + "', \n"
                    + "	'" + stuisactive + "'\n"
                    + "	)";

            System.out.println(query);
            int update = statement.executeUpdate(query);

            if (update == 1) {
                flag = true;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultset != null) {
                    resultset.close();
                }
            } catch (Exception e) {
            }
        }
        return flag;
    }

    @Override

    public boolean stucheck(String stuusn, String stupass) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        boolean flag = false;

        try {

            connection = DBService.getconnection();
            statement = connection.createStatement();
            final String query = "select * from students where stuusn='" + stuusn + "' and stupass='" + stupass + "' and stuisactive=1";
            System.out.println(query);
            resultset = statement.executeQuery(query);
            if (resultset.next()) {
                System.out.println("its true");
                flag = true;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultset != null) {
                    resultset.close();
                }
            } catch (Exception e) {
            }
        }

        return flag;
    }

    @Override
    public boolean stupickuploc(String stupiklat, String stupiklang, String stupikplace, String stupikusn) {
        boolean flag = true;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        try {
            DBService database = new DBService();
            connection = DBService.getconnection();
            statement = connection.createStatement();
            String query = "insert into stupickuplocation\n"
                    + "	(`stupikusn`, \n"
                    + "	`stupiklat`, \n"
                    + "	`stupiklang`, \n"
                    + "	`stupikplace`, \n"
                    + "	`stupikisadminact`, \n"
                    + "	`stupikisdriveract`, \n"
                    + "	`stupickupdate`\n"
                    + "	)\n"
                    + "	values\n"
                    + "	('" + stupikusn + "', \n"
                    + "	'" + stupiklat + "', \n"
                    + "	'" + stupiklang + "', \n"
                    + "	'" + stupikplace + "', \n"
                    + "	'1', \n"
                    + "	'0', \n"
                    + "	'" + dateFormat.format(date) + "'\n"
                    + "	)";

            System.out.println(query);
            int update = statement.executeUpdate(query);

        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultset != null) {
                    resultset.close();
                }
            } catch (Exception e) {
            }
        }
        System.out.println(flag);
        sendMail(stupikusn);
        return flag;
    }

    @Override
    public String stugetapprovedList() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        String jsonarry;
        JSONArray jsonArray ;
        ArrayList<pickupdetails> picklist = new ArrayList<pickupdetails>();
        try {

            connection = DBService.getconnection();
            statement = connection.createStatement();
            final String query = "select * from stupickuplocation where stupikisadminact=1 and stupikisdriveract=0";
            System.out.println(query);
            resultset = statement.executeQuery(query);

            while (resultset.next()) {
               // int total_rows = resultset.getMetaData().getColumnCount();
                //for (int i = 0; i < total_rows; i++) {
                    
                    pickupdetails pick = new pickupdetails();
                    pick.setStupikid(resultset.getInt("stupikid"));
                    pick.setStupikusn(resultset.getString("stupikusn"));
                    pick.setStupiklat(resultset.getString("stupiklat"));
                    pick.setStupikplace(resultset.getString("stupikplace"));
                    pick.setStupiklang(resultset.getString("stupiklang"));
                    pick.setStupikisadminact(resultset.getInt("stupikisadminact"));
                    pick.setStupikisdriveract(resultset.getInt("stupikisdriveract"));
                    pick.setStupikdriverid(resultset.getString("stupikdriverid"));
                    pick.setStupickupdate(resultset.getDate("stupickupdate"));
                    picklist.add(pick);
                            
         
                   // JSONObject obj = new JSONObject();
                  //  obj.put(resultset.getMetaData().getColumnLabel(i + 1)
                   //         .toLowerCase(), resultset.getObject(i + 1));
                   // jsonArray.put(obj);
               // }
            }
            
           

        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultset != null) {
                    resultset.close();
                }
            } catch (Exception e) {
            }
        }
        jsonArray= new JSONArray(picklist);
        System.out.println("test.dbo.studentImplement.stugetapprovedList()"+jsonArray.toString());
        return jsonArray.toString();

    }

    @Override
    public String stugetpickupdetails(String pickupid) {
   
    Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        String jsonarry;
        JSONArray jsonArray ;
        ArrayList<pickupdetails> picklist = new ArrayList<pickupdetails>();
        try {

            connection = DBService.getconnection();
            statement = connection.createStatement();
            final String query = "select * from stupickuplocation where stupikid="+pickupid+"";
            System.out.println(query);
            resultset = statement.executeQuery(query);

            while (resultset.next()) {
               // int total_rows = resultset.getMetaData().getColumnCount();
                //for (int i = 0; i < total_rows; i++) {
                    
                    pickupdetails pick = new pickupdetails();
                    pick.setStupikid(resultset.getInt("stupikid"));
                    pick.setStupikusn(resultset.getString("stupikusn"));
                    pick.setStupiklat(resultset.getString("stupiklat"));
                    pick.setStupikplace(resultset.getString("stupikplace"));
                    pick.setStupiklang(resultset.getString("stupiklang"));
                    pick.setStupikisadminact(resultset.getInt("stupikisadminact"));
                    pick.setStupikisdriveract(resultset.getInt("stupikisdriveract"));
                    pick.setStupikdriverid(resultset.getString("stupikdriverid"));
                    pick.setStupickupdate(resultset.getDate("stupickupdate"));
                    picklist.add(pick);
                            
         
                   // JSONObject obj = new JSONObject();
                  //  obj.put(resultset.getMetaData().getColumnLabel(i + 1)
                   //         .toLowerCase(), resultset.getObject(i + 1));
                   // jsonArray.put(obj);
               // }
            }
            
           

        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultset != null) {
                    resultset.close();
                }
            } catch (Exception e) {
            }
        }
        jsonArray= new JSONArray(picklist);
        System.out.println("test.dbo.studentImplement.stugetapprovedList()"+jsonArray.toString());
        return jsonArray.toString();
    
    
    }

    private void sendMail(String stuemail) {
    try{
        Connection con = DBService.getconnection() ;       
        ResultSet resultSet = con.createStatement()
                .executeQuery("SELECT stuemailid FROM students "
                       + "WHERE students.stuusn = '" +stuemail+"'");
        String emailID="";
        while(resultSet.next()){
            emailID = resultSet.getString("stuemailid");
        }
        
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                        
        Session session =  Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("pramodnitya798@gmail.com", "8147504881");
            }
	});
        MimeMessage mimeMessage = new MimeMessage(session);
        
            mimeMessage.setFrom(new InternetAddress("pramodnitya798@gmail.com"));
            mimeMessage.setRecipients(Message.RecipientType.TO,emailID);
            mimeMessage.setSubject("Acceptance of pickup request");
            mimeMessage.setText("Dear User," + "\n\n Your request is accepted");
                
            Transport.send(mimeMessage);
        } catch(Exception e){
            System.err.println(e);  
            e.printStackTrace();
        }
    }

    @Override
    public String driverapprovedlist(String drivername) {
     
     Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        String jsonarry;
        JSONArray jsonArray ;
        ArrayList<pickupdetails> picklist = new ArrayList<pickupdetails>();
        try {

            connection = DBService.getconnection();
            statement = connection.createStatement();
            final String query = "select * from stupickuplocation where stupikisadminact=1 and stupikisdriveract=1 and stupikdriverid='"+drivername+"'";
            System.out.println(query);
            resultset = statement.executeQuery(query);

            while (resultset.next()) {
               // int total_rows = resultset.getMetaData().getColumnCount();
                //for (int i = 0; i < total_rows; i++) {
                    
                    pickupdetails pick = new pickupdetails();
                    pick.setStupikid(resultset.getInt("stupikid"));
                    pick.setStupikusn(resultset.getString("stupikusn"));
                    pick.setStupiklat(resultset.getString("stupiklat"));
                    pick.setStupikplace(resultset.getString("stupikplace"));
                    pick.setStupiklang(resultset.getString("stupiklang"));
                    pick.setStupikisadminact(resultset.getInt("stupikisadminact"));
                    pick.setStupikisdriveract(resultset.getInt("stupikisdriveract"));
                    pick.setStupikdriverid(resultset.getString("stupikdriverid"));
                    pick.setStupickupdate(resultset.getDate("stupickupdate"));
                    picklist.add(pick);
                            
         
                   // JSONObject obj = new JSONObject();
                  //  obj.put(resultset.getMetaData().getColumnLabel(i + 1)
                   //         .toLowerCase(), resultset.getObject(i + 1));
                   // jsonArray.put(obj);
               // }
            }
            
           

        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultset != null) {
                    resultset.close();
                }
            } catch (Exception e) {
            }
        }
        jsonArray= new JSONArray(picklist);
        System.out.println("test.dbo.studentImplement.stugetapprovedList()"+jsonArray.toString());
        return jsonArray.toString();
    }

}