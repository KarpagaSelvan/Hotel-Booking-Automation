package com.reporting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClassCucumber;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see To Generates JVM Report
 */
public class Reporting extends BaseClassCucumber {

	/**
	 * @param jsonFile
	 * @throws IOException
	 * @see To provide destination path and details to generate JVM Reports
	 */
	public static void generatesJvmReports(String jsonFile) throws IOException {

		// 1.Mention the path of the JVM Report
		File file = new File(System.getProperty("user.dir") + getPropertyFileValue("jvmpath"));

		// 2.Create Object for Configuration Class
		Configuration configuration = new Configuration(file, "Adactin Hotel");

		// 3.Mention the Browser, Version, OS, Sprint, Types of Testing for JVM
		// Visbility
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser Version", "105");
		configuration.addClassifications("OS", "WIN10");
		configuration.addClassifications("Sprint", "32");
		configuration.addClassifications("Testing", "Regression");

		// 4.Create Object for Report Builder Class ---> To pass json file

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

		// 5.Read results from json file report and generate JVM Report
		builder.generateReports();

	}

}
