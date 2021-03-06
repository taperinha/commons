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
package br.ojimarcius.commons.lang;

import br.ojimarcius.commons.text.CharSequenceComparator;
import br.ojimarcius.commons.BaseTest;
import br.ojimarcius.commons.constants.Constants;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CharSequenceComparatorTest extends BaseTest {

    private static final int MAX_IT = 25000;

    @Test
    public void testCompare() {
        long t0 = System.currentTimeMillis();
        CharSequenceComparator comparator = new CharSequenceComparator(Constants.CASE_SENSITIVE);
        assertTrue(comparator.compare("a", "b") < 0);
        assertTrue(comparator.compare("a", "A") > 0);
        assertTrue(comparator.compare("A", "a") < 0);
        assertTrue(comparator.compare("Á", "Â") != 0);

        comparator.setCaseSensitive(Constants.CASE_INSENSITIVE);
        assertTrue(comparator.compare("a", "b") < 0);
        assertTrue(comparator.compare("a", "A") == 0);
        assertTrue(comparator.compare("A", "a") == 0);
        assertTrue(comparator.compare("Á", "Â") != 0);
        long t1 = System.currentTimeMillis();
        infoTime("compare() tested in {0} msecs", t0, t1);
    }

    @Test
    public void testIndexOf() {
        long t0 = System.currentTimeMillis();
        CharSequenceComparator comparator = new CharSequenceComparator(Constants.CASE_SENSITIVE);
        for (int i = 0; i < MAX_IT; i++) {
            final String toSearch = randomString();
            final String seq = randomString();
            final int expected = seq.indexOf(toSearch);
            final int result = comparator.indexOf(toSearch, seq);
            assertEquals("failed for: <" + toSearch + "> in <" + seq + ">", expected, result);
        }

        comparator.setCaseSensitive(Constants.CASE_INSENSITIVE);
        for (int i = 0; i < MAX_IT; i++) {
            final String toSearch = randomString();
            final String seq = randomString();
            final int expected = seq.toLowerCase().indexOf(toSearch.toLowerCase());
            final int result = comparator.indexOf(toSearch, seq);
            assertEquals("failed for: <" + toSearch + "> in <" + seq + ">", expected, result);
        }
        long t1 = System.currentTimeMillis();
        infoTime("indexOf() tested in {0} msecs", t0, t1);
    }

    @Test
    public void testLastIndexOf() {
        long t0 = System.currentTimeMillis();
        CharSequenceComparator comparator = new CharSequenceComparator(Constants.CASE_SENSITIVE);
        for (int i = 0; i < MAX_IT; i++) {
            final String toSearch = randomString();
            final String seq = randomString();
            final int expected = seq.lastIndexOf(toSearch);
            final int result = comparator.lastIndexOf(toSearch, seq);
            assertEquals("failed for: <" + toSearch + "> in <" + seq + ">", expected, result);
        }

        comparator.setCaseSensitive(Constants.CASE_INSENSITIVE);
        for (int i = 0; i < MAX_IT; i++) {
            final String toSearch = randomString();
            final String seq = randomString();
            final int expected = seq.toLowerCase().lastIndexOf(toSearch.toLowerCase());
            final int result = comparator.lastIndexOf(toSearch, seq);
            assertEquals("failed for: <" + toSearch + "> in <" + seq + ">", expected, result);
        }
        long t1 = System.currentTimeMillis();
        infoTime("lastIndexOf() tested in {0} msecs", t0, t1);
    }
}
