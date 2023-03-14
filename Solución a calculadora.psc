Algoritmo calculadora
	Definir operando1, operando2, resultado como Real;
	Definir operacion como Caracter;
	
	Escribir "Introduce el primer operando:";
	Leer operando1;
	
	Escribir "Introduce el segundo operando:";
	Leer operando2;
	
	Escribir "Indica operación: S Suma, R Resta, P Producto, Q Cociente";
	Leer operacion;
	
	Segun operacion Hacer
		'S','s':
			resultado<-operando1+operando2;
		'R','r':
			resultado<-operando1-operando2;
		'P','p':
			resultado<-operando1*operando2;
		'Q','q':
			Si operando2<>0
				resultado<-operando1/operando2;
			SiNo
				Escribir "No se puede dividir por cerooooo!!!";
			FinSi	
		De Otro Modo:
			Escribir "Operación no soportada";
	Fin Segun
	
	Escribir "El resultado es: ", resultado;
	
FinAlgoritmo
