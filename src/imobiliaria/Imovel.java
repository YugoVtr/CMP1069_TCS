
package imobiliaria;

/**
 *
 * @author Fernando.Sousa
 */
public abstract class Imovel {
    
    protected Endereco endereco;
    protected String descricao;
    protected float areaTotal;
    protected double valor;
    protected Situacao situacao;
    
    abstract String consultar();
    abstract String listar();
    
}
