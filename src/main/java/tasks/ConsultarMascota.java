package tasks;

import interactions.GetPeticion;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarMascota implements Task {

    private final String idMascota;
    private final String recurso;

    public ConsultarMascota(String idMascota, String recurso) {
        this.idMascota = idMascota;
        this.recurso = recurso;
    }


    @Override
    @Step("{0} consulta la mascota con ID #idMascota")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                GetPeticion.getPeticion(recurso + "/" + idMascota)
        );

    }

    public static ConsultarMascota conId(String idMascota, String recurso) {
        return instrumented(ConsultarMascota.class, idMascota, recurso);
    }
}