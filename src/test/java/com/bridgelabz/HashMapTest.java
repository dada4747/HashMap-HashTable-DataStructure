package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {
    @Test
    public void givenASentence_WhenWordsAreAddedToList_ShouldReturnWordFrequency() {
        String sentence = "To be or not to be";
        HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value = value + 1;
            myHashMap.add(word, value);
        }
        int frequency = myHashMap.get("to");
        Assertions.assertEquals(2, frequency);
    }
}
