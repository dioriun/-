package com.example.app_guangbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class student_Activity extends AppCompatActivity implements View.OnClickListener {
    private RequestQueue mQueue;
    private TextView txt1,txt2,txt3,txt4;
    private Button btn1,btn2,btn3,btn4;
    private String student_id;
    private User data=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        txt1=(TextView)findViewById(R.id.student_text_id);
        txt2=(TextView)findViewById(R.id.student_text_username);
        txt3=(TextView)findViewById(R.id.student_text_password);
        txt4=(TextView)findViewById(R.id.student_text_school);
        btn1=(Button)findViewById(R.id.btn_student_update);
        btn2=(Button)findViewById(R.id.btn_student_fanhui);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        mQueue= Volley.newRequestQueue(this);
        Intent Mainactivity_it=getIntent();;
         student_id=Mainactivity_it.getStringExtra("student_id");
         System.out.println("id="+student_id);
        StringRequest stringRequest1=new StringRequest(Request.Method.POST, "http://192.168.52.15:8081/androidfuwqi_1_war_exploded/student_Servlet_hca.do", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                data = JSON.parseObject(JSON.toJSONString(JSON.parse(response)), User.class);
                txt1.setText(data.getId()+"");
                txt2.setText(data.getUsername());
                txt3.setText(data.getPassword());
                txt4.setText(data.getSchool());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> maps=new HashMap<>();
            maps.put("id",student_id);
            maps.put("nickname","Tomcat");
            return maps;
        }
        };
        mQueue.add(stringRequest1);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_student_update:
                Intent it2=new Intent(student_Activity.this,student_update_Activity.class);
                it2.putExtra("student_id",data.getId()+"");
                it2.putExtra("student_username",data.getUsername());
                startActivity(it2);
                break;
            case R.id.btn_student_fanhui:
                Intent it3=new Intent(student_Activity.this,MainActivity.class);
                startActivity(it3);
                break;




    }
}
}