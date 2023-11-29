package com.deng.dao.imp;


import com.deng.dao.UserDao;
import com.deng.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {

    @Override
    public boolean login(String userName,String password){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;



        try {
            connection = JDBCUtil.getConn();
            System.out.println("状态是"+connection.isClosed());

            String sql = "select * from t_user where username=? and password=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();

            return resultSet.next();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }


        return false;
    }
}
