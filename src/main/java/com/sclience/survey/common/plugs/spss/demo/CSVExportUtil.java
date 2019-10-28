package com.sclience.survey.common.plugs.spss.demo;

import com.pmstation.spss.SPSSWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class CSVExportUtil {

	private String xlsFileName;
	private String path;
	private  OutputStream out;
	private  SPSSWriter outSPSS;

	public CSVExportUtil(String fileName,String path) {
		try {
			this.xlsFileName = fileName;
			this.path=path;
			this.out= new FileOutputStream(path+fileName);
			outSPSS = new SPSSWriter(out, "windows-1252");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
