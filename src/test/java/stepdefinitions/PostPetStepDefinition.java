package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import tasks.CrearMascota;

import java.util.List;
import java.util.Map;



public class PostPetStepDefinition extends EstablecerServicio {



    @Cuando("crea una petición para añadir una nueva mascota en el recurso {string} con los siguientes datos:")
    public void configuraPeticionNuevaMascota(String recurso, DataTable dataTable) {
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class); // ✅ CAMBIO AQUÍ
        actor.attemptsTo(CrearMascota.conDatos(recurso, datos));
    }





}