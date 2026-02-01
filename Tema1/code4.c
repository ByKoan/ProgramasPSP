#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

#define NUM_PROCESOS 3
int I = 0;

void codigo_del_proceso(int id) {
    for (int i = 0; i < 10; i++) {
        printf("Proceso %d: i=%d, I=%d\n", id, i, I++);
        exit(id);
    }
}

int main () {

    int p;
    int id[NUM_PROCESOS] = {1, 2, 3};
    int pid;
    int salida;
    
    for (p=0; p<NUM_PROCESOS; p++) {
        pid=fork();
        if (pid == -1) {
            perror("Error al crear el proceso\n");
            return 0;
        } else if (pid == 0) {
            codigo_del_proceso(id[p]);
        }
    }

    for (p = 0; p < NUM_PROCESOS; p++) {
        pid = wait(&salida);
        printf("Proceso padre: proceso %d con id=%x terminado", pid, salida >> 8);
    }

    return 0;
}