package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */
@Entity
@Table(name = "t_account")
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler", "fieldHandler"})
@Data
public class Account {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String phone;

    private String username;

    private Integer balance;

}
