package dao;

import bean.AdminBean;
import DBUlite.shujuku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminimt implements AdminDao{
    @Override
    public AdminBean selectAdminById(int id) {
        Connection conn = shujuku.conn();
        String sql = "select * from Admin where Uno = " + id;
        AdminBean stu = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stu = new AdminBean();
                stu.setUno(rs.getInt("Uno"));
                stu.setUpass(rs.getString("Upass"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }

    @Override
    public void add(AdminBean u) {
        Connection conn=shujuku.conn();
        String sql="insert into Student(Uno,Upass) values(?,?)";

        PreparedStatement ps= null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,u.getUno());
            ps.setString(2,u.getUpass());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
