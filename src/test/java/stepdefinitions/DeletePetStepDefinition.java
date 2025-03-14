package stepdefinitions;

import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import questions.MensajeEliminacion;
import tasks.EliminarMascota;
import static com.google.common.base.Predicates.equalTo;
import static stepdefinitions.EstablecerServicio.actor;

public class DeletePetStepDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeletePetStepDefinition.class);

    @Y("crea una petición para eliminar la mascota con el ID {string} en el recurso {string}")
    public void creaUnaPeticiónParaEliminarLaMascotaConElIDEnElRecurso(String idMascota, String recurso) {
        LOGGER.info("Eliminando la mascota con ID: " + idMascota);
        actor.attemptsTo(EliminarMascota.conId(idMascota, recurso));
    }

    @Y("verifica que la mascota con el ID {string} ha sido eliminada correctamente")
    public void verificaQueLaMascotaHaSidoEliminada(String idMascota) {
        LOGGER.info("Verificando que la mascota con ID " + idMascota + " fue eliminada");

        actor.should(
                GivenWhenThen.seeThat("La mascota ha sido eliminada",
                        MensajeEliminacion.esElId(idMascota), equalTo(true))
        );
    }
}
