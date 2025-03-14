package tasks;

import interactions.PutPeticion;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ActualizarMascota implements Task {

    private final String idMascota;
    private final String recurso;
    private final Object body;

    public ActualizarMascota(String idMascota, String recurso, Object body) {
        this.idMascota = idMascota;
        this.recurso = recurso;
        this.body = body;
    }

    public static ActualizarMascota conDatos(String idMascota, String recurso, Object body) {
        return Tasks.instrumented(ActualizarMascota.class, idMascota, recurso, body);
    }

    @Override
    @Step("{0} realiza una petición PUT al recurso #recurso con el cuerpo #body")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PutPeticion.conDatos(recurso, body));
    }
}
