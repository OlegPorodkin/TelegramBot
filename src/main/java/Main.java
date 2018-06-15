import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Main {

    /**
     * ip - 217.61.106.183 (German)
     * port - 80
     *
     * ip - 145.239.92.106(Poland)
     * port - 3128
     *
     * ip - 109.251.106.8(Ukraine)
     * port - 8010
     *
     * ip - 195.80.140.212(Ukraine)
     * port - 8081
     * */

    private static final String BOT_NAME = "POBot";
    private static final String BOT_TOKEN = "607409929:AAGn4Bj3cNjnR2ZKBkyA0SRwM2aGfIkVo1c" /* your bot's token here */;

    private static final String PROXY_HOST = "217.61.106.183" /* proxy host */;
    private static final Integer PROXY_PORT = 80 /* proxy port */;

    public static void main(String[] args) {

        try {

            ApiContextInitializer.init();

            // Create the TelegramBotsApi object to register your bots
            TelegramBotsApi botsApi = new TelegramBotsApi();

            // Set up Http proxy
            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);

            HttpHost httpHost = new HttpHost(PROXY_HOST, PROXY_PORT);

            RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setAuthenticationEnabled(false).build();
            botOptions.setRequestConfig(requestConfig);

            botOptions.setHttpProxy(httpHost);

            MyBot bot = new MyBot(BOT_TOKEN, BOT_NAME, botOptions);

            botsApi.registerBot(bot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
