package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeEliminacion implements Question<Boolean> {

    private final String idEsperado;

    public MensajeEliminacion(String idEsperado) {
        this.idEsperado = idEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensaje = SerenityRest.lastResponse().jsonPath().getString("message");
        return idEsperado.equals(mensaje);
    }

    public static MensajeEliminacion esElId(String idEsperado) {
        return new MensajeEliminacion(idEsperado);
    }
}
