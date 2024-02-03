package syberry.hackathon.bot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Data
public class BotConfig {

    @Value("${bot.name}")
    public String botName;

    @Value("${bot.token}")
    public String botToken;
}
