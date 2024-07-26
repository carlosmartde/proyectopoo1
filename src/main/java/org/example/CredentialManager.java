package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CredentialManager {
    private Map<String, String> credentials;
    public CredentialManager(String filename) {
        credentials = loadCredentials(filename);
    }

    private Map<String, String> loadCredentials(String filename) {
        Map<String, String> credentials = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    credentials.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }

    public boolean validateLogin(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}
