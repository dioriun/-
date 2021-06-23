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

public class student_update_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4;
    private RequestQueue mQueue;
    private String age_username;
    private String age_password;
    private String age_school;
    private String age_id;
    private TextView txt1,txt2,txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_update);
        Intent student_it=getIntent();;
        age_id=student_it.getStringExtra("student_id");
        age_username=student_it.getStringExtra("student_username");
        txt1=(TextView)findViewById(R.id.student_update_id);
        txt2=(TextView)findViewById(R.id.student_update_username);
        txt=(TextView)findViewById(R.id.student_update_txt) ;
        btn1=(Button)findViewById(R.id.btn_student_update_queding);
        btn2=(Button)findViewById(R.id.btn_student_update_quxiao);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        mQueue= Volley.newRequestQueue(this);
      txt1.setText(age_id+"");
        txt2.setText(age_username);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_student_update_queding:
                txt.setText("shibai");
                EditText et_password=(EditText)findViewById(R.id.student_update_password);
                age_password=et_password.getText().toString();
                EditText et_school=(EditText)findViewById(R.id.student_update_school);
                age_school=et_school.getText().toString();

                StringRequest stringRequest2=new StringRequest(Request.Method.POST,"http://192.168.52.15:8081/androidfuwqi_1_war_exploded/admin_student_update_Servlet.do", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txt.setText(response);
                        if (response=="chenggong"){
                            Intent it=new Intent(student_update_Activity.this,student_Activity.class);
                            it.putExtra("student_id",age_id);
                            startActivity(it);
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
            case R.id.btn_student_update_quxiao:
                Intent it1=new Intent(student_update_Activity.this,student_Activity.class);
                it1.putExtra("student_id",age_id);
                startActivity(it1);
                break;
        }
    }
}