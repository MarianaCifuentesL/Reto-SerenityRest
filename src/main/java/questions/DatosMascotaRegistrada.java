package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DatosMascotaRegistrada implements Question<Boolean> {

    private final String idMascota;
    private final String nombreMascota;
    private final String estado;

    public DatosMascotaRegistrada(String idMascota, String nombreMascota, String estado) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.estado = estado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int responseId = SerenityRest.lastResponse().jsonPath().getInt("id");
        String responseNombre = SerenityRest.lastResponse().jsonPath().getString("name");
        String responseEstado = SerenityRest.lastResponse().jsonPath().getString("status");

        return responseId == Integer.parseInt(idMascota) &&
                responseNombre.equals(nombreMascota) &&
                responseEstado.equals(estado);
    }

    public static DatosMascotaRegistrada esCorrecta(String idMascota, String nombreMascota, String estado) {
        return new DatosMascotaRegistrada(idMascota, nombreMascota, estado);
    }
}
