package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tasks.CrearMascota;

import java.util.List;
import java.util.Map;



public class PostPetStepDefinition extends EstablecerServicio {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeletePetStepDefinition.class);


    @Cuando("crea una petición para añadir una nueva mascota en el recurso {string} con los siguientes datos:")
    public void configuraPeticionNuevaMascota(String recurso, DataTable dataTable) {
        LOGGER.info("Añadiendo una nueva mascota en el recurso: " + recurso);
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);
        actor.attemptsTo(CrearMascota.conDatos(recurso, datos));
    }





}