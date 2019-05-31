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
			.from(Udp.inboundAdapter(8888))
			.handle(CharacterStreamWritingMessageHandler.stdout())
			.get();
	}

}
