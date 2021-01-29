import logging
import threading
import time

format = "%(asctime)s:%(message)s"
logging.basicConfig(format=format,level=logging.INFO,datefmt="%H:%M:%S")

def run(max:int,millis:int,par:bool):
    if(par):
        printPar(max,millis)
    else:
        printImpar(max,millis)

def printPar(max:int,millis:int):
    for i in range(2,max,2):
        logging.info(i)
        time.sleep((millis/1000))

def printImpar(max:int,millis:int):
    for i in range(1,max,2):
        logging.info(i)
        time.sleep((millis/1000))

maximo = int(input("Ingrese el límite superior"))
milisegundos= int(input("Ingrese el tiempo de espera en milisegundos")) 

thread1 = threading.Thread(target=run,args=(maximo,milisegundos,False))
thread2 = threading.Thread(target=run,args=(maximo,milisegundos,True))

thread1.start()
thread2.start()