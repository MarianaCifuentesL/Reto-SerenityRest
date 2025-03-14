package stepdefinitions;

import io.cucumber.java.es.Y;
import tasks.EliminarMascota;

import static stepdefinitions.EstablecerServicio.actor;

public class DeletePetStepDefinition {

    @Y("crea una petición para eliminar la mascota con el ID {string} en el recurso {string}")
    public void creaUnaPeticiónParaEliminarLaMascotaConElIDEnElRecurso(String idMascota, String recurso) {
        actor.attemptsTo(EliminarMascota.conId(idMascota, recurso));
    }
}
