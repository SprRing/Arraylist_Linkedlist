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
public class Course {
    public String CourseID;
    public Integer capacity;
   
    public Course(String CourseID, Integer capacity){
        this.CourseID = CourseID;
        this.capacity = capacity;
    }
    
    public String getCourseID(){ //ID getter 
        return this.CourseID;
    }
    public int getCapacity(){ //capacity getter
       return this.capacity;
    }
}
