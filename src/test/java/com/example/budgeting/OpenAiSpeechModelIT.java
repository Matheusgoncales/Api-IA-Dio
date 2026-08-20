package com.example.budgeting;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPEN_AI_KEY", matches = ".+")
public class OpenAiSpeechModelIT {
    @Autowired
    OpenAiAudioSpeechModel openAiAudioSpeechModelModel;

    @Test
    public void shouldproduceAudioWhenTextIsProvied() throws IOException {
      var response = openAiAudioSpeechModelModel.call("O valor total de serviço ficou em 80 reais, posso confirmar o pagamento?");

      assertThat(response).hasSizeGreaterThan(1024);

       var tempFile = Files.createTempFile("AUDIO_",".mp3");
       Files.write(tempFile, response);
       System.out.println(tempFile.toAbsolutePath());
    }
}
