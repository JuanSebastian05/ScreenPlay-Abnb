package com.SPAirbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.SPAirbnb.userInterfaces.HomePageUI.BTN_CERRAR_POPUP;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarPopUp implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (BTN_CERRAR_POPUP.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_CERRAR_POPUP, isVisible()).forNoMoreThan(5).seconds(),
                    Click.on(BTN_CERRAR_POPUP)
            );
        }
    }
    public static CerrarPopUp cerrarPopUp(){
        return instrumented(CerrarPopUp.class);
    }
}
