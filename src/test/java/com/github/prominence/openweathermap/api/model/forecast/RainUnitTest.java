/*
 * Copyright (c) 2021 Alexey Zinchenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.prominence.openweathermap.api.model.forecast;

import org.junit.Assert;
import org.junit.Test;

public class RainUnitTest {
    @Test
    public void whenCreateRainWithValidArgs_thenObjectIsCreated() {
        Rain.withThreeHourLevelValue(2222.3);
        Rain.withThreeHourLevelValue(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithInvalidData_thenFail() {
        Rain.withThreeHourLevelValue(-20);
    }

    @Test
    public void whenSetValues_thenTheyAreSet() {
        final Rain rain = Rain.withThreeHourLevelValue(0);

        Assert.assertEquals(0, rain.getThreeHourRainLevel(), 0.00001);

        rain.setThreeHourRainLevel(55.5);
        Assert.assertEquals(55.5, rain.getThreeHourRainLevel(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSetInvalidValue_thenFail() {
        final Rain rain = Rain.withThreeHourLevelValue(0);

        rain.setThreeHourRainLevel(-20);
    }

    @Test
    public void whenCallToString_thenAllIsFine() {
        final Rain rain = Rain.withThreeHourLevelValue(33.5);

        Assert.assertNotNull(rain.toString());
        Assert.assertNotEquals("", rain.toString());
    }

    @Test
    public void whenCallHashCode_thenAllIsFine() {
        final Rain first = Rain.withThreeHourLevelValue(0);
        final Rain second = Rain.withThreeHourLevelValue(0);

        Assert.assertEquals(first.hashCode(), second.hashCode());

        second.setThreeHourRainLevel(11.0);

        Assert.assertNotEquals(first.hashCode(), second.hashCode());

        first.setThreeHourRainLevel(11.0);

        Assert.assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void whenCheckEquality_thenAllIsFine() {
        final Rain first = Rain.withThreeHourLevelValue(0);
        final Rain second = Rain.withThreeHourLevelValue(0);

        Assert.assertTrue(first.equals(second));
        Assert.assertTrue(first.equals(first));
        Assert.assertFalse(first.equals(new Object()));

        second.setThreeHourRainLevel(66.7);

        Assert.assertFalse(first.equals(second));

        first.setThreeHourRainLevel(66.7);

        Assert.assertTrue(first.equals(second));
    }
}
