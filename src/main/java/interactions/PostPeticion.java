package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostPeticion extends RestInteraction {

    private final String recurso;
    private final Object body;

    public PostPeticion(String recurso, Object body) {
        this.recurso = recurso;
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .log().all()
                .body(body)
                .post(as(actor).resolve(recurso))
                .then()
                .log().all();
    }

    public static PostPeticion postPeticion(String recurso, Object body) {
        return instrumented(PostPeticion.class, recurso, body);
    }
}
