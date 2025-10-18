package com.SPAirbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.LocalDate;

import static com.SPAirbnb.userInterfaces.HomePageUI.dateButton;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarFechasTask implements Task {

    private final int diasEstadia;

    public SeleccionarFechasTask(int diasEstadia) {
        this.diasEstadia = diasEstadia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        LocalDate diaActual = LocalDate.now();
        LocalDate diaSalida = diaActual.plusDays(diasEstadia);

        String fechaEntradaStr = diaActual.toString();
        String fechaSalidaStr = diaSalida.toString();

        actor.attemptsTo(
                Click.on(dateButton(fechaEntradaStr)),
                Click.on(dateButton(fechaSalidaStr))
        );
    }
    public static SeleccionarFechasTask seleccionarFechas(int diasEstadia){
        return instrumented(SeleccionarFechasTask.class, diasEstadia);
    }
}

