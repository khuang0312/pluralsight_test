package com.veevaQA.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AnagramTest {
    @Test
    void testIsAnagramReturnsTrueWhenSpellingIsSame() {
        assertTrue(Anagram.isAnagram("", ""));
        assertTrue(Anagram.isAnagram("a", "a"));
        assertTrue(Anagram.isAnagram("abc", "abc"));
        assertTrue(Anagram.isAnagram("Def", "Def"));
    }

    @Test
    void testIsAnagramReturnsFalseWhenNotAnagrams() {
        assertFalse(Anagram.isAnagram("", "a"));
        assertFalse(Anagram.isAnagram("ab", "a"));
        assertFalse(Anagram.isAnagram("abc", "aab"));
    }

    @Test
    void testIsAnagramReturnsTrueWhenCharFreqIsSame() {
        assertTrue(Anagram.isAnagram("abcc", "ccab"));
        assertTrue(Anagram.isAnagram("tour", "rout"));
    }

    @Test
    void testIsAnagramDisregardsPunctuation() {
        assertTrue(Anagram.isAnagram("snake's", "snakes"));
    }

    @Test
    void testIsAnagramDisregardsSpacing() {
        assertTrue(Anagram.isAnagram("tom marvolo riddle", "i am lord voldemort"));
    }

    @Test
    void testIsAnagramDisregardsCapitalization() {
        assertTrue(Anagram.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
    }

    @Test
    void testIsAnagramReturnsTrueWithUnicodeCharactersWithSameSoundAndLatinLetter() {
        // https://codepoints.net/U+A7AE
        assertTrue(Anagram.isAnagram("Tom Marvolo R\uA7AEddle", "\uA7AE am Lord Voldemort"));
    }

    @Test
    void testIsAnagramReturnsFalseWithUnicodeCharactersWithoutSameSoundNorLatinLetter() {
        // this doesn't match modern G
        // https://codepoints.net/U+A7D1
        assertFalse(Anagram.isAnagram("Google", "\uA7D1oo\uA7D1le"));

        // Cherokee script is not the same as Latin
        // https://codepoints.net/U+13AA
        assertFalse(Anagram.isAnagram("apple", "\u13AApple"));

        // Roman numerals translate to numbers, not letters
        assertFalse(Anagram.isAnagram("vi", "\u2174\u2170"));
    }

    @Test
    void testIsAnagramHandlesNullReferences() {
        assertThrows(NullPointerException.class, () -> {
            Anagram.isAnagram(null, "");
        });
        assertThrows(NullPointerException.class, () -> {
            Anagram.isAnagram("", null);
        });
        assertThrows(NullPointerException.class, () -> {
            Anagram.isAnagram(null, null);
        });
    }
}
