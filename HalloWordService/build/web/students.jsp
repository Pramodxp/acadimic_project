<%-- 
    Document   : students
    Created on : 21 Apr, 2018, 2:59:08 PM
    Author     : Sachin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h1>Add New Students</h1>
         <br/>
         <form action="newstudentreg" method="POST">
        
         <table border="0">
             
             <tbody>
                 <tr>
                     <td>Name :</td>
                     <td><input type="text" name="stuname" value="" /></td>
                 </tr>
                 <tr>
                     <td>USN</td>
                     <td><input type="text" name="stuusn" value="" /></td>
                 </tr>
                 <tr>
                     <td>Email Id</td>
                     <td><input type="text" name="stuemail" value="" /></td>
                 </tr>
                 <tr>
                     <td>Password</td>
                     <td><input type="password" name="stupass" value="" /></td>
                 </tr>
                 <tr>
                     <td><input type="submit" value="Submit" /></td>
                     <td><input type="reset" value="Clear" /></td>
                 </tr>
             </tbody>
         </table>
 </form>
        </center>
    </body>
</html>
