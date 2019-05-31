package ute.apdist.udp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.dsl.Udp;
import org.springframework.integration.stream.CharacterStreamWritingMessageHandler;;

@Configuration
public class UdpReceiveConfig {

	@Bean
	public IntegrationFlow fromUdpToConsole() {
		return IntegrationFlows
			.from(Udp.inboundMulticastAdapter(8888, "224.0.0.2"))
			.handle(CharacterStreamWritingMessageHandler.stdout())
			.get();
	}

}
