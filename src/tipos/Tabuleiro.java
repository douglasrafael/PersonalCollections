package tipos;

import enums.Estado;
import enums.TipoItem;

/**
 * Representa um jogo de tabuleiro.
 * 
 * @author Douglas Rafael
 *
 */
public class Tabuleiro extends Item {

	/**
	 * Método construtor.
	 * 
	 * @param titulo
	 * @param observacao
	 * @param dataDeCompra
	 * @param precoDeCompra
	 * @param totalEmprestado
	 * @param nota
	 * @param estado
	 * @param emprestado
	 * @param tipo
	 */
	public Tabuleiro(String titulo, String observacao, String dataDeCompra,
			double precoDeCompra, int totalEmprestado, double nota, Estado estado,
			boolean emprestado, TipoItem tipo) {
		super(titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota,
				estado, emprestado, tipo);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Tabuleiro)) {
			return false;
		} else {
			Tabuleiro outroT = (Tabuleiro) o;
			return getId() == outroT.getId();
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
