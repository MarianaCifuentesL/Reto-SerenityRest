package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuesta implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static CodigoRespuesta codigoRespuesta() {
        return new CodigoRespuesta();
    }
}