package com.veevaQA.app;

import java.util.Locale;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class Anagram {
    private Anagram() {
        // Utility classes should not have public constructors
        // by defining this, we get rid of the implicit constructor
        throw new IllegalStateException("Utilty class");
    }

    /**
     * Returns whether two strings are an anagram of each other
     */
    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase(Locale.ROOT);
        s2 = s2.toLowerCase(Locale.ROOT);

        Multiset<Integer> charPointFrequencyMap = HashMultiset.create();

        // code points map to every possible character in the Unicode standard
        // char is too small to do such
        s1.codePoints().forEachOrdered(c -> {
            // punctuation, symbols, and spacing
            // do not matter toward determining anagrams
            if (Character.isLetter(c)) {
                // helps make case agnostic logic
                charPointFrequencyMap.add(Character.toLowerCase(c));
            }
        });

        s2.codePoints().forEachOrdered(c -> {
            if (Character.isLetter(c)) {
                int lowerC = Character.toLowerCase(c);

                if (charPointFrequencyMap.contains(lowerC)) {
                    int newCount = charPointFrequencyMap.count(lowerC) - 1;
                    charPointFrequencyMap.setCount(lowerC, newCount);
                } else {
                    charPointFrequencyMap.add(lowerC);
                }
            }
        });

        return charPointFrequencyMap.isEmpty();
    }
}
