package net.chrisrichardson.scripting.helloWorld;

import net.chrisrichardson.scripting.common.files.FileUtil;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class HelloWorldWriterTest {

  @Test
  public void shouldWriteFile() {

    var writer = new HelloWorldWriter();

    var targetFile = FileUtil.makeTempFilePath("hello.txt");

    writer.sayHello(targetFile);

    assertFileContainsExactly(targetFile, "Hello, World!");
  }

  private static void assertFileContainsExactly(Path targetFile, String... lines) {
    var contents = FileUtil.readLinesFromFile(targetFile);
    assertThat(contents).containsExactly(lines);
  }

}