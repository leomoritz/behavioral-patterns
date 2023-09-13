package br.com.cod3r.command.alexa.command;

import java.util.logging.Logger;

import br.com.cod3r.command.alexa.command.exception.CommandException;
import br.com.cod3r.command.alexa.lights.GenericLight;

public class TurnOffLightCommand implements Command {

    private GenericLight light;

    public TurnOffLightCommand(GenericLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        if (light == null) {
            throw new CommandException("Cannot turn off the light because the hue light type is required!");
        }
        logger.fine("Turning off the light as requested");
        light.turnOff();
    }

    public GenericLight getLight() {
        return light;
    }

    public void setLight(GenericLight light) {
        this.light = light;
    }
}
