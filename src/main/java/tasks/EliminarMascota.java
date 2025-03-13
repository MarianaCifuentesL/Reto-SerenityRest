package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarMascota implements Task {

    private final String idMascota;

    public EliminarMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    @Step("{0} elimina la mascota con ID #idMascota")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.from(idMascota)
                .with(request -> request)
        );
        SerenityRest.lastResponse().prettyPrint(); // Muestra la respuesta en consola
    }

    public static EliminarMascota conId(String idMascota) {
        return instrumented(EliminarMascota.class, idMascota);
    }
}
