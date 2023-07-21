package com.conttoler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.dao.StudentDao;
import com.model.Student;


@WebServlet("/Servlet1")
@MultipartConfig(maxRequestSize = 999999999, maxFileSize = 999999999)
public class Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//--------------------------------------------------------------------------------------------------------------

		if (req.getParameter("s1").equalsIgnoreCase("Add")) {
			Student s = new Student();
			s.setSname(req.getParameter("sname"));
			s.setScity(req.getParameter("scity"));
			s.setSpercentage(Double.parseDouble(req.getParameter("spercentage")));
			if (req.getPart("simg").getSize() != 0)
				s.setSimg(IOUtils.toByteArray(req.getPart("simg").getInputStream()));
			if (req.getPart("sdocs").getSize() != 0)
				s.setSdocs(IOUtils.toByteArray(req.getPart("sdocs").getInputStream()));
			s.setSclass(req.getParameter("sclass"));
			s.setGender(req.getParameter("gender"));

			if (new StudentDao().insertStudent(s) > 0)
				res.sendRedirect("thank_you.jsp");
			else
				res.sendRedirect("index.jsp");
		}
//--------------------------------------------------------------------------------------------------------------
		
		if (req.getParameter("s1").equalsIgnoreCase("Delete")) {
			if (new StudentDao().deleteStudentById(Integer.parseInt(req.getParameter("sid"))) > 0)
				res.sendRedirect("index.jsp");
			else
				res.sendRedirect("error.jsp");
		}
//--------------------------------------------------------------------------------------------------------------

		if (req.getParameter("s1").equalsIgnoreCase("Display")) {
			Student s = new StudentDao().displayStudentById(Integer.parseInt(req.getParameter("sid")));
			if (s == null)
				res.sendRedirect("index.jsp");
			else {
				req.setAttribute("student", s);
				req.getRequestDispatcher("second.jsp").forward(req, res);
			}
		}
//--------------------------------------------------------------------------------------------------------------

		if (req.getParameter("s1").equalsIgnoreCase("Update")) {
			Student s = new Student();
			s.setSid(Integer.parseInt(req.getParameter("sid")));
			s.setSname(req.getParameter("sname"));
			s.setScity(req.getParameter("scity"));
			s.setSpercentage(Double.parseDouble(req.getParameter("spercentage")));
			if (req.getPart("simg").getSize() != 0)
				s.setSimg(IOUtils.toByteArray(req.getPart("simg").getInputStream()));
			else
				s.setSimg(new StudentDao().displayImageById(s.getSid()));
			if (req.getPart("sdocs").getSize() != 0)
				s.setSdocs(IOUtils.toByteArray(req.getPart("sdocs").getInputStream()));
			else
				s.setSdocs(new StudentDao().displayDocsById(s.getSid()));
			s.setSclass(req.getParameter("sclass"));
			s.setGender(req.getParameter("gender"));

			if (new StudentDao().updateStudentById(s) > 0)
				res.sendRedirect("index.jsp");
			else
				res.sendRedirect("error.jsp");
		}
	}
//--------------------------------------------------------------------------------------------------------------

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("s1").equalsIgnoreCase("Delete")) {
			if (new StudentDao().deleteStudentById(Integer.parseInt(req.getParameter("sid"))) > 0)
				res.sendRedirect("index.jsp");
			else
				res.sendRedirect("error.jsp");
		}
//--------------------------------------------------------------------------------------------------------------

		if (req.getParameter("s1").equalsIgnoreCase("Display")) {
			Student s = new StudentDao().displayStudentById(Integer.parseInt(req.getParameter("sid")));
			if (s == null)
				res.sendRedirect("index.jsp");
			else {
				req.setAttribute("student", s);
				req.getRequestDispatcher("second.jsp").forward(req, res);
			}
		}
	}
}
