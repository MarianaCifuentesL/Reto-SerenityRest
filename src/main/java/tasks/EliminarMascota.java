package tasks;

import interactions.DeletePeticion;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarMascota implements Task {

    private final String idMascota;
    private final String recurso;

    public EliminarMascota(String idMascota, String recurso) {
        this.idMascota = idMascota;
        this.recurso = recurso;
    }

    @Step("{0} elimina la mascota con ID #idMascota")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                DeletePeticion.deletePeticion(recurso + "/" + idMascota)
        );
    }

    public static EliminarMascota conId(String idMascota, String recurso) {
        return instrumented(EliminarMascota.class, idMascota, recurso);
    }
}