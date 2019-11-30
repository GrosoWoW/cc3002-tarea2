# Alpaca Emblem parte 2

En esta parte de la tarea se implementaran los controladores del juego, es decir, la parte del programa que conectara al usuario con el juego, de manera que pueda recibir los inputs de este. Para esto se utilizaran distintos patrones de diseño.

## GameController

Es el encargado de manejar todos los inputs del juego. Este maneja distintos parametros de la partida como lo son, el numero de jugadores, rondas, numero maximos de jugadores, un puntero al mapa actual, jugador actual y la unidad seleccionada por el juegador, etc. Es importante notar que cada parametro tiene su metodo set y get.

#### Creacion de lista de jugadores y turnos

Posee un metodo para crear la lista inicial de jugadores (addPlayers) y otro metodo (randomList) que revuelve la lista de jugadores de manera de que los turnos sean al azar. El sistema de turnos funciona de la siguiente manera, la posicion 0 de la lista sera el primero jugador en jugar en la ronda y se va avanzando en esta hasta llegar al final. Esto se hace de la siguiente manera, se toma una lista ordenada, se obtiene un jugador al azar y se introduce a una nueva lista, la que sera la definitiva, asi hasta llegar al final. Es importante notar que el metodo randomList se llama al finalizar una ronda. Por otro lado tambien se considera que un jugador no tenga dos turnos seguidos. Esto se hace sacando al ultimo jugador antes de revolver la lista y luego se introduce en una posicion al azar.

#### Inicio del juego

Para dar inicio al juego, se setea la lista de jugadores nulas y la lista de players se crea de la forma mencionada anteiormente, se pone al jugador actual al primero en la lista creada y luego en un ciclo se setean las unidades a cada jugador (en este caso se colocaron una unidad de cada tipo para cada jugador). Para el caso que no posee limites de turnos, el parametro de maximo turnos se setea en -1, de esta manera no llegara a terminar.

#### Fin del turno-ronda

Cuando finaliza el turno se verifica que la lista no sea de tamaño igual a 1, pues si esto sucede, el jugador en la lista es el ganador y termina el juego, en caso contrario se verifica que el jugador actual sea diferente al ultimo en jugar, si esto sucede se termina la ronda. En cualquier otro caso se pasa al siguiente jugador.

Para finalizar la ronda se verifica el tamaño de la lista para notar si existe un ganador. En caso contrario si el numero de ronda actual es igual a la ronda maxima, si es asi, los jugadores restantes son los ganadores, en caso contrario se suma uno al numero de ronda y se revuelve  la lista de jugadores seteando al primero como jugador actual.


#### Remover a un jugador

Si un jugador pierde su unidad de Hero, sera removido de la lista de jugadores del controlador, para esto se busca con un ciclo en toda la lista hasta encontrar al jugador, una vez encontrado es removido, verificando el tamaño de la lista restante, pues si es igual a 1, el jugador restante sera el ganador del juego y este finaliza.



## Tactician  

El tactician se encarga de manejar todo lo relacionado con el jugador, este posee parametros como su nombre, su unidad actual, su lista de unidades, el item actual de la unidad, el controlador donde esta jugando, un puntero al mata, y parametros que tienen relacion con el Observer. 

#### Observer del Tactician

En este caso el observer sera el controlador y el tactician sera el observable, esto quiere decir que el controlador estara al pendiente de cualquier cambio que se produzca en el Tactician y este sera notificado para realizar los cambios correspondientes. Para esto se crearon 3 clases, ActualUnitChange, HeroDie y UnitDie, la primera se encarga de ver los cambios de unidades del Tactician, es decir cuando un jugador cambie su unidad actual, esta sera notificado al controlador de manera que tambien cambie su parametro (Esto lo hace atravez del metodo propertyChange).

Para el caso de UnitDie, este sera llamado cuando una unidad muere, para este caso el metodo de propertyChange se encargara de setear a la unidad como muerta, remover a la unidad de la posicion actual del mapay finalmente verificar si corresponde al tipo Hero, si es asi, se llamara al metodo heroDie() de el tactician.

Finalmente la clase UnitDie se encargara de responder frente a la muerte de la unidad de un Tactician. Si esto sucede, el jugador que se le fue eliminado la unidad Hero, debe ser removido de la partida.

#### Metodos del Tactician a aplicar a sus unidades

El tactician tendra a disposicion distintos metodos que le permitiran realizar acciones implementadas en la tarea 1, como atacar con sus unidades, mover a su unidad, ver sus parametro, items, etc, de esta manera el jugador poseera el conocimiento necesario para que su partida sea lo más jugable posible.





## Fabricas

Las fabricas son las encargadas de crear las unidades, items y el mapa del juego, estas se basan en el patron de diseño de Factorys, cada clase de las mencionadas anteriormente tendra sus propias fabricas, de esta manera el jugador no podra interaccionar con los parametros que estan por detras en la creacion de una unidad, objeto, etc, al jugador solo se le entregara la unidad ya creada.

### Fabrica de Unidades

Esta fabrica se encargara de crear las distintas unidades que se encuentran en el juego, para esto se dividio en dos tipos, el metodo create normal y el createDefault, para el primero se recibiran parametros como los hitpoints y una lista de items, de manera que al crear la unidad se pueda entregar la vida de este asi como sus items iniciales, mientras que el segundo es una creacion de una unidad por default, es decir no se podran modificar los hitpoints ni la lista de items, es decir estos parametros vendran por default. Es importante notar que una vez creada la unidad, antes de retornarla se setea el dueño de la unidad y se agrega a la lista de unidades del jugador. 

Es importante notar que la unidad no se coloca en ningun mapa (para completar con los parametros, se rellena con un InvalidLocation).

Para la creacion de este tipo de fabrica se decidio crear una interfaz UnitFactory con los metodos create y createDefault, esta sera implementada por la clase abstracta AbstractUnitFactory, la cual sera heredada por las distintas fabricas de unidades.


### Fabrica de Objetos

Este tipo de fabrica se encarga de la creacion de los distintos elementos que se encuentran disponibles en el juegos, funciona de manera similar a la anterior, se divide en dos metodos importantes, los cuales son el create y createDefault, el primero se encarga de crear el item correspondiente, pudiendo modificar el poder, el rango minimo y maximo, mientras que el segundo genera un item con parametros por default (estos son dependiendo del item). Una vez creado el item no posera dueño, este tendra que ser asignado luego.


### Fabrica de Mapa
