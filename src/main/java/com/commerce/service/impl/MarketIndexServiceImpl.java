package com.commerce.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.commerce.dao.IMarketIndexDao;
import com.commerce.service.IMarketIndexService;

@Service
@Component
public class MarketIndexServiceImpl implements IMarketIndexService {

	@Autowired
	IMarketIndexDao marketIndexDao;
	
	@Override
	public String importFile(MultipartFile file) {//.xls
		Integer num = 0;
		StringBuffer errMsg = new StringBuffer();
		HSSFWorkbook workbook = null;
		Map<String, Object> params = new HashMap<String, Object>();
		String result = null;
		JSONObject resultJson = null;
		try {
			workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
		} catch (IOException e1) {
			throw new RuntimeException("读取文件失败");
		}
		int sheets = workbook.getNumberOfSheets();
		if (sheets < 1) {
			throw new RuntimeException("文件无内容");
		}
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rows = workbook.getSheetAt(0).getPhysicalNumberOfRows();
		if (rows < 2) {
			throw new RuntimeException("文件无内容");
		}
		for (int j = 0; j < rows; j++) {
			try {
				if (j == 0) {
					continue;
				}
				int cells = sheet.getRow(j).getPhysicalNumberOfCells();
				if (cells < 2) {
					continue;
				}
				sheet.getRow(j).getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(1).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(3).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(4).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(6).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(7).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(9).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(10).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(12).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(13).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(15).setCellType(Cell.CELL_TYPE_NUMERIC);
				sheet.getRow(j).getCell(16).setCellType(Cell.CELL_TYPE_NUMERIC);
			} catch (Exception e) {
				errMsg.append("列表中第" + j + "行出错:");
				errMsg.append(e.getMessage());
			}
		}
		return "成功导入" + num + "条数据.   " + errMsg.toString();

	}

}
