//MicroTestThree File

package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class MicroTestThree {

    private SuggestionEngine suggestionEngine = new SuggestionEngine();

    @Mock
    private SuggestionsDatabase mockSuggestionDB;

    private MicroTestThree() {
    }

    public static MicroTestThree createMicroTestThree() {
        return new MicroTestThree();
    }

    @Test
    public void testSuggestionsDatabaseFunctionality() {
        SuggestionsDatabase suggestionsDatabase = new SuggestionsDatabase();
        Map<String, Integer> wordMap = suggestionsDatabase.getWordMap();

        Assertions.assertNotNull(wordMap);
        Assertions.assertTrue(wordMap.isEmpty());

        wordMap.put("test", 1);
        Assertions.assertEquals(1, wordMap.size());
        Assertions.assertEquals(1, (int) wordMap.get("test"));
    }

    @Test
    public void testSuggestionEngineWithMockedDatabase() {
        Map<String, Integer> wordMapForTest = new HashMap<>();
        wordMapForTest.put("example", 1);

        Mockito.when(mockSuggestionDB.getWordMap()).thenReturn(wordMapForTest);
        suggestionEngine.setWordSuggestionDB(mockSuggestionDB);

        Assertions.assertTrue(suggestionEngine.generateSuggestions("examp").contains("example"));
        Assertions.assertFalse(suggestionEngine.generateSuggestions("example").contains("example"));
    }

    @Test
    public void testLoadDictionaryData() throws Exception {
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));
        Assertions.assertFalse(suggestionEngine.getWordSuggestionDB().isEmpty());
    }

    @Test
    public void testGenerateSuggestionsWithRealDictionary() throws Exception {
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));
        Assertions.assertTrue(suggestionEngine.generateSuggestions("wrld").contains("world"));
    }
}