package com.ppm.dataimport;

import com.ppm.dataimport.resource.ExcelReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class DataimportApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataimportApplication.class, args);

//		// TODO code application logic here
//		File excelFile = new File("/home/iita/Kelvin/JavaProjects/dataimport/uploads/UCSF/Oct17_Jan18_UCSF_ IPD.xlsx");
//		ExcelReader er = new ExcelReader(excelFile);
//		er.getRowAsListFromExcel();
	}
}
