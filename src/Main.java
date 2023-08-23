import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Banco> bancosList = new ArrayList<>();
        List<ContaCorrente> contaCorrenteList = new ArrayList<>();
        List<ContaPoupanca> contaPoupancaList = new ArrayList<>();
        String nomeBanco;
        int opcaoMenu = 0;
        int idBancoEscolhido;
        int idAgenciaEscolhida;
        String nomeCliente;


        do {
            System.out.println("MENU - Digite a opção pretendida");
            System.out.println("***************");
            System.out.println("1 - Criar Banco");
            System.out.println("2 - Abrir Conta Corrente");
            System.out.println("3 - Abrir Conta Poupança");
            System.out.println("4 - Ver Contas de um Cliente");
            //etc
            System.out.println("0 - Sair");
            System.out.println("***************");
            opcaoMenu = scan.nextInt();scan.nextLine();

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



            }

        }while (opcaoMenu != 0);




        /*Banco bancoBrasil = new Banco("Banco do Brasil", new int[]{1244, 4556, 4875});

        ContaPoupanca cpw = new ContaPoupanca(1244, "wallace");
        ContaPoupanca cps = new ContaPoupanca(1244, "stevan");

        ContaCorrente ccw = new ContaCorrente(4556, "wallace");
        ContaCorrente ccs = new ContaCorrente(4556, "stevan");

        cpw.verSaldo();
        cps.verSaldo();
        ccw.verSaldo();
        ccs.verSaldo();

        cpw.depositar(1500);
        cps.depositar(200);
        ccw.depositar(8457);
        ccs.depositar(12);

        cpw.sacar(1501);
        cps.sacar(150);
        ccw.sacar(8000);
        ccs.sacar(2);

        cpw.transferir(1499, ccs);

        cpw.verSaldo();
        cps.verSaldo();
        ccw.verSaldo();
        ccs.verSaldo();*/










    }
}