package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static utils.Constantes.URL_BASE;

public class MascotaEliminada implements Question<Boolean> {

    private final String idMascota;

    public MascotaEliminada(String idMascota) {
        this.idMascota = idMascota;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        SerenityRest.given()
                .baseUri(URL_BASE)
                .when()
                .get("/pet/" + idMascota)
                .then()
                .log().all();

        int statusCode = SerenityRest.lastResponse().statusCode();
        return statusCode == 404;
    }

    public static MascotaEliminada conId(String idMascota) {
        return new MascotaEliminada(idMascota);
    }
}
