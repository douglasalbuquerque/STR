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
    
    
    public boolean verificaUsoDaCpu(List<Tarefa> tarefas){
        for(Tarefa t : tarefas){
            this.somaDoUso += t.getUtilizacaoCPU();
        }
        if((somaDoUso * 100) > 100){
            return false;
        }else{
            return true;
        }
        
    } 
    
    
    
}
