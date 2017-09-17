Juego 2017



                         PROGRAMACIÓN​ ​ORIENTADA​ ​A​ ​OBJETOS  

                                    TRABAJO​ ​PRÁCTICO​ ​FINAL​ ​2017  

                                                        “AircraftWar”  

OBJETIVO  

El   proyecto       será     utilizado     como      una     herramienta         para    el   desarrollo       práctico     de    las  
incumbencias  propias  de  la  cátedra.  Las  entregas  sucesivas  permiten  la  implementación  de  los  
temas  teóricos  y  la  generación  de  un  proyecto  por  etapas  que  facilita  la  asimilación  de  las  
características​ ​de​ ​POO.  

Dado  el  objetivo  de  la  cátedra  de  lograr  un  mejor  aprendizaje  del  alumno,  se  ha  diseñado  una  
aplicación​ ​que​ ​implementa​ ​un​ ​juego​ ​sencillo​ ​en​ ​distintas​ ​etapas.   

El​ ​trabajo​ ​deberá​ ​ser​ ​realizado​ ​bajo​ ​las​ ​condiciones​ ​explicitadas​ ​por​ ​la​ ​cátedra.  

DESCRIPCIÓN  

El  juego  A​ ircraftWar  ​se  desarrolla  como  una  guerra  de  naves  que  intentan  destruirse  unos  a  
otros​ ​con​ ​el​ ​objetivo​ ​de​ ​ser​ ​el​ ​último​ ​en​ ​quedar​ ​vivo.   

El  escenario  del  juego  es  una  pantalla  donde,  en  un  principio,  las  naves  aparecen  ubicadas  en  
una​ ​posición​ ​aleatoria.  

Existen​ ​distintos​ ​tipos​ ​de​ ​naves,​ ​y​ ​cada​ ​una​ ​posee​ ​un​ ​tipo​ ​de​ ​comportamiento​ ​específico.  

Una  nave  es  un  dispositivo  que  puede  desplazarse  por  todo  el  escenario  del juego,  posee  una  
velocidad,  dirección  en  la  que  avanza  y  un  nivel  de  combustible. Además,  cada nave cuenta con  
armamento  especializado,  conformado  por  un  radar,  una  carga  inicial  de  misiles  y  bombas que  
puede​ ​utilizar​ ​para​ ​destruir​ ​a​ ​sus​ ​adversarios.   

El  movimiento  de  las  naves  está  determinado  por  la  velocidad  y  la  dirección  en  la  que  desea  
desplazarse,  cada  vez  que  una  nave avanza gasta una unidad de combustible  (si una nave queda  
sin  combustible  sigue  jugando  pero  no  puede  moverse).  Ejemplo:  una  nave  puede  avanzar  en  
dirección​ ​30º​ ​a​ ​una​ ​velocidad​ ​de​ ​2.​ ​La​ ​velocidad​ ​estará​ ​representada​ ​por​ ​pixeles​ ​por​ ​turno.  

Cada  nave  tiene  un  nivel  de  destrucción.  Cuando  se  inicia  el juego  todas  las  naves  poseen nivel  
de  destrucción  0  y  cuando  llegan  a  100  se considera que la nave está completamente destruida.  
Cuando  una  nave  se encuentra en un nivel de destrucción mayor al 70% disminuye su velocidad  
en​ ​la​ ​mitad.  




Además​ ​de​ ​las​ ​naves,​ ​existen​ ​otro​ ​tipo​ ​de​ ​dispositivos.  

-  Obstáculo  explosivo:  Dispositivo  que  se  encuentra  en  algún  lugar  del  escenario,  pero  se  
      destruye  cuando  colisiona  con  cualquier  otro  tipo  de  dispositivo  (naves,  misil, bomba, etc.).  
      Cuando  explota,  permanece  un  tiempo  explotando  y  luego  desaparece.  Cuando  una  nave  
      choca​ ​contra​ ​un​ ​dispositivo​ ​de​ ​este​ ​tipo,​ ​incrementa​ ​su​ ​nivel​ ​de​ ​destrucción​ ​en​ ​XX​ ​cantidad.  

-  Pasadizo:  Un  pasadizo  se  comporta  como  un  túnel  donde  existen  una  entrada  (el  propio  
      pasadizo)  y  una  salida  (otro  pasadizo  ubicado  en  algún  lugar  del  escenario).  Cuando  una  
      nave  se  traslada  por  el  escenario  utilizando  un pasadizo, disminuye su nivel de combustible  
      en  15  puntos.  Por  ejemplo,  si  tenemos  un  pasadizo  en  la  zona  superior  del escenario y otro  
      en  la  zona  inferior,  cuando  una  nave  ingresa  en  el  pasadizo  superior  saldrá  por  el  inferior  
      sin​ ​sufrir​ ​destrucción​ ​alguna.  

-  Bonus:  Todos  los  bonus  tienen  un  tiempo  de  vida  determinado.  Finalizado  ese  tiempo  de  
      vida​ ​se​ ​destruyen.   

           o Bonus  de  reparación:  Cuando  una  nave  o  misil  impacta con un bonus de reparación,  
                 disminuye  su  nivel  de  destrucción  en  XX unidades y recarga su nivel de combustible  
                 al​ ​valor​ ​inicial.  

           o Bonus  de  inmunidad:  Cuando  una  nave  obtiene  este  bonus,  permanece  inmune  (no  
                 se​ ​destruye)​ ​por​ ​un​ ​tiempo​ ​determinado.   

           o Bonus  misil:  Este  bonus  tiene  un  tiempo  de  vida.  Cuando  una  nave  obtiene  este  
                 bonus​ ​recarga​ ​la​ ​cantidad​ ​de​ ​misiles​ ​a​ ​su​ ​nivel​ ​inicial.  

Cada  nave  posee  un  radar  que  puede  utilizar para detectar otros dispositivos en el escenario de  
juego.  El  radar  es  la  única  forma  que  tiene  una  nave  de  conocer  donde  se  encuentran  otros  
dispositivos.   

Estos  radares  se  encuentran  sobre  la  nave,  poseen  un  ángulo  de  apertura,  una  dirección  y  un  
alcance.   Este  alcance  disminuye  a  medida  que  aumenta  el  ángulo  de  apertura  (cuanto  más  
amplio  es  el  ángulo,  más  corto  el  alcance).  Cuando el radar detecta elementos dentro de su área  
de  cobertura,  le  avisa  a  su  nave  de  dicho  evento.  Luego,  cada  nave  puede  determinar  que  
realizar​ ​con​ ​esta​ ​información.  

Los  misiles,  son  dispositivos  que  puede  disparar  una  nave, poseen una velocidad constante y se  
destruyen  cuando  colisionan  con  cualquier  otro  tipo  de  elemento.  Cuando  la  colisión  se  da  
contra​ ​otra​ ​nave,​ ​le​ ​aumente​ ​el​ ​nivel​ ​de​ ​destrucción​ ​en​ ​XX​ ​puntos.  

Las  bombas,  son  dispositivos  que  dispara  una  nave,  comienzan  con  una  velocidad  inicial  y  
disminuye  en  forma  progresiva  hasta  detenerse  y explota. Cuando una bomba explota, aumenta  
su​ ​tamaño​ ​en​ ​3​ ​veces​ ​y​ ​un​ ​nivel​ ​de​ ​destrucción​ ​de​ ​XX​ ​puntos​ ​en​ ​las​ ​naves​ ​alcanzadas.  

En​ ​el​ ​desarrollo​ ​del​ ​juego​ ​se​ ​presentan​ ​los​ ​siguientes​ ​tipos​ ​de​ ​naves:  

-  Crazy :  Se  mueve  por  el  escenario  sin  un  rumbo  fijo,  y  dispara  misiles  cada  vez  que  toca  
      alguno​ ​de​ ​los​ ​límites​ ​del​ ​escenario.  
	  
-  Ecuatorial:  Se mueve en forma horizontal, cuando llega al límite del escenario se desplaza en  
      forma  vertical algunas posiciones y vuelve a retomar su rumbo horizontal contrario. Dispara  
      misiles  cuando  detecta  una  nave  en  el  radar.  Si  por  el  contrario  detecta  a  más  de  3  naves,  
      dispara​ ​una​ ​bomba.  

-  Greenwich:  Se  mueve  en  forma  vertical,  cuando  llega  al  límite  del  escenario,  invierte  su  
      dirección.​ ​Dispara​ ​misiles​ ​solo​ ​cuando​ ​detecta​ ​algún​ ​dispositiva​ ​más​ ​cerca​ ​de​ ​xx​ ​unidades.  

-  Manual:​ ​Nave​ ​controlado​ ​por​ ​el​ ​usuario,​ ​por​ ​medio​ ​del​ ​teclado.  

El juego  inicia  con  una  nave de cada tipo, y en forma aleatoria aparecen distintos tipos de bonus  
en  el  escenario.  Todos  los  dispositivos  del  juego  tiene  la  posibilidad  de  realizar  algo  cada  vez  
que​ ​le​ ​toque​ ​su​ ​turno,​ ​dependiendo​ ​del​ ​tipo​ ​de​ ​dispositivo​ ​será​ ​el​ ​tipo​ ​de​ ​acción​ ​que​ ​realicen.   

El  objetivo  del  juego  es  destruir  a  todos  las  naves  del  escenario  durante  el  tiempo  que  dure  la  
partida.  La  nave  que  queda  viva  gana.  Si  luego  de  finalizado  el  tiempo  del juego  quede  más  de  
una​ ​nave​ ​viva,​ ​el​ ​ganador​ ​será​ ​la​ ​nave​ ​que​ ​posea​ ​el​ ​menor​ ​nivel​ ​de​ ​destrucción.  
	  