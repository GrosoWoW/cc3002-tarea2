# Alpaca Emblem parte 2

En esta parte de la tarea se implementaran los controladores del juego, es decir, la parte del programa que conectara al usuario con el juego, de manera que pueda recibir los inputs de este. Para esto se utilizaran distintos patrones de diseño.

## GameController

Es el encargado de manejar todos los inputs del juego. Este maneja distintos parámetros de la partida como lo son, el numero de jugadores, rondas, numero máximos de jugadores, un puntero al mapa actual, jugador actual y la unidad seleccionada por el jugador, etc. Es importante notar que cada parámetro tiene su método set y get.

#### Creación de lista de jugadores y turnos

Posee un método para crear la lista inicial de jugadores (addPlayers) y otro método (randomList) que revuelve la lista de jugadores de manera de que los turnos sean al azar. El sistema de turnos funciona de la siguiente manera, la posición 0 de la lista será el primero jugador en jugar en la ronda y se va avanzando en esta hasta llegar al final. Esto se hace de la siguiente manera, se toma una lista ordenada, se obtiene un jugador al azar y se introduce a una nueva lista, la que será la definitiva, así hasta llegar al final. Es importante notar que el método randomList se llama al finalizar una ronda. Por otro lado también se considera que un jugador no tenga dos turnos seguidos. Esto se hace sacando al ultimo jugador antes de revolver la lista y luego se introduce en una posición al azar.

#### Inicio del juego

Para dar inicio al juego, se setea la lista de jugadores nulas y la lista de players se crea de la forma mencionada anteriormente, se pone al jugador actual al primero en la lista creada y luego en un ciclo se setean las unidades a cada jugador (en este caso se colocaron una unidad de cada tipo para cada jugador). Para el caso que no posee limites de turnos, el parámetro de máximo turnos se setea en -1, de esta manera no llegara a terminar.

#### Fin del turno-ronda

Cuando finaliza el turno se verifica que la lista no sea de tamaño igual a 1, pues si esto sucede, el jugador en la lista es el ganador y termina el juego, en caso contrario se verifica que el jugador actual sea diferente al ultimo en jugar, si esto sucede se termina la ronda. En cualquier otro caso se pasa al siguiente jugador.

Para finalizar la ronda se verifica el tamaño de la lista para notar si existe un ganador. En caso contrario si el numero de ronda actual es igual a la ronda máxima, se consideraran a los jugadores restantes como los ganadores, en caso contrario se suma uno al numero de ronda y se revuelve la lista de jugadores seteando al primero como jugador actual.


#### Remover a un jugador

Si un jugador pierde su unidad de Hero, será removido de la lista de jugadores del controlador, para esto se busca con un ciclo en toda la lista hasta encontrar al jugador, una vez encontrado es removido, verificando el tamaño de la lista restante, pues si es igual a 1, el jugador restante será el ganador del juego y este finaliza.



## Tactician  

El tactician se encarga de manejar todo lo relacionado con el jugador, este posee parametros como su nombre, su unidad actual, su lista de unidades, el item actual de la unidad, el controlador donde esta jugando, un puntero al mata, y parámetros que tienen relación con el Observer. 

#### Observer del Tactician

En este caso el observer será el controlador y el tactician será el observable, esto quiere decir que el controlador estara al pendiente de cualquier cambio que se produzca en el Tactician y este sera notificado para realizar los cambios correspondientes. Para esto se crearon 3 clases, ActualUnitChange, HeroDie y UnitDie, la primera se encarga de ver los cambios de unidades del Tactician, es decir cuando un jugador cambie su unidad actual, esta será notificado al controlador de manera que también cambie su parámetro (Esto lo hace a travez del método propertyChange).

Para el caso de UnitDie, este sera llamado cuando una unidad muere, para este caso el método de propertyChange se encargara de setear a la unidad como muerta, remover a la unidad de la posición actual del mapa y finalmente verificar si corresponde al tipo Hero, si es así, se llamara al método heroDie() de el tactician, el cual se encargara de eliminar al jugador.

Finalmente la clase UnitDie se encargara de responder frente a la muerte de la unidad de un Tactician. Si esto sucede, el jugador que se le fue eliminado la unidad Hero, debe ser removido de la partida.

#### Métodos del Tactician a aplicar a sus unidades

El tactician tendrá a disposición distintos métodos que le permitirán realizar acciones implementadas en la tarea 1, como atacar con sus unidades, mover a su unidad, ver sus parámetro, items, etc, de esta manera el jugador poseerá el conocimiento necesario para que su partida sea lo más jugable posible.





## Fabricas

Las fabricas son las encargadas de crear las unidades, items y el mapa del juego, estas se basan en el patrón de diseño de Factorys, cada clase de las mencionadas anteriormente tendrá sus propias fabricas, de esta manera el jugador no podrá interaccionar con los parámetros que están por detrás en la creación de una unidad, objeto, etc, al jugador solo se le entregara la unidad ya creada.

### Fabrica de Unidades

Esta fabrica se encargara de crear las distintas unidades que se encuentran en el juego, para esto se dividió en dos tipos, el método create normal y el createDefault, para el primero se recibieran parámetros como los hitpoints y una lista de items, de manera que al crear la unidad se pueda entregar la vida de este así como sus items iniciales, mientras que el segundo es una creación de una unidad por default, es decir no se podrán modificar los hitpoints ni la lista de items, es decir estos parámetros vendrán por default. Es importante notar que una vez creada la unidad, antes de retornarla se setea el dueño de la unidad y se agrega a la lista de unidades del jugador. 

Es importante notar que la unidad no se coloca en ningún mapa (para completar con los parámetros, se rellena con un InvalidLocation).

Para la creación de este tipo de fabrica se decidió crear una interfaz UnitFactory con los métodos create y createDefault, esta será implementada por la clase abstracta AbstractUnitFactory, la cual será heredada por las distintas fabricas de unidades.


### Fabrica de Objetos

Este tipo de fabrica se encarga de la creación de los distintos elementos que se encuentran disponibles en el juego, funciona de manera similar a la anterior, se divide en dos métodos importantes, los cuales son el create y createDefault, el primero se encarga de crear el item correspondiente, pudiendo modificar el poder, el rango mínimo y máximo, mientras que el segundo genera un item con parámetros por default (estos son dependiendo del item). Una vez creado el item no poseera dueño, este tendrá que ser asignado luego.


### Fabrica de Mapa

Para la creación de esta fabrica, se dividió en dos métodos de creación de mapa, uno es con una semilla al azar y otra con una semilla random, la segunda es principalmente para hacer mucho mas faciles los test del mapa.

El método getField se encargara de introducir las celdas a un Field en principio vació, para esto primero crea nuevas Location en todos los puntos del HashMap, luego recorrerá nuevamente las celdas, pero esta vez a través de un random, donde se decidirá si remover una location del mapa. Para remover una Location, se retiraran todos los vecinos de la Location, de esta manera quedara completamente aislada (tambien se retiran esta location de los vecinos de las zonas alrededor. Una vez terminado todo ese proceso, se chequeara el mapa para ver si es conexo o no, en caso de no serlo, se recorrerá el HashMap nuevamente, agregando al mapa la location antes retirada, y se volverá a verificar la conexividad, este proceso se repetirá hasta que el mapa sea conexo, el proceso anterior lo realiza el método checkMap.


Una vez que el mapa es creado exitosamente, es retornado al controlador para que lo guarde y pueda ser utilizado en el juego. 
