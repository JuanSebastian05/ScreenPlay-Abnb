package com.SPAirbnb.interactions;


import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.SPAirbnb.userInterfaces.HomePageUI.INPUT_DESTINO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarDestino implements Interaction {

    private String destino;

    public BuscarDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(INPUT_DESTINO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(destino).into(INPUT_DESTINO),
                Hit.the(Keys.ENTER).into(INPUT_DESTINO)
        );
    }
    public static BuscarDestino buscarDestino(String destino) {
        return instrumented(BuscarDestino.class, destino);
    }

}
