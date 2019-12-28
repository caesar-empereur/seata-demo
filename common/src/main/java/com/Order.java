package com;

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
@Table(name = "t_order")
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler", "fieldHandler"})
@Data
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String skuId;

    private Integer totalPrice;

    private String accountId;

}
