package ute.apdist.udp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.ip.dsl.Udp;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.stream.CharacterStreamReadingMessageSource;

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
			.handle(Udp.outboundMulticastAdapter("224.0.0.2", 8888))
			.get();
	}
	
}
