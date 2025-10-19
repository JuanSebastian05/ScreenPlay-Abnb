package com.SPAirbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.SPAirbnb.userInterfaces.HomePageUI.RESULTADO_ALOJAMIENTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ElegirAlojamiento implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(RESULTADO_ALOJAMIENTO)
        );
    }
    public static ElegirAlojamiento elegirAlojamiento(){
        return instrumented(ElegirAlojamiento.class);
    }

}
