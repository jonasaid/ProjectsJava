protagonista(shaggy ,masculino).
protagonista(fred,masculino).
protagonista(daphne,femenino).
protagonista(velma ,femenino).
protagonista('scooby doo',masculino).
protagonista('scrappy doo',masculino).

humano(shaggy).
humano(fred).
humano(daphne).
humano(velma).

perro('scooby doo').
perro('scrappy doo').

/* Reglas */

heroe(X):-protagonista(X,masculino),humano(X).
heroina(X):- protagonista(X,femenino),humano(X).
estrellas(X):-protagonista(X,masculino),perro(X).

