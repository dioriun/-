package com.example.app_guangbo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4;
    private RequestQueue mQueue;
    private TextView text1,txt1,txt2,txt3;
    private String age_username;
    private String age_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt3=(TextView) findViewById(R.id.btn_get);
        btn2=(Button)findViewById(R.id.btn_post);
        txt1=(TextView) findViewById(R.id.txt_wangjimima);
        txt2=(TextView) findViewById(R.id.txt_add);
        txt3.setOnClickListener(this);
        btn2.setOnClickListener(this);
        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        mQueue= Volley.newRequestQueue(this);
        text1=(TextView)findViewById(R.id.text1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get:
                Intent it=new Intent(MainActivity.this,admin_denglu_Activity.class);
                startActivity(it);
                break;

            case R.id.btn_post:
                EditText et_username=(EditText)findViewById(R.id.edt_student_id);
                age_username=et_username.getText().toString();
                EditText et_password=(EditText)findViewById(R.id.edt_student_password);
                age_password=et_password.getText().toString();
                StringRequest stringRequest2=new StringRequest(Request.Method.POST,"http://192.168.52.15:8081/androidfuwqi_1_war_exploded/student_denglu_Servlet.do", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        text1.setText(response);
                        if(response.equalsIgnoreCase("chenggong")){
                            Intent it1=new Intent(MainActivity.this,student_Activity.class);
                            it1.putExtra("student_id",age_username);
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
            case R.id.txt_wangjimima:
                Toast.makeText(this,"请联系管理员",Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_add:
                Intent it4=new Intent(MainActivity.this,student_add_Activity.class);
                startActivity(it4);
                break;
        }
    }
}