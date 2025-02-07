package net.chrisrichardson.scripting.common.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtil {

  public static Path makeTempDir() {
    try {
      return Files.createTempDirectory("tempProjectRoot");
    } catch (IOException e) {
      throw new RuntimeException("Failed to create temp directory", e);
    }
  }

  public static Path makeTempFilePath(String fileName) {
    var tempDir = makeTempDir();
    var targetFile = tempDir.resolve(fileName);
    return targetFile;
  }

  public static List<String> readLinesFromFile(Path path) {
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  public static void writeLinesToFile(Path targetFile, List<String> lines) {
    try {
      Files.write(targetFile, lines);
    } catch (IOException e) {
      throw new RuntimeException("Failed to write lines to file", e);
    }
  }

}
