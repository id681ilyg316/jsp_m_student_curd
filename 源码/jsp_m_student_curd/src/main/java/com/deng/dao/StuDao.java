package com.deng.dao;


import com.deng.pojo.Student;

import java.sql.SQLException;
import java.util.List;


/**
 * DAO层，Data Access Object，专门用来封装我们对于实体类的数据库的访问，就是增删改查，不加业务逻辑。
 */

public interface StuDao {

    int PAG_SIZE=5;

    public List<Student> findStudentByPage(int currentPage) throws SQLException;

    public int findStuCount() throws SQLException;

    public Student getStu(int id) throws Exception;

    public List<Student> findAll();
    
    public List<Student> findTop5();

    public int insertStu(Student student) throws SQLException;

    public int updateStu(Student student) throws SQLException;

    public int deleteStu(Integer id) throws SQLException;

    public List<Student> readStu(String name) throws SQLException;


}
