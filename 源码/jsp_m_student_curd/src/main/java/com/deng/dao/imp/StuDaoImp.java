package com.deng.dao.imp;



import com.deng.dao.StuDao;
import com.deng.pojo.Student;
import com.deng.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDaoImp implements StuDao {


    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        List<Student> list= new ArrayList<Student>();
        Connection connection = JDBCUtil.getConn();
        String sql = "select * from t_stu LIMIT ? OFFSET ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,PAG_SIZE);
        preparedStatement.setInt(2,(currentPage-1)*PAG_SIZE);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setAddr(resultSet.getString("addr"));
            student.setGender(resultSet.getString("gender"));
            list.add(student);
        }
        return list;
    }


    @Override
    public int findStuCount() throws SQLException {
        int index = 0;
        Connection connection = JDBCUtil.getConn();
        String sql = "select * from t_stu";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            index++;
        }
        JDBCUtil.release(connection, preparedStatement, resultSet);
        return index;
    }

    @Override
    public List<Student> readStu(String name) throws SQLException {

        Connection connection = JDBCUtil.getConn();
        String sql = "SELECT * FROM t_stu WHERE `name` LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String name02 = "%" + name + "%";
        preparedStatement.setString(1, name02);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Student> students = new ArrayList<Student>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setAddr(resultSet.getString("addr"));
            student.setGender(resultSet.getString("gender"));
            students.add(student);
        }

        JDBCUtil.release(connection, preparedStatement, resultSet);
        System.out.println(students);
        return students;
    }


    @Override
    public int deleteStu(Integer id) throws SQLException {
        Connection connection = JDBCUtil.getConn();
        String sql = "delete from t_stu where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int index = preparedStatement.executeUpdate();

        JDBCUtil.release(connection, preparedStatement);

        return index;
    }


    @Override
    public int updateStu(Student student) throws SQLException {
        Connection connection = JDBCUtil.getConn();
        String sql = "UPDATE t_stu set name=?,age=?,addr=?,gender=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int index = 0;

        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.setString(3, student.getAddr());
        preparedStatement.setString(4, student.getGender());
        preparedStatement.setInt(5, student.getId());

        index = preparedStatement.executeUpdate();

        JDBCUtil.release(connection, preparedStatement);

        return index;
    }

    @Override
    public Student getStu(int id) throws Exception {
        Connection connection = JDBCUtil.getConn();
        String sql = "select * from t_stu where id like ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Student student = new Student();
        if (resultSet.next()) {
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setAddr(resultSet.getString("addr"));
            student.setGender(resultSet.getString("gender"));
        }
        JDBCUtil.release(connection, preparedStatement, resultSet);

        return student;
    }

    @Override
    public int insertStu(Student student) throws SQLException {
        Connection connection = JDBCUtil.getConn();

        String sql = "INSERT into t_stu VALUES(NULL,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.setString(3, student.getAddr());
        preparedStatement.setString(4, student.getGender());

        int res = preparedStatement.executeUpdate();
        if (res > 0) {
            System.out.println("insert success");
        } else {
            System.out.println("insert default");
        }

        JDBCUtil.release(connection, preparedStatement);

        return res;

    }


    @Override
    public List<Student> findAll() {

        List<Student> list = new ArrayList<Student>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = JDBCUtil.getConn();
            System.out.println("状态是" + connection.isClosed());
            String sql = "select * from t_stu";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setAddr(resultSet.getString("addr"));
                student.setGender(resultSet.getString("gender"));

                list.add(student);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }

        return list;
    }


	@Override
	public List<Student> findTop5() {

        List<Student> list = new ArrayList<Student>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = JDBCUtil.getConn();
            System.out.println("状态是" + connection.isClosed());
            String sql = "select * from t_stu limit 0,5";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setAddr(resultSet.getString("addr"));
                student.setGender(resultSet.getString("gender"));

                list.add(student);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }

        return list;
	}
}
