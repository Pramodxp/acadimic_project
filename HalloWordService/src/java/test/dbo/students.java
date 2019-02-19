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
public class students {
    
     private Integer stuid;
    private String stuname;
    private String stuusn;
    private String stuemail;
    private int stuisactive;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuusn() {
        return stuusn;
    }

    public void setStuusn(String stuusn) {
        this.stuusn = stuusn;
    }

    public String getStuemail() {
        return stuemail;
    }

    public void setStuemail(String stuemail) {
        this.stuemail = stuemail;
    }

    public int getStuisactive() {
        return stuisactive;
    }

    public void setStuisactive(int stuisactive) {
        this.stuisactive = stuisactive;
    }

    @Override
    public String toString() {
        return "students{" + "stuid=" + stuid + ", stuname=" + stuname + ", stuusn=" + stuusn + ", stuemail=" + stuemail + ", stuisactive=" + stuisactive + '}';
    }
    
    
    
}
