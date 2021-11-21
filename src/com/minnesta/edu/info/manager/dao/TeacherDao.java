package com.minnesta.edu.info.manager.dao;

import com.minnesta.edu.info.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] tchr =  new Teacher[10];
    public boolean addTeacher(Teacher tch) {
        int index = -1;
        for (int i = 0; i < tchr.length; i++) {
            Teacher teacher = tchr[i];
            if (teacher == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }else{
            tchr[index] = tch;
            return true;
        }

    }
    public Teacher[] findAllTeacher() {
        return tchr;
    }
    public void deleteTeacherById(String delId) {
        int index = getIndex(delId);
        tchr[index] = null;

    }
    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < tchr.length; i++) {
            Teacher tch = tchr[i];
            if (tch != null && tch.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void updateTeacher(String updateId, Teacher newTch) {
        int index = getIndex(updateId);
        tchr[index] = newTch;
    }
    
    
}
