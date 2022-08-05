package lti_project_3_by_hugo_queiros;

import java.util.Scanner;

public class LTI_Project_3_by_Hugo_Queiros {

    //contador dos termos do polinomio
    public int contaNos(Node primeiro) {
        int contador = 0;
        while (primeiro != null) {
            contador++;
            primeiro = primeiro.getProximo();
        }
        System.out.println("HÁ " + contador + " TERMOS\n");
        return contador;
    }

    // conta os numero de nos da lista - versao recursiva
    public int contaNosR(Node primeiro) {
        if (primeiro != null) {
            return 1 + contaNosR(primeiro.getProximo());
        } else {
            return 0;
        }
    }

    // elimina um valor da lista
    public Node eliminaElemento(Node primeiro, int e) {
        Node p = primeiro;
        if (p != null) {
            if (p.getElemento().getExpoente() == e) {
                primeiro = primeiro.getProximo();
            }
            while (p != null) {
                if (p.getProximo() == null) {
                    break;
                }
                if (p.getProximo().getElemento().getExpoente() == e) {
                    p.setProximo(p.getProximo().getProximo());
                    break;
                } else {
                    p = p.getProximo();
                }
            }
        }
        return primeiro;
    }

    //verifica o maior expoente, o grau do polinómio
    public void grauPolinomio(Node primeiro) {
        int maior = 0;
        while (primeiro != null) {
            if (primeiro.getElemento().getExpoente() > maior) {
                maior = primeiro.getElemento().getExpoente();
                primeiro = primeiro.getProximo();
            } else {
                primeiro = primeiro.getProximo();
            }
        }
        System.out.println("\nO GRAU DO POLINÓMIO É " + maior + "\n");
    }

    // escreve todos os elementos da lista
    public void escreveLista(Node lista) {
        while (lista != null) {
            System.out.println(lista);
            lista = lista.getProximo();
        }
    }

    // escreve todos os elementos da lista - versao recursiva
    public void escreveListaR(Node lista) {
        if (lista != null) {
            System.out.println(lista);
            escreveListaR(lista.getProximo());
        } else {
            System.out.println("NÃO EXISTEM MAIS ELEMENTOS!");
        }
    }

    //soma os coeficientes com expoentes iguais
    public boolean verificaExpoentes(Node primeiro, double c, int e) {
        Node no_expoentes = primeiro;
        while (no_expoentes != null) {
            if (no_expoentes.getElemento().getExpoente() == e) {
                c += no_expoentes.getElemento().getCoeficiente();
                no_expoentes.getElemento().setCoeficiente(c);
                return true;
            } else {
                no_expoentes = no_expoentes.getProximo();
            }
        }
        return false;
    }

    //ordena os polinómios pela ordem descendente dos expoentes
    public int ordenacaoDescendente(Node n) {
        Node nod1 = null;
        for (Node nod = n; nod.getProximo() != null; nod = nod.getProximo()) {
            if (nod.getElemento().getExpoente() < nod.getProximo().getElemento().getExpoente()) {
                Node next = nod.getProximo();
                if (nod1 == null) {
                    n = next;
                } else {
                    nod1.setProximo(next);
                }
                nod.setProximo(next.getProximo());
                next.setProximo(nod);
                nod1 = next;
            } else {
                nod1 = nod;
            }
            System.out.println(nod);
        }
        return 1;
    }

    public void go() {

        Scanner leitura = new Scanner(System.in);
        int escolha, contador = 0;
        Node primeiro = null;
        do {
            System.out.println("\nTRABALHO DE POLINOMIOS\n");
            System.out.println("1- Inserir o Termo do Polinómio");
            System.out.println("2- Remover Termo");
            System.out.println("3- Escrever Polinómio");
            System.out.println("4- Mostrar Grau do Polinómio");
            System.out.println("5- Mostrar Número de Termos ");
            System.out.println("6- Ordenar o Polinómio");
            System.out.println("7- Calcular o Valor do Polinímio");
            System.out.println("8- Sair do Programa\n");
            System.out.println("Escolha uma das opções: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    contador = 0;
                    System.out.println("\nINSIRA COEFICIENTE: ");
                    Double c = leitura.nextDouble();
                    System.out.println("INSIRA EXPOENTE: ");
                    int e = leitura.nextInt();
                    if (e < 0) {
                        System.out.println("EXPOENTE INVÁLIDO");
                    } else {
                        if (verificaExpoentes(primeiro, c, e) == true) {
                            System.out.println("MESMO EXPOENTE!\nCOEFICIENTES DOS EXPOENTES SOMADOS");
                        } else {
                            Polinomio p = new Polinomio();
                            p.setCoeficiente(c);
                            p.setExpoente(e);
                            Node nod = new Node(p, null);
                            nod.setProximo(primeiro);
                            primeiro = nod;
                        }
                    }
                    break;
                case 2:
                    System.out.println("IDENTIFIQUE O EXPOENTE DO TERMO QUE PRETENDE ELIMINAR: ");
                    e = leitura.nextInt();
                    primeiro = eliminaElemento(primeiro, e);

                    System.out.println("O TERMO COM EXPOENTE " + e + " FOI ELIMINADO");
                    break;

                case 3:
                    escreveListaR(primeiro);
                    if (primeiro == null) {
                        System.out.println("O NODE ESTÁ VAZIO");
                    }
                    break;

                case 4:
                    grauPolinomio(primeiro);
                    break;

                case 5:
                    contador = contaNos(primeiro);
                    break;

                case 6:
                    ordenacaoDescendente(primeiro);
                    break;

                case 7:
                    double potencia = 0;
                    System.out.println("Qual o valor que pretende dar ao x?");
                    int x = leitura.nextInt();
                    if (primeiro != null) {
                        while (primeiro != null) {
                            potencia += Math.pow(x, primeiro.getElemento().getExpoente()) * primeiro.getElemento().getCoeficiente();
                            primeiro = primeiro.getProximo();
                        }
                        System.out.println(potencia);
                    }
                    break;

                default:
                    System.out.println("\nPROGRAMA TERMINADO\n");
                    break;
            }
        } while (escolha != 8);
    }

    public static void main(String[] args) {

        new LTI_Project_3_by_Hugo_Queiros().go();
    }
}
