package ute.apdist.tcp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.stream.CharacterStreamReadingMessageSource;

// https://docs.spring.io/spring-integration/api/org/springframework/integration/ip/dsl/Tcp.html

@Configuration
public class TcpClientConfig {

	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata poller() {
	    return Pollers.fixedDelay(500).get();
	}

	@Bean
	public IntegrationFlow fromKeyboardToTcp() {
		return IntegrationFlows
			.from(CharacterStreamReadingMessageSource.stdin())
			.handle(Tcp.outboundAdapter(Tcp.netClient("localhost", 8888)))
			.get();
	}
	
}
