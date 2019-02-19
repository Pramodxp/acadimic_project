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
import java.util.Date;
import test.database.DBService;

/**
 *
 * @author Sachin
 */
public class driverImplementation implements driverinterface {

    @Override
    public boolean drivercheck(String drivername, String driverpass) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        boolean flag = false;

        try {

            connection = DBService.getconnection();
            statement = connection.createStatement();
            final String query = "select * from driverdetails where drivername='" + drivername + "' and driverpass='" + driverpass + "' and isdriveractive=1";
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
    public boolean updatepickupbydriver(String drivername, String pickupid) {
        boolean flag = false;
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
            String query = "UPDATE stupickuplocation \n"
                    + "	SET	 \n"
                    + "	`stupikisdriveract` = '1' , \n"
                    + "	`stupikdriverid` = '"+drivername+"'  \n"
                    + "	\n"
                    + "	WHERE\n"
                    + "	`stupikid` = '"+pickupid+"'";

            System.out.println(query);
            int update = statement.executeUpdate(query);
            if(update > 0){
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
        System.out.println(flag);
        return flag;
    }

}
