package runners;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.ReportGenerator;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        publish = true,
        monochrome = true
)
public class TestRunner {
//create another prettier report with masterthroughreport
	@AfterClass
	public static void generateReport() {
	    List<String> jsonFiles = new ArrayList<>();
	    String jsonPath = System.getProperty("user.dir") + "/target/cucumber.json";
	    jsonFiles.add(jsonPath);

	    ReportGenerator.generateMasterthoughtReport("JPetStore Automation Report", jsonFiles);
	}
}
