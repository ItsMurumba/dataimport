package com.ppm.dataimport;

//import com.ppm.dataimport.resource.ExcelReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;


//@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class DataimportApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataimportApplication.class, args);
//		File excelFile = new File("/home/iita/Kelvin/JavaProjects/dataimport/uploads/UCSF/Oct17_Jan18_UCSF_IPD.xlsx");
//		ExcelReader er = new ExcelReader(excelFile);
//		er.getRowAsListFromExcel();
	}
}
