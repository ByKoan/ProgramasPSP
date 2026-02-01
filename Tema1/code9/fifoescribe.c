#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <fcntl.h>

int main () {
    int fp;
    char saludo [] = "Un saludo!!!\n";
    fp = open ("FIFO2", 1);
    
    if (fp == 1) {
        printf("Error al abrir al fichero...");
        return 0;
    }

    printf("Mandando informacion al FIFO.\n");
    write(fp, saludo, strlen(saludo));
    close(fp);

    return 0;
}