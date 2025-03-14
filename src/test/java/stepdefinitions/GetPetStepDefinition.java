package stepdefinitions;

import io.cucumber.java.es.Y;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tasks.ConsultarMascota;

import static stepdefinitions.EstablecerServicio.actor;

public class GetPetStepDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetPetStepDefinition.class);

    @Y("crea una petición para consultar la mascota con el ID {string} en el recurso {string}")
    public void creaUnaPeticiónParaConsultarLaMascotaConElIDEnElRecurso(String idMascota, String recurso) {
        LOGGER.info("Consultando la mascota con ID: " + idMascota);
        actor.attemptsTo(ConsultarMascota.conId(idMascota, recurso));
    }
}
