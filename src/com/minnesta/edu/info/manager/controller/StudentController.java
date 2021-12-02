package com.minnesta.edu.info.manager.controller;

import java.util.Scanner;

import com.minnesta.edu.info.manager.domain.Student;
import com.minnesta.edu.info.manager.service.StudentService;

public class StudentController {
    //开启学生管理系统
    private Scanner sc = new Scanner(System.in); //提取键盘录入到成员对象，并私有化
    private StudentService studentService = new StudentService();

    public void start() {
        
        //Scanner sc = new Scanner(System.in);
        loop:
        while (true) {        
            
        System.out.println("--------欢迎来到 <学生> 管理系统--------");
        System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
        int i = sc.nextInt();
        switch (i) {
            case 1:
                //System.out.println("添加学生");
                addstudent();
                break;
            case 2:
                //System.out.println("删除学生");
                deleteStudentById();
                break;
            case 3:
                //System.out.println("修改学生");
                updateStudent();
                break;
            case 4:
                //System.out.println("查看学生");
                findAllStudent();

                break;
            case 5:
                System.out.println("感谢使用学生管理系统，再见！");
                break loop;        
            default:
                System.out.println("你的输入有误，请重新输入");
                break;
        }
    }
    }

    public void updateStudent() {
        String updateId = inputStudentId();
        Student newStu = inputStudentInfo(updateId);
        studentService.updateStudent(updateId,newStu);
        System.out.println("修改成功！");

        

    }

    public void deleteStudentById() {
        String delId = inputStudentId();
        studentService.deleteStudentById(delId);
        System.out.println("删除成功！");
        
        
    }

    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("请输入学生id");
            id = sc.next();
            boolean exists = studentService.isExists(id);
            if (!exists) {
                System.out.println("你输入的id有误，请重新输入！");
            }else{
                break;
            }

        }
        return id;
    }
    public void findAllStudent() {
        //调用StudentService的findAllStudent方法，得到学生的对象数组
        Student[] stus = studentService.findAllStudent();
        //判断数组的内存地址，是否为null
        if (stus == null) {
            System.out.println("查无信息，请添加后重试");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t住址");
        //遍历数组，把学生信息打印在控制台
        for (int i = 0; i < stus.length; i++) {
            //用学生类型的对象去接收stus[i]
            Student stu = stus[i];
            //判读取出的学生信息是不是null，可能有没有装满的存在
            if(stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getAddr());
            }
        }

    }

    public void addstudent() {
        /*
        1.addstudent方法中接受用户输入的信息
        2.
        */

        
        
        String id;
        while (true) {//接收学员id和判断的代码，使用无限循环进行包裹，直至输入了不存在的id，break
            System.out.println("请输入学生id：");
            //String id = sc.next();//需要提升id作用域，把String id放到while(true)循环外
            id = sc.next();
            //判断：指派StudentService中判断id是否存在<此处★★new-object已抽取到更大的作用域>
            /*调用内部isExists方法，该方法返回Boolean类型的值 flag
            true：存在——继续循环
            false：不存在 ——终止循环*/
            boolean flag = studentService.isExists(id);
            if (flag) {
                System.out.println("你输入的学号已被占用，请重新输入");
            } else {
                break;
            }

        }
        
        Student stu = inputStudentInfo(id);
        /*将学生对象传递给StudentService的addStudent方法
            创建studentService对象，导包（StudentService）
            StudentService studentService = new StudentService(); ★★此已抽取到更大的作用域
            通过对象名去调用addStudent方法，把封装好的学生对象（stu）传入，此可返还一个Boolean类型的结果。我们用result进行接收
            */
        boolean result = studentService.addstudent(stu);
        //根据result的结果我们在控制台输出为成功或者失败
        if (result) {
            System.out.println("添加成功");//返还为true
        }else{
            System.out.println("添加失败");
        }

    }
    //以下是抽取extract出的输入方法
    public Student inputStudentInfo(String id) {
        //输入学生信息
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        String age = sc.next();
        System.out.println("请输入学生住址：");
        String addr = sc.next();
        //将学生信息封装为学生对象：用Student方法，创建学生对象
        Student stu = new Student();
        //用set方法，把数据放入
        //开闭原则：对扩展内容开放，对修改内容关闭
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setAddr(addr);
        
        return stu;
    }
}
