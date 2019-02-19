package com.shastri.controller;

/** SHARAN SHAS...3 (9538180903)*/
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


/************* java Packages *************/
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shastri.serviceImpl.CustomServiceImpl;
import com.shastri.to.AttributeBasedAccessTO;
import com.shastri.to.BGAccessTO;
import com.shastri.to.DriverTo;
import com.shastri.to.ECPTO;
import com.shastri.to.LoginTO;
import com.shastri.to.PatientTO;
import com.shastri.to.SignUpTO;
import com.shastri.to.StudentTO;

@MultipartConfig(maxFileSize = 16177215)
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String path = req.getServletPath();
		CustomServiceImpl service = new CustomServiceImpl();
		HttpSession session = req.getSession();

		String status = "";

		String loginStatus = "";
		if (path.equals("/index.do")) {

			req.getRequestDispatcher("/html/index.html").forward(req, res);

		}

		if (path.equals("/uc.do")) {

			req.getRequestDispatcher("/html/uc.html").forward(req, res);

		}
		
		if (path.equals("/loginForm.do")) {

			req.getRequestDispatcher("/jsp/commonLogin.jsp").forward(req, res);

		}

		if (path.equals("/login.do")) {

			LoginTO to = new LoginTO();
			String type = req.getParameter("user");
			to.setUserName(req.getParameter("nme"));
			to.setPassword(req.getParameter("pwd"));

			loginStatus = service.login(to, type);

			if (loginStatus.equals("SUCCESS")) {
				if (type.equals("doctor")) {
					session.setAttribute("DOCTOR", to.getUserName());
					req.setAttribute("PATH", "/doctorMain.do");
					req.getRequestDispatcher("/jsp/doctorMain.jsp").forward(req, res);
				}
				if (type.equals("patient")) {
					session.setAttribute("PATIENT", to.getUserName());
					req.setAttribute("PATH", "/patientMain.do");
					req.getRequestDispatcher("/jsp/patientMain.jsp").forward(req, res);
				}

			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/commonLogin.jsp").forward(req, res);
			}

		}

		
		
		if (path.equals("/cloudLogin.do")) {

			LoginTO to = new LoginTO();
			to.setUserName(req.getParameter("nme"));
			to.setPassword(req.getParameter("pwd"));

			loginStatus = service.login(to);
			if (loginStatus.equals("SUCCESS")) {
				session.setAttribute("CLOUD", to.getUserName());
				req.setAttribute("PATH", "/adminMain.do");
				req.getRequestDispatcher("/jsp/adminMain.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}

		}

		if (path.equals("/adminMain.do")) {
			if (session.getAttribute("CLOUD") != null) {
				req.setAttribute("PATH", path);
				req.setAttribute("PATH", "/adminMain.do");
				req.getRequestDispatcher("/jsp/adminMain.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}

		if (path.equals("/adminLogout.do")) {
			req.setAttribute("LOGIN_STATUS", "Admin logout successful");
			session.invalidate();
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
		}
		
		if (path.equals("/add.do")) {
			if (session.getAttribute("CLOUD") != null) {
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/adminMain.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
                if (path.equals("/addD.do")) {
			if (session.getAttribute("CLOUD") != null) {
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/adminMain.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
		
		if (path.equals("/jsp/addStudent.do")) {
			if (session.getAttribute("CLOUD") != null) {
				StudentTO to = new StudentTO();

				to.setStuname(req.getParameter("stuname"));
				to.setStupass(req.getParameter("stupass"));
				to.setStuusn(req.getParameter("stuusn"));
				to.setStuemail(req.getParameter("stuemail"));
				

				status = service.addStudent(to);

				req.setAttribute("ADDED_STATUS", status);
				req.getRequestDispatcher("addUsers.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", "please login to continue");
				req.getRequestDispatcher("/jsp/hipLogin.jsp").forward(req, res);
			}
		}
		
		if (path.equals("/view.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				List<StudentTO> list = service.students();
				session.setAttribute("STUDENT", list);
				
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/adminMain.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
                
                
                if (path.equals("/viewD.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				List<DriverTo> list = service.drivers();
				session.setAttribute("DRIVER", list);
				
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/adminMain.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
                
                
                
                
		
		if (path.equals("/permit.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				List<StudentTO> list = service.studentPickupLocation();
				session.setAttribute("STUDENT_PICKUP_LOCATION", list);
				
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/adminMain.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
		
		if (path.equals("/jsp/permit.do")) {
			if (session.getAttribute("CLOUD") != null) {
				service.permit(Integer.parseInt(req.getParameter("id")));
				
				List<StudentTO> list = service.studentPickupLocation();
				session.setAttribute("STUDENT_PICKUP_LOCATION", list);
				
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("permitUsers.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
                
                if (path.equals("/jsp/cancel.do")) {
                    if (session.getAttribute("CLOUD") != null) {
                        service.cancel(Integer.parseInt(req.getParameter("id")));
                        
                        List<StudentTO> list = service.studentPickupLocation();
                        session.setAttribute("STUDENT_PICKUP_LOCATION", list);
                        
                        req.setAttribute("PATH", path);
                        req.getRequestDispatcher("permitUsers.jsp").forward(req, res);
                        
                    } else {
                        req.setAttribute("LOGIN_STATUS", loginStatus);
                        req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
                    }
                }
		
		if (path.equals("/jsp/edit.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				StudentTO to = service.user(Integer.parseInt(req.getParameter("id")));
				
				session.setAttribute("STUDENT", to);
				
				req.getRequestDispatcher("update.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
                
                
                if (path.equals("/jsp/editD.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				DriverTo to = service.driver(Integer.parseInt(req.getParameter("id")));
				
				System.out.println("--aaa--"+to);
				session.setAttribute("DRIVER", to);
				
				req.getRequestDispatcher("updateD.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
                
		
		if (path.equals("/jsp/delete.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				service.delete(Integer.parseInt(req.getParameter("id")));
				
				List<StudentTO> list = service.students();
				session.setAttribute("STUDENT", list);
				
				req.getRequestDispatcher("viewUsers.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
		
                
                if (path.equals("/jsp/deleteD.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				service.deleteD(Integer.parseInt(req.getParameter("id")));
				
				List<DriverTo> list = service.drivers();
				session.setAttribute("DRIVER", list);
				
				req.getRequestDispatcher("viewUsers.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
		
                
                
		if (path.equals("/jsp/update.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				StudentTO to = new StudentTO();

				to.setSlNo(Long.parseLong(req.getParameter("slNo")));
				to.setStuname(req.getParameter("stuname"));
				to.setStupass(req.getParameter("stupass"));
				to.setStuusn(req.getParameter("stuusn"));
				to.setStuemail(req.getParameter("stuemail"));
				

				service.update(to);
				
				List<StudentTO> list = service.students();
				session.setAttribute("STUDENT", list);
				
				req.getRequestDispatcher("viewUsers.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
		
    if (path.equals("/jsp/updateD.do")) {
			if (session.getAttribute("CLOUD") != null) {
				
				DriverTo to = new DriverTo();

				to.setDriverID(Integer.parseInt(req.getParameter("driverID")));
				to.setdName(req.getParameter("dname"));
				to.setdEmail(req.getParameter("Demail"));
				to.setDriverPass(req.getParameter("Driverpass"));
				to.setdActive("1");
			System.out.println("inside controo "+to);
				

				service.updateD(to);
				
				List<DriverTo> list = service.drivers();
				session.setAttribute("DRIVER", list);
				
				req.getRequestDispatcher("viewDriver.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", loginStatus);
				req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			}
		}
		
                
                if (path.equals("/jsp/addDriver.do")) {
			if (session.getAttribute("CLOUD") != null) {
				DriverTo to = new DriverTo();
				to.setdName(req.getParameter("dname"));
				
			
				to.setdEmail(req.getParameter("Demail"));
				to.setDriverPass(req.getParameter("Driverpass"));
                    to.setdActive(req.getParameter("dActive"));
			
				status = service.addDiver(to);

				req.setAttribute("ADDED_STATUS", status);
				req.getRequestDispatcher("addUsers.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", "please login to continue");
				req.getRequestDispatcher("/jsp/hipLogin.jsp").forward(req, res);
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////

		
	}
}
