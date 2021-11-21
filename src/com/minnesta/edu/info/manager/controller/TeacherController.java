package com.minnesta.edu.info.manager.controller;


import java.util.Scanner;

import com.minnesta.edu.info.manager.domain.Teacher;
import com.minnesta.edu.info.manager.service.TeacherService;

public class TeacherController {

    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();
    public void start() {
        loop:
        while (true) {
            
        System.out.println("--------欢迎来到 <教师> 管理系统--------");
        System.out.println("请输入您的选择: 1.添加教师  2.删除教师  3.修改教师  4.查看教师  5.退出");

        String key = sc.next();
        switch (key) {
            case "1":
                addTeacher();
                break;
            case "2":
                deleteTeacherById();
                break;
            case "3":
                updateTeacher();
                break;
            case "4":
                findAllTeacher();
                break;
            case "5":
                System.out.println("感谢使用教师管理系统，再见！");
                break loop;
            default:
                System.out.println("你的输入有误，请重新输入");
                break;
        }
    }
    
    }
    public void updateTeacher() {
        String updateId =inputTeacherId();
        Teacher newTch = inputTeacherInfo(updateId); 
        teacherService.updateTeacher(updateId,newTch);
        System.out.println("Modify successfully");

    }
    public void deleteTeacherById() {
        
        String delId = inputTeacherId();
        teacherService.deleteTeacherById(delId);
        System.out.println("Teacher was successfully deleted.");
    }
    private String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("Please type which teacher's ID you want to delete:");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if (!exists) {
                System.out.println("The Id you entered was wrong, please enter another one again");
            } else {
                break;
            }
        }
        return id;
    }
    public void findAllTeacher() {
        
        Teacher[] tchr = teacherService.findAllTeacher();
        if (tchr == null) {
            System.out.println("No relevant information was found");
            return;
        } 
        System.out.println("ID \t NAME \t AGE \t ADDRESS");
        
        for (int i = 0; i < tchr.length; i++) {
            Teacher tch = tchr[i];
            if (tch != null) {
                System.out.println(tch.getId() + "\t" + tch.getName() + "\t" + tch.getAge() + "\t" + tch.getAddr());
            }
            
        }


    }
    public void addTeacher() {
        String id;
        while (true) {
            System.out.println("Please input Id:");
            id = sc.next();
            boolean flag = teacherService.isExists(id);
            if (flag) {
                System.out.println("The teacher'id you entered has been occupied, please enter another one again");
            } else {
                break;
            }
        }

        Teacher tch = inputTeacherInfo(id);
       
        boolean result = teacherService.addTeacher(tch);
        if (result) {
            System.out.println("Your information added successfully");
        } else {
            System.out.println("Add information failed");
        }
    }
    private Teacher inputTeacherInfo(String id) {
        System.out.println("Please input Name");
        String name = sc.next();
        System.out.println("Please input your Age");
        String age = sc.next();
        System.out.println("Please input your Address");
        String addr = sc.next();
        Teacher tch = new Teacher();
        
        tch.setId(id);
        tch.setName(name);
        tch.setAge(age);
        tch.setAddr(addr);
        return tch;
    }
    

}
