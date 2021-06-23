package com.example.app_guangbo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class admin_denglu_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2;
    private RequestQueue mQueue;
    private TextView text1;
    private String age_username;
    private String age_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_denglu);
        btn1=(Button)findViewById(R.id.btn_get);
        btn2=(Button)findViewById(R.id.btn_post);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        mQueue= Volley.newRequestQueue(this);
        text1=(TextView)findViewById(R.id.text1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get:
                Intent it=new Intent(admin_denglu_Activity.this,MainActivity.class);
                startActivity(it);
                break;

            case R.id.btn_post:
                EditText et_username=(EditText)findViewById(R.id.edt_one_1);
                age_username=et_username.getText().toString();
                EditText et_password=(EditText)findViewById(R.id.edt_one_2);
                age_password=et_password.getText().toString();
                StringRequest stringRequest2=new StringRequest(Request.Method.POST,"http://192.168.52.15:8081/androidfuwqi_1_war_exploded/denglu.do", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        text1.setText(response);
                        if(response.equalsIgnoreCase("chenggong")){
                            Intent it1=new Intent(admin_denglu_Activity.this,admin_student_Activity.class);
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
                        maps.put("username",age_username);
                        maps.put("password",age_password);
                        maps.put("school","edu");
                        maps.put("nickname","Tomcat");
                        return maps;
                    }
                };
                mQueue.add(stringRequest2);
                break;
        }
    }
}