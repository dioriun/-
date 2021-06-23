package com.example.app_guangbo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class admin_student_add_Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btn1,btn2,btn3,btn4;
    private RequestQueue mQueue;
    private String age_username;
    private String age_password;
    private String age_school;
    private String age_id;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_add);
txt=(TextView)findViewById(R.id.txt_activity_admin_student_add);
        btn1=(Button)findViewById(R.id.btn_activity_admin_student_add_queding);
        btn2=(Button)findViewById(R.id.btn_activity_admin_student_add_quxiao);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        mQueue= Volley.newRequestQueue(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_activity_admin_student_add_queding:
                EditText et_username=(EditText)findViewById(R.id.edt_activity_admin_student_add_username);
                age_username=et_username.getText().toString();
                EditText et_password=(EditText)findViewById(R.id.edt_activity_admin_student_add_password);
                age_password=et_password.getText().toString();
                EditText et_school=(EditText)findViewById(R.id.edt_activity_admin_student_add_school);
                age_school=et_school.getText().toString();
                EditText et_id=(EditText)findViewById(R.id.edt_activity_admin_student_add_id);
                age_id=et_id.getText().toString();
                txt.setText("shibai");
                StringRequest stringRequest2=new StringRequest(Request.Method.POST,"http://192.168.52.15:8081/androidfuwqi_1_war_exploded/admin_student_add_Servlet.do", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            txt.setText(response);
                        if (response=="chenggong"){
                            Intent it1=new Intent(admin_student_add_Activity.this,admin_student_Activity.class);
                            startActivity(it1);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Nullable

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> maps=new HashMap<>();
                        maps.put("id",age_id);
                        maps.put("username",age_username);
                        maps.put("password",age_password);
                        maps.put("school",age_school);
                        maps.put("nickname","Tomcat");
                        return maps;
                    }
                };
                mQueue.add(stringRequest2);



                break;
            case R.id.btn_activity_admin_student_add_quxiao:
                Intent it1=new Intent(admin_student_add_Activity.this,admin_student_Activity.class);
                startActivity(it1);
                break;
        }
    }
}