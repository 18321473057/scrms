package com.tn.scrms.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: yangcs
 * @Date: 2020/6/16 15:53
 * @Description:
 */

@Data
@Table(name = "t_crms_test")
public class CrmsTestPo {

    // 主键 自动递增
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    private Long phone;
 
}
