/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ribeiraoreefshop.orcamentos.model.enumerator.UnidadeDeMedida;

/**
 * @author Tiago Ferezin Data: 12/07/2018
 */
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Double quantidade;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UnidadeDeMedida unidadeDeMedida;

	@Column(nullable = false)
	private Double valorUnitario;

	private Double valorTotal;

	public Produto() {

	}

	/**
	 * @return the id
	 */
	public Long getIdProduto() {
		return idProduto;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the quantidade
	 */
	public Double getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the unidadeDeMedida
	 */
	public UnidadeDeMedida getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	/**
	 * @param unidadeDeMedida
	 *            the unidadeDeMedida to set
	 */
	public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	/**
	 * @return the valorUnitario
	 */
	public Double getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * @param valorUnitario
	 *            the valorUnitario to set
	 */
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/**
	 * @return the valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal
	 *            the valorTotal to set
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
