/*
 * commons-persistence - Copyright (c) 2009-2012 MSF. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to
 * the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 */
package br.ojimarcius.commons.persistence.service;

import br.ojimarcius.commons.persistence.model.DescribedEntity;
import java.io.Serializable;
import java.util.Collection;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

/**
 * TODO
 *
 * @author Marcius da Silva da Fonseca (sf.marcius@gmail.com)
 * @version 1.0
 * @param <ID> The type of the Entity's id (Ex: Long, Integer, String, ...).
 * @param <T>  The Type of Entity handled by the Service.
 * @param <D>  The Type of DAO that do the database tasks for the Service.
 */
public interface DescribedEntityService<ID extends Serializable & Comparable<ID>, T extends DescribedEntity<ID>> extends EntityService<ID, T> {

    public Collection<T> findByDescription(final String descrPart);

    public Collection<T> findByDescription(final String descrPart, final MatchMode matchMode);

    public Collection<T> findByDescription(final String descrPart, final MatchMode matchMode, final boolean caseSensitive);

    public Collection<T> findByDescription(final String descrPart, final MatchMode matchMode, final boolean caseSensitive, final Order order);
}
