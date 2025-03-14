package interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetPeticion extends RestInteraction {

    private final String recurso;

    public GetPeticion(String recurso) {
        this.recurso = recurso;
    }

    @Override
    @Step("{0} realiza una petición DELETE al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        rest().
                log().all().
                get(as(actor).
                        resolve(recurso)).
                then().
                log().all();
    }

    public static GetPeticion getPeticion(String recurso) {
        return instrumented(GetPeticion.class, recurso);
    }
}
