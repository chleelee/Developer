package com.minnesta.edu.info.manager.service;

import com.minnesta.edu.info.manager.dao.StudentDao;
import com.minnesta.edu.info.manager.domain.Student;

public class StudentService {
    

	private StudentDao studentDao = new StudentDao();
    public boolean addstudent(Student stu) {
        //上面是通过快捷键创建出来的
        //①创建StudentDao对象（此已提取到上面，已更大的作用域）
        //此处只要把接收到的学生对象stu继续向下传递给StudentDao，addstudent会有一个Boolean类型的返回，返还给StudentController
        return studentDao.addstudent(stu);
	}

    public boolean isExists(String id) {
        //创建StudentDao对象<已抽取到更大域>，①从StudentDao中获取学生对象的数组，用StudentDao调用内部方法findAllStudent，该方法用学生类型的数组[]stus接收
        
        Student[] stus = studentDao.findAllStudent();
        //预设Boolean类型的exists为false——不存在
        boolean exists = false;
        //②遍历数组中获取每一个学生对象，判断学号是否存在，如果学生对象不等于null，且得到的id与查询的id相等，exists为true，break结束。for循环结束后，返回exists
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(id)) {
                exists = true;
                break;
            }
        }return exists;
        
    }

    public Student[] findAllStudent() {
        //调用Dao对象的findAllStudent获取学生对象数组,用学生对象数组allStudent去接收
        Student[] allStudent = studentDao.findAllStudent();
        //判断数组中是否有学生信息（有：返回地址；没有；返回null。
        //思路：数组中只要有一个不是null，就代表有学生信息
        boolean flag = false;//定义一个Boolean类型的变量flag，假设里面都是null，初始值就是false
        //遍历数组，获取数组中的每一个学生对象allStudent[i]，用学生对象类型的stu接收
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if (stu != null ) {
                flag = true;
                break;
            }
        }
        //如果是true，就返回数组的内存地址allStudent
        if (flag) {
            return allStudent;    
        }else{
            return null;
        }
        
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);

    }

    public void updateStudent(String updateId, Student newStu) {
        studentDao.updateStudent(updateId,newStu);
    }
    
}
