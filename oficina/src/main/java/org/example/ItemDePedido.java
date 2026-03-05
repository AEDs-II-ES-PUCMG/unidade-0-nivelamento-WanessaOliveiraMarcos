package org.example;

public class ItemDePedido {
	private Produto produto;
	private int quantidade;
	private double precoVenda;
	
	/**
     * Construtor da classe ItemDePedido.
     * O precoVenda deve ser capturado do produto no momento da criação do item,
     * garantindo que alterações futuras no preço do produto não afetem este pedido.
     */
	public ItemDePedido(Produto produto, int quantidade, double precoVenda) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
	}
	
	// métodos

    public double calcularSubtotal() {
        double subTotal = this.produto.valorDeVenda() * this.quantidade;
        return subTotal;
    }
	/**
	* Igualdade de produtos: caso possuam o mesmo nome/descrição.
	* @param obj Outro produto a ser comparado
	* @return booleano true/false conforme o parâmetro possua a descrição igual ou não a este produto.
	*/
	@Override
	public boolean equals(Object obj){
		Produto outro = (Produto)obj;
		return this.produto.getDescricao().toLowerCase().equals(outro.getDescricao().toLowerCase());
	}
}
