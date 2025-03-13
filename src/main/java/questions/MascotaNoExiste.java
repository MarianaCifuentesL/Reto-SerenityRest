package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import tasks.ConsultarMascota;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;

public class MascotaNoExiste implements Question<Boolean> {

    private final String idMascota;

    public MascotaNoExiste(String idMascota) {
        this.idMascota = idMascota;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(ConsultarMascota.conId(idMascota));
        int statusCode = SerenityRest.lastResponse().getStatusCode();
        System.out.println("Código de estado recibido en la verificación: " + statusCode);

        return statusCode == SC_NOT_FOUND;
    }

    public static MascotaNoExiste conId(String idMascota) {
        return new MascotaNoExiste(idMascota);
    }
}
