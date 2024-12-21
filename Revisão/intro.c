#include <stdio.h> //input e output
#include <stdlib.h> // lib auxiliar p/ system pause;

int main (){
    //corpo do programa
    printf("Hello World!\n");
    
    system("pause"); //espera o comando do usuário para encerrar o programa
    return 0;
}


int main (){
    //corpo do programa
    printf("Hello World!\n");
    

    //tipos de dados e  declaração de variáveis
    char x = 'a';
    int w = 8;
    long int e = 4562145;
    long long int t = 148962145621445256;
    float n = 5.145;
    double m = 5.4785;
    

    // printf => cout 
    printf("%c \n", x); //%c => char
    printf("%d \n", x); //%d => decimal ou o numero da letra na tab ASC
    printf("%f \n", x); //%f => float reais


    //scanf => cin
    scanf("%c", &x);
    scanf("%d", &w);
    scanf("%d", &e);
    scanf("%d %f", w, n);


    // Operadores Relacionais
    // (>) (<) (>=) (<=) (!=) (==)

    // Operadores Lógicos
    // (&&) // (||)
    // ! operador de negação


    //CONDICIONAIS
    if ((x > 0) && (x %2 == 0)){
        printf("O valor eh positivo.");
    } else if (x == 0){
        printf("O valor eh zero.");
    }else{
        printf("O valor eh negativos");
    }

    //OPERADOR TERNÁRIO
    // var = (condição) ? resultado verdadeiro : resultado falso;

    // SWITCH CASE
    switch (x)
    {
    case 'a': printf("digitado a letra 'A'\n"); break;
    case 'b': printf("digitado a letra 'B'\n"); break;
    default: printf("Nao tem caracteres"); break;
    }

    //REPETIÇÕES
    while(x >= 0){
        printf("%d\n", x);
        x--;
    }



    system("pause"); //espera o comando do usuário para encerrar o programa
    return 0;
}