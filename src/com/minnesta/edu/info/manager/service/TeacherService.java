package com.minnesta.edu.info.manager.service;

import com.minnesta.edu.info.manager.dao.TeacherDao;
import com.minnesta.edu.info.manager.domain.Teacher;

public class TeacherService {

    private TeacherDao teacherDao  = new TeacherDao();
    public boolean addTeacher(Teacher tch){
        return teacherDao.addTeacher(tch);
    

    
    }
    public Teacher[] findAllTeacher() {
        Teacher [] tchr = teacherDao.findAllTeacher();
        boolean flag = false;
        for (int i = 0; i < tchr.length; i++) {
            Teacher tch = tchr[i];
            if (tch != null) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return tchr;
        } else {
            return null;
        }
    }
    
    public boolean isExists(String id) {
        Teacher[] tchr = teacherDao.findAllTeacher();
        boolean exists = false;
        for (int i = 0; i < tchr.length; i++) {
            Teacher teacher = tchr[i];
            if (teacher != null && teacher.getId().equals(id)) {
                exists = true;
                break;
            }
        }return exists;
    }
    public void deleteTeacherById(String delId) {
        teacherDao.deleteTeacherById(delId);
    }
    public void updateTeacher(String updateId, Teacher newTch) {
        teacherDao.updateTeacher(updateId,newTch);
    }
}
