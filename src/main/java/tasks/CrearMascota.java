package tasks;

import interactions.PostPeticion;
import models.Mascota;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CrearMascota implements Task {

    private final Mascota mascota;
    private final String recurso;

    public CrearMascota(String recurso, Mascota mascota) {
        this.recurso = recurso;
        this.mascota = mascota;
    }

    @Step("{0} configura la petición para registrar una nueva mascota en {recurso}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PostPeticion.postPeticion(recurso, mascota));
    }

    public static CrearMascota conDatos(String recurso, List<Map<String, String>> datos) {
        Mascota nuevaMascota = new Mascota();
        Map<String, String> primeraFila = datos.get(0);
        nuevaMascota.setId(Integer.valueOf(primeraFila.get("Id Mascota")));
        nuevaMascota.getCategory().setId(Integer.valueOf(primeraFila.get("Id Categoría")));
        nuevaMascota.getCategory().setName(primeraFila.get("Nombre Categoría"));
        nuevaMascota.setName(primeraFila.get("Nombre Mascota"));
        nuevaMascota.setPhotoUrls(Collections.singletonList(primeraFila.get("URL Fotos")));
        nuevaMascota.getTags().get(0).setId(Integer.valueOf(primeraFila.get("Id Etiqueta")));
        nuevaMascota.getTags().get(0).setName(primeraFila.get("Nombre Etiqueta"));
        nuevaMascota.setStatus(primeraFila.get("Estado"));

        return instrumented(CrearMascota.class, recurso, nuevaMascota);
    }


}