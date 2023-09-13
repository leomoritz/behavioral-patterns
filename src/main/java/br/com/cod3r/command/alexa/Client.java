package br.com.cod3r.command.alexa;

import java.util.Arrays;

import br.com.cod3r.command.alexa.alexa.Alexa;
import br.com.cod3r.command.alexa.alexa.AlexaConfiguration;
import br.com.cod3r.command.alexa.command.TurnOffLightCommand;
import br.com.cod3r.command.alexa.command.TurnOnLightCommand;
import br.com.cod3r.command.alexa.lights.PhillipsHueLightImpl;
import br.com.cod3r.command.alexa.lights.XiaomiLightImpl;

public class Client {

    public static void main(String[] args) {
        // Alexa's creation and configuration
        Alexa alexa = new Alexa();

        PhillipsHueLightImpl livingRoom = new PhillipsHueLightImpl();
        XiaomiLightImpl kitchen = new XiaomiLightImpl();

        AlexaConfiguration turnOnLivingRoomConfig = new AlexaConfiguration("Turn on the Living room light", //
                                                                           new TurnOnLightCommand(livingRoom), //
                                                                           "on", "living room", "light");

        AlexaConfiguration turnOfLivingRoomConfig = new AlexaConfiguration("Turn off the Living room light", //
                                                                           new TurnOffLightCommand(livingRoom), //
                                                                           "off", "living room", "light");

        AlexaConfiguration turnOnKitchenConfig = new AlexaConfiguration("Turn on the Kitchen light", //
                                                                        new TurnOnLightCommand(kitchen), //
                                                                        "on", "kitchen", "light");

        AlexaConfiguration turnOfKitchenConfig = new AlexaConfiguration("Turn off the Kitchen light", //
                                                                        new TurnOffLightCommand(kitchen), //
                                                                        "off", "kitchen", "light");

        alexa.configureAlexaWithNewIntegrations(Arrays.asList(turnOnLivingRoomConfig, turnOfLivingRoomConfig, turnOnKitchenConfig, turnOfKitchenConfig));

        // Executing the operations with Alexa
        alexa.sendRequest("Turn on the Living room light"); // encontrará pela chave
        alexa.sendRequest("Turn off the Kitchen light"); // encontrará pela chave
        alexa.sendRequest("Alexa, could you turn on the living room light, please?"); // encontrará através da AlexaAI com as palavras chaves.
        alexa.sendRequest("Alexa, turn the light, now!"); // lançará exceção, pois não há informações suficientes para encontrar pela chave ou pela AlexaAI.
    }
}
