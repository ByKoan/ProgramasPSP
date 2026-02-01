#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <fcntl.h>
#include <signal.h>
#include <stdio.h>
#include <unistd.h>

void gestion_padre(int segnal) {
    printf("Padre recibe señal..%d\n", segnal);
}

void gestion_hijo(int segnal) {
    printf("Hijo recibe señal..%d\n", segnal);
}

int main () {
    int pid_padre, pid_hijo;
    pid_padre = getpid();
    pid_hijo = fork();

    switch (pid_hijo){
        case -1: 
            printf("Error al crear el proceso hijo...\n");
            return 0;

        case 0:

            signal (SIGUSR1, gestion_hijo);
            while (1) {
                sleep(1);
                kill(pid_padre, SIGUSR1);
                pause();
            }
            break;

        default:

            signal(SIGUSR1, gestion_padre);
            while (1) {
                pause();
                sleep(1);
                kill(pid_hijo, SIGUSR1);
            }
            break;
    }
    return 0;
}