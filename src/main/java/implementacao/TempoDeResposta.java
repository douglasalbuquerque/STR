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
    private static TempoDeResposta tempoResposta = null;

    public TempoDeResposta(Tarefa t) {
        this.tarefaMaisAtrapalhada = t;
    }

    public static TempoDeResposta getInstance(Tarefa t) {
        if (tempoResposta == null) {
            tempoResposta = new TempoDeResposta(t);
        }
        return tempoResposta;
    }

    public boolean tempoResposta() {

        double cargaMaxima = tarefaMaisAtrapalhada.getCarga();
        double periodoMaximo = tarefaMaisAtrapalhada.getPeriodo();
        double somaAtual = cargaMaxima;
        double somaAnterior = 0;
        double resultadoAtual;
        int i = 0;
        int tamanho = tarefaMaisAtrapalhada.getTarefasExecutadasAntes().size();
            boolean resultadoFinal = Boolean.FALSE;

        while (i <= tamanho) {
            resultadoAtual = 0;
            for (int j = 0; j < tamanho; j++) {
                Tarefa tarefaAtual = tarefaMaisAtrapalhada.getTarefasExecutadasAntes().get(j);
                resultadoAtual += Math.ceil(somaAtual / tarefaAtual.getPeriodo()) * tarefaAtual.getCarga();
            }
            somaAtual = cargaMaxima + resultadoAtual;

            if (somaAtual == somaAnterior) {
                resultadoFinal = Boolean.TRUE;
                break;
            }
            if (somaAtual > periodoMaximo) {
                resultadoFinal = Boolean.FALSE;
                break;
            }
            somaAnterior = somaAtual;
            i++;
        }
        return resultadoFinal;
    }
}
