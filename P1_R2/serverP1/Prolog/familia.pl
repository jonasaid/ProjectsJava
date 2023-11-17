/* Hechos */

hombre(javier).
hombre(pedro).
hombre(jorge).
hombre(alfonso).
hombre(juan).

mujer(maria).
mujer(carmen).
mujer(teresa).
mujer(alicia).

progenitor(javier, pedro).
progenitor(maria, pedro).
progenitor(javier, teresa).
progenitor(maria, teresa).
progenitor(pedro, alfonso).
progenitor(carmen, alfonso).
progenitor(pedro, juan).
progenitor(carmen, juan).
progenitor(teresa, alicia).
progenitor(jorge, alicia).

/* Reglas */
padre(X,Y):- progenitor(X,Y), hombre(X).
madre(X,Y):- progenitor(X,Y), mujer(X).
abuelo(X,Y):- padre(X,Z), progenitor(Z,Y).
abuela(X,Y):- madre(X,Z), progenitor(Z,Y).
ascendencia(X,Y) :- progenitor(X,Y).
ascendencia(X,Y) :- progenitor(X,Z), ascendencia(Z,Y).



