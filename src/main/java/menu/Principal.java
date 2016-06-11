/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import implementacao.Escalonabilidade;
import implementacao.Escalonador;
import implementacao.RateMonotonic;
import implementacao.Tarefa;
import implementacao.TempoDeResposta;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author douglas
 */
public class Principal {

    ArrayList<Tarefa> tarefas = null;
    Scanner input = new Scanner(System.in);
    private static Principal principal = null;

    public static Principal getInstance() {
        if (principal == null) {
            principal = new Principal();
        }
        return principal;
    }

    public boolean menu() {
        int escolha;
        int continuar = 1;

        while (continuar != 2) {

            System.out.println("Escolha uma das opções: \n          1-Inserir Tarefa\n          2-Escalonabilidade\n          3-Rate Monotonic\n          4-Tempo de Resposta\n\n");
            escolha = input.nextInt();
            switch (escolha) {
                case 1:
                    trataString();
                    tarefas = Escalonador.getInstance(tarefas).getTarefas();
                    break;
                case 2:

                    boolean resposta = Escalonabilidade.getInstance().verificaUsoDaCpu(tarefas);
                    if (resposta == Boolean.TRUE) {
                        System.out.println("Não sei");
                        System.out.println("Tente os próximos escalonamentos");
                    } else {
                        System.err.println("Não!!");
                    }
                    break;
                case 3:
                    boolean result = RateMonotonic.getInstance().calculoRateMonotonic(tarefas);
                    if (result == Boolean.TRUE) {
                        System.out.println("Talvez seja possivel, tente utilizar outro escalonamento!");
                    } else {
                        System.err.println("Não!!");
                    }
                    break;
                case 4:
                    int index = tarefas.size() - 1;
                    boolean resp = TempoDeResposta.getInstance(tarefas.get(index)).tempoResposta();
                    if (resp == Boolean.TRUE) {
                        System.out.println("Escalonamento é possivel!");
                    } else {
                        System.err.println("Escalonamento não é possivel!");
                    }
                    break;
                default:
                    System.err.println("Digite um número válido entre 1 - 4");
                    break;
            }
            System.out.println("Deseja Continuar? \n1-sim\n2-nao");
            continuar = input.nextInt();

        }
        return Boolean.FALSE;
    }

    private void trataString() {
        String tarefaEmString;
        String arrayValores[] = new String[2];
        boolean resultado;
        int opcao;

        while (Boolean.TRUE) {
            System.out.println("Insira os valores da tarefa da seguinte forma: carga(C)|periodo \n      Ex: 4.5|50\n");
            tarefaEmString = input.next();
            arrayValores = tarefaEmString.split(Pattern.quote("|"));
            resultado = addTarefa(Double.parseDouble(arrayValores[0]), Double.parseDouble(arrayValores[1]));
            if (resultado == true) {
                System.out.println("Tarefa Adicionada\n");
            }

            System.out.println("Deseja Inserir uma nova tarefa?\n       1-sim\n       2-nao");
            opcao = input.nextInt();
            if (opcao == 2) {
                break;
            }
        }
    }

    private boolean addTarefa(double carga, double periodo) {
        Tarefa tarefa = new Tarefa(carga, periodo, periodo);
        if (this.tarefas == null) {
            this.tarefas = new ArrayList<>();
        }
        this.tarefas.add(tarefa);
        int index = tarefas.indexOf(tarefa);

        return index >= 0;
    }
}
