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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package br.ojimarcius.commons.constants;

/**
 *
 * @author vbox
 */
public abstract class SplitPattern {

    /**
     * A constant to split a CharSequence by commas, surrounded or not by spaces.
     */
    public static final String COMMA = "\\s*,\\s*";
    /**
     * A constant to split a CharSequence by semicolons, surrounded or not by spaces.
     */
    public static final String SEMICOLON = "\\s*;\\s*";
    /**
     * A constant to split a CharSequence by pipes, surrounded or not by spaces.
     */
    public static final String PIPE = "\\s*\\|\\s*";
    /**
     * A constant to split a CharSequence by newlines, surrounded or not by non-newline-spaces.
     */
    public static final String NEWLINE = "([^\\S\\n])*\\n([^\\S\\n])*";
}
