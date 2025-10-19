package stepDefinitions;

import com.SPAirbnb.interactions.*;
import com.SPAirbnb.tasks.*;
import com.SPAirbnb.utils.GuardarEnExcel;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ReservaStepDefinition {

    @Before
    public void ConfigurarEscenario(){
        setTheStage(new OnlineCast());
    }

    @Given("que el usuario se encuentra en la página de Airbnb")
    public void queElUsuarioSeEncuentraEnLaPáginaDeAirbnb() {
        theActorCalled("Usuario").wasAbleTo(
                AbrirNavegadorTask.abrir()
        );
    }

    @When("el usuario ingresa {string} como destino")
    public void elUsuarioIngresaComoDestino(String destino) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarDestino.buscarDestino(destino)
        );
    }

    @When("el usuario selecciona el día de hoy como fecha de llegada y dentro de {int} días como fecha de salida")
    public void elUsuarioSeleccionaElDíaDeHoyComoFechaDeLlegadaYDentroDeDíasComoFechaDeSalida(Integer dias) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarFechasTask.seleccionarFechas(dias)
        );
    }

    @When("el usuario aplica el filtro de huéspedes con {int} adultos, {int} niño y {int} mascota")
    public void elUsuarioAplicaElFiltroDeHuéspedesConAdultosNiñoYMascota(Integer adultos, Integer ninos, Integer mascotas) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NumeroDeHuespedesTask.numeroDeHuespedes(adultos, ninos, mascotas)
        );
    }

    @When("el usuario realiza la busqueda inicial")
    public void elUsuarioRealizaLaBusquedaInicial() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickEnBuscar.clickEnBuscar()
        );
    }

    @When("el usuario aplica el filtro de precio máximo de {int} por noche")
    public void elUsuarioAplicaElFiltroDePrecioMáximoDePorNoche(Integer precio) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarPopUp.cerrarPopUp(),
                FiltrarPrecioMaxTask.filtrarPrecioMax(precio)
        );
    }

    @When("el usuario aplica el filtro de comodidades seleccionando {string}, {string} y {string}")
    public void elUsuarioAplicaElFiltroDeComodidadesSeleccionandoY(String string, String string2, String string3) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AplicarFiltrosTask.aplicarFiltros(string, string2, string3)
        );
    }

    @When("el usuario realiza la busqueda con los filtros aplicados")
    public void elUsuarioRealizaLaBusquedaConLosFiltrosAplicados() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickEnAplicarFiltros.aplicarFiltros()
        );
    }

    @When("el usuario selecciona el primer resultado de la búsqueda")
    public void elUsuarioSeleccionaElPrimerResultadoDeLaBúsqueda() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ElegirAlojamiento.elegirAlojamiento()
        );
    }

    @When("el usuario extrae el nombre, precio y anfitrion del alojamiento seleccionado")
    public void elUsuarioExtraeElNombrePrecioYAnfitrionDelAlojamientoSeleccionado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ExtraerDetallesAlojamientoTask.extraerDetallesAlojamiento()
        );
    }

    @When("el usuario guarda los datos extraídos en un archivo de Excel")
    public void elUsuarioGuardaLosDatosExtraídosEnUnArchivoDeExcel() {
        Actor actor = OnStage.theActorInTheSpotlight();
        GuardarEnExcel.guardarDetallesEnExcel(actor);
    }

    @Then("debería mostrarse una lista de alojamientos que incluya al menos un resultado que cumpla con los criterios especificados")
    public void deberíaMostrarseUnaListaDeAlojamientosQueIncluyaAlMenosUnResultadoQueCumplaConLosCriteriosEspecificados() {

    }

}
