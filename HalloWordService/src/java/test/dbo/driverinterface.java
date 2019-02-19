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
public interface driverinterface {
    
    public boolean drivercheck(String stuusn, String stupass);
    public boolean updatepickupbydriver(String drivername,String pickupid);
    
    
    
}
