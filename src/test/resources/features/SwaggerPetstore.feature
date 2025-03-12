# language: es

Característica: Gestión de mascotas en Swagger Petstore

  Como usuario del sistema
  Quiero registrar una nueva mascota en la tienda
  Para que pueda ser encontrada en el sistema

  Esquema del escenario: Registrar una nueva mascota
    Dado que el usuario tiene acceso al servicio de mascotas
    Cuando configura la petición para añadir una nueva mascota en el recurso "<recurso>" con los siguientes datos:
      | Id Mascota  | Id Categoría | Nombre Categoría | Nombre Mascota   | URL Fotos | Id Etiqueta | Nombre Etiqueta | Estado     |
      | <idMascota> | <idCategoria> | <nombreCategoria> | <nombreMascota> | <urlFotos> | <idEtiqueta> | <nombreEtiqueta> | <estado> |
    Entonces verifica el estado de la respuesta de dicha petición

    Ejemplos:
      | recurso  | idMascota | idCategoria | nombreCategoria | nombreMascota | urlFotos           | idEtiqueta | nombreEtiqueta | estado    |
      | v2/pet  | 1         | 1           | Perros          | Max           | url1 | 1          | Rescatado      | available |