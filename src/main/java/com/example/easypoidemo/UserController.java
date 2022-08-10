package com.example.easypoidemo;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.wps.service.EasyPoiWpsFileUtil;
import com.example.easypoidemo.vo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    /**
     * 处理Excel解析的方法
     *
     * @param file 前台上传的文件对象
     * @return
     */
    @RequestMapping(value = "/importExcel")
    @ResponseBody
    public String importExcel(@RequestParam("file") MultipartFile file) throws Exception {

        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
//        params.setSheetNum(1);
        List<User> objects = ExcelImportUtil.importExcel(file.getInputStream(), User.class, params);
 System.out.println(objects);

        return "成功";
    }

}
