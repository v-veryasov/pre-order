package ru.edu.iorder.booking;

@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(EhealthApiGatewayApplication.class, args);
    }
}
