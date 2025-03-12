package stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static utils.Constantes.ACTOR;

public class EstablecerServicio {

    public static final Actor actor = new Actor(ACTOR);

    protected void establecerServicio(String urlBase) {
        actor.can(CallAnApi.at(urlBase));

    }
}
