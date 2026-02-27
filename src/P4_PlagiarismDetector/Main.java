package P4_PlagiarismDetector;

public class Main {

    public static void main(String[] args) {

        PlagiarismDetector detector = new PlagiarismDetector(3);

        String doc1 = "Java is a programming language. Java is widely used.";
        String doc2 = "Java is a powerful programming language used worldwide.";
        String doc3 = "Python is different from Java and is popular.";

        detector.addDocument("Doc1", doc1);
        detector.addDocument("Doc2", doc2);

        detector.analyzeDocument("Doc3", doc3);
    }
}