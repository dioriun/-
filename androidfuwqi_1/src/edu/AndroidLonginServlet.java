package edu;

import bean.User;
import dao.userdaoimt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AndroidLonginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String school=request.getParameter("school");
        System.out.println("name="+username);
        System.out.println("password="+password);
        System.out.println("school="+school);
        userdaoimt dao = new userdaoimt();
        if(username.equals("w")&&password.equals("c")){
            String cuhansong = null;
            List<User> datas=dao.listall();
           User u=datas.get(0);
            cuhansong=u.getUsername();
            out.write(cuhansong);

        }else {
            out.write("失败");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
request.setCharacterEncoding("utf-8");
PrintWriter out=response.getWriter();
        String username;
        String password;
        String school;
        username = request.getParameter("username");
        password=request.getParameter("password");
        school = request.getParameter("school");
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setSchool(school);
        userdaoimt dao = new userdaoimt();
        dao.add(u);
System.out.println("连接成功");
out.flush();
out.close();

    }
}
