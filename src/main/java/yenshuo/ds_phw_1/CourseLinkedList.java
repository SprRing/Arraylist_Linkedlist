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
public class CourseLinkedList extends CourseList{
    
    private int size;
    
    private Node first; // declare a header
    
    public CourseLinkedList(){
        size = 0;
    }
    
    public Node getfirst(){
        //first's getter
        return first;
    }
   
    public int size(){
        //size's getter
        return this.size;
    }
    public void addCourse(int i, Course course){
        Node record = new Node(course); //use a node to record the resource we need to insert
        if(first == null){ 
            // if linkedlist is null, just add.
            first = record;
        }
        else{
            Node node = this.getfirst();
            if(i == 0){ 
                // the condition that we need to insert in the beginning
                record.next = first;
                first = record;
            }
            else if(i != 0 && i < this.size()){ 
                // the condition that we need to insert in the middle
                for(int j=0; j < i; j++){ // search
                    if(j == i){
                        record.next= node.next;
                        node.next = record;
                    }
                    node = node.next;
                }
            }
            else if(i >= this.size()) {
                // if out of bound, just insert in the last.
                while(node.next != null){
                    node = node.next;
                }
                node.next = record; 
                record.next = null;
            }
        }
        size ++ ;
    }
    
    public boolean changeCapacity(String ID, int cap){
        if(first == null){
            return false;
        }
        Node node = this.getfirst();
        while(node != null){
            if(node.course.CourseID.equals(ID)){
                node.course.capacity = cap;
                return true;
            }
            node = node.next; // search
        }
        return false;
    }
    
    public boolean removeCourse(int i){
            if(i < this.size()){
                //we're sure that we have to link the prior and the following one
                Node node = this.getfirst();
                for(int j=0; j < i; j++){
                    if(j == i-1){
                        node.next = node.next.next;
                    }
                    node = node.next;
                }
                size--;
                return true;
            }
            else if(i == this.size()){ 
                // just delete the last
                Node node = this.getfirst();
                for(int j=0; j < i-1; j++){
                    node = node.next;
                }
                node.next = null;
                return true;
            }
            else{ 
                return false;
            }
    }
    
    public Course search(int i){
        if(i > this.size()){
            return null;
        }
        int count = 0;
        Node node = this.getfirst();
        while(count < i){
            node = node.next;
            count++;
        }
        return node.course;     
    }
}
