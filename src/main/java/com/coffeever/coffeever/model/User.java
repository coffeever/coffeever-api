package com.coffeever.coffeever.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user1")
public class User {

    @Id
    private long google_id;

    @Column
    private String name;

    @Column
    private String mail;






}
