package edu;

import bean.AdminBean;
import dao.adminimt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dengluServlet")
public class dengluServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        int username=Integer.parseInt(request.getParameter("username"));
        String password=request.getParameter("password");
        adminimt admini=new adminimt();
        AdminBean ad=admini.selectAdminById(username);
        int ids=ad.getUno();
        String ps=ad.getUpass();
if (username==ids && ps.equals(password)){
    out.write("chenggong");

}else{
    out.write("shibai");
}

        System.out.println("name="+username);
        System.out.println("password="+password);


        out.flush();
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
