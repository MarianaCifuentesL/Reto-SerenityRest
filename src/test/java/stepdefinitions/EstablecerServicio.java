package stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static utils.Constantes.ACTOR;
import static utils.Constantes.URL_BASE;

public class EstablecerServicio {

    public static Actor actor = new Actor(ACTOR);

    protected void establecerServicio() {
        actor.can(CallAnApi.at(URL_BASE));

    }
}