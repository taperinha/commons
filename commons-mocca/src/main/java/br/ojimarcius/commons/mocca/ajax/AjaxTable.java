/*
 * Copyright (C) 2014 Marcius da Silva da Fonseca.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package br.ojimarcius.commons.mocca.ajax;

import java.io.Serializable;
import java.util.Map;

/**
 * Classe base para paginação ajax.
 *
 * @author Marcius da Silva da Fonseca (mfonseca@ufsm.br)
 * @param <T> Tipo de retorno do search().
 */
public interface AjaxTable<T extends Serializable> extends AjaxFinder<T> {

    /**
     * Deve retornar um mapa, contendo o nome do field como chave, e a msg de erro de sua validação.
     * <p/>
     * Retorno vazio ou nulo significa sem erros de validação.
     *
     * @param params A coleção de parametros da pesquisa.
     * @return Um mapa, contendo o nome do field como chave, e a msg de erro de sua validação.
     */
    public Map<String, String> validate(final Map<String, String> params);

    /**
     * Deve retornar a contagem total dos itens da pesquisa.
     *
     * @param params A coleção de parametros da pesquisa.
     * @return A contagem total dos itens da pesquisa.
     * @throws java.lang.Exception Caso ocorra algo inesperado.
     */
    public abstract long count(final Map<String, String> params) throws Exception;
}
