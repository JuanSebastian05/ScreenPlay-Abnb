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

    public static final Target BTN_FILTROS = Target.the("Boton para aplicar filtros a la busqueda").
            located(By.cssSelector("[data-testid=category-bar-filter-button]"));

    public static final Target INPUT_PRECIO_MAXIMO = Target.the("Input para precio maximo por noche").
            located(By.id("price_filter_max"));

    public static final Target BTN_MOSTRAR_MAS_COMODIDADES = Target.the("Boton para mostrar mas comodidades").
            located(By.xpath("//span[text()='Muestra más']"));

    public static Target BTN_COMODIDADES(String nombre_comodidad){
        return Target.the("Boton para seleccionar la comodidad " + nombre_comodidad).
                located(By.xpath("//span[normalize-space(.) = '" + nombre_comodidad + "']"));
    }

    public static final Target BTN_APLICAR_FILTROS = Target.the("Boton para aplicar los filtros seleccionados").
            located(By.xpath("//a[contains(text(),'Mostrar')]"));

    public static final Target BTN_CERRAR_POPUP = Target.the("Boton para cerrar el popup de aviso").
            located(By.xpath("//button[@aria-label='Cerrar']"));

    public static final Target RESULTADO_ALOJAMIENTO = Target.the("El ´rimer alojamiento que hay").
            located(By.xpath("(//*[@data-testid='card-container'])[1]"));

}
