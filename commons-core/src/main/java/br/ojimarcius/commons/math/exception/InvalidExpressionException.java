/*
 * Copyright (C) 2013 Marcius da Silva da Fonseca.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA
 */
package br.ojimarcius.commons.math.exception;

/**
 * Exception thrown when a math expression is invalid.
 *
 * @author Marcius da Silva da Fonseca (sf.marcius@gmail.com)
 * @version 1.0
 */
public class InvalidExpressionException extends RuntimeException {

    private static final long serialVersionUID = 3415434370641506225L;
    /**
     * Default message used when none is defined.
     */
    private static final String DEFAULT_MESSAGE = "Invalid math exception.";

    /**
     * Default constructor.
     */
    public InvalidExpressionException() {
        this(DEFAULT_MESSAGE, null);
    }

    /**
     * Constructor with message definition.
     *
     * @param message The message for the new exception.
     */
    public InvalidExpressionException(final String message) {
        this(message, null);
    }

    /**
     * Constructor with cause definition.
     *
     * @param cause The cause for the new exception.
     */
    public InvalidExpressionException(final Throwable cause) {
        this(DEFAULT_MESSAGE, cause);
    }

    /**
     * Constructor with message and cause definition.
     *
     * @param message The message for the new exception.
     * @param cause   The cause for the new exception.
     */
    public InvalidExpressionException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
