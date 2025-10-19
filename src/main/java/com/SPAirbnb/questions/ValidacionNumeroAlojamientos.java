package com.SPAirbnb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionNumeroAlojamientos implements Question<Boolean> {

    private Target elemento;

    public ValidacionNumeroAlojamientos(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WaitUntil.the(elemento, isVisible()).forNoMoreThan(10).seconds();
        return elemento.resolveFor(actor).isDisplayed();
    }

    public static ValidacionNumeroAlojamientos validacionLabel(Target elemento){
        return new ValidacionNumeroAlojamientos(elemento);
    }
}
