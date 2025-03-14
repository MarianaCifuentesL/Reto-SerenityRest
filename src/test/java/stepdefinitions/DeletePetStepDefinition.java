package stepdefinitions;

import io.cucumber.java.es.Y;
import tasks.EliminarMascota;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static stepdefinitions.EstablecerServicio.actor;

public class DeletePetStepDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeletePetStepDefinition.class);

    @Y("crea una petición para eliminar la mascota con el ID {string} en el recurso {string}")
    public void creaUnaPeticiónParaEliminarLaMascotaConElIDEnElRecurso(String idMascota, String recurso) {
        LOGGER.info("Eliminando la mascota con ID: " + idMascota);
        actor.attemptsTo(EliminarMascota.conId(idMascota, recurso));
    }
}