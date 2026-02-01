#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main () {

    pid_t pid, hijo_pid;
    pid = fork();

    if (pid == -1 ) {
        perror("Error al crear el proceso\n");
        return 1;
    } else if (pid == 0) {
        printf("Soy el proceso hijo\n\tmi PID es %d, el PID de mi padre es %d\n", getpid(), getppid());
    } else {
        hijo_pid = wait(NULL);
        printf("Soy el proceso padre\n\tMi PID es %d, el PID de mi padre es %d\n\t mi hijo: %d termino.\n", getpid(), getppid(), pid);
    }

    return 0;
}