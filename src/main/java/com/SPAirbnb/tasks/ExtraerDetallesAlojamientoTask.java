package com.SPAirbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static com.SPAirbnb.userInterfaces.DetallesAlojamientoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ExtraerDetallesAlojamientoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        if (!handles.isEmpty()) {
            String ultimaPestana = handles.get(handles.size() - 1);
            driver.switchTo().window(ultimaPestana);
        }

        try {
            if (BTN_CERRAR_POPUP_DETALLES.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_CERRAR_POPUP_DETALLES, isVisible()).forNoMoreThan(5).seconds(),
                        Click.on(BTN_CERRAR_POPUP_DETALLES)
                );
            }
        } catch (Exception ignored) {
            // Si no existe o no se puede resolver, continuar
        }

        // Esperar título y también anfitrión y precio antes de leerlos
        actor.attemptsTo(
                WaitUntil.the(TITULO_ALOJAMIENTO, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(NOMBRE_ANFITRION, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(PRECIO_ALOJAMIENTO, isVisible()).forNoMoreThan(10).seconds()
        );

        String titulo = Text.of(TITULO_ALOJAMIENTO).answeredBy(actor);
        String anfitrionRaw = Text.of(NOMBRE_ANFITRION).answeredBy(actor);
        String precio = Text.of(PRECIO_ALOJAMIENTO).answeredBy(actor);

        // Regex más flexible: acepta "Anfitrión", "Anfitrión:", "Anfitrión·", "Anfitrión -", etc.
        String anfitrion = anfitrionRaw.replaceFirst("(?i)Anfitri[oó]n\\s*[:·\\-]?\\s*", "").trim();

        actor.remember("tituloAlojamiento", titulo);
        actor.remember("nombreAnfitrion", anfitrion);
        actor.remember("precioAlojamiento", precio);
    }

    public static ExtraerDetallesAlojamientoTask extraerDetallesAlojamiento() {
        return instrumented(ExtraerDetallesAlojamientoTask.class);
    }
}
