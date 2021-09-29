package com.ssm.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ExcelUtil {
    public static final String XLSX = ".xlsx";
    public static final String XLS = ".xls";

    public static JSONArray readExcel(File file) throws IOException, InvalidFormatException {
        int res = checkFile(file);
        if (res == 0){
            throw new NullPointerException("this is null file");
        }else if (res == 1){
            return readXlsx(file);
        }else if (res == 2){
            return readXls(file);
        }
        throw new IllegalAccessError("the file["+file.getName()+"] is not excel file.");
    }

    /**
     * 判断文件
     * @param file
     * @return
     */
    public static int checkFile(File file){
        if (file == null){
            return 0;
        }
        String fileName = file.getName();
        if (fileName.endsWith(XLSX)){
            return 1;
        }
        if (fileName.endsWith(XLS)){
            return 2;
        }
        return 3;
    }

    public static JSONArray readXlsx(File file) throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        return read(sheet,workbook);
    }

    public static JSONArray readXls(File file) throws IOException {
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file));
        Workbook workbook = new HSSFWorkbook(poifsFileSystem);
        Sheet sheet = workbook.getSheetAt(0);
        return read(sheet,workbook);
    }

    public static JSONArray read(Sheet sheet,Workbook workbook) throws IOException {
        int rowStart = sheet.getFirstRowNum();
        int rowEnd = sheet.getLastRowNum();
        if (rowStart == rowEnd){
            workbook.close();
            return new JSONArray();
        }

        Row firstRow = sheet.getRow(rowStart);
        int cellStart = firstRow.getFirstCellNum();
        int cellEnd = firstRow.getLastCellNum();
        Map<Integer,String> map = new HashMap<>();
        for (int j = cellStart;j < cellEnd;j++){
            map.put(j,getValue(firstRow.getCell(j),rowStart,j,workbook,true));
        }
        JSONArray array = new JSONArray();
        for (int i = rowStart+1;i <= rowEnd;i++){
            Row eachRow = sheet.getRow(i);
            JSONObject jsonObject = new JSONObject();
            StringBuffer buffer = new StringBuffer();
            for (int k = cellStart;k<cellEnd;k++){
                if (eachRow != null){
                    String val = getValue(eachRow.getCell(k),i,k,workbook,false);
                    buffer.append(val);
                    jsonObject.put(map.get(k),val);
                }
            }
            if (buffer.toString().length() > 0){
                array.add(jsonObject);
            }
        }
        workbook.close();
        return array;
    }
    public static String getValue(Cell cell,int rowNum,int index,Workbook workbook,boolean isKey) throws IOException {
        if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK){
            if (isKey){
                workbook.close();
                throw new NullPointerException();
            }else {
                return "";
            }
        }

        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            if (HSSFDateUtil.isCellDateFormatted(cell)){
                Date date = cell.getDateCellValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dateFormat.format(date);

            }
            String val = cell.getNumericCellValue()+"";
            val = val.toUpperCase();
            if (val.contains("E")){
                val = val.split("E")[0].replace(".","");
            }
            return val;
        }

        if (cell.getCellType() == Cell.CELL_TYPE_STRING){
            String val = cell.getStringCellValue();
            if (val == null || val.trim().length() == 0){
                if (workbook != null){
                    workbook.close();
                }
                return "";
            }
            return val.trim();
        }

        if (cell.getCellType() == Cell.CELL_TYPE_FORMULA){
            return cell.getStringCellValue();
        }
        if (cell.getCellType() ==  Cell.CELL_TYPE_BOOLEAN){
            return cell.getBooleanCellValue()+"";
        }
        return "";
    }
}
