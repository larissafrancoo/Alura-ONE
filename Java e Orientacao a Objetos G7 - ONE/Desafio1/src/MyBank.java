import java.util.Scanner;

public class MyBank {
    public static double dados_cliente() {
        Scanner entrada = new Scanner(System.in);
        String nomeCliente;
        double valorInicial = -1;

        System.out.println("""
                Olá, bem-vindo ao MyBank! :)
                Vamos abrir uma nova conta corrente para você
                
                Por favor, me diga seu nome completo:""");
        nomeCliente = entrada.nextLine();
        while (valorInicial < 0) {
            System.out.println("Quanto você quer começar depositando?");
            valorInicial = entrada.nextDouble();
            if (valorInicial < 0)
                System.out.println("Desculpe, não podemos iniciar com saldo negativo :(");
        }
        System.out.println("Perfeito! Aqui estão seus dados:");
        System.out.printf("""
                ***********************
                Nome: %s
                Tipo conta: corrente
                Saldo inicial: R$ %.2f
                ***********************
                
                Agora podemos operar com sua conta ;)
                """, nomeCliente, valorInicial);
        entrada.close();
        return valorInicial;
    }
    public static void main(String[] args) {
        double saldoAtual = dados_cliente();
        Scanner opcao = new Scanner(System.in);
        int opcaoDesejada = 0;
        double valorDeEntrada;
        while (opcaoDesejada != 4)
        {
            System.out.println("""
                
                Operações
                
                1 - Consultar saldos
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                
                Digite a opção desejada:""");

            opcaoDesejada = opcao.nextInt();
            switch (opcaoDesejada) {
                case 1:
                    System.out.printf("O saldo atual é R$ %.2f%n", saldoAtual);
                    break ;
                case 2:
                    System.out.println("Informe o valor a receber:");
                    valorDeEntrada = opcao.nextDouble();
                    if (valorDeEntrada < 0)
                        System.out.println("Para diminuir o saldo, selecione a opção '3'.");
                    else {
                        saldoAtual += valorDeEntrada;
                        System.out.printf("Saldo atualizado R$ %.2f%n", saldoAtual);
                    }
                    break ;
                case 3:
                    System.out.println("Informe o valor a transferir:");
                    valorDeEntrada = opcao.nextDouble();
                    if (valorDeEntrada > saldoAtual)
                        System.out.println("Não há saldo suficiente para fazer essa transferência.");
                    else {
                        saldoAtual -= valorDeEntrada;
                        System.out.printf("Saldo atualizado R$ %.2f%n", saldoAtual);
                    }
                    break ;
                case 4:
                    System.out.print("Programa encerrado.");
                    break ;
                default:
                    System.out.println("Opção inválida");
                    break ;
            }
        }
        opcao.close();
    }
}
