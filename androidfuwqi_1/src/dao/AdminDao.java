package dao;

import bean.AdminBean;

public interface AdminDao {
    AdminBean selectAdminById(int id);
    void add(AdminBean u);
}
