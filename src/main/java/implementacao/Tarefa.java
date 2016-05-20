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
public class Tarefa {

    private double periodo, deadline, carga;
    private List<Tarefa> tarefaExecutadasAntes;
    int prioridade;
    
    public Tarefa(double c, double p, double d) {
        this.periodo = p;
        this.deadline = d;
        this.carga = c;
        tarefaExecutadasAntes = new ArrayList<>();
    }

    public double getUtilizacaoCPU() {
        return this.carga / this.periodo;
    }

    /**
     * @return the periodo
     */
    public double getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(double periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the deadline
     */
    public double getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(double deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the carga
     */
    public double getCarga() {
        return carga;
    }

    /**
     * @param carga the carga to set
     */
    public void setCarga(double carga) {
        this.carga = carga;
    }

    public List<Tarefa> getTarefasExecutadasAntes(){
        return tarefaExecutadasAntes;
    }
    
    public void addTarefa(Tarefa tarefa){
        if (this.tarefaExecutadasAntes == null) {
            this.tarefaExecutadasAntes = new ArrayList<>();
        }
        this.tarefaExecutadasAntes.add(tarefa);
    }
    
    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
    }
}
