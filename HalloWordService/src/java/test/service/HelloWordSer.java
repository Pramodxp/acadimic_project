/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import test.dbo.driverImplementation;
import test.dbo.driverinterface;
import test.dbo.studentImplement;
import test.dbo.studentInterface;

/**
 *
 * @author Sachin
 */
@WebService(serviceName = "HelloWordSer")
public class HelloWordSer {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello() {
        System.out.println("test.service.HelloWordSer.hello()");
        return "Hello welcoome to services !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        //TODO write your implementation code here:
        return null;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "studentlogin")
    public String studentlogin(@WebParam(name = "stuusn") String stuusn, @WebParam(name = "stupass") String stupass) {
        //TODO write your implementation code here:
        studentInterface stu= new studentImplement();
        System.out.println("test.service.HelloWordSer.studentlogin()");
        boolean flag = stu.stucheck(stuusn, stupass);
        System.out.println("test.service.HelloWordSer.studentlogin() sachin :"+flag);
        if(flag){
            return "Success";
        }
        else{
            return "fail";
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertlatlangdata")
    public String insertlatlangdata(@WebParam(name = "stupiklat") String stupiklat, @WebParam(name = "stupiklang") String stupiklang, @WebParam(name = "stupikplace") String stupikplace, @WebParam(name = "stupikusn") String stupikusn) {
        //TODO write your implementation code here:
        studentInterface stu= new studentImplement();
        boolean flag = stu.stupickuploc(stupiklat, stupiklang,stupikplace,stupikusn);
        System.out.println("test.service.HelloWordSer.studentlogin() sachin :"+flag);
         if(flag){
            return "Success";
        }
        else{
            return "fail";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "stuacceptedlist")
    public String stuacceptedlist() {
        //TODO write your implementation code here:
        studentInterface stu= new studentImplement();
        return stu.stugetapprovedList();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "driverlogin")
    public String driverlogin(@WebParam(name = "drivername") String drivername, @WebParam(name = "driverpass") String driverpass) {
        driverinterface driv= new driverImplementation();
        System.out.println("test.rgrdgrgdfgdfg");
        boolean flag = driv.drivercheck(drivername, driverpass);
        System.out.println("tesfghgfhgfhfg :"+flag);
        if(flag){
            return "Success";
        }
        else{
            return "fail";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "driverselectstudentpickup")
    public String driverselectstudentpickup(@WebParam(name = "drivername") String drivername, @WebParam(name = "pickid") String pickid) {
        driverinterface driv= new driverImplementation();
        System.out.println("test.service.HelloWordSer.driverselectstudentpickup()fsfsdfdsfsdfsdfsfd");
        boolean flag = driv.updatepickupbydriver(drivername, pickid);
        if(flag){
            return "Success";
        }
        else{
            return "fail";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getsyudentpickupinfo")
    public String getsyudentpickupinfo(@WebParam(name = "pickupid") String pickupid) {
        //TODO write your implementation code here:
        studentInterface stu= new studentImplement();
        return stu.stugetpickupdetails(pickupid);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getdriverapprovelist")
    public String getdriverapprovelist(@WebParam(name = "drivername") String drivername) {
        //TODO write your implementation code here:
         studentInterface stu= new studentImplement();
         System.out.println("test.service.HelloWordSer.getdriverapprovelist()"+drivername);
        return stu.driverapprovedlist(drivername);
    }
   
    
}
