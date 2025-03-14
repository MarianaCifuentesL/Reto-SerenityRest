package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import questions.CodigoRespuesta;
import tasks.CrearMascota;
import tasks.EliminarMascota;
import utils.Constantes;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static utils.Constantes.URL_BASE;

public class CommonStepDefinitions extends EstablecerServicio {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonStepDefinitions.class);

    @Dado("que el usuario tiene acceso al servicio de mascotas")
    public void queElUsuarioTieneAccesoAlServicio() {
        LOGGER.info("Accediendo al servicio de mascotas con la API: " + URL_BASE);
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(Constantes.ACTOR)
                        .whoCan(CallAnApi.at(URL_BASE));
        establecerServicio();
    }

    @Cuando("crea una petición para añadir una nueva mascota en el recurso {string} con los siguientes datos:")
    public void configuraPeticionNuevaMascota(String recurso, DataTable dataTable) {
        LOGGER.info("Añadiendo una nueva mascota en el recurso: " + recurso);
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);
        actor.attemptsTo(CrearMascota.conDatos(recurso, datos));
    }

    @Entonces("verifica el estado de la respuesta de dicha petición")
    public void verificaElEstadoDeLaRespuestaDeDichaPetición() {
        LOGGER.info("Verificando el estado de la respuesta de la petición");
        actor.should(
                seeThat("El código de respuesta es ",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_OK))
        );
        String responseBody = net.serenitybdd.rest.SerenityRest.lastResponse().body().asString();
        LOGGER.info("Respuesta del servicio: " + responseBody);
    }

    @Y("revierte la creación de la mascota con el ID {string} en el recurso {string} para dejar el sistema en su estado original")
    public void revierteLaCreaciónDeLaMascotaConElIDEnElRecursoParaDejarElSistemaEnSuEstadoOriginal(String idMascota, String recursos) {
        LOGGER.info("Revirtiendo la creación de la mascota con ID: " + idMascota);
        actor.attemptsTo(EliminarMascota.conId(idMascota, recursos));
    }
}
