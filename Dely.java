
// Imports
import java.util.Scanner;

public class Dely {
    private Deposito depositos;
    private Deposito trajetos;
    private CriaColecaoCSV arrayCidades;
    private CriaColecaoCSV matrizCidades;

    private Scanner entrada = null;

    // Construtor
    public Dely() {
        depositos = new Deposito();
        trajetos = new Deposito();
        arrayCidades = new CriaColecaoCSV();
        matrizCidades = new CriaColecaoCSV();
        entrada = new Scanner(System.in);

    }
    // Construtor

    private String arrayCidade(int cidade) {
        String f = arrayCidades.getCidade(cidade);
        return f;
    }

    private int matrizDistancia(int cidade1, int cidade2) {
        int f = matrizCidades.getMatriz(cidade1, cidade2);
        return f;
    }

    public void executar() {
        int opcao = 0;
        do {
            menuInicial();
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cadastrarTransporte();
                    break;
                case 2:
                    dadosEstatisticos();
                    break;
                case 3:
                    consultarTrajetoxValores();
                    break;

                default:
                    System.out.println("Opcao invalida! Redigite!");
            }
        } while (opcao != 0);
    }

    private void menuInicial() {
        System.out.println("=====================================");
        System.out.println("Menu de opcoes: ");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Cadastrar Transporte");
        System.out.println("[2] Transportes Cadastrados");
        System.out.println("[3] Consultar Trajeto x Valores");

        System.out.println("=====================================");
    }

    private void menuCadastrarTransporte() {

        System.out.println("=====================================");
        System.out.println("[0] Voltar");
        System.out.println("[1] Selecionar cidade");
        System.out.println("[2] Adicionar itens ");
        System.out.println("[3] Confirmação do Cadastro de transporte");

        System.out.println("=====================================");
    }

    // ================================================================================================================
    // Dentro do menu Cadastrar transporte
    private void cadastrarTransporte() {

        int selecao = 0;
        do {
            menuCadastrarTransporte();
            System.out.println("Digite a opção desejada: ");
            selecao = entrada.nextInt();
            entrada.nextLine();
            switch (selecao) {
                case 0:
                    break;
                case 1:
                    selecionaCidades();
                    break;
                case 2:
                    menuAdicionaItens();
                    break;

                case 3:
                    Carga f = trajetos.consultarTrajetos();
                    Carga a = depositos.consultarCargas();

                    if (f.getCidade1() == null || f.getCidade2() == null) {
                        System.out.println(" Cidades não cadastradas ");
                    } else if (a.getSomaDosItens() <= 0) {
                        System.out.println("Itens não cadastrados");
                    } else {
                        confirmacaoCadastroDeTransporte();
                        System.out.println("Cadastrado com sucesso");
                    }
                    break;
                default:
                    System.out.println("Opcao invalida! Redigite!");
            }
        } while (selecao != 0);
    }

    private void menuSelecionaCidades() {
        System.out.println("=====================================");
        System.out.println("[0] Voltar");
        System.out.println("[1] Adicionar Cidade de origem ");
        System.out.println("[2] Adicionar Cidade de destino");
        System.out.println("[3] Adicionar Cidade de parada");
        System.out.println("[4] Confirmar escolha de cidades");
        System.out.println("=====================================");
    }

    private int selecionaCidades() {

        int selecao, cidade1 = 0, cidade2 = 0, cidade3 = 0;
        do {
            mostraOpcaoCidades();
            menuSelecionaCidades();
            System.out.println("Digite a opção desejada: ");
            selecao = entrada.nextInt();
            entrada.nextLine();
            switch (selecao) {
                case 0:
                    break;
                case 1:
                    System.out.println("Seleção da cidade de origem");
                    cidade1 = menuSelecionaCidadeOrigem();
                    break;
                case 2:
                    System.out.println("Seleção da cidade de destino");
                    cidade2 = menuSelecionaCidadeDestino();
                    break;
                case 3:
                    System.out.println("Seleção de cidade de parada para entrega");
                    cidade3 = menuSelecionaCidadeParada();
                    break;
                case 4:
                    if (cidade1 != 0 && cidade2 != 0) {
                        System.out.println("Cadastrado");
                        if (cidade3 != 0) {
                            Carga a = new Carga((matrizDistancia(cidade1, cidade2) + matrizDistancia(cidade2, cidade3)),
                                    arrayCidade(cidade1),
                                    arrayCidade(cidade2), arrayCidade(cidade3), matrizDistancia(cidade1, cidade2),
                                    matrizDistancia(cidade2, cidade3));

                            trajetos.cadastrarTrajetos(a);
                            selecao = 0;
                            break;
                        } else {
                            Carga a = new Carga(matrizDistancia(cidade1, cidade2), arrayCidade(cidade1),
                                    arrayCidade(cidade2));

                            trajetos.cadastrarTrajetos(a);
                            selecao = 0;
                            break;
                        }

                    } else {
                        System.out.println("Alguma das cidades não foi adicionada");
                    }
                    break;
                default:
                    System.out.println("Opcao invalida! Redigite!");
            }
        } while (selecao != 0);
        return 999;
    }

    private void menuAdicionaItens() {
        int controleLoopCase2;
        int qtdDeCelulares = 0, qtdDeCadeiras = 0, qtdDeFrezzers = 0, qtdDeLuminarias = 0, qtdLavaRoupa = 0,
                qtdDeGeladeiras = 0;
        do {
            System.out.println("Selecione o item e depois a quantidade: ");
            System.out.println("[0] Voltar");
            System.out.println("[1] Celular");
            System.out.println("[2] Geladeira");
            System.out.println("[3] Freezer ");
            System.out.println("[4] Cadeira");
            System.out.println("[5] Luminária");
            System.out.println("[6] Lavadora de roupa");
            System.out.println("[7] Confirmar adição de itens");
            controleLoopCase2 = entrada.nextInt();
            entrada.nextLine();
            switch (controleLoopCase2) {

                case 0:
                    break;
                case 1:
                    System.out.println("Digite a quantidade: ");
                    qtdDeCelulares = entrada.nextInt();
                    entrada.nextLine();
                    if (qtdDeCelulares > 0) {
                    } else {
                        System.out.println("Quantidade Invalida");
                    }
                    break;
                case 2:
                    System.out.println("Digite a quantidade: ");
                    qtdDeGeladeiras = entrada.nextInt();
                    entrada.nextLine();
                    if (qtdDeGeladeiras > 0) {
                    } else {
                        System.out.println("Quantidade Invalida");
                    }
                    break;

                case 3:
                    System.out.println("Digite a quantidade: ");
                    qtdDeFrezzers = entrada.nextInt();
                    entrada.nextLine();
                    if (qtdDeFrezzers > 0) {
                    } else {
                        System.out.println("Quantidade Invalida");
                    }
                    break;
                case 4:
                    System.out.println("Digite a quantidade: ");
                    qtdDeCadeiras = entrada.nextInt();
                    entrada.nextLine();
                    if (qtdDeCadeiras > 0) {
                    } else {
                        System.out.println("Quantidade Invalida");
                    }

                    break;
                case 5:
                    System.out.println("Digite a quantidade: ");
                    qtdDeLuminarias = entrada.nextInt();
                    entrada.nextLine();
                    if (qtdDeLuminarias > 0) {
                    } else {
                        System.out.println("Quantidade Invalida");
                    }

                    break;
                case 6:
                    System.out.println("Digite a quantidade: ");
                    qtdLavaRoupa = entrada.nextInt();
                    entrada.nextLine();
                    if (qtdLavaRoupa > 0) {
                    } else {
                        System.out.println("Quantidade Invalida");
                    }

                    break;
                case 7:
                    System.out.println("Você possue adicionado os sequintes itens: ");
                    if (qtdDeCelulares > 0) {
                        System.out.println("[" + qtdDeCelulares + "]" + " Celular(es)");
                    }
                    if (qtdDeGeladeiras > 0) {
                        System.out.println("[" + qtdDeGeladeiras + "]" + " Geladeira(s)");
                    }
                    if (qtdDeFrezzers > 0) {
                        System.out.println("[" + qtdDeFrezzers + "]" + " Frezzer(s)");
                    }
                    if (qtdDeCadeiras > 0) {
                        System.out.println("[" + qtdDeCadeiras + "]" + " Cadeira(s)");
                    }
                    if (qtdDeLuminarias > 0) {
                        System.out.println("[" + qtdDeLuminarias + "]" + " Luminaria(s)");
                    }
                    if (qtdLavaRoupa > 0) {
                        System.out.println("[" + qtdLavaRoupa + "]" + " Lavadoura(s) de roupas");
                    }
                    if (confirmacao() == true) {
                        Carga c = new Carga(qtdDeCelulares, qtdDeGeladeiras, qtdDeFrezzers, qtdDeCadeiras,
                                qtdDeLuminarias, qtdLavaRoupa);
                        if (depositos.cadastrarCarga(c)) {
                            System.out.println("Carga cadastrada com sucesso");
                            controleLoopCase2 = 0;
                            break;
                        } else {
                            System.out.println("Erro: carga não cadastrada");
                        }
                    } else {

                    }

                    break;
                default:
                    System.out.println("Opcao invalida! Redigite!");
            }

        } while (controleLoopCase2 != 0);
    }

    private void menuRemoveIten() {
        int controleLoopCase2;

        do {
            Carga f = depositos.consultarCargas();
            System.out.println("Você possue adicionado os sequintes itens: ");
            if (f.getQtdDeCelulares() > 0) {
                System.out.println("[" + f.getQtdDeCelulares() + "]" + " Celular(es)");
            }
            if (f.getQtdDeGeladeiras() > 0) {
                System.out.println("[" + f.getQtdDeGeladeiras() + "]" + " Geladeira(s)");
            }
            if (f.getQtdDeFrezzers() > 0) {
                System.out.println("[" + f.getQtdDeFrezzers() + "]" + " Frezzer(s)");
            }
            if (f.getQtdDeCadeiras() > 0) {
                System.out.println("[" + f.getQtdDeCadeiras() + "]" + " Cadeira(s)");
            }
            if (f.getQtdLuminarias() > 0) {
                System.out.println("[" + f.getQtdLuminarias() + "]" + " Luminaria(s)");
            }
            if (f.getQtdLavaRoupa() > 0) {
                System.out.println("[" + f.getQtdLavaRoupa() + "]" + " Lavadoura(s) de roupas");
            } else {

            }

            System.out.println("=====================================================================");
            System.out.println("Selecione o item e depois a quantidade para descarregar: ");
            System.out.println("[0] Voltar");
            System.out.println("[1] Celular");
            System.out.println("[2] Geladeira");
            System.out.println("[3] Freezer ");
            System.out.println("[4] Cadeira");
            System.out.println("[5] Luminária");
            System.out.println("[6] Lavadora de roupa");

            controleLoopCase2 = entrada.nextInt();
            entrada.nextLine();
            int qtdDeItensParaRemover;
            switch (controleLoopCase2) {

                case 0:
                    break;
                case 1:
                    System.out.println("Digite a quantidade: ");
                    qtdDeItensParaRemover = entrada.nextInt();
                    entrada.nextLine();
                    if (qtdDeItensParaRemover > 0 && (f.getQtdDeCelulares() - qtdDeItensParaRemover) >= 0) {
                        f.setRedQtdDeCelulares(qtdDeItensParaRemover);
                        f.setPesoRemovido(qtdDeItensParaRemover * 0.5);
                    } else {
                        System.out.println("Quantidade Invalida");
                    }
                    break;
                case 2:
                    System.out.println("Digite a quantidade: ");
                    qtdDeItensParaRemover = entrada.nextInt();
                    entrada.nextLine();

                    if (qtdDeItensParaRemover > 0 && (f.getQtdDeGeladeiras() - qtdDeItensParaRemover) >= 0) {
                        f.setRedQtdDeGeladeiras(qtdDeItensParaRemover);
                        f.setPesoRemovido(qtdDeItensParaRemover * 60.0);
                    } else {
                        System.out.println("Quantidade Invalida");
                    }
                    break;

                case 3:
                    System.out.println("Digite a quantidade: ");
                    qtdDeItensParaRemover = entrada.nextInt();
                    entrada.nextLine();

                    if (qtdDeItensParaRemover > 0 && (f.getQtdDeFrezzers() - qtdDeItensParaRemover) >= 0) {
                        f.setRedQtdDeFrezzers(qtdDeItensParaRemover);
                        f.setPesoRemovido(qtdDeItensParaRemover * 100.0);
                    } else {
                        System.out.println("Quantidade Invalida");
                    }
                    break;
                case 4:
                    System.out.println("Digite a quantidade: ");
                    qtdDeItensParaRemover = entrada.nextInt();
                    entrada.nextLine();

                    if (qtdDeItensParaRemover > 0 && (f.getQtdDeCadeiras() - qtdDeItensParaRemover) >= 0) {
                        f.setRedQtdDeCadeiras(qtdDeItensParaRemover);
                        f.setPesoRemovido(qtdDeItensParaRemover * 5.0);
                    } else {
                        System.out.println("Quantidade Invalida");
                    }

                    break;
                case 5:
                    System.out.println("Digite a quantidade: ");
                    qtdDeItensParaRemover = entrada.nextInt();
                    entrada.nextLine();

                    if (qtdDeItensParaRemover > 0 && (f.getQtdLuminarias() - qtdDeItensParaRemover) >= 0) {
                        f.setRedQtdLuminarias(qtdDeItensParaRemover);
                        f.setPesoRemovido(qtdDeItensParaRemover * 0.8);
                    } else {
                        System.out.println("Quantidade Invalida");
                    }

                    break;
                case 6:
                    System.out.println("Digite a quantidade: ");
                    qtdDeItensParaRemover = entrada.nextInt();
                    entrada.nextLine();

                    if (qtdDeItensParaRemover > 0 && (f.getQtdLavaRoupa() - qtdDeItensParaRemover) >= 0) {
                        f.setRedQtdLavaRoupa(qtdDeItensParaRemover);
                        f.setPesoRemovido(qtdDeItensParaRemover * 120.0);
                    } else {
                        System.out.println("Quantidade Invalida");
                    }

                    break;

                default:
                    System.out.println("Opcao invalida! Redigite!");
            }

        } while (controleLoopCase2 != 0);

    }

    private void consultarTrajetoxValores() {
        System.out.println("=====================================");
        System.out.println("Selecione as cidades a partir da lista abaixo");
        mostraOpcaoCidades();
        int cidade1 = menuSelecionaCidadeOrigem();
        if (cidade1 != 0) {
            int cidade2 = menuSelecionaCidadeDestino();
            if (cidade2 != 0) {
                int distancia = matrizDistancia(cidade1, cidade2);
                System.out.println("A distancia é de " + distancia + " KM");
                System.out.println("O valor por unidade de caminhãp é de: ");
                System.out.println("(1x) Caminhão de pequeno porte: R$ " + (4.87 * distancia));
                System.out.println("(1x) Caminhão de médio porte: R$ " + (11.92 * distancia));
                System.out.println("(1x) Caminhão de grande porte: R$ " + (27.44 * distancia));

                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
            }
        } else {
            System.out.println("=====================================");
        }

    }

    private void mostraOpcaoCidades() {
        System.out.println("=====================================");

        for (int i = 1; i <= 24; i++) {
            String cidade = arrayCidade(i);
            System.out.println("[" + i + "] " + cidade);
        }
        System.out.println("=====================================");

    }

    private int menuSelecionaCidadeOrigem() {

        int a = 0;
        int controleLoop = 45;
        do {
            System.out.println("=====================================");
            System.out.println("[0] Voltar");
            a = selecionaCidade();

            if (a == 0) {
                break;
            }

            boolean confirmacao = confirmacaoCidades(a);
            if (confirmacao == true) {
                controleLoop = 0;
                System.out.println(" Cidade : " + arrayCidade(a) + " Selecionada como origem.");
                return a;
            }

            System.out.println("=====================================");

        } while (controleLoop != 0);
        return 0;
    }

    private int menuSelecionaCidadeDestino() {

        int controleLoop = 45;
        int a = 0;
        do {
            System.out.println("=====================================");

            System.out.println("[0] Voltar");
            a = selecionaCidade();
            if (a == 0) {
                break;
            }
            boolean confirmacao = confirmacaoCidades(a);
            if (confirmacao == true) {
                controleLoop = 0;
                System.out.println(" Cidade : " + arrayCidade(a) + " Selecionada como Destino.");
                return a;
            }

            System.out.println("=====================================");

        } while (controleLoop != 0);
        return 0;
    }

    private int menuSelecionaCidadeParada() {

        int a = 0;
        int controleLoop = 45;
        do {
            System.out.println("=====================================");
            System.out.println("[0] Voltar");
            a = selecionaCidade();

            if (a == 0) {
                break;
            }
            String recebe = arrayCidade(a);
            boolean confirmacao = confirmacaoCidades(a);
            if (confirmacao == true) {
                controleLoop = 0;
                System.out.println(" Cidade : " + recebe + " Selecionada como parada de entrega.");
                return a;
            }

            System.out.println("=====================================");

        } while (controleLoop != 0);
        return 0;
    }

    private int selecionaCidade() {
        int selecao;
        int cidade = 100;
        do {
            System.out.println("Digite o codigo da cidade: ");
            selecao = entrada.nextInt();
            entrada.nextLine();
            cidade = selecao;
            if (cidade >= 1 && cidade <= 24) {
                return cidade;
            } else if (cidade == 0) {
                System.out.println("Cidade não escolhida, voltando");
                break;
            }

        } while (selecao != 0);

        System.out.println("Opcao invalida! Redigite!");
        return 0;
    }

    private boolean confirmacaoCidades(int a) {
        System.out.println(" Cidade : " + arrayCidade(a) + " Selecionada.");
        System.out.println("[0] Voltar");
        System.out.println("[1] Confirmar");
        int decisao = entrada.nextInt();
        if (decisao == 1) {
            return true;
        }

        return false;
    }

    private boolean confirmacao() {

        System.out.println("Você quer confirmar estes itens e prosseguir?");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        int confirmaInt = entrada.nextInt();
        entrada.nextLine();
        if (confirmaInt == 1) {
            return true;
        } else {
            return false;
        }

    }

    private void confirmacaoCadastroDeTransporte() {
        Carga f = depositos.consultarCargas();
        Carga a = trajetos.consultarTrajetos();
        int[] alocador = new int[3];
        alocador = numeroDeCaminhoesTrecho1();
        int grande = alocador[0];
        int medio = alocador[1];
        int pequeno = alocador[2];
        int distancia = a.getDistancia();
        if (a.getCidade3() == null) {

            System.out.println("=====================================");
            System.out.println("Você possui os seguintes itens cadastrados: ");
            System.out.println("[" + f.getQtdDeCadeiras() + "]" + " Cadeiras");
            System.out.println("[" + f.getQtdDeCelulares() + "]" + " Celulares");
            System.out.println("[" + f.getQtdDeFrezzers() + "]" + " Frezzers");
            System.out.println("[" + f.getQtdDeGeladeiras() + "]" + " Geladeiras");
            System.out.println("[" + f.getQtdLuminarias() + "]" + " Luminarias");
            System.out.println("[" + f.getQtdLavaRoupa() + "]" + " Lavaroura de roupas");
            System.out.println("");
            System.out.println("Dando o peso total da carga de : " + f.calcularCargaTotalTrecho1() + " Kg");
            System.out.println("");
            System.out.println("Será necessário : " + grande + " Caminhoes de grande porte");
            System.out.println("Será necessário : " + medio + " Caminhoes de medio porte");
            System.out.println("Será necessário : " + pequeno + " Caminhoes de pequeno porte");
            System.out.println("---------------------------------------------");
            System.out
                    .println("O valor do transporte é de R$ " + depositos.somaPreco(grande, medio, pequeno, distancia));
            System.out.println("=====================================");
            if (confirmacaoFinal() == false) {
                System.out.println("Cadastro apagado.");
                f.setRESETATUDO();
            }
        } else {
            System.out.println("=====================================");
            System.out.println("De " + a.getCidade1() + " até " + a.getCidade2() + " o comboio possui");
            System.out.println("[" + f.getQtdDeCadeiras() + "]" + " Cadeiras");
            System.out.println("[" + f.getQtdDeCelulares() + "]" + " Celulares");
            System.out.println("[" + f.getQtdDeFrezzers() + "]" + " Frezzers");
            System.out.println("[" + f.getQtdDeGeladeiras() + "]" + " Geladeiras");
            System.out.println("[" + f.getQtdLuminarias() + "]" + " Luminarias");
            System.out.println("[" + f.getQtdLavaRoupa() + "]" + " Lavaroura de roupas");
            System.out.println("");
            System.out.println("Dando o peso total da carga de : " + f.calcularCargaTotalTrecho1() + " Kg");
            System.out.println("");
            System.out.println("Será necessário : " + grande + " Caminhoes de grande porte");
            System.out.println("Será necessário : " + medio + " Caminhoes de medio porte");
            System.out.println("Será necessário : " + pequeno + " Caminhoes de pequeno porte");
            System.out.println("---------------------------------------------");
            System.out.println(
                    "Para selecionar a quantidade de itens que devem ser descarregados em : " + a.getCidade3());
            menuRemoveIten();
            alocador = numeroDeCaminhoesTrecho2();
            grande = alocador[0];
            medio = alocador[1];
            pequeno = alocador[2];
            System.out.println("De " + a.getCidade2() + " até " + a.getCidade3() + " o comboio possui");
            System.out.println("[" + f.getQtdDeCadeiras() + "]" + " Cadeiras");
            System.out.println("[" + f.getQtdDeCelulares() + "]" + " Celulares");
            System.out.println("[" + f.getQtdDeFrezzers() + "]" + " Frezzers");
            System.out.println("[" + f.getQtdDeGeladeiras() + "]" + " Geladeiras");
            System.out.println("[" + f.getQtdLuminarias() + "]" + " Luminarias");
            System.out.println("[" + f.getQtdLavaRoupa() + "]" + " Lavaroura de roupas");
            System.out.println("");
            System.out.println("Dando o peso total da carga de : " + f.calcularCargaTotalTrecho2() + " Kg");
            System.out.println("");
            System.out.println("Será necessário : " + grande + " Caminhoes de grande porte");
            System.out.println("Será necessário : " + medio + " Caminhoes de medio porte");
            System.out.println("Será necessário : " + pequeno + " Caminhoes de pequeno porte");
            System.out.println("---------------------------------------------");
            if (confirmacaoFinal() == false) {
                System.out.println("Cadastro apagado.");
                f.setRESETATUDO();
            }
        }
    }

    private boolean confirmacaoFinal() {

        System.out.println("Você quer confirmar este cadastro e prosseguir?");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        int confirmaInt = entrada.nextInt();
        entrada.nextLine();
        if (confirmaInt == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int[] numeroDeCaminhoesTrecho1() {
        Carga f = depositos.consultarCargas();
        int grande = 0;
        int medio = 0;
        int pequeno = 0;
        double pesoRestante = f.calcularCargaTotalTrecho1();
        int controleG = 1;
        int[] vetor = new int[3];
        while (controleG != 0) {

            if (pesoRestante >= 10000) {
                pesoRestante = pesoRestante - 10000;
                grande++;

            }
            if (pesoRestante < 10000) {
                controleG = 0;
            }
        }
        int controleM = 1;
        while (controleM != 0) {
            if (pesoRestante >= 4000) {
                pesoRestante = pesoRestante - 4000;
                medio++;
            }
            if (pesoRestante < 4000) {
                controleM = 0;
            }
        }
        int controleP = 1;
        while (controleP != 0) {
            if (pesoRestante >= 0) {
                pesoRestante = pesoRestante - 1000;
                pequeno++;
            }
            if (pesoRestante < 0) {
                controleP = 0;
            }
        }
        vetor[0] = grande;
        vetor[1] = medio;
        vetor[2] = pequeno;

        return vetor;
    }

    private int[] numeroDeCaminhoesTrecho2() {
        Carga f = depositos.consultarCargas();
        int grande = 0;
        int medio = 0;
        int pequeno = 0;
        double pesoRestante = (f.calcularCargaTotalTrecho1() - f.getPesoRemovido());
        int controleG = 1;
        int[] vetor = new int[3];
        while (controleG != 0) {

            if (pesoRestante >= 10000) {
                pesoRestante = pesoRestante - 10000;
                grande++;

            }
            if (pesoRestante < 10000) {
                controleG = 0;
            }
        }
        int controleM = 1;
        while (controleM != 0) {
            if (pesoRestante >= 4000) {
                pesoRestante = pesoRestante - 4000;
                medio++;
            }
            if (pesoRestante < 4000) {
                controleM = 0;
            }
        }
        int controleP = 1;
        while (controleP != 0) {
            if (pesoRestante >= 0) {
                pesoRestante = pesoRestante - 1000;
                pequeno++;
            }
            if (pesoRestante < 0) {
                controleP = 0;
            }
        }
        vetor[0] = grande;
        vetor[1] = medio;
        vetor[2] = pequeno;

        return vetor;
    }

    // Dentro do menu Cadastrar transporte
    // ===============================================================================================================
    // ===============================================================================================================
    // Mostra itens Cadastrados
    private void dadosEstatisticos() {
        Carga c = trajetos.consultarTrajetos();
        if (c.getCidade3() != null) {

            Carga b = depositos.consultarCargas();

            if (b != null && c != null) {
                Carga a = trajetos.consultarTrajetos();
                Carga f = depositos.consultarCargas();

                int[] alocador = new int[3];
                alocador = numeroDeCaminhoesTrecho1();
                int grande = alocador[0];
                int medio = alocador[1];
                int pequeno = alocador[2];
                double valorTotalViajem = depositos.somaPreco(grande, medio, pequeno,
                        (a.getDistancia12() + a.getDistancia23()));
                int quantidadeDeItens = f.getSomaDosItens();
                System.out.println("=====================================");
                System.out.println(
                        "O valor do transporte é de R$ " + valorTotalViajem);
                System.out.println("De " + a.getCidade1() + " para " + a.getCidade2());
                System.out.println("A média por KM é de : " + valorTotalViajem / a.getDistancia());
                System.out.println("O custo médio por produto é : R$ " + quantidadeDeItens / valorTotalViajem);

                System.out.println("Dando o peso total da carga de : " + f.calcularCargaTotalTrecho1() + " Kg");
                System.out.println("O custo do Primeiro trecho é de : " + (((a.getDistancia12() * 27.44) * grande)
                        + ((a.getDistancia12() * 11.92) * medio) + (a.getDistancia12() * 4.87) * pequeno));
                System.out.println("Para o primeiro trecho");
                System.out.println("Será necessário : " + grande + " Caminhoes de grande porte dando o valor de: R$ "
                        + (a.getDistancia12() * 27.44) * grande);
                System.out.println("Será necessário : " + medio + " Caminhoes de medio porte dando o valor de: R$ "
                        + (a.getDistancia12() * 11.92) * medio);
                System.out.println("Será necessário : " + pequeno + " Caminhoes de pequeno porte dando o valor de: R$ "
                        + (a.getDistancia12() * 4.87) * pequeno);
                alocador = numeroDeCaminhoesTrecho2();
                grande = alocador[0];
                medio = alocador[1];
                pequeno = alocador[2];
                System.out.println("Para o segundo trecho: ");
                System.out.println("De " + a.getCidade2() + " para " + a.getCidade3());
                System.out.println("O custo do Segundo trecho é de : " + (((a.getDistancia23() * 27.44) * grande)
                        + ((a.getDistancia23() * 11.92) * medio) + (a.getDistancia23() * 4.87) * pequeno));
                System.out.println("---------------------------------------------");
                System.out.println("Será necessário : " + grande + " Caminhoes de grande porte dando o valor de: R$ "
                        + (a.getDistancia23() * 27.44) * grande);
                System.out.println("Será necessário : " + medio + " Caminhoes de medio porte dando o valor de: R$ "
                        + (a.getDistancia23() * 11.92) * medio);
                System.out.println("Será necessário : " + pequeno + " Caminhoes de pequeno porte dando o valor de: R$ "
                        + (a.getDistancia23() * 4.87) * pequeno);

                System.out.println("---------------------------------------------");
                System.out.println("O numero total de veículos deslocados é de: " + (grande + medio + pequeno));
                System.out.println("O numero total de itens é de : " + quantidadeDeItens);

                System.out.println("=====================================");

            }

            else {
                System.out.println("------------ERRO------------");
                System.out.println("Não existem transportes cadastrados");
            }
        } else {
            Carga b = depositos.consultarCargas();

            if (b != null && c != null) {
                Carga a = trajetos.consultarTrajetos();
                Carga f = depositos.consultarCargas();

                int[] alocador = new int[3];
                alocador = numeroDeCaminhoesTrecho1();
                int grande = alocador[0];
                int medio = alocador[1];
                int pequeno = alocador[2];
                double valorTotalViajem = depositos.somaPreco(grande, medio, pequeno,
                        a.getDistancia());
                int quantidadeDeItens = f.getSomaDosItens();
                System.out.println("=====================================");
                System.out.println(
                        "O valor do transporte é de R$ " + valorTotalViajem);
                System.out.println("De " + a.getCidade1() + " para " + a.getCidade2());
                System.out.println("A média por KM é de : " + valorTotalViajem / a.getDistancia());
                System.out.println("O custo médio por produto é : R$ " + quantidadeDeItens / valorTotalViajem);
                System.out.println("Dando o peso total da carga de : " + f.calcularCargaTotalTrecho1() + " Kg");
                System.out.println("O custo do Primeiro trecho é de : " + (((a.getDistancia() * 27.44) * grande)
                        + ((a.getDistancia() * 11.92) * medio) + (a.getDistancia() * 4.87) * pequeno));
                System.out.println("Será necessário : " + grande + " Caminhoes de grande porte dando o valor de: R$ "
                        + (a.getDistancia() * 27.44) * grande);
                System.out.println("Será necessário : " + medio + " Caminhoes de medio porte dando o valor de: R$ "
                        + (a.getDistancia() * 11.92) * medio);
                System.out.println("Será necessário : " + pequeno + " Caminhoes de pequeno porte dando o valor de: R$ "
                        + (a.getDistancia() * 4.87) * pequeno);
            }
        }
        // ===============================================================================================================

    }
}
