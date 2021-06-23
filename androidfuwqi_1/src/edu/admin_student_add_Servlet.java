package edu;

import bean.User;
import dao.userdaoimt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "admin_student_add_Servlet")
public class admin_student_add_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String username;
        String password;
        String school;
        int id=Integer.parseInt(request.getParameter("id"));
        username = request.getParameter("username");
        password=request.getParameter("password");
        school = request.getParameter("school");
        User u = new User();
        u.setId(id);
        u.setUsername(username);
        u.setPassword(password);
        u.setSchool(school);
        userdaoimt dao = new userdaoimt();
        String str=dao.add(u);
        System.out.println(username);
        out.write(str);

        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
