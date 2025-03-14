package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.CodigoRespuesta;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public class CommonStepDefinitions extends EstablecerServicio {

    @Dado("que el usuario tiene acceso al servicio de mascotas")
    public void queElUsuarioTieneAccesoAlServicio() {
        OnStage.setTheStage(new OnlineCast()); // Inicializa el entorno de Serenity
        establecerServicio(); // Establece la URL base
    }

    @Entonces("verifica el estado de la respuesta de dicha petición")
    public void verificaElEstadoDeLaRespuestaDeDichaPetición() {
        actor.should(
                seeThat("El código de respuesta es ",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_OK))
        );

        String responseBody = net.serenitybdd.rest.SerenityRest.lastResponse().body().asString();
        System.out.println("Respuesta del servicio: " + responseBody);
    }
}
