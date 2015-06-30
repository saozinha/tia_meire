package to;

import java.io.Serializable;

/**
 * Created by ConceicaoLourenco on 25/06/2015.
 */
public class Produto implements Serializable {

    // identifica o objeto para serializacao - ou seja, transportar um objeto pela rede
    private static final long serialVersionUID = 1L;

    public Long id;
    public int imagem;
    public String descricao;
    public String preco;

    public Produto() {
    }

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public Produto(Long id, int imagem, String descricao, String preco) {
        this.id = id;
        this.imagem = imagem;
        this.descricao = descricao;
        this.preco = preco;
    }


    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }


}
