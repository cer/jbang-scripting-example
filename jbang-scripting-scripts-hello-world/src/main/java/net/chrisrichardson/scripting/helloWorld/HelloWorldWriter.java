package net.chrisrichardson.scripting.helloWorld;

import net.chrisrichardson.scripting.common.files.FileUtil;

import java.nio.file.Path;
import java.util.List;

public class HelloWorldWriter {

  void sayHello(Path targetFile) {
    FileUtil.writeLinesToFile(targetFile, List.of("Hello, World!"));
  }

}
