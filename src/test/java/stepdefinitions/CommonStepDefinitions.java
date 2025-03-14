package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import questions.CodigoRespuesta;
import utils.Constantes;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public class CommonStepDefinitions extends EstablecerServicio {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeletePetStepDefinition.class);

    @Dado("que el usuario tiene acceso al servicio de mascotas")
    public void queElUsuarioTieneAccesoAlServicio() {
        LOGGER.info("Accediendo al servicio de mascotas con la API: " + Constantes.URL_BASE);
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(Constantes.ACTOR)
                        .whoCan(CallAnApi.at(Constantes.URL_BASE));
        establecerServicio();
    }

    @Entonces("verifica el estado de la respuesta de dicha petición")
    public void verificaElEstadoDeLaRespuestaDeDichaPetición() {
        LOGGER.info("Verificando el estado de la respuesta de la petición");
        actor.should(
                seeThat("El código de respuesta es ",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_OK))
        );

        String responseBody = net.serenitybdd.rest.SerenityRest.lastResponse().body().asString();
        System.out.println("Respuesta del servicio: " + responseBody);
    }
}
