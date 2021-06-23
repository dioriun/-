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

@WebServlet(name = "student_Servlet_hca")
public class student_Servlet_hca extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        userdaoimt dao=new userdaoimt();

        User data=null;
        data=dao.studentByid(id);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(data);
        jsonArray.add(jsonObject);
        String jsonString = jsonObject.toJSONString();
        String str = jsonArray.toString();
        if (data.getId()==id){
            System.out.println(jsonString);
            out.write(jsonString);
        }else {
            out.write("shibai");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
