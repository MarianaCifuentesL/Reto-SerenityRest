package stepdefinitions;

import io.cucumber.java.es.Y;
import tasks.ConsultarMascota;

import static stepdefinitions.EstablecerServicio.actor;

public class GetPetStepDefinition {

    @Y("crea una petición para consultar la mascota con el ID {string} en el recurso {string}")
    public void creaUnaPeticiónParaConsultarLaMascotaConElIDEnElRecurso(String idMascota, String recurso) {
        actor.attemptsTo(ConsultarMascota.conId(idMascota, recurso));
    }
}
