package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "task")
@Getter
@Setter
@ToString
public class Task extends IdEntity{

    @NotBlank
    @Column(name = "tname")
    public String task_name;

    @NotNull
    @Column(name = "Deadline")
    public Date deadline;

    @Column(name = "description")
    public String description;

    @Column(name = "process")
    public boolean process;

    @NotBlank
    @Column(name = "priority")
    public String priority;

}
