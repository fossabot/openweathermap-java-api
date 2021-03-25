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

package com.github.prominence.openweathermap.api.model;

import org.junit.Assert;
import org.junit.Test;

public class TemperatureUnitTest {
    @Test
    public void whenCreateObjectWithValidArgs_thenObjectIsCreated() {
        Temperature.withValue(22.2, "K");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateObjectWithEmptyUnit_thenThrowAnException() {
        Temperature.withValue(22.2, null);
    }

    @Test
    public void whenSetValue_thenAllIsFine() {
        final Temperature temperature = Temperature.withValue(22.2, "K");
        temperature.setValue(55.44);

        Assert.assertEquals(55.44, temperature.getValue(), 0.00001);
    }

    @Test
    public void whenSetMaximumTemperature_thenAllIsOk() {
        final Temperature temperature = Temperature.withValue(22.2, "K");
        temperature.setMaxTemperature(44.4);

        Assert.assertEquals(44.4, temperature.getMaxTemperature(), 0.00001);

        temperature.setMaxTemperature(null);

        Assert.assertNull(temperature.getMaxTemperature());
    }

    @Test
    public void whenSetMinimumTemperature_thenAllIsOk() {
        final Temperature temperature = Temperature.withValue(22.2, "K");
        temperature.setMinTemperature(33.2);

        Assert.assertEquals(33.2, temperature.getMinTemperature(), 0.00001);

        temperature.setMinTemperature(null);

        Assert.assertNull(temperature.getMinTemperature());
    }

    @Test
    public void whenSetFeelsLikeTemperature_thenAllIsOk() {
        final Temperature temperature = Temperature.withValue(22.2, "K");
        temperature.setFeelsLike(22.3);

        Assert.assertEquals(22.3, temperature.getFeelsLike(), 0.00001);

        temperature.setFeelsLike(null);

        Assert.assertNull(temperature.getFeelsLike());
    }

    @Test
    public void whenSetNonNullUnit_thenAllIsOk() {
        final Temperature temperature = Temperature.withValue(22.2, "K");
        temperature.setUnit("test");

        Assert.assertTrue("test".equals(temperature.getUnit()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSetNullUnit_thenThrowAnException() {
        final Temperature temperature = Temperature.withValue(22.2, "K");

        temperature.setUnit(null);
    }

    @Test
    public void whenCallToString_thenAllIsFine() {
        final Temperature temperature = Temperature.withValue(22.2, "K");

        Assert.assertNotNull(temperature.toString());
        Assert.assertNotEquals("", temperature.toString());

        temperature.setMinTemperature(11.2);

        Assert.assertNotNull(temperature.toString());
        Assert.assertNotEquals("", temperature.toString());

        temperature.setMaxTemperature(44.3);

        Assert.assertNotNull(temperature.toString());
        Assert.assertNotEquals("", temperature.toString());

        temperature.setFeelsLike(22.4);

        Assert.assertNotNull(temperature.toString());
        Assert.assertNotEquals("", temperature.toString());
    }

    @Test
    public void whenCallHashCode_thenAllIsFine() {
        final Temperature one = Temperature.withValue(22.2, "K");
        final Temperature two = Temperature.withValue(22.2, "K");

        Assert.assertEquals(one.hashCode(), two.hashCode());
    }

    @Test
    public void whenCheckEquality_thenAllIsFine() {
        final Temperature one = Temperature.withValue(22.2, "K");
        final Temperature two = Temperature.withValue(21.2, "K");

        Assert.assertTrue(one.equals(one));
        Assert.assertFalse(one.equals(new Object()));
        Assert.assertFalse(one.equals(two));

        one.setValue(21.2);

        Assert.assertTrue(one.equals(two));

        one.setMaxTemperature(33.56);

        Assert.assertFalse(one.equals(two));

        two.setMaxTemperature(33.56);

        Assert.assertTrue(one.equals(two));

        one.setMinTemperature(11.54);

        Assert.assertFalse(one.equals(two));

        two.setMinTemperature(11.54);

        Assert.assertTrue(one.equals(two));

        two.setUnit("U");

        Assert.assertFalse(one.equals(two));

        one.setUnit("U");

        Assert.assertTrue(one.equals(two));

        one.setFeelsLike(22.3);

        Assert.assertFalse(one.equals(two));

        two.setFeelsLike(22.3);

        Assert.assertTrue(one.equals(two));
    }
}
