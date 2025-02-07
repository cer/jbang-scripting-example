package net.chrisrichardson.scripting.helloWorld;

import org.junit.jupiter.api.Test;
import net.chrisrichardson.scripting.common.files.FileUtil;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.file.Path;

@ExtendWith(MockitoExtension.class)
class HelloWorldCommandTest {

  @Mock
  private HelloWorldWriter writer;

  @Test
  public void shouldRequireArg() {

    var result = HelloWorldCommand.execute(new HelloWorldCommand(writer));

    assertThat(result).isNotEqualTo(0);

    verifyNoInteractions(writer);
  }

  @Test
  public void shouldWriteFile() {

    String targetFile = "hello.txt";

    var result = HelloWorldCommand.execute(new HelloWorldCommand(writer), targetFile);

    assertThat(result).isEqualTo(0);

    verify(writer).sayHello(Path.of(targetFile));
  }

}