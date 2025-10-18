package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/reserva_airbnb.feature",
        glue = "stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class ReservaRunner {
}
