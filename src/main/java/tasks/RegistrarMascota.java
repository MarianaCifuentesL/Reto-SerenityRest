package tasks;

import io.cucumber.messages.types.Tag;
import io.restassured.http.ContentType;
import models.Categoria;
import models.Mascota;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarMascota implements Task {

    private final String recurso;
    private final Mascota mascota;

    public RegistrarMascota(String recurso, Mascota mascota) {
        this.recurso = recurso;
        this.mascota = mascota;
    }

    @Step("{0} configura la petición para registrar una nueva mascota en {recurso}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(recurso) // Aquí pasamos la parte final de la URL
                        .with(requestSpecification ->
                                requestSpecification
                                        .contentType(ContentType.JSON)
                                        .body(mascota)
                        )
        );

        SerenityRest.lastResponse().prettyPrint();
    }

    public static RegistrarMascota enElRecursoConDatos(String recurso, List<Map<String, String>> datos) {
        Mascota nuevaMascota = new Mascota();

        // Accedemos a la primera fila de datos
        Map<String, String> primeraFila = datos.get(0);

        nuevaMascota.setId(Integer.valueOf(primeraFila.get("Id Mascota")));
        nuevaMascota.getCategory().setId(Integer.valueOf(primeraFila.get("Id Categoría")));
        nuevaMascota.getCategory().setName(primeraFila.get("Nombre Categoría"));
        nuevaMascota.setName(primeraFila.get("Nombre Mascota"));
        nuevaMascota.setPhotoUrls(Collections.singletonList(primeraFila.get("URL Fotos")));
        nuevaMascota.getTags().get(0).setId(Integer.valueOf(primeraFila.get("Id Etiqueta")));
        nuevaMascota.getTags().get(0).setName(primeraFila.get("Nombre Etiqueta"));
        nuevaMascota.setStatus(primeraFila.get("Estado"));

        return instrumented(RegistrarMascota.class, recurso, nuevaMascota);
    }


}
