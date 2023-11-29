package com.deng;

import com.deng.dao.StuDao;
import com.deng.dao.imp.StuDaoImp;
import com.deng.pojo.Student;
import org.junit.Test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testMain {

    @Test
    public void testPage() throws SQLException {
        StuDao stuDao = new StuDaoImp();
        List<Student> list = new ArrayList<Student>();
        list = stuDao.findStudentByPage(1);
        System.out.println(list);
    }

    @Test
    public void testCount() throws SQLException {
        StuDao stuDao = new StuDaoImp();
        System.out.println(stuDao.findStuCount());
    }

    @Test
    public void testInsert() throws SQLException {
        StuDao stuDao = new StuDaoImp();
        Student student = new Student();
        student.setName("张宝庆");
        student.setAge(18);
        student.setAddr("成都");
        student.setGender("boy");
        int index = stuDao.insertStu(student);
        System.out.println(index);
    }

    @Test
    public void testQuery() throws SQLException, Exception {
        int id = 3;
        StuDao stuDao = new StuDaoImp();
        Student student;
        student = stuDao.getStu(id);
        System.out.println(student);
    }

    @Test
    public void testUpdate() throws SQLException, Exception {
        StuDao stuDao = new StuDaoImp();
        Student student = new Student();
        student.setId(18);
        student.setName("张宝庆");
        student.setAge(18);
        student.setAddr("成都");
        student.setGender("boy");
        int a = stuDao.updateStu(student);
        System.out.println(a);

    }

    @Test
    public void testDelete() throws SQLException, Exception {
        StuDao stuDao = new StuDaoImp();
        stuDao.deleteStu(18);
    }

    @Test
    public void testRead() throws SQLException, Exception {
        StuDao stuDao = new StuDaoImp();
        List<Student> list = stuDao.readStu("z");
        System.out.println(list);
    }
}
