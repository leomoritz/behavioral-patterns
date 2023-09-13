package br.com.cod3r.command.alexa.alexa;

import br.com.cod3r.command.alexa.command.Command;

public class AlexaConfiguration {

    private String key;
    private Command commandLight;
    private String[] keywords;

    public AlexaConfiguration() {
    }

    public AlexaConfiguration(String key, Command commandLight, String... keywords) {
        this.key = key;
        this.commandLight = commandLight;
        this.keywords = keywords;
    }

    public AlexaConfiguration(String key, Command commandLight) {
        this.key = key;
        this.commandLight = commandLight;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Command getCommandLight() {
        return commandLight;
    }

    public void setCommandLight(Command commandLight) {
        this.commandLight = commandLight;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void addKeywords(String... keywords) {
        this.keywords = keywords;
    }
}
