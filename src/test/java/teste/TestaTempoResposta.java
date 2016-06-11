package teste;

import implementacao.Escalonador;
import implementacao.Tarefa;
import implementacao.TempoDeResposta;
import java.util.ArrayList;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Douglas Albuquerque
 */
public class TestaTempoResposta {

    ArrayList<Tarefa> tarefasTrue = null;
    ArrayList<Tarefa> tarefasFalse = null;
    ArrayList<Tarefa> tarefasOrdenadas = null;
    Tarefa tarefaMaisAtrapalhada = null;

//    @Before
//    public void setUpTrue() {
//        tarefasTrue = new ArrayList<>();
//        tarefasTrue.add(montarObjetoTarefa1());
//        tarefasTrue.add(montarObjetoTarefa2());
//        tarefasTrue.add(montarObjetoTarefa3());
//
//        Escalonador escalonador = new Escalonador(tarefasTrue);
//        tarefasOrdenadas = escalonador.getTarefas();
//        tarefaMaisAtrapalhada = escalonador.getTarefaMaisPrejudicada();
//    }

    @Before
    public void setUpFalse() {
        tarefasFalse = new ArrayList<>();
        tarefasFalse.add(montarObjetoTarefa4());
        tarefasFalse.add(montarObjetoTarefa5());
        tarefasFalse.add(montarObjetoTarefa6());

        Escalonador escalonador = new Escalonador(tarefasFalse);
        tarefasOrdenadas = escalonador.getTarefas();
        tarefaMaisAtrapalhada = escalonador.getTarefaMaisPrejudicada();
    }
    
    
    @Test
    public void testarTempoRespostaTrue() {
        TempoDeResposta tempoResposta = new TempoDeResposta(this.tarefaMaisAtrapalhada);
        assertTrue(tempoResposta.tempoResposta());
    }

    @Test
    public void testarTempoRespostaFalse() {
        TempoDeResposta tempoResposta = new TempoDeResposta(this.tarefaMaisAtrapalhada);
        assertFalse(tempoResposta.tempoResposta());
    }
        
    private Tarefa montarObjetoTarefa1() {
        Tarefa tarefa = new Tarefa(6.25, 25, 25);
        return tarefa;
    }

    private Tarefa montarObjetoTarefa2() {
        Tarefa tarefa = new Tarefa(6.25, 50, 50);
        return tarefa;
    }

    private Tarefa montarObjetoTarefa3() {
        Tarefa tarefa = new Tarefa(40, 80, 80);
        return tarefa;
    }
    
    private Tarefa montarObjetoTarefa4() {
        Tarefa tarefa = new Tarefa(6.25, 25, 25);
        return tarefa;
    }

    private Tarefa montarObjetoTarefa5() {
        Tarefa tarefa = new Tarefa(6.25, 50, 50);
        return tarefa;
    }

    private Tarefa montarObjetoTarefa6() {
        Tarefa tarefa = new Tarefa(40, 68, 68);
        return tarefa;
    }
}
