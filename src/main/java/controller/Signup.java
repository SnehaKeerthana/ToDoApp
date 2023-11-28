package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;
import service.UserService;
@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		LocalDate dob=LocalDate.parse(req.getParameter("DOB"));
		String Gender=req.getParameter("gender");
		int age=LocalDate.now().getYear()-dob.getYear();
		
//		resp.getWriter().print("<h1>");
//		resp.getWriter().print("Name:"+ name+"<br>");
//		resp.getWriter().print("email:"+email+"<br>");
//		resp.getWriter().print("password:"+password+"<br>");
//		resp.getWriter().print("mobile:"+mobile+"<br>");
//		resp.getWriter().print("DOB:"+dob+"<br>");
//		resp.getWriter().print("Gender:"+Gender+"<br>");
//		resp.getWriter().print("Age:"+age+"<br>");
		
		UserDto dto=new UserDto();
		dto.setPassword(password);
		dto.setName(name);
		dto.setAge(age);
		dto.setDob(dob);
		dto.setEmail(email);
		dto.setGender(Gender);
		dto.setMobile(mobile);
		
		UserService service=new UserService();
		if(service.saveUser(dto))
		{
		  resp.getWriter().print("<h1 style='color:green'>Account created Successfully</h1>");	
		  req.getRequestDispatcher("login.html").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1 style='color:green'>Sorry!!!Account can not be created Successfully</h1>");	
		
			req.getRequestDispatcher("signup.html").include(req, resp);
		
		}
	}

}
