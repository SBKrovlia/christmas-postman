package com.gmail.berdnik.stanislav.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

/**
 * Created by Berdniky on 27.12.2014.
 */
@Entity
@Table
public class Congratulation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @Email
    private String email;

    @Column
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
