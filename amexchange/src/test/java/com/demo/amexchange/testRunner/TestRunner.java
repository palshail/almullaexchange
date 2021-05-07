package com.demo.amexchange.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Feature/",
				glue = "com.demo.amexchange.stepdefination",
				dryRun = false,
				monochrome = true,
				plugin = {"pretty","html:test-output.html"},
				tags = "@highleveltest"
				)
public class TestRunner {

}
