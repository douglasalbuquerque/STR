/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import implementacao.Escalonabilidade;
import implementacao.Tarefa;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author douglas
 */
public class TestaEscalonabilidade {

    List<Tarefa> tarefas = null;
    Escalonabilidade escalonador = null;

    @Before
    public void before() {
        tarefas = new ArrayList<>();
        tarefas.add(montarObjetoTarefa1());
        tarefas.add(montarObjetoTarefa2());
        tarefas.add(montarObjetoTarefa3());
        this.escalonador = new Escalonabilidade();
    }

    @Test
    public void testaEscalonabilidadeTrue() {
        assertTrue(this.escalonador.verificaUsoDaCpu(tarefas));
    }

    @Test
    public void testaEscalonabilidadeFalse() {
        tarefas.add(montarObjetoTarefa4());
        assertFalse(this.escalonador.verificaUsoDaCpu(tarefas));
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
        Tarefa tarefa = new Tarefa(40, 100, 100);
        return tarefa;
    }

    private Tarefa montarObjetoTarefa4() {
        Tarefa tarefa = new Tarefa(30, 100, 100);
        return tarefa;
    }

}
