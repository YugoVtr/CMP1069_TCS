
package imobiliaria;

/**
 *
 * @author Fernando.Sousa
 */
public class Apartamento extends Imovel{
    
    int andar;
    int numero;
    String nomeEdificio;
    int numQuartos;
    int numVagasGaragem;
    int anoConstrucao;
    double valorCondominio;
    TipoApto tipoApartamento;
    
     @Override
    String consultar() {
       return "";
    }

    @Override
    String listar() {
        return "";
    }
}
