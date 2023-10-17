package bo.edu.ucb.msclientpago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsClientPagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClientPagoApplication.class, args);
	}

}
