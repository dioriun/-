package com.example.app_guangbo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {

    private RequestQueue mQueue;
    private Context mContext;
    private List<Map<String,Object>> mDatas;

    public MyAdapter(Context mContext, List<Map<String, Object>> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mQueue= Volley.newRequestQueue(mContext);
        ViewHolder holder1=null;
        if (convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.admin_student_item,null);
            holder1=new ViewHolder();
            holder1.txt=(TextView) convertView.findViewById(R.id.admin_student_item_text_id);
            holder1.txt1=(TextView) convertView.findViewById(R.id.admin_student_item_text_username);
            holder1.txt2=(TextView) convertView.findViewById(R.id.admin_student_item_text_password);
            holder1.txt3=(TextView) convertView.findViewById(R.id.admin_student_item_text_school);
     holder1.btn1=(Button) convertView.findViewById(R.id.admin_student_item_btn_update);
        holder1.btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it1=new Intent(mContext,admin_student_update_Activity.class);
                mContext.startActivity(it1);
            }
        });

        holder1.btn2=(Button) convertView.findViewById(R.id.admin_student_item_btn_delete);
        ViewHolder finalHolder = holder1;
        holder1.btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                StringRequest stringRequest1=new StringRequest(Request.Method.POST, "http://192.168.52.15:8081/androidfuwqi_1_war_exploded/admin_student_delete_Servlet.do", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Intent it2=new Intent(mContext,admin_student_Activity.class);
                        mContext.startActivity(it2);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> maps=new HashMap<>();
                    maps.put("id",(String)mDatas.get(position).get("id").toString());
                    maps.put("nickname","Tomcat");
                    return maps;

                }
                };
                mQueue.add(stringRequest1);

            }
        });
            convertView.setTag(holder1);

        }else {
            holder1=(ViewHolder)convertView.getTag();
        }

        holder1.txt.setText((String)mDatas.get(position).get("id").toString());
        holder1.txt1.setText((String)mDatas.get(position).get("username"));
        holder1.txt2.setText((String)mDatas.get(position).get("password"));
        holder1.txt3.setText((String)mDatas.get(position).get("school"));








        return convertView;

    }
    static class ViewHolder{
        TextView txt2;
        TextView txt;
        TextView txt1;
        TextView txt3;
        Button btn1;
        Button btn2;

    }
}
