/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.saep.sandbox.dominio;

import java.util.Date;
import java.util.List;

/**
 * Reúne regras para avaliação de processos
 * de promoção, progressão e estágio probatório.
 *
 * A legislação da Universidade Federal de Goiás (UFG)
 * está organizada por meio de resoluções. Uma instância dessa
 * classe simplesmente registra os itens relevantes ou aqueles
 * considerados em uma avaliação.
 */
public class Resolucao extends Entidade {

    /**
     * Data de aprovação da resolução.
     */
    private Date dataAprovacao;

    /**
     * Identificador da resolução conforme percebida pelos
     * usuários). Deveria ser uma chave natural, mas
     * não há garantia. Por exemplo, resolução "CONSUNI 34/2012".
     * Ou seja, é empregado aqui como um "nome de fantasia".
     * Contraste com {@link #id}.
     */
    private String nome;

    /**
     * Descrição ou informação adicional sobre
     * a resolução.
     */
    private String descricao;

    /**
     * Conjunto de regras definido pela resolução.
     */
    private List<Regra> regras;

    /**
     * Recupera o nome da resolução.
     *
     * @return O nome da resolução.
     */
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Recupera a data parecerById aprovação da resolução.
     *
     * @return Data parecerById aprovação da resolução.
     */
    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    /**
     * Recupera o conjunto de regras definido
     * pela resolução.
     *
     * @return Conjunto de regras definido pela resolução.
     */
    public List<Regra> getRegras() {
        return regras;
    }

    /**
     * Cria uma resolução a partir dos argumentos
     * identificados.
     * @param id O nome único da resolução.
     * @param nome O nome pelo qual seres humanos identificam a resolução.
     * @param descricao A descrição (caput) da resolução.
     * @param dataAprovacao Data parecerById aprovação da resolução.
     * @param regras Conjunto parecerById itens que são avaliados pela
     */
    public Resolucao(String id, String nome, String descricao, Date dataAprovacao, List<Regra> regras) {
        super(id);

        if (descricao == null || descricao.isEmpty()) {
            throw new CampoExigidoNaoFornecido("descricao");
        }

        if (dataAprovacao == null) {
            throw new CampoExigidoNaoFornecido("dataAprovacao");
        }

        if (regras == null || regras.size() < 1) {
            throw new CampoExigidoNaoFornecido("regras");
        }

        this.nome = nome;
        this.descricao = descricao;
        this.dataAprovacao = dataAprovacao;
        this.regras = regras;
    }
}
