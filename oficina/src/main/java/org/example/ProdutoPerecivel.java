package org.example;
import java.time.LocalDate;

import org.example.exceptions.ProdutoVencidoException;

public class ProdutoPerecivel extends Produto {
    private static final int PRAZO_DESCONTO = 7;
    private static final double DESCONTO = 0.25;
    LocalDate dataDeValidade;
    // Construtores
    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataDeValidade) {
        super(desc, precoCusto, margemLucro);
        if (dataDeValidade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de validade não pode ser anterior à data atual");
        }
        this.dataDeValidade = dataDeValidade;
    }

    public ProdutoPerecivel(String desc, double precoCusto, LocalDate dataDeValidade) {
        super(desc, precoCusto);
        this.dataDeValidade = dataDeValidade;
    }

    // Getters e Setters
    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    // Métodos
    public boolean venceEm7DiasOuMenos() {
        return !dataDeValidade.isBefore(LocalDate.now()) &&
                !dataDeValidade.isAfter(LocalDate.now().plusDays(7));
    }
    @Override
    public double valorDeVenda() throws ProdutoVencidoException {
        if (dataDeValidade.isBefore(LocalDate.now())) {
            throw new ProdutoVencidoException("O produto esta fora da data de validade");

        }else{
            if(venceEm7DiasOuMenos()){
                double valorSemDesconto = super.valorDeVenda();
                return valorSemDesconto - (valorSemDesconto * 0.25);
            } else {
                return super.valorDeVenda();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Data de Validade: " + dataDeValidade;
    }
}
