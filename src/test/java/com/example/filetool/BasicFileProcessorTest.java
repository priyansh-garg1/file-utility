package com.example.filetool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class BasicFileProcessorTest {

    @Test
    void summarizeFileCountsWordsAndLines() throws IOException {
        Path tempFile = Files.createTempFile("simple-file", ".txt");
        Files.writeString(tempFile, "hello world\nhello again\n", StandardCharsets.UTF_8);

        BasicFileProcessor processor = new BasicFileProcessor();
        String summary = processor.summarizeFile(tempFile);

        assertTrue(summary.contains("chars="));
        assertTrue(summary.contains("lines=2"));
        assertTrue(summary.contains("words=4"));
        assertEquals(4, processor.countWords("hello world\nhello again"));
    }
}
