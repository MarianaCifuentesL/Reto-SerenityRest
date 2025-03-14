package interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.serenitybdd.rest.SerenityRest;

public class PutPeticion extends RestInteraction {
    private final String recurso;
    private final Object body;

    public PutPeticion(String recurso, Object body) {
        this.recurso = recurso;
        this.body = body;
    }

    public static PutPeticion conDatos(String recurso, Object body) {
        return new PutPeticion(recurso, body);
    }

    @Override
    @Step("{0} realiza una petición PUT al recurso #recurso con el cuerpo #body")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(recurso)
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(body))
        );
    }

}