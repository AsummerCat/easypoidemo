package com.example.easypoidemo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

@Data
public class User {

    @Excel(name = "机构名称",orderNum="1",width = 25)
    private String name;
    @Excel(name = "手机号",orderNum="2",width = 25)
    private String telphone;
    @Excel(name = "企业地址",orderNum="3",width = 25)
    private String address;
}
