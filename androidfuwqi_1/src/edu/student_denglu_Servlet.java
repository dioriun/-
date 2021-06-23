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

@WebServlet(name = "student_denglu_Servlet")
public class student_denglu_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        int username=Integer.parseInt(request.getParameter("username"));
        String password=request.getParameter("password");
        userdaoimt admini=new userdaoimt();
        User ad=admini.selectStudentById(username);
        int ids=ad.getId();
        String ps=ad.getPassword();

        if (username==ids && ps.equals(password)){
            out.write("chenggong");

        }else{
            out.write("shibai");
        }
//
//        System.out.println("name="+username);
//        System.out.println("password="+password);


        out.flush();
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
