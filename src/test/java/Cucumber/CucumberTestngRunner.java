package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Cucumber runs depends upon testng or Junit 
@CucumberOptions(features="src/test/java/Cucumber", glue="FrameworkPractice.StepDefinations",
monochrome=true, tags ="@ErrorValidation", plugin= {"html:target/cucumber.html"})
//features is to give the path of feature file.
// glue is to give the path of step-definition.
// monochrome is return the reports in readable manner.
//plugin is to give the path where report will be store.
public class CucumberTestngRunner extends AbstractTestNGCucumberTests{
	
	// When use profile in pom.xml to run by maven command then use **/ its means where ever the file is in project and then filename.

}
