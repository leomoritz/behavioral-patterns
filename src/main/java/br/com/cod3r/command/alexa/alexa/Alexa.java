package br.com.cod3r.command.alexa.alexa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import br.com.cod3r.command.alexa.command.Command;

public class Alexa {

    private Map<String, Command> integrations;
    private AlexaAI alexaAI;
    private Logger logger;

    public Alexa() {
        integrations = new HashMap<>();
        alexaAI = new AlexaAI();
        logger = Logger.getLogger("AlexaLogger");
    }

    public void configureAlexaWithNewIntegrations(List<AlexaConfiguration> alexaConfigurations) {
        for (AlexaConfiguration config : alexaConfigurations) {
            addIntegration(config.getKey(), config.getCommandLight(), config.getKeywords());
        }
    }

    private void addIntegration(String key, Command light, String... keywords) {
        key = toLowerCase(key);
        keywords = toLowerCase(keywords);
        this.integrations.put(key, light);
        alexaAI.addAssociation(key, keywords);
    }

    private String[] toLowerCase(String... keys) {
        return Arrays.stream(keys).map(this::toLowerCase).toArray(String[]::new);
    }

    private String toLowerCase(String key) {
        return key.toLowerCase();
    }

    public void sendRequest(String request) {
        request = toLowerCase(request);
        Command commandLight = integrations.get(request);

        if (commandLight == null) {
            commandLight = alexaAI.getKeyInAssociationByRequest(request) //
                    .map(key -> integrations.get(key)) //
                    .orElseThrow(() -> new RuntimeException("Cannot perform this action because a command could not be found from the request!"));
        }

        String startExecuteLog = String.format("Starting execution of the \\\"%s\\\" request", request);
        logger.fine(startExecuteLog);
        commandLight.execute();
    }
}
