package com.example.app_guangbo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
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

public class admin_student_Activity extends AppCompatActivity implements View.OnClickListener{
    private RequestQueue mQueue;
    private ListView lv=null;
    private List<Map<String,Object>>list=new ArrayList<Map<String, Object>>();
    private Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_student);
        lv=(ListView) findViewById(R.id.admin_student_lv);
        mQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest1=new StringRequest(Request.Method.POST, "http://192.168.52.15:8081/androidfuwqi_1_war_exploded/admin_student_servlet_cha.do", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    System.out.println(JSON.parse(response));
                    List<User> datas = JSONArray.parseArray(JSON.toJSONString(JSON.parse(response)), User.class);

                    for (User u:datas){
                        Map<String,Object> listmap=new HashMap<String, Object>();
                        listmap.put("id",u.getId());
                        listmap.put("username",u.getUsername());
                        listmap.put("password",u.getPassword());
                        listmap.put("school",u.getSchool());
                        list.add(listmap);
                    }
                    System.out.println(list);
        MyAdapter myAdapter=new MyAdapter(admin_student_Activity.this,list);
        lv.setAdapter(myAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> maps=new HashMap<>();
            maps.put("username","1");
            maps.put("nickname","Tomcat");
            return maps;

        }
        };
        mQueue.add(stringRequest1);
        btn1=(Button)findViewById(R.id.admin_student__btn_up);
        btn2=(Button)findViewById(R.id.admin_student__btn_add);
        btn3=(Button)findViewById(R.id.admin_student__btn_fanhui);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.admin_student__btn_add:
                Intent it1=new Intent(admin_student_Activity.this,admin_student_add_Activity.class);
                startActivity(it1);
                break;
            case R.id.admin_student__btn_up:
                Intent it2=new Intent(admin_student_Activity.this,admin_student_Activity.class);
                startActivity(it2);
                break;
            case R.id.admin_student__btn_fanhui:
                Intent it3=new Intent(admin_student_Activity.this,MainActivity.class);
                startActivity(it3);
                break;
        }
    }
}