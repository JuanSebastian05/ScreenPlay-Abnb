package com.SPAirbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.SPAirbnb.userInterfaces.HomePageUI.*;
import static com.SPAirbnb.userInterfaces.HomePageUI.BTN_FILTROS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AplicarFiltrosTask implements Task {

    private String filtro1;
    private String filtro2;
    private String filtro3;

    public AplicarFiltrosTask(String filtro1, String filtro2, String filtro3) {
        this.filtro1 = filtro1;
        this.filtro2 = filtro2;
        this.filtro3 = filtro3;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
            WaitUntil.the(BTN_FILTROS, isVisible()).forNoMoreThan(10).seconds(),
            WaitUntil.the(BTN_FILTROS, isEnabled()).forNoMoreThan(10).seconds(),
            Click.on(BTN_MOSTRAR_MAS_COMODIDADES),
            Click.on(BTN_COMODIDADES(filtro1)),
            Click.on(BTN_COMODIDADES(filtro2)),
            Click.on(BTN_COMODIDADES(filtro3))
        );
    }
    public static AplicarFiltrosTask aplicarFiltros(String filtro1, String filtro2, String filtro3){
        return instrumented(AplicarFiltrosTask.class, filtro1, filtro2, filtro3);
    }
}
