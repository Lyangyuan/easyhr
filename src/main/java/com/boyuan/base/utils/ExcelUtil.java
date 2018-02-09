package com.boyuan.base.utils;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/4
 */
public class ExcelUtil {

    public static String prefix = ".xlsx";

    public static int cellWidth = 6000;

    public static String defaultSheetName = "默认sheet";

    /**
     * 生成excel
     */
    public static String createExcel(List<String> header,List<List<String>> data,String savePath,String fileName){
        HSSFWorkbook workbook = new HSSFWorkbook();
        if(CollectionUtils.isEmpty(header) || CollectionUtils.isEmpty(data)){
            return null;
        }
        int columeCount = header.size();
        HSSFSheet sheet = workbook.createSheet(defaultSheetName);

        HSSFRow headRow = sheet.createRow(0);
        HSSFCell cell;
        for (int i = 0; i < columeCount; i++) {
            cell = headRow.createCell(i);
            // 单元格类型都设置为string
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            // 宽度
            sheet.setColumnWidth(i, cellWidth);
            cell.setCellValue(header.get(i));
        }

        int index = 1;
        for (List<String> datum : data) {
            HSSFRow row = sheet.createRow(index);
            for (int i = 0; i < datum.size(); i++) {
                row.createCell(i);
                row.getCell(i).setCellValue(datum.get(i));
            }
            index++;
        }

        if(!fileName.endsWith(prefix)){
            fileName = fileName + prefix;
        }
        String path = savePath +"/"+fileName;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static void main(String[] args) {
        String savePath = "D:";
        String fileName = "excel_test.xlsx";
        List<String> head = Arrays.asList("col1","col2","col3");
        List<List<String>> data = new ArrayList<List<String>>();
        List<String> row = Arrays.asList("val1","val2","val2");
        List<String> row2 = Arrays.asList("val1","val2","val2");
        data.add(row);
        data.add(row2);
        String path = createExcel(head,data,savePath,fileName);
        System.out.println(path);
    }
}
