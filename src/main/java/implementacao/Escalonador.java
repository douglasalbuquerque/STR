/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas
 */
public class Escalonador {

    ArrayList<Tarefa> tarefasOrdenadasPorDeadline = null;
    private static Escalonador escalonador = null;

    public Escalonador(ArrayList<Tarefa> tarefas) {
        this.tarefasOrdenadasPorDeadline = tarefas;
        ordenarTarefasPorDeadline();
    }

    public static Escalonador getInstance(ArrayList<Tarefa> tarefas) {
        if (escalonador == null) {
            escalonador = new Escalonador(tarefas);
        }
        return escalonador;
    }

    private void ordenarTarefasPorDeadline() {
        Tarefa tarefaAuxiliar;
        for (int i = this.tarefasOrdenadasPorDeadline.size() - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (this.tarefasOrdenadasPorDeadline.get(j).getDeadline() > this.tarefasOrdenadasPorDeadline.get(j + 1).getDeadline()) {
                    tarefaAuxiliar = this.tarefasOrdenadasPorDeadline.get(j);
                    this.tarefasOrdenadasPorDeadline.add(j, this.tarefasOrdenadasPorDeadline.get(j + 1));
                    this.tarefasOrdenadasPorDeadline.add((j + 1), tarefaAuxiliar);
                }
            }
        }
        definirTarefasQueAtrapalham();
    }

    private void definirTarefasQueAtrapalham() {

        for (int i = 0; i < tarefasOrdenadasPorDeadline.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (i == 0) {
                } else {
                    tarefasOrdenadasPorDeadline.get(i).addTarefa(tarefasOrdenadasPorDeadline.get(j));
                }
            }
        }
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefasOrdenadasPorDeadline;
    }

    public Tarefa getTarefaMaisPrejudicada() {
        int indice = tarefasOrdenadasPorDeadline.size() - 1;
        return tarefasOrdenadasPorDeadline.get(indice);
    }

    public Tarefa getTarefaMenosPrejudicada() {
        return tarefasOrdenadasPorDeadline.get(0);
    }

}
