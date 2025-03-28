# language: es

Característica: Gestión de mascotas en Swagger Petstore

  Como usuario del sistema
  Quiero registrar, consultar y eliminar mascotas en la tienda
  Para que pueda gestionar su información correctamenteEsquema del escenario: Registrar una nueva mascota

  Esquema del escenario: Eliminar una mascota por su ID
    Dado que el usuario tiene acceso al servicio de mascotas
    Cuando crea una petición para añadir una nueva mascota en el recurso "<recurso>" con los siguientes datos:
      | Id Mascota  | Id Categoría | Nombre Categoría | Nombre Mascota   | URL Fotos | Id Etiqueta | Nombre Etiqueta | Estado     |
      | <idMascota> | <idCategoria> | <nombreCategoria> | <nombreMascota> | <urlFotos> | <idEtiqueta> | <nombreEtiqueta> | <estado> |
    Y crea una petición para eliminar la mascota con el ID "<idMascota>" en el recurso "<recurso>"
    Entonces verifica el estado de la respuesta de dicha petición
    Y verifica que la mascota con el ID "<idMascota>" ha sido eliminada correctamente

    Ejemplos:
      |recurso | idMascota | idCategoria | nombreCategoria | nombreMascota | urlFotos | idEtiqueta | nombreEtiqueta | estado    |
      | /pet   | 2403      | 1           | Perros          | Max           | url1     | 1          | Rescatado      | available |
