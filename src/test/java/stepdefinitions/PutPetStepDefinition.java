package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Entonces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tasks.ActualizarMascota;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static questions.ActualizarMascota.conDatos;

import java.util.Map;

public class PutPetStepDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeletePetStepDefinition.class);


    @Y("crea una petición para actualizar la mascota con el ID {string} en el recurso {string} con los siguientes datos:")
    public void actualizarMascota(String idMascota, String recurso, DataTable dataTable) {
        LOGGER.info("Actualizando la mascota con ID: " + idMascota);
        Map<String, String> datos = dataTable.asMaps().get(0);
        theActorInTheSpotlight().attemptsTo(
                ActualizarMascota.conDatos(idMascota, recurso, datos)
        );
    }

    @Entonces("verifica el estado de la respuesta de dicha petición al actualizar la mascota")
    public void verificarEstadoRespuesta() {
        LOGGER.info("Verificando el estado de la respuesta de la petición");
        theActorInTheSpotlight().should(
                seeThat(conDatos(2403, "Rocky", "available"))
        );
    }
}
