#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main () {
    
    pid_t pid, hijoPID, pid2, hijo2PID;

    pid = fork();

    if (pid == -1) {
        perror("Error al crear el proceso hijo...");
        return 0;
    } else if (pid == 0) {
        pid2 = fork();

        if (pid2 == -1) {
            perror("Error al crear el proceso hijo...");
            return 0;            
        } else if (pid2 == 0) {
            printf("Soy el proceso NIETO %d; mi padre es= %d; mi id de grupo es %d\n", getpid(), getppid(), getpgrp());
        } else {
            hijo2PID = wait(NULL);
            printf("Soy el proceso PADRE: %d mi padre es = %d; mi ID de grupo es %d Mi hijo: %d termino \n", getpid(), getppid(), pid2);
        }
    } else {
        hijoPID = wait(NULL);
        printf("Soy el proceso ABUELO: %d; mi padre es  = %d; mi ID de grupo es %d Mi hijo: %d termino. \n", getpid(), getppid(), getpgrp(), pid);
    }

    return 0;
}