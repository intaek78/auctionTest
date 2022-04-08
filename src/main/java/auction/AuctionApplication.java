package auction;
import auction.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
@EnableSwagger2
public class AuctionApplication {
    protected static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(AuctionApplication.class, args);
    }
}

