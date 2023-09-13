package br.com.cod3r.command.alexa.command;

import br.com.cod3r.command.alexa.command.exception.CommandException;
import br.com.cod3r.command.alexa.lights.GenericLight;

public class TurnOnLightCommand implements Command {

    private GenericLight light;

    public TurnOnLightCommand(GenericLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        if (light == null) {
            throw new CommandException("Cannot turn on the light because the hue light type is required!");
        }
        logger.fine("Turning on the light as requested");
        light.turnOn();
    }

    public GenericLight getLight() {
        return light;
    }

    public void setLight(GenericLight light) {
        this.light = light;
    }
}
