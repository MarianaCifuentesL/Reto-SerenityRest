package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tasks.ActualizarMascota;
import static stepdefinitions.EstablecerServicio.actor;
import java.util.List;
import java.util.Map;

public class PutPetStepDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(PutPetStepDefinition.class);

    @Y("crea una petición para actualizar la mascota con el ID {string} en el recurso {string} con los siguientes datos:")
    public void actualizarMascota(String idMascota, String recurso, DataTable dataTable) {
        LOGGER.info("Actualizando la mascota con ID: " + idMascota);
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);
        actor.attemptsTo(ActualizarMascota.conDatos(recurso, datos));
    }
}
