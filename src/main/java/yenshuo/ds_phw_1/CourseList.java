/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yenshuo.ds_phw_1;

/**
 *
 * @author yenshou
 */
public abstract class CourseList {
    
    abstract int size();
    abstract void addCourse(int i, Course course);
    abstract boolean changeCapacity(String ID, int cap);
    abstract boolean removeCourse(int i);
    abstract Course search(int i);
    
}
