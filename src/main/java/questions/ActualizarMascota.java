package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import io.restassured.response.Response;

public class ActualizarMascota implements Question<Boolean> {

    private final int idEsperado;
    private final String nombreEsperado;
    private final String estadoEsperado;

    public ActualizarMascota(int idEsperado, String nombreEsperado, String estadoEsperado) {
        this.idEsperado = idEsperado;
        this.nombreEsperado = nombreEsperado;
        this.estadoEsperado = estadoEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();

        if (response.statusCode() != 200) {
            return false;
        }

        int idMascota = response.jsonPath().getInt("id");
        String nombreMascota = response.jsonPath().getString("name");
        String estadoMascota = response.jsonPath().getString("status");

        return idMascota == idEsperado &&
                nombreMascota.equals(nombreEsperado) &&
                estadoMascota.equals(estadoEsperado);
    }

    public static ActualizarMascota conDatos(int id, String nombre, String estado) {
        return new ActualizarMascota(id, nombre, estado);
    }
}
