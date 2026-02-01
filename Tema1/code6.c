#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <string.h>
#include <fcntl.h>

int main () {

    char saludo[] = "Un saludo!!!\n";
    char buffer[10];
    int fd, bytesLeidos;

    fd = open("texto.txt", 1);
    if (fd == -1) {
        printf("ERROR al abrir el archivo\n");
        return 0;
    }

    printf("Escribo el saludo...\n");
    write(fd, saludo, strlen(saludo));
    close(fd);

    fd = open("texto.txt", 0);
    printf("El contenido del fichero es: \n");
    bytesLeidos = read(fd, buffer, 1);
    while (bytesLeidos) {
        printf("%s", buffer);
        bytesLeidos = read(fd, buffer, 1);
    }
    close(fd);

    return 0;
}