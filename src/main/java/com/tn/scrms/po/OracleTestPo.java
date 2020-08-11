package com.tn.scrms.po;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: yangcs
 * @Date: 2020/5/30 9:26
 * @Description: 钉钉应用token 管理
 */

@Data
@Table(name="T_ORACLE_TEST")
public class OracleTestPo {

    @Id
    private String id;

    private String name;

    private Long phone;


}
