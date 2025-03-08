import java.util.Stack;

public class Logica {
   public static int Prioridade(char x) {
        if(x == '*' || x == '/') {  //colocando prioridades nos operadores;
            return 1;
        }
        else if (x=='+' || x == '-') {
            return 0;
        }
        return -1;
    }
    public static String Numeros(String expressao) {
        String resposta = "";
        Stack<Character> pilha = new Stack<>();
        int transforma_char = expressao.length();

        for(int i=0; i < transforma_char; i++) {
            char valor = expressao.charAt(i);

            if(valor >= '0' && valor <= '9') {
                resposta+=valor; //atribuindo os numeros (operantes) na resposta;
            }
            
            
         /* Use a lógica do parêntese somente se for necessário, mas para isso deverá trocar o Queue */   
            
        //  else if(valor == '(') {
        //         pilha.add('(');
        //     }
        //     else if(valor == ')') {
        //         while(!pilha.isEmpty() && pilha.peek() != '(') {
        //             resposta+=pilha.pop();
        //         }
        //         if(!pilha.isEmpty()) {
        //             resposta+=pilha.pop();
        //         }
        //     }
            
            else {
                while(!pilha.isEmpty() && Prioridade(pilha.peek()) == 1) {
                    // System.out.println("operador no topo " + Prioridade(pilha.peek()));
                    resposta+=pilha.pop(); //alego que a pilha contém elementos (mesmo eu não tendo adicionando algum, devido fato de ela poder acessar elementos presentes em armazenamentos, ela consegue fazer o mesmo papel dentro do método de Prioridade, ele vai verificar os valores de X, aquele que estiver = 1, ele vai descer e atribuir ao resultado)
                
                }
                // while(!pilha.isEmpty() && Prioridade(pilha.peek()) == 0) {
                //     resposta+=pilha.poll();
                // }
                pilha.add(valor); //sobe o valor na pilha, mas agora somente com os operadores de prioridade menor que 1. Lembrando que se for uma expressão de +/-, a lógica acima será ignorada e vai retornar somente os operadores de prioridade 0. Caso tenha algum de prioridade 1, vai retornar ele primeiro e depois o de prioridade 0.
               //Mas geralmente a multiplicação fica entre os caracteres numerais. Então uma expressão grande irá ter um retorno por ex: 10+10*2/4 = 10102*4/+
                // System.out.println("operador no topo atualmente " + Prioridade(pilha.peek()));
            }
        }
        while(!pilha.isEmpty()) {
            resposta+=pilha.pop(); //os removendo e atribuindo na respostas
        }
        
        return resposta;   
    } 
}
