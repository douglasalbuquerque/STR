/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao;

import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class RateMonotonic {

    private static RateMonotonic rateMonotonic = null;

    public static RateMonotonic getInstance() {
        if (rateMonotonic == null) {
            rateMonotonic = new RateMonotonic();
        }
        return rateMonotonic;
    }

    public boolean calculoRateMonotonic(ArrayList<Tarefa> tarefas) {
        int radicando = 2;
        int indice = tarefas.size();
        double usoCPU = Escalonabilidade.getInstance().verificaUsoDaCpuDouble(tarefas);
        boolean resultado = Boolean.FALSE;

        double respostaFormula = indice * ((Math.pow(radicando, 1.0 / indice)) - 1);

        if (usoCPU <= respostaFormula) {
            resultado = Boolean.TRUE;
        } else if (usoCPU >= respostaFormula) {
            resultado = Boolean.FALSE;
        }

        return resultado;
    }

}
