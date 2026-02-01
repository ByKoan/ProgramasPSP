#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <fcntl.h>
#include <sys/wait.h>

int main () {

    pid_t pid, hijo_pid, pid2, hijo2_pid;
    int fd1[2];
    int fd2[2];

    char saludoAbuelo[] = "Saludos del abuelo";
    char saludoPadre[] = "Saludos del padre";
    char saludoHijo[] = "Saludos del hijo";
    char saludoNieto[] = "Saludos del nieto";

    char buffer [80] = "";

    pipe(fd1);
    pipe(fd2);

    pid=fork(); // Soy el abuelo creo al hijo

    if (pid == -1) {
        puts("No se ha podido crear el proceso hijo...");
        return 0;
    } else if (pid == 0) {
        pid2=fork();
        switch(pid2) {

            case -1:

                puts("No se ha podido crear el proceso nieto...");
                return 0;
                break;

            case 0:

                close(fd2[1]);
                read(fd2[0], buffer, sizeof(buffer));
                printf("\tNieto recibe mensaje de su padre: %s\n", buffer );

                printf("\tNieto envia mensaje a su padre: %s\n", buffer);
                close(fd1[0]);
                write(fd1[1], saludoNieto, strlen(saludoNieto));
                break;

            default:

                close(fd1[1]);
                read(fd1[0], buffer, sizeof(buffer));
                printf("\tHijo recibe mensaje de su padre (ABUELO): %s\n", buffer);

                printf("\tHijo envia mensaje de su hijo (Nieto)\n");
                close(fd2[0]);
                write(fd2[1], saludoPadre, strlen(saludoPadre));

                close(fd1[1]);
                read(fd1[0], buffer, sizeof(buffer));
                printf("\tHijo recibe mensaje de su hijo (Nieto): %s\n", buffer);

                printf("\tHijo envia mensaje a su padre (Abuelo)\n");
                close(fd2[0]);
                write(fd2[1], saludoHijo, strlen(saludoHijo));
                break;
        }
    } else {
        printf("\tAbuelo envia mensaje a su hijo\n");
        close(fd1[0]);
        write(fd1[1], saludoAbuelo, strlen(saludoAbuelo));
        hijo_pid = wait(NULL);

        close(fd2[1]);
        read(fd2[0], buffer, sizeof(buffer));
        printf("\tAbuelo recive mensaje de su hijo: %s\n", buffer);
    }
    return 0;
}


















