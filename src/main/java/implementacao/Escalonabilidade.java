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
public class Escalonabilidade {
    
    private double somaDoUso = 0;
    private static Escalonabilidade escalonabilidade = null;
    
    public static Escalonabilidade getInstance(){
        if(escalonabilidade == null){
            escalonabilidade = new Escalonabilidade();
        }
        return escalonabilidade;
    }
    
    
    public boolean verificaUsoDaCpu(List<Tarefa> tarefas){
        for(Tarefa t : tarefas){
            this.somaDoUso += t.getUtilizacaoCPU();
        }
        return (somaDoUso * 100) <= 100;
    }
    
    public double verificaUsoDaCpuDouble(List<Tarefa> tarefas){
        this.somaDoUso = 0;
        for(Tarefa t : tarefas){
            this.somaDoUso += t.getUtilizacaoCPU();
        }
        return somaDoUso;
    }
    
    
    
}
