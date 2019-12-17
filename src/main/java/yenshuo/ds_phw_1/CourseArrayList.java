/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yenshuo.ds_phw_1;
import java.lang.*;

/**
 *
 * @author yenshou
 */
public class CourseArrayList extends CourseList{
    private Course [] list_;
    private int size;
    
    public CourseArrayList(){
        size = 0;
    }
    
    public int size(){
        //size's getter
        return this.size;
    }
    
    public Course[] getList(){
        //list's getter
        return list_;
    }
    
    
    /*we want to make the Arraylist "dynamically", 
        but not allocate thousands of memories to it.
        so we declare a new list bigger than the origin by one
        copy data from old one to the new one, and insert sth in the new one
        and return the new list*/
    void addCourse(int i, Course course){
        int length = this.size();
        Course [] New_list = new Course[length + 1];
        
        if(length == 0){
            //if null
            New_list[0] = course;
        }
        else{
            if (i < this.size()){
                //we have to find the right place to insert.
                for(int trace_new=0, trace_old=0; trace_old < length; trace_new++){
                    if(trace_new == i){
                        New_list[trace_new] = course;
                    }
                    else{
                        New_list[trace_new] = list_[trace_old];
                        trace_old++;
                    }
                }
            }
            else{
                //just add in the tail.
                for(int trace_new=0, trace_old=0; trace_old < length; trace_new++){
                    New_list[trace_new] = list_[trace_old];
                    trace_old++;
                }
                New_list[length] = course;
            }
        }
        size++;
        list_ = New_list;
    }
    
    boolean changeCapacity(String ID, int cap){
        for(int i=0; i < this.size(); i++){
            if (list_[i] != null && list_[i].CourseID.equals(ID)){
                list_[i].capacity = cap;
                return true;
            }
        }
        return false;
    }
    boolean removeCourse(int i){
        if(i < this.size() - 1){
            Course [] New_list = new Course[this.size() - 1];
            for(int trace_old = 0, trace_new = 0; trace_old < this.size(); trace_old++){
                if(trace_old == i){
                    // because I do this dynamically, so just ignore the target
                    //do not copy it from the old one to the new one
                    continue;
                }
                New_list[trace_new] = list_[trace_old];
                trace_new ++;
            }
            list_ = New_list;
            size--;
            return true;
        }
        else{
            return false;
        }
    }
    Course search(int i){
        if (i > this.size()){
            return null;
        }
        return list_[i];
    }
}
