package ute.apdist.tcp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.stream.CharacterStreamWritingMessageHandler;

@Configuration
public class TcpServerConfig {

	@Bean
	public IntegrationFlow fromTcpToConsole() {
		return IntegrationFlows
			.from(Tcp.inboundAdapter(Tcp.netServer(8888)))
			.handle(CharacterStreamWritingMessageHandler.stdout())
			.get();
	}
	
}
