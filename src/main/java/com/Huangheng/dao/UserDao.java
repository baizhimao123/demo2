package com.Huangheng.dao;

import com.Huangheng.model.User;
//import sun.rmi.server.UnicastServerRef;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        int i=0;
        String sql="update usertable set Password=?,Email=?,Gender=?,Birthdate=? where UserName=?";
        PreparedStatement statement=con.prepareStatement(sql);
        statement.setString(1,user.getPassword());
        statement.setString(2,user.getEmail());
        statement.setString(3,user.getGender());
        statement.setDate(4, (java.sql.Date) user.getBirthdate());
        statement.setString(5,user.getUserName());
        statement.executeUpdate();
        i=1;
        return i;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {

        String sql="select * from usertable where UserName=? and Password=? ";
        PreparedStatement statement=con.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet resultSet=statement.executeQuery();
        User user=null;

        if (resultSet.next()==true){
            user=new User();
            user.setUserName(resultSet.getString("UserName"));
            user.setPassword(resultSet.getString("Password"));
            user.setEmail(resultSet.getString("Email"));
            user.setGender(resultSet.getString("Gender"));
            user.setBirthdate(resultSet.getDate("Birthdate"));
        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
