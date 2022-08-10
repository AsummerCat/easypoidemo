package com.example.easypoidemo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class User {

    @Excel(name = "名称",orderNum="1",width = 25)
    private String name;
    @Excel(name = "机构",orderNum="1",width = 25)

    private String orgId;
    @Excel(name = "身份证",orderNum="1",width = 25)
    private String idCard;
}
