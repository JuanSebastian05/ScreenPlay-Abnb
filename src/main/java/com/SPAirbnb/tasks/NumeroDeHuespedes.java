package com.SPAirbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.SPAirbnb.userInterfaces.HomePageUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NumeroDeHuespedes implements Task {

    private final int adultos;
    private final int ninos;
    private final int mascotas;

    public NumeroDeHuespedes(int adultos, int ninos, int mascotas) {
        this.adultos = adultos;
        this.ninos = ninos;
        this.mascotas = mascotas;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_HUESPEDES)
        );

        for (int i = 0; i < adultos; i++) {
            actor.attemptsTo(
                Click.on(BTN_INCREMENTAR_ADULTOS)
            );
        }
        for (int i = 0; i < ninos; i++) {
            actor.attemptsTo(
                    Click.on(BTN_INCREMENTAR_NINOS)
            );
        }
        for (int i = 0; i < mascotas; i++) {
            actor.attemptsTo(
                    Click.on(BTN_INCREMENTAR_MASCOTAS)
            );
        }
        actor.attemptsTo(
                Click.on(BTN_BUSCAR));
    }
    public static NumeroDeHuespedes numeroDeHuespedes(int adultos, int ninos, int mascotas){
        return instrumented(NumeroDeHuespedes.class, adultos, ninos, mascotas);
    }
}
