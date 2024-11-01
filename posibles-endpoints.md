ENDPOINTS TP BACKEND

### 1

#### a
POST /pruebas
BODY info de la pruebas

Respuestas posibles:
- Codigo 201 creado y 400 si hubo error
- Devolver id de la nueva prueba

#### b
GET /pruebas/in-course
- Buscar todas las pruebas que se encuentren en curso (sin fechaFIN)

Respuestas posibles:
- Codigo 200 y el listado, si no hay nada, lista vacia

#### c
PATCH /pruebas/{id_prueba}/end

BODY {
	"comentario": "" // Puede ser nulo
}

Respuestas posibles:
- Código 200 si todo ok, 204 no content

#### d
POST /vehiculo/{id_vehiculo}/posicion

BODY {
	info de la posicion
}

Respuestas posibles:
- Código 201 si se creo, 400 si hubo error

#### e
POST /notificaciones/promos

BODY listado de telefonos a notificar

#### f

##### i
GET /pruebas/incidentes

Respuesta lista de incidentes

##### ii
GET /empleados/{id_empleado}/incidentes

##### iii
GET /vehiculos/{id_vehiculo}/kilometros
Parametros: ?fecha_desde=FECHA1-fechahasta=FECHA1

Validar que las fechas no esten cruzadas

##### iv
GET /vehiculos/{id_vehiculo}/pruebas