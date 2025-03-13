package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarMascota implements Task {

    private final String idMascota;

    public ConsultarMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    @Step("{0} consulta la información de la mascota con ID #idMascota en el recurso #recurso")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(idMascota)
                        .with(request -> request)
        );

        SerenityRest.lastResponse().prettyPrint(); // Muestra la respuesta en consola
    }

    public static ConsultarMascota conId(String idMascota) {
        return instrumented(ConsultarMascota.class, idMascota);
    }
}
