package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "steps",
        plugin = {
        "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
        "progress",
        "summary"
}
)

public class CucumberTest extends AbstractTestNGCucumberTests {
}