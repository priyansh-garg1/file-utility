# Simple File Utility

This is a minimal Java Maven project that performs a basic file operation: it reads a file, counts the number of lines and words, and prints a summary.

## Project structure

- `src/main/java/com/example/filetool/BasicFileProcessor.java` - main logic
- `src/test/java/com/example/filetool/BasicFileProcessorTest.java` - basic unit test

## Build

```bash
mvn clean test
```

## Run

```bash
mvn exec:java -Dexec.mainClass="com.example.filetool.BasicFileProcessor" -Dexec.args="/path/to/file.txt"
```

Or build a jar and run it:

```bash
mvn clean package
java -jar target/simple-file-utility-1.0.0.jar /path/to/file.txt
```

## Apache 2.0 License

This project is released under the Apache License 2.0. See the `LICENSE` file for details.

## Publishing to Maven Central

1. Create a GitHub repository and push the code.
2. Create a Sonatype JIRA account and open a new project ticket.
3. Generate a GPG key for signing artifacts.
4. Update `pom.xml` with your real groupId, artifactId, version, GitHub URL, developer details, and SCM URLs.
5. Add your Sonatype username/password to `~/.m2/settings.xml`.
6. Run:

```bash
mvn clean deploy -P release
```

7. Log in to Sonatype OSSRH and promote the staged release.
8. Wait for Maven Central sync.

## Important notes for publishing

- Maven Central requires a valid GPG signature.
- Your project must have a valid `LICENSE` file.
- The package coordinates must be unique across Maven Central.
- Use a real GitHub repository and correct SCM URLs.
- Keep artifact versions unique and semantic.
# file-utility
