package com.example.easypoidemo;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.easypoidemo.vo.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
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
        params.setSheetNum(1);
        List<User> objects = ExcelImportUtil.importExcel(file.getInputStream(), User.class, params);
        System.out.println(objects);

        return "成功";
    }

    /**
     * 导出
     *
     * @return
     */
    @RequestMapping(value = "/reportExcel")
    @ResponseBody
    public String reportExcel(HttpServletResponse response) throws Exception {

        try {
            // 告诉浏览器用什么软件可以打开此文件
            response.setHeader("content-Type", "application/vnd.ms-excel");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("测试数据表", "UTF-8") + ".xls");
            //编码
            response.setCharacterEncoding("UTF-8");
            //ExcelExportUtil.exportExcel()方法的第二个参数为对应实体class对象，第三个参数为对应实体的list集合
            List<User> users = new ArrayList<>();
            User user = new User();
            User use1 = new User();
            user.setName("测试1");
            use1.setName("测试1");
            user.setAddress("地址1");
            use1.setAddress("地址2");
            user.setTelphone("131");
            use1.setTelphone("132");
            users.add(user);
            users.add(use1);
            //基本导出
//            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), User.class, users);

//            //设置表头
            ExportParams exportParams = new ExportParams();
            exportParams.setTitle("哈哈哈");
//            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, users);

            //或者
            Workbook workbook =ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","第一页"), User.class, users);

            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "成功";
    }

}
