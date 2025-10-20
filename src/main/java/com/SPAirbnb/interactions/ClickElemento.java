package com.SPAirbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickElemento implements Interaction {

    private final Target target;

    public ClickElemento(Target target) {
        this.target = target;
    }

    public static ClickElemento en(Target target) {
        return instrumented(ClickElemento.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(target)
        );
    }

    @Override
    public String toString() {
        return "hacer click en " + (target != null ? target.getName() : "elemento desconocido");
    }
}

