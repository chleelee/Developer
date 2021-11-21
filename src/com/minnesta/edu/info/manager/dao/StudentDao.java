package com.minnesta.edu.info.manager.dao;

import com.minnesta.edu.info.manager.domain.Student;

public class StudentDao {
    //创建学生数组Student[]
    private static Student[] stus = new Student[10];
    //使用static，把stus变成静态共享数据
    public boolean addstudent(Student stu) {
        //定义索引变量index=-1，假设数组已经全部存满，没有null的元素
        int index = -1;
        //遍历学生数组
        for (int i = 0; i < stus.length; i++) {
            //取出学生对象
            Student student = stus[i];
            //如果当前的学生对象==null
            if (student == null) {
                //index变量记录当前的索引位置
                index = i;
                //用break结束掉当前的循环
                break;
            }
        }
        //如果遍历完成，index值仍是-1，就意为数组已满，就return false结果
        if (index == -1) {
            return false;
        }else{
            //没有住满，正常添加“数组名stus[索引]=学生对象stu，并返回true的结果
            stus[index] = stu;
            return true;
        }
        
    }

    public Student[] findAllStudent() {
        //就是返回学生数组stus
        return stus;
    }


    public void deleteStudentById(String delId) {

        int index = getIndex(delId);
        stus[index] = null;
    }
    //根据id找索引的代码抽取成一个方法来实现
    public int getIndex(String id){
        //假设id不存在
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }

        }
        return index;


    }

    public void updateStudent(String updateId, Student newStu) {
        int index = getIndex(updateId);
        stus[index] = newStu;


    }
    
}
