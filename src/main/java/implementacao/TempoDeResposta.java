/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao;

import java.util.List;

/**
 *
 * @author douglas
 */
public class TempoDeResposta {

    Tarefa tarefaMaisAtrapalhada;

    public TempoDeResposta(Tarefa t) {
        this.tarefaMaisAtrapalhada = t;
    }

    public boolean tempoResposta() {
        double tempoRespostaAnterior = 0;
        double tempoRespostaAtual = tarefaMaisAtrapalhada.getCarga();
        double soma = 0;
        boolean resultado = Boolean.FALSE;
        int size = tarefaMaisAtrapalhada.getTarefasExecutadasAntes().size();
        List<Tarefa> tarefas = tarefaMaisAtrapalhada.getTarefasExecutadasAntes();
        double cargaMaxima = tarefaMaisAtrapalhada.getCarga();
        Tarefa tarefaAnterior = null;
        int index = 0;

        soma += cargaMaxima;

        while (index < tarefas.size()) {
            //tempoRespostaAnterior = tempoRespostaAtual;

            for (Tarefa tarefaAtual : tarefas) {
                if (tarefaAtual.getTarefasExecutadasAntes().isEmpty()) {
                } else {
                    soma += cargaMaxima + (Math.ceil(soma / tarefaAnterior.getPeriodo()) * tarefaAnterior.getCarga()) + (Math.ceil(soma / tarefaAtual.getPeriodo()) * tarefaAtual.getCarga());
                }
                tarefaAnterior = tarefaAtual;

                tempoRespostaAtual = tarefaMaisAtrapalhada.getCarga() + soma;

                if (tempoRespostaAtual > tarefaMaisAtrapalhada.getPeriodo()) {
                    System.err.println("Não Escalonavel.");
                    resultado = Boolean.FALSE;
                    break;
                }
                if (tempoRespostaAnterior == tempoRespostaAtual) {
                    System.out.println("Escalonavel");
                    resultado = Boolean.TRUE;
                    break;
                }
            }
        }
        return resultado;
    }

}
