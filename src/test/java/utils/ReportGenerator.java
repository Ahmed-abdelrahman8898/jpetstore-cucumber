package utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.json.support.Status;

import java.io.File;
import java.util.Collections;
import java.util.List;
public class ReportGenerator {
	  public static void generateMasterthoughtReport(String projectName, List<String> jsonFiles) {

	        File reportOutputDirectory = new File("target");

	        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
	        configuration.setBuildNumber("1");
	        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
	        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));

	        configuration.addClassifications("Platform", "Windows");
	        configuration.addClassifications("Browser", "Chrome");
	        configuration.addClassifications("Build", "1.0");

	        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	        reportBuilder.generateReports();
	    }

}
