package com.SPAirbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirNavegadorTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.airbnb.com.co")
        );
    }
    public static AbrirNavegadorTask abrir(){
        return instrumented(AbrirNavegadorTask.class);
    }
}
