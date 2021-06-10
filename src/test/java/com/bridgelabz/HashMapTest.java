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
    @Test
    public void givenASentenceWhenWordsAreAddedShouldReturnWordFrequency() {
        String sentence = "Paranoids are not paranoid because they are paranoid but "+
                "because they keep putting themselves deliberately into " +
                "paranoid avoidable situations";
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = linkedHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value = value + 1;
            linkedHashMap.add(word, value);
        }
        int frequency = linkedHashMap.get("paranoid");
        Assertions.assertEquals(3, frequency);
    }
    @Test
    public void givenASentence_WhenWordsAreRemoved_ShouldReturnRemovedWord() {
        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        LinkedHashMap<String, Integer> myLinkedHashMap = new LinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value = value + 1;
            myLinkedHashMap.add(word, value);
        }
        myLinkedHashMap.remove("avoidable");
        Integer frequency = myLinkedHashMap.get("avoidable");
        Assertions.assertEquals(null, frequency);
    }
}
