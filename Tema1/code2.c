#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main () {

    printf("Ejemplo de usos de system(): ");
    printf("\n\tListado del directorio actual y envio a un fichero: ");
    printf("%d", system("ls>ficsalida"));
    printf("\n\tVemos el contenido del fichero...");
    printf("%d", system("cat ficsalida"));
    printf("\n\tEste comando es erroneo: %d:", system("ged"));
    printf("\n\tFin de programa...\n");

    return 0;
}