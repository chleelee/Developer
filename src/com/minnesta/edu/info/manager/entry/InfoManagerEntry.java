package com.minnesta.edu.info.manager.entry;

import java.util.Scanner;

import com.minnesta.edu.info.manager.controller.OtherStudentController;
import com.minnesta.edu.info.manager.controller.TeacherController;

public class infoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
        System.out.println("--------欢迎来到明尼苏达信息管理系统--------");
        System.out.println("请输入您的选择: 1.学生管理  2.老师管理  3.退出");
        
        int i = sc.nextInt();
        switch (i) {
            case 1:
                //创建studentController对象，通过此对象.✘✘✘调用start方法
                OtherStudentController studentController = new OtherStudentController();
                studentController.start();
                break;
            case 2:  //删除System.out.println("老师管理");
                TeacherController teacherController = new TeacherController();
                teacherController.start();
                break;
            case 3:
                System.out.println("感谢你的使用");
                System.exit(0);//退出当前正在运行的JVM虚拟机，关闭运行代码的平台
                break;        
            default:
                System.out.println("你的输入有误，请重新输入");
                break;
        }
    }
    }
}
