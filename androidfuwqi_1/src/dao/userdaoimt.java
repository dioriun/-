package dao;

import DBUlite.shujuku;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class userdaoimt implements userdao{
    public userdaoimt() {
    }

    public String  add(User u) {
        Connection coon = shujuku.conn();
        String sql = "insert into studen(id,username,password,school) values(?,?,?,?)";
        PreparedStatement ps = null;
String string = null;
        try {
            ps = coon.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getSchool());

            int row = ps.executeUpdate();
            coon.close();
            ps.close();

            if (row==1){
                string= "chenggong";
            }else {
                string= "shibai";
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }
return string;
    }

    public void deleteById(int id) {
        Connection conn = shujuku.conn();
        String sql = "delete from studen where id=?";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    public List<User> listall() {
        Connection conn = shujuku.conn();
        String sql = "select id,username,password,school from studen";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

        ArrayList data = new ArrayList();

        while(true) {
            try {
                if (!rs.next()) {
                    break;
                }
            } catch (SQLException var10) {
                var10.printStackTrace();
            }

            try {
                data.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("school")));
            } catch (SQLException var8) {
                var8.printStackTrace();
            }
        }

        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return data;
    }

    public String update(User u) {
        String sql = "update studen set  id=?,username=?,password=?,school=? where id=?";
        Connection conn = shujuku.conn();
        String string = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getSchool());
            ps.setInt(5, u.getId());
            int row = ps.executeUpdate();
            ps.close();
            conn.close();

            if (row==1){
                string= "chenggong";
            }else {
                string= "shibai";
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }
return string;
    }

    public boolean id(int id1) {
        List<User> date = this.listall();

        User u;
        String var8;
        for(Iterator var3 = date.iterator(); var3.hasNext(); var8 = u.getSchool()) {
            u = (User)var3.next();
            int id = u.getId();
            String username = u.getUsername();
            String password = u.getPassword();
        }

        return false;
    }

    @Override
    public User selectStudentById(int id) {
        Connection conn = shujuku.conn();
        String sql = "select * from studen where id = " + id;
        User stu = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stu = new User();
                stu.setId(rs.getInt("id"));
                stu.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }

    @Override
    public User studentByid(int id) {
        Connection conn = shujuku.conn();
        String sql = "select * from studen where id = " + id;
        User u = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setSchool(rs.getString("school"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
