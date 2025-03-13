package tasks;

import interactions.GetPeticion;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicioGet implements Task {

    private String recurso;

    public ConsumirServicioGet conRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetPeticion.getPeticion(recurso)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                        )
        );

    }

    public static ConsumirServicioGet consumirServicioGet() {
        return instrumented(ConsumirServicioGet.class);
    }
}
