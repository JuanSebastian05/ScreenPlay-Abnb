package com.SPAirbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.SPAirbnb.userInterfaces.HomePageUI.BTN_APLICAR_FILTROS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickEnAplicarFiltros implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_APLICAR_FILTROS)
        );
    }
    public static ClickEnAplicarFiltros aplicarFiltros(){
        return instrumented(ClickEnAplicarFiltros.class);
    }
}
