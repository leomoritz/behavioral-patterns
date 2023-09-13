package br.com.cod3r.command.alexa.command;

import java.util.logging.Logger;

public interface Command {
    Logger logger = Logger.getLogger("CommandLogger");
    void execute();

}
