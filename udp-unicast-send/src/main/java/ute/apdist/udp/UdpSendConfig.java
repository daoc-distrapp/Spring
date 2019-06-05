package ute.apdist.udp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.ip.dsl.Udp;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.stream.CharacterStreamReadingMessageSource;

// https://docs.spring.io/spring-integration/api/org/springframework/integration/scheduling/PollerMetadata.html
// https://docs.spring.io/spring-integration/api/org/springframework/integration/annotation/Poller.html
// https://docs.spring.io/spring-integration/api/org/springframework/integration/dsl/IntegrationFlow.html
// https://docs.spring.io/spring-integration/api/org/springframework/integration/dsl/IntegrationFlows.html
// https://docs.spring.io/spring-integration/api/org/springframework/integration/stream/CharacterStreamReadingMessageSource.html
// https://docs.spring.io/spring-integration/docs/5.1.0.RELEASE/reference/html/ip.html
// https://docs.spring.io/spring-integration/api/org/springframework/integration/ip/dsl/Udp.html

@Configuration
public class UdpSendConfig {

	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata poller() {
	    return Pollers.fixedDelay(500).get();
	}

	@Bean
	public IntegrationFlow fromKeyboardToUdp() {
		return IntegrationFlows
			.from(CharacterStreamReadingMessageSource.stdin())
			.handle(Udp.outboundAdapter("localhost", 8888))
			.get();
	}
	
}
