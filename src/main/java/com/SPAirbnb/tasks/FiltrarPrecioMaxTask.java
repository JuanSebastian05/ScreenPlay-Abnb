package com.SPAirbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.SPAirbnb.userInterfaces.HomePageUI.BTN_FILTROS;
import static com.SPAirbnb.userInterfaces.HomePageUI.INPUT_PRECIO_MAXIMO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FiltrarPrecioMaxTask implements Task {

    private int maxPrice;

    public FiltrarPrecioMaxTask(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(BTN_FILTROS),
                WaitUntil.the(INPUT_PRECIO_MAXIMO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(INPUT_PRECIO_MAXIMO),
                SendKeys.of(Keys.chord(Keys.CONTROL, "a")).into(INPUT_PRECIO_MAXIMO),
                SendKeys.of(Keys.DELETE).into(INPUT_PRECIO_MAXIMO),
                SendKeys.of(String.valueOf(maxPrice)).into(INPUT_PRECIO_MAXIMO)
        );
    }
    public static FiltrarPrecioMaxTask filtrarPrecioMax(int maxPrice) {
        return instrumented(FiltrarPrecioMaxTask.class, maxPrice);
    }

}
