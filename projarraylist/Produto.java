package projarraylist;

public class Produto {
	int codigo;
	String descricao;
	double prUnit;
	int qtdEstoque;

	public Produto(int codigo, String descricao, double prUnit, int qtdEstoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.prUnit = prUnit;
		this.qtdEstoque = qtdEstoque;
	}

	public void mostraProduto() {
		System.out.println("\nCódigo: " + codigo);
		System.out.println("Descrição: " + descricao);
		System.out.println("Preço Unitário: " + prUnit);
		System.out.println("Quantidade no Estoque: " + qtdEstoque);

	}

}