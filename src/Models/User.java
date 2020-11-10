/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GenericGenerator(name="civicanga" , strategy="increment")
    @GeneratedValue(generator="civicanga")
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_password")
    private String password;
    @Column(name="is_student")
    private boolean isStudent;
 
    
    public User() {
        
    }
    public User(String name,String password, boolean isStudent){
        this.name = name;
        this.password = password;
        this.isStudent = isStudent;
    }

    public User(int userId, String name, String password, boolean isStudent) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.isStudent = isStudent;
    }

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    
    
    
    

}
