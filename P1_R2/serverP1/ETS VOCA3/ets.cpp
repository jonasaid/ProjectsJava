#include<iostream>
#include<stdlib.h>
#include<string.h>
#include<fstream>
using namespace std;
string texto;

void blankspace()
{
	ifstream fin;
	fin.open("sargazo.txt");
	char ch;
	int count=0;
	while(!fin.eof())
	{
		fin.get(ch);
		if(ch==' ')
			count++;
	}
	cout<<"Number of blank spaces in file are "<<count;
	fin.close();
}

 
int main(){
   return 0;
}

