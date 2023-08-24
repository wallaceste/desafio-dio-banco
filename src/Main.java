import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        List<Banco> bancosList = new ArrayList<>();
        List<Conta> contaCorrenteList = new ArrayList<>();
        List<Conta> contaPoupancaList = new ArrayList<>();
        Conta contaEscolhida;
        int opcaoMenu;
        int opcaoMenuInterno;
        String nomeBanco;
        int idBancoEscolhido;
        int idAgenciaEscolhida;
        int idContaEscolhida;
        String nomeCliente;
        int numeroConta;
        int seletor;


        do {

            opcaoMenu = menu();

            switch (opcaoMenu){
                case 1:
                    System.out.println("Informe o nome do banco:");
                    nomeBanco = scan.nextLine();
                    System.out.println("Informe quantas agências serão cadastradas:");
                    int qtdAgencias = scan.nextInt();scan.nextLine();
                    int[] agencias = new int[qtdAgencias];
                    for(int i=0;i<agencias.length;i++){
                        System.out.println("Informe o número da agencia " + (i+1));
                        agencias[i] = scan.nextInt();scan.nextLine();
                    }
                    bancosList.add(new Banco(nomeBanco, agencias));
                    System.out.println("Banco criado com sucesso!");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Selecione o banco onde a conta será aberta:");
                    for(int i=0;i<bancosList.size();i++){
                        System.out.println(bancosList.get(i).getNome() + " - " + (i+1));
                    }
                    idBancoEscolhido = scan.nextInt()-1;scan.nextLine();

                    System.out.println("Selecione a agência:");
                    for(int i=0; i<bancosList.get(idBancoEscolhido).getAgencias().length;i++){
                        System.out.println(bancosList.get(idBancoEscolhido).escolheAgencia(i) + " " + (i+1));
                    }
                    idAgenciaEscolhida = scan.nextInt()-1;scan.nextLine();

                    System.out.println("Informe o nome do cliente:");
                    nomeCliente = scan.nextLine();

                    contaCorrenteList.add(new ContaCorrente(bancosList.get(idBancoEscolhido), bancosList.get(idBancoEscolhido).escolheAgencia(idAgenciaEscolhida),nomeCliente));
                    break;
                case 3:
                    System.out.println("Selecione o banco onde a conta será aberta:");
                    for(int i=0;i<bancosList.size();i++){
                        System.out.println(bancosList.get(i).getNome() + " - " + (i+1));
                    }
                    idBancoEscolhido = scan.nextInt()-1;scan.nextLine();

                    System.out.println("Selecione a agência:");
                    for(int i=0; i<bancosList.get(idBancoEscolhido).getAgencias().length;i++){
                        System.out.println(bancosList.get(idBancoEscolhido).escolheAgencia(i) + " " + (i+1));
                    }
                    idAgenciaEscolhida = scan.nextInt()-1;scan.nextLine();

                    System.out.println("Informe o nome do cliente:");
                    nomeCliente = scan.nextLine();

                    contaPoupancaList.add(new ContaPoupanca(bancosList.get(idBancoEscolhido), bancosList.get(idBancoEscolhido).escolheAgencia(idAgenciaEscolhida),nomeCliente));
                    break;
                case 4:
                    System.out.println("Informe o nome do cliente:");
                    nomeCliente = scan.nextLine();

                    for(Conta conta: contaCorrenteList){
                        if(conta.getNomeCliente().equalsIgnoreCase(nomeCliente)){
                            System.out.println("Conta Corrente: " + conta.getNumero());
                        }
                    }
                    for(Conta conta: contaPoupancaList){
                        if(conta.getNomeCliente().equalsIgnoreCase(nomeCliente)){
                            System.out.println("Conta Poupança: " + conta.getNumero());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Selecione: 1 - Conta Corrente   2 - Conta Poupança ");
                    int tipoConta = scan.nextInt();scan.nextLine();
                    System.out.println("Informe o nome do cliente:");
                    nomeCliente = scan.nextLine();
                    System.out.println("Informe o numero da conta:");
                    numeroConta = scan.nextInt();scan.nextLine();
                    if(tipoConta == 1){
                        for(Conta conta: contaCorrenteList){
                            if(conta.getNomeCliente().equalsIgnoreCase(nomeCliente) &&
                                    (conta.getNumero() == numeroConta)){
                                System.out.println("Conta " + conta.getNumero() + " ,cliente " + conta.getNomeCliente() + " , selecionada.");
                                contaEscolhida = conta;

                                do{
                                    opcaoMenuInterno = menuInterno();
                                    acoesContas(opcaoMenuInterno, contaEscolhida, contaCorrenteList, contaPoupancaList);
                                }while (opcaoMenuInterno!=0);

                            }
                        }
                    }else if(tipoConta == 2){
                        for(Conta conta: contaPoupancaList){
                            if(conta.getNomeCliente().equalsIgnoreCase(nomeCliente) &&
                                    (conta.getNumero() == numeroConta)){
                                System.out.println("Conta " + conta.getNumero() + " ,cliente " + conta.getNomeCliente() + " , selecionada.");
                                contaEscolhida = conta;

                                do{
                                    opcaoMenuInterno = menuInterno();
                                    acoesContas(opcaoMenuInterno, contaEscolhida, contaCorrenteList, contaPoupancaList);
                                }while (opcaoMenuInterno!=0);

                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println(bancosList);
            }
        }while (opcaoMenu != 0);
    }

    public static int menu(){
        System.out.println("MENU - Digite a opção pretendida");
        System.out.println("***************");
        System.out.println("1 - Criar Banco");
        System.out.println("2 - Abrir Conta Corrente");
        System.out.println("3 - Abrir Conta Poupança");
        System.out.println("4 - Ver Contas de um Cliente");
        System.out.println("5 - Acessar conta");
        System.out.println("6 - Listar bancos e agências");
        //etc
        System.out.println("0 - Sair");
        System.out.println("***************");
        int opcaoMenu = scan.nextInt();scan.nextLine();
        return opcaoMenu;
    }
    public static int menuInterno() {
            System.out.println("MENU - Digite a opção pretendida");
            System.out.println("***************");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Transferir");
            System.out.println("0 - Sair");
            System.out.println("***************");
            int opcaoMenuInterno = scan.nextInt();
            scan.nextLine();
            return opcaoMenuInterno;
    }

    public static void acoesContas(int acao, Conta contaEscolhida, List<Conta> contasCorrente, List<Conta> contasPoupanca){
        Conta contaDestino = null;
        switch (acao){
            case 1://sacar
                System.out.println("Informe o valor do saque:");
                double valorSaque = scan.nextDouble();scan.nextLine();
                contaEscolhida.sacar(valorSaque);
                break;
            case 2://depositar
                System.out.println("Informe o valor do depósito:");
                double valorDeposito = scan.nextDouble();scan.nextLine();
                contaEscolhida.depositar(valorDeposito);
                break;
            case 3://saldo
                contaEscolhida.verSaldo();
                break;
            case 4://transferir
                System.out.println("Informe o valor da transferência:");
                double valorTransferencia = scan.nextDouble();scan.nextLine();
                System.out.println("Informe o numero da conta de destino");
                int numContaDestino = scan.nextInt();scan.nextLine();

                for(Conta conta: contasCorrente){
                    if(conta.getNumero() == numContaDestino){
                        contaDestino = conta;
                    }
                }

                for(Conta conta: contasPoupanca){
                    if(conta.getNumero() == numContaDestino){
                        contaDestino = conta;
                    }
                }

                contaEscolhida.transferir(valorTransferencia, contaDestino);
                break;
        }

    }
}