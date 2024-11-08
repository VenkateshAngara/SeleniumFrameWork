package Wipro.CucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="Features",glue="Wipro.StepDefinition",monochrome=true,tags="@Regression",plugin= {"html:targets/WebsiteReport.html"})
public class EcommerceTestRunner extends AbstractTestNGCucumberTests{

}
