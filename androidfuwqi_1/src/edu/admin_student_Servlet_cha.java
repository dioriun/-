package edu;

import bean.User;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dao.userdaoimt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "amind_student_Servlet_cha")
public class admin_student_Servlet_cha extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        List s=null;

        int username=Integer.parseInt(request.getParameter("username"));
        if (username==1){
            userdaoimt stu=new userdaoimt();
            List<User> data=null;
            data=stu.listall();
            JSONArray jsonArray = new JSONArray();
            for (User u : data){
                JSONObject jsonObject = (JSONObject) JSONObject.toJSON(u);
                String jsonString = jsonObject.toJSONString();
                jsonArray.add(jsonObject);
            }
            String str = jsonArray.toString();
System.out.println(str);

            out.write(str);
        }else{
            out.write("shibai");
        }

//        System.out.println("name="+username);



        out.flush();
        out.close();




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
