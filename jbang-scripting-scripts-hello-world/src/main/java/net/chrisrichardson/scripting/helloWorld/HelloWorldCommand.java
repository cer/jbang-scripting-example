package net.chrisrichardson.scripting.helloWorld;

import java.nio.file.Path;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "HelloWorld", mixinStandardHelpOptions = true, version = "0.1",
    description = "HelloWorld made with JBang")
public class HelloWorldCommand implements Callable<Integer>  {


  @Parameters(index = "0", description = "target file")
  private Path targetFile;

  private final HelloWorldWriter writer;

  public HelloWorldCommand(HelloWorldWriter writer) {
    this.writer = writer;
  }

  @Override
  public Integer call() {
    writer.sayHello(targetFile);
    return 0;
  }

  public static int execute(String... args) {
    return execute(new HelloWorldCommand(new HelloWorldWriter()), args);
  }

  public static int execute(HelloWorldCommand command, String... args) {
    return new CommandLine(command).execute(args);
  }

}
