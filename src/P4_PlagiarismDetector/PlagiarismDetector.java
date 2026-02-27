package P4_PlagiarismDetector;

import java.util.*;

public class PlagiarismDetector {

    private HashMap<String, Set<String>> ngramIndex;
    private int n;

    public PlagiarismDetector(int n) {
        this.n = n;
        this.ngramIndex = new HashMap<>();
    }

    // Add document to index
    public void addDocument(String docId, String content) {
        List<String> ngrams = generateNGrams(content);

        for (String gram : ngrams) {
            ngramIndex
                    .computeIfAbsent(gram, k -> new HashSet<>())
                    .add(docId);
        }
    }

    // Analyze similarity
    public void analyzeDocument(String docId, String content) {

        List<String> ngrams = generateNGrams(content);
        HashMap<String, Integer> matchCount = new HashMap<>();

        for (String gram : ngrams) {
            if (ngramIndex.containsKey(gram)) {
                for (String existingDoc : ngramIndex.get(gram)) {
                    matchCount.put(existingDoc,
                            matchCount.getOrDefault(existingDoc, 0) + 1);
                }
            }
        }

        System.out.println("Analyzing document: " + docId);
        System.out.println("Total n-grams: " + ngrams.size());

        for (Map.Entry<String, Integer> entry : matchCount.entrySet()) {
            double similarity = (entry.getValue() * 100.0) / ngrams.size();
            System.out.println("Matched with: " + entry.getKey()
                    + " | Similarity: " + similarity + "%");
        }
    }

    // Generate n-grams
    private List<String> generateNGrams(String content) {

        String[] words = content.toLowerCase().split("\\s+");
        List<String> grams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(words[i + j]).append(" ");
            }
            grams.add(sb.toString().trim());
        }

        return grams;
    }
}