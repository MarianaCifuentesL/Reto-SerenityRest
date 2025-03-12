package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.CodigoRespuesta;
import tasks.RegistrarMascota;
import utils.Constantes;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public class SwaggerPetstoreStepDefinition extends EstablecerServicio {

    @Dado("que el usuario tiene acceso al servicio de mascotas")
    public void queElUsuarioTieneAccesoAlServicio() {
        OnStage.setTheStage(new OnlineCast()); // Inicializa el entorno de Serenity
        establecerServicio(Constantes.URL_BASE); // Establece la URL base
    }

    @Cuando("configura la petición para añadir una nueva mascota en el recurso {string} con los siguientes datos:")
    public void configuraPeticionNuevaMascota(String recurso, DataTable dataTable) {
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class); // ✅ CAMBIO AQUÍ
        actor.attemptsTo(RegistrarMascota.enElRecursoConDatos(recurso, datos));
    }


    @Entonces("la mascota se registra exitosamente con código {int}")
    public void validarRegistroMascota(int codigoEsperado) {
        restAssuredThat(response -> response.statusCode(codigoEsperado));
    }

    @Entonces("verifica el estado de la respuesta de dicha petición")
    public void verificaElEstadoDeLaRespuestaDeDichaPetición() {
        actor.should(
                seeThat("El código de respuesta es ",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_OK))
        );
    }
}
