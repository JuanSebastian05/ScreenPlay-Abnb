package com.SPAirbnb.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetallesAlojamientoUI {

    public static final Target BTN_CERRAR_POPUP_DETALLES = Target.the("Boton para cerrar el popup de aviso").
            located(By.xpath("*[@aria-label='Cerrar']"));

    public static Target TITULO_ALOJAMIENTO = Target.the("Título del alojamiento").
            located(By.xpath("(//h1)[1]"));

    public static Target NOMBRE_ANFITRION = Target.the("Nombre del anfitrión").
            located(By.xpath("(//div[contains(text(), 'Anfitrión')])"));

    public static Target PRECIO_ALOJAMIENTO = Target.the("Precio del alojamiento").
            located(By.xpath("(//div[@data-section-id='BOOK_IT_SIDEBAR']//span[contains(text(), 'COP')])[1]"));

}
