package dao;

import bean.User;

import java.util.List;

public interface userdao {
    String add(User var1);

    void deleteById(int var1);

    List<User> listall();

    String update(User var1);

    boolean id(int var1);

    User selectStudentById(int id);

    User studentByid(int id);
}
