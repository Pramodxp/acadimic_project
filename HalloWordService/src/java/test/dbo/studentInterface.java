/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dbo;

/**
 *
 * @author Sachin
 */
public interface studentInterface {
    public boolean addstudent(String stuname,String stuusn,String stupass,String stuemail,int stuisactive);
    public boolean stucheck(String stuusn, String stupass);
    public boolean stupickuploc(String stupiklat, String stupiklang, String stupikplace, String stupikusn);
    public String stugetapprovedList();
    public String stugetpickupdetails(String pickupid);

    public String driverapprovedlist(String drivername);
}
