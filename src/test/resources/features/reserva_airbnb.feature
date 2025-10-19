Feature: Cómo usuario de la página Airbnb quiero probar la reserva de un alojamiento
  Scenario: reservar un alojamiento usando filtros en la pagina Airbnb
    Given que el usuario se encuentra en la página de Airbnb
    When el usuario ingresa "Bogotá" como destino
    And el usuario selecciona el día de hoy como fecha de llegada y dentro de 7 días como fecha de salida
    And el usuario aplica el filtro de huéspedes con 2 adultos, 1 niño y 1 mascota
    And el usuario realiza la busqueda inicial
    And el usuario aplica el filtro de precio máximo de 1500000 por noche
    And el usuario aplica el filtro de comodidades seleccionando "Aire acondicionado", "Cocina" y "Lavadora"
    And el usuario realiza la busqueda con los filtros aplicados
    And el usuario selecciona el primer resultado de la búsqueda
    And el usuario extrae el nombre, precio y anfitrion del alojamiento seleccionado
    And el usuario guarda los datos extraídos en un archivo de Excel
    Then debería mostrarse una lista de alojamientos que incluya al menos un resultado que cumpla con los criterios especificados