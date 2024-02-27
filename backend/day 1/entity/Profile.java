package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="register")

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Name",nullable=false)
    private String name;

    @Column(name="Email",nullable=false,unique=true)
    private String email;

    @Column(name="Gender",nullable=false)
    private String gender;

    @Column(name="Age",nullable=false)
    private Long age;

    @Lob
    @Column(name="Image",nullable = false)
    private byte[] image;
}
