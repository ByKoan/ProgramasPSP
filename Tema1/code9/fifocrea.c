#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <fcntl.h>
#include <sys/stat.h>

int main () {

    int fp;
    int p, bytesleidos;
    char saludo[] = "Un saludo!!!\n";
    char buffer[10];

    p = mknod("FIFO2", S_IFIFO|0666, 0);

    if (p == -1) {
        puts("Ha ocurrido un error....");
        return 0;
    }

    while (1) {
        fp = open("FIFO2", 0);
        bytesleidos = read(fp, buffer, 1);
        printf("%s", buffer);
        while (bytesleidos != 0)
        {
            printf("%s", buffer);
            bytesleidos = read(fp, buffer, 1);
        }
        close(fp);        
    }

    return 0;
}