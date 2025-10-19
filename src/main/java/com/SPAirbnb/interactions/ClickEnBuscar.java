package com.SPAirbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.SPAirbnb.userInterfaces.HomePageUI.BTN_BUSCAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickEnBuscar implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_BUSCAR)
        );
    }
    public static ClickEnBuscar clickEnBuscar() {
        return instrumented(ClickEnBuscar.class);
    }
}
