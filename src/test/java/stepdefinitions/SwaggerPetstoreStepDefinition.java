package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.CodigoRespuesta;
import questions.DatosMascotaConsultada;
import questions.DatosMascotaRegistrada;
import questions.MascotaNoExiste;
import tasks.ConsultarMascota;
import tasks.EliminarMascota;
import tasks.RegistrarMascota;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SwaggerPetstoreStepDefinition extends EstablecerServicio {

    @Dado("que el usuario tiene acceso al servicio de mascotas")
    public void queElUsuarioTieneAccesoAlServicio() {
        OnStage.setTheStage(new OnlineCast()); // Inicializa el entorno de Serenity
        establecerServicio(); // Establece la URL base
    }

    @Cuando("configura la petición para añadir una nueva mascota con los siguientes datos:")
    public void configuraPeticionNuevaMascota(DataTable dataTable) {
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class); // ✅ CAMBIO AQUÍ
        actor.attemptsTo(RegistrarMascota.enElRecursoConDatos(datos));
    }

    @Entonces("verifica el estado de la respuesta de dicha petición")
    public void verificaElEstadoDeLaRespuestaDeDichaPetición() {
        actor.should(
                seeThat("El código de respuesta es ",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_OK))
        );
        System.out.println("w");
        // 🔹 Imprimir la respuesta del servicio para verificar qué devuelve
        String responseBody = net.serenitybdd.rest.SerenityRest.lastResponse().body().asString();
        System.out.println("Respuesta del servicio: " + responseBody);
    }

    @Y("configura la petición para consultar la mascota con el ID {string}")
    public void configuraLaPeticiónParaConsultarLaMascotaConElID(String idMascota) {
        actor.attemptsTo(ConsultarMascota.conId(idMascota));
    }


    @Y("configura la petición para eliminar la mascota con el ID {string}")
    public void configuraLaPeticiónParaEliminarLaMascotaConElID(String idMascota) {
        actor.attemptsTo(EliminarMascota.conId(idMascota));
    }

    @Y("verifica que la mascota fue registrada con los datos {string}, {string}, {string}")
    public void verificaQueLaMascotaFueRegistradaCorrectamente(String idMascota, String nombreMascota, String estado) {
        actor.should(
                seeThat("Los datos de la mascota registrada son correctos",
                        DatosMascotaRegistrada.esCorrecta(idMascota, nombreMascota, estado))
        );
    }

    @Y("verifica que la información de la mascota consultada es {string}, {string}, {string}")
    public void verificaQueLaInformacionDeLaMascotaConsultadaEsCorrecta(String idMascota, String nombreMascota, String estado) {
        actor.should(
                seeThat("Los datos de la mascota consultada son correctos",
                        DatosMascotaConsultada.esCorrecta(idMascota, nombreMascota, estado))
        );
    }

    @Y("verifica que la mascota con ID {string} ha sido eliminada correctamente")
    public void verificaQueLaMascotaHaSidoEliminadaCorrectamente(String idMascota) {
        actor.should(
                seeThat("La mascota ya no existe en la API", MascotaNoExiste.conId(idMascota))
        );
    }
}
