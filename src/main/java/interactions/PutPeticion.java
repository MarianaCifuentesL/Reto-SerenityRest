package interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutPeticion extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(PutPeticion.class);
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
        String url = recurso; // Asegurar que la URL incluya el ID de la mascota
        LOGGER.info("Realizando PUT a la URL: " + url);
        LOGGER.info("Cuerpo de la petición: " + body.toString());

        actor.attemptsTo(
                Put.to(recurso)
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(body))
        );
    }
}
