package br.com.cod3r.command.alexa.alexa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class AlexaAI {

    private Map<String, String[]> associationsMap;

    protected AlexaAI() {
        this.associationsMap = new HashMap<>();
    }

    protected void addAssociation(String key, String... keywords) {
        associationsMap.put(key, keywords);
    }

    public Optional<String> getKeyInAssociationByRequest(String request) {
        if(associationsMap.isEmpty()) {
            return Optional.empty();
        }

        Optional<String> command = Optional.empty();

        for(String[] keywords : associationsMap.values()) {
            if (Arrays.stream(keywords).allMatch(request.toLowerCase()::contains)) {
                command = getKeyByKeywords(keywords);
            }
        }

        return command;
    }

    private Optional<String> getKeyByKeywords(String... keywords) {
        return associationsMap.
                entrySet()
                .stream()
                .filter(association -> Arrays.equals(association.getValue(), keywords))
                .map(Map.Entry::getKey)
                .findFirst();
    }


}
