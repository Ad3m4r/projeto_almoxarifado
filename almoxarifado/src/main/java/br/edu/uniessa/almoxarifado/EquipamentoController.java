package br.edu.uniessa.almoxarifado;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EquipamentoController {
 
    private Equipamento equipamento = new Equipamento(
       "1234", "Projetor", true
    );

    @GetMapping("/equipamento")
    public Equipamento obterEquipamento() {
        return equipamento;
    }

    @GetMapping("/equipamento/emprestar")
    public Equipamento emprestarEquipamento() {
        Equipamento equipamento = equipamentoService.obterEquipamentoPrincipal();
        equipamento.emprestar();
        return equipamento;
    }

    @GetMapping("/equipamento/devolver")
    public Equipamento devolverEquipamento() {
        Equipamento equipamento = equipamentoService.obterEquipamentoPrincipal();
        equipamento.devolver();
        return equipamento;
    }
}
