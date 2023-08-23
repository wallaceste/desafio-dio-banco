import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        List<Banco> bancosList = new ArrayList<>();
        List<Conta> contaCorrenteList = new ArrayList<>();
        List<Conta> contaPoupancaList = new ArrayList<>();
        int opcaoMenu = 0;
        int opcaoMenuInterno = 0;
        String nomeBanco;
        int idBancoEscolhido;
        int idAgenciaEscolhida;
        int idContaEscolhida;
        String nomeCliente;
        int numeroConta;


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
                    for(int i=0;i<contaCorrenteList.size();i++){
                        if(contaCorrenteList.get(i).getNomeCliente().equalsIgnoreCase(nomeCliente)){
                            System.out.println("Conta Corrente: " + contaCorrenteList.get(i).numero);
                        }
                        if(contaPoupancaList.get(i).getNomeCliente().equalsIgnoreCase(nomeCliente)){
                            System.out.println("Conta Poupança: " + contaPoupancaList.get(i).numero);
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
                        for(int i=0;i<contaCorrenteList.size();i++){
                            if(contaCorrenteList.get(i).getNomeCliente().equalsIgnoreCase(nomeCliente) &&
                                    (contaCorrenteList.get(i).getNumero() == numeroConta)){
                                idContaEscolhida = i;
                                System.out.println("Conta " + contaCorrenteList.get(idContaEscolhida).getNumero() + " ,cliente " + contaCorrenteList.get(idContaEscolhida).getNomeCliente() + " selecionada.");

                                do{
                                    opcaoMenuInterno = menuInterno();
                                    acoesContas(opcaoMenuInterno, idContaEscolhida, contaCorrenteList, contaPoupancaList);
                                }while (opcaoMenuInterno!=0);

                            }
                        }
                    }else if(tipoConta == 2){
                        for(int i=0;i<contaPoupancaList.size();i++){
                            if(contaPoupancaList.get(i).getNomeCliente().equalsIgnoreCase(nomeCliente) &&
                                    (contaPoupancaList.get(i).getNumero() == numeroConta)){
                                idContaEscolhida = i;
                                System.out.println("Conta " + contaPoupancaList.get(idContaEscolhida).getNumero() + " ,cliente " + contaPoupancaList.get(idContaEscolhida).getNomeCliente() + " selecionada.");

                                do{
                                    opcaoMenuInterno = menuInterno();
                                    acoesContas(opcaoMenuInterno, idContaEscolhida, contaPoupancaList, contaCorrenteList);
                                }while (opcaoMenuInterno!=0);

                            }
                        }
                    }

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

    public static void acoesContas(int acao, int idConta, List<Conta> contas, List<Conta> demaisContasParaDestino){
        Conta contaDestino = null;
        switch (acao){
            case 1://sacar
                System.out.println("Informe o valor do saque:");
                double valorSaque = scan.nextDouble();scan.nextLine();
                contas.get(idConta).sacar(valorSaque);
                break;
            case 2://depositar
                System.out.println("Informe o valor do depósito:");
                double valorDeposito = scan.nextDouble();scan.nextLine();
                contas.get(idConta).depositar(valorDeposito);
                break;
            case 3://saldo
                contas.get(idConta).verSaldo();
                break;
            case 4://transferir
                System.out.println("Informe o valor da transferência:");
                double valorTransferencia = scan.nextDouble();scan.nextLine();
                System.out.println("Informe o numero da conta de destino");
                int numContaDestino = scan.nextInt();scan.nextLine();
                for (int i=0; i<contas.size();i++){
                    if (contas.get(i).getNumero() == numContaDestino){
                        contaDestino = contas.get(i);
                    }
                }
                for (int i=0; i<demaisContasParaDestino.size();i++){
                    if (demaisContasParaDestino.get(i).getNumero() == numContaDestino){
                        contaDestino = demaisContasParaDestino.get(i);
                    }
                }
                contas.get(idConta).transferir(valorTransferencia, contaDestino);
                break;
        }

    }
}