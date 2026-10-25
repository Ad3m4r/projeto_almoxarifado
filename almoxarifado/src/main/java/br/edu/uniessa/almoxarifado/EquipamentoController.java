package br.edu.uniessa.almoxarifado;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipamentoController {
 
    private Equipamento equipamento = new Equipamento(
       1234, 
       "Projetor", 
       true
    );

    @GetMapping("/equipamento")
    public Equipamento obterEquipamento() {
        return equipamento;
    }

    @GetMapping("/equipamento/emprestar")
    public Equipamento emprestarEquipamento() {
        equipamento.emprestar();
        return equipamento;
    }

    @GetMapping("/equipamento/devolver")
    public Equipamento devolverEquipamento() {
        equipamento.devolver();
        return equipamento;
    }
}
