#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    int i = 0;

    switch(fork()) {
        case -1: 
            perror("Error al crear el proceso\n");
            return 0;
            break;
        case 0: 
            while(i<5){
                sleep(1);
                printf("\t\tSoy el proceso hijo: %d\n", i++);
            }
            break;
        default:
            while(i<5) {
                printf("Soy el proceso padre: %d\n", i++);
                sleep(2);
            }
    };
    return(0);
}