package com.example.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.easyexcel.model.UserExcelModel;
import com.example.easyexcel.utils.DateFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 下载模板
     */
    @GetMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("excelTemplate/物美报货单模板.xls");
        InputStream inputStream = classPathResource.getInputStream();
        Workbook workbook = new HSSFWorkbook(inputStream);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode("物美报货单模板.xls", "utf-8"));
        response.setHeader("Access-Control-Expose-Headers", "content-Disposition");
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


    /**
     * 下载模板
     */
    @PostMapping("/test")
    public String test(@RequestBody List<String> listString) {
        System.out.println(listString);
        return listString.toString();
    }

    /**
     * 导出数据
     */
    @GetMapping("/exportData")
    public void exportData(HttpServletResponse response) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();

        String[] columnNames = {"用户名", "年龄", "手机号", "性别"};

        Sheet sheet = workbook.createSheet();
        Font titleFont = workbook.createFont();
        titleFont.setFontName("simsun");
        titleFont.setBold(true);
        titleFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        titleStyle.setFont(titleFont);

        Row titleRow = sheet.createRow(0);

        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(titleStyle);
        }

        //模拟构造数据
        List<UserExcelModel> dataList = new ArrayList<>();
        dataList.add(new UserExcelModel("张三", 12, "13867098765", "男"));
        dataList.add(new UserExcelModel("张三1", 12, "13867098765", "男"));
        dataList.add(new UserExcelModel("张三2", 12, "13867098765", "男"));
        dataList.add(new UserExcelModel("张三3", 12, "13867098765", "男"));

        //创建数据行并写入值
        for (int j = 0; j < dataList.size(); j++) {
            UserExcelModel userExcelModel = dataList.get(j);
            int lastRowNum = sheet.getLastRowNum();
            Row dataRow = sheet.createRow(lastRowNum + 1);
            dataRow.createCell(0).setCellValue(userExcelModel.getName());
            dataRow.createCell(1).setCellValue(userExcelModel.getAge());
            dataRow.createCell(2).setCellValue(userExcelModel.getMobile());
            dataRow.createCell(3).setCellValue(userExcelModel.getSex());
        }
        response.setContentType("application/vnd.ms-excel");
        String dateTime = DateFormatUtil.convertStringByDateTime(new Date());
        response.setHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(dateTime + ".xlsx", "utf-8"));
        response.setHeader("Access-Control-Expose-Headers", "content-Disposition");
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    @PostMapping("/readExcel")
    public List<UserExcelModel> readExcel(@RequestParam("file") MultipartFile file) {
        List<UserExcelModel> list = new ArrayList<>();
        try {
            list = EasyExcel.read(file.getInputStream(), UserExcelModel.class, new ModelExcelListener()).sheet().doReadSync();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static class ModelExcelListener extends AnalysisEventListener {
        private List<Object> datas = new ArrayList<>();

        /**
         * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
         */
        @Override
        public void invoke(Object data, AnalysisContext context) {
            //数据存储到list，供批量处理，或后续自己业务逻辑处理。
            log.info("读取到数据{}", data);
            datas.add(data);
            //根据业务自行处理，可以写入数据库等等
        }

        //所以的数据解析完了调用
        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            log.info("所有数据解析完成");
        }
    }
}
