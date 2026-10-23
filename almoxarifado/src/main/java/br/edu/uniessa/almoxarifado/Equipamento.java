package br.edu.uniessa.almoxarifado;

public class Equipamento {
 
    private Integer codigo;
    private String nome;
    private boolean situacao;

    public Equipamento(Integer codigo, String nome, boolean situacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.situacao = situacao;
    
    }
    public Integer getCodigo() { 
        return codigo; 
    }

    public String getNome() { 
        return nome; 
    }
 public boolean isSituacao() { 
        return situacao; 
    }

    public void emprestar() {
        situacao = false;
    }

    public void devolver() {
        situacao = true;
    }
}