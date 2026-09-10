package com.motabhai.filetool;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasicFileProcessor {

    public String readFileContent(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    public int countLines(Path path) throws IOException {
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }

    public int countWords(String content) {
        if (content == null || content.trim().isEmpty()) {
            return 0;
        }
        String[] words = content.trim().split("\\s+");
        return words.length;
    }

    public String summarizeFile(Path path) throws IOException {
        String content = readFileContent(path);
        int lineCount = countLines(path);
        int wordCount = countWords(content);

        return String.format(
                "path=%s chars=%d lines=%d words=%d",
                path.toAbsolutePath(),
                content.length(),
                lineCount,
                wordCount
        );
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java -jar <jar-name> <file-path>");
            System.exit(1);
        }

        Path inputFile = Paths.get(args[0]);
        BasicFileProcessor processor = new BasicFileProcessor();
        String summary = processor.summarizeFile(inputFile);
        System.out.println(summary);
    }
}
