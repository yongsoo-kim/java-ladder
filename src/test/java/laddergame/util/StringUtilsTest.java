package laddergame.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void isEmpty_for_empty_string() {
        assertTrue(StringUtils.isEmpty((String) null));
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void isEmpty_for_string() {
        assertFalse(StringUtils.isEmpty("aaa"));
    }

    @Test
    public void repeat_for_empty_string() {
        String expected = "";

        assertEquals(expected, StringUtils.repeat(null, 1));
        assertEquals(expected, StringUtils.repeat("", 1));
    }

    @Test
    public void repeat() {
        assertEquals("", StringUtils.repeat("a", -1));
        assertEquals("", StringUtils.repeat("a", 0));
        assertEquals("aaaaa", StringUtils.repeat("a", 5));
        assertEquals("abc", StringUtils.repeat("abc", 1));
        assertEquals("abcdabcdabcd", StringUtils.repeat("abcd", 3));
    }

    @Test
    public void removeWhiteSpace() {
        assertEquals("", StringUtils.removeWhitespace(null));
        assertEquals("", StringUtils.removeWhitespace(""));
        assertEquals("", StringUtils.removeWhitespace(" "));
        assertEquals("", StringUtils.removeWhitespace("      "));
        assertEquals("a", StringUtils.removeWhitespace("  a    "));
        assertEquals("abc", StringUtils.removeWhitespace("  a   b       c"));
    }
}