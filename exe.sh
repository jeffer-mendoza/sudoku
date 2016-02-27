#!/bin/bash


echo "Esta ejecutando el algoritmo las vegas para resolver el sudoku... espere un momento\n\n"

for a in `seq 1 5`; do
	echo "Sudoku No. ==>"  $a"%"
    /opt/jdk1.8.0_60/bin/java -jar dist/Sudoku.jar sudoku.txt & sleep 300 && kill $! 2>/dev/null && echo "myProgram didn't finish"
done


echo "*************************************************\n\n"
 echo "Se ejecuto exitosamente, revise los archivos que corresponden a cada escenario:\n
       \t banco-1.csv \n
       \t banco-6.csv \n 
       \t banco-7.csv \n\n"