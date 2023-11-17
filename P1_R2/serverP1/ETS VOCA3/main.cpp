#include<iostream>
#include<stdlib.h>
#include<string.h>
#include<fstream>
using namespace std;
string texto;

string abrir(){
    ifstream archivo;
    
    archivo.open("sargazo.txt",ios::in);

    if(archivo.fail()){
        cout<<"No es posible abrir el archivo";
        exit(1);
    }

    while(!archivo.eof()){
        getline(archivo,texto);
        cout<<texto<<endl;
    }

    archivo.close();    
    return texto;
}

int espacios(){
    char espacios = ' '; 
    string lineas;
    
    ifstream archivo ("sargazo.txt");
    if (archivo.is_open())
    {

        while ( getline (archivo,lineas) )
        {
        cout << lineas;
        }
        archivo.close();
    }

    else cout << "No es posible abrir el archivo"; 

    return 0;
}

int main(){
	abrir();
	system("pause");
	
	return 0;
}

