class Billetes {
   //Los atributos de la clase, los cuales son la denominaion, 
   //la cantidadBilletes (cuantos billetes y monedas forman parte de la solucion)
   //cantidadBilletesDisponibles, cuantos billetes dispnibles tenemos. 
   Integer denominaciones;
   int cantidadBilletes;
   int cantidadBilletesDisponibles;   

    //Constructor de billetes simplemente le asigna los parametros recibidos a los atributos   
    public Billetes(Integer denominaciones, int cantidadBilletes) {
        this.denominaciones = denominaciones;
        this.cantidadBilletes = cantidadBilletes;
    }
    
    //Segundo constructor de billetes simplemente le asigna los parametros recibidos a los atributos,
    //pero, la cantidad de billetes siempre la dejara en 0, esto porque este constructor lo utilizaremos
    //dentro del metodo rellenarListaDenominacion()
    public Billetes(Integer denominaciones, int cantidadBilletes, int cantidadBilletesDisponibles) {
        this.denominaciones = denominaciones;
        this.cantidadBilletes = 0;
        this.cantidadBilletesDisponibles = cantidadBilletesDisponibles;
    }
    
    //Agrega una moneda o billete 
    public void sumaUnbillete() {
        cantidadBilletes++;
    }
     
    //Quita una moneda o billete disponible
    public void quitarBilletesDisponibles() {
        cantidadBilletesDisponibles--;
    }
        
    //Me permite imprimir la lista de objetos (la cantidad de billestes y su denominación)
    @Override
    public String toString() {
        return  cantidadBilletes + "($"+denominaciones+")";
    }
}
