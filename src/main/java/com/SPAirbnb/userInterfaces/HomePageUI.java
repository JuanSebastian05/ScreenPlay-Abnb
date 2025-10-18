package com.SPAirbnb.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageUI {

    public static final Target INPUT_DESTINO = Target.the("Input para ingresar el destino").
            located(By.cssSelector("[data-testid=structured-search-input-field-query]"));

    public static Target dateButton(String fecha) {
        return Target.the("día " + fecha)
                .located(By.cssSelector("[data-state--date-string='" + fecha + "']"));
    }

    public static final Target BTN_HUESPEDES = Target.the("Boton para seleccionar numero de huespedes").
            located(By.xpath("//div[contains(text(), '¿Cuántos?')]"));

    public static final Target BTN_INCREMENTAR_ADULTOS = Target.the("Boton para incrementar numero de huespedes adultos").
            located(By.cssSelector("[data-testid=stepper-adults-increase-button]"));

    public static final Target BTN_INCREMENTAR_NINOS = Target.the("Boton para incrementar numero de huespedes niños").
            located(By.cssSelector("[data-testid=stepper-children-increase-button]"));

    public static final Target BTN_INCREMENTAR_MASCOTAS = Target.the("Boton para incrementar numero de huespedes mascotas").
            located(By.cssSelector("[data-testid=stepper-pets-increase-button]"));

    public static final Target BTN_BUSCAR = Target.the("Boton para buscar alojamiento").
            located(By.cssSelector("[data-testid=structured-search-input-search-button]"));
}
