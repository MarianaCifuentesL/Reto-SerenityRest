package tasks;

import interactions.PutPeticion;
import models.Mascota;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ActualizarMascota implements Task {

    private final Mascota mascota;
    private final String recurso;

    public ActualizarMascota(String recurso, Mascota mascota) {
        this.recurso = recurso;
        this.mascota = mascota;
    }

    public static ActualizarMascota conDatos(String recurso, List<Map<String, String>> datos) {
        Mascota mascota = new Mascota();
        Map<String, String> primeraFila = datos.get(0);
        mascota.setId(Integer.valueOf(primeraFila.get("Id Mascota")));
        mascota.getCategory().setId(Integer.valueOf(primeraFila.get("Id Categoría")));
        mascota.getCategory().setName(primeraFila.get("Nombre Categoría"));
        mascota.setName(primeraFila.get("Nombre Mascota"));
        mascota.setPhotoUrls(Collections.singletonList(primeraFila.get("URL Fotos")));
        mascota.getTags().get(0).setId(Integer.valueOf(primeraFila.get("Id Etiqueta")));
        mascota.getTags().get(0).setName(primeraFila.get("Nombre Etiqueta"));
        return Tasks.instrumented(ActualizarMascota.class, recurso, mascota);
    }

    @Override
    @Step("{0} actualiza la mascota con ID #idMascota en el recurso #recurso con el cuerpo #body")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PutPeticion.conDatos(recurso, mascota));
    }
}
