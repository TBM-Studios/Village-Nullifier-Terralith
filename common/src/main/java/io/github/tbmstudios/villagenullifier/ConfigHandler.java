package io.github.tbmstudios.villagenullifier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConfigHandler {
    private static final String DEFAULT_CONFIG_CONTENT = "{\n" +
            "  \"villageGenerationSettings\": {\n" +
            "    \"generateMinecraftVillages\": false,\n" +
            "    \"generateTerralithVillages\": false,\n" +
            "    \"generateCtovVillages\": false\n" +
            "  }\n" +
            "}";

    public static void createConfigFile(String path) {
        File configFile = new File(path);
        if (!configFile.exists()) {
            try (FileWriter writer = new FileWriter(configFile)) {
                writer.write(DEFAULT_CONFIG_CONTENT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static JsonObject readConfigFile(String path) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            return new Gson().fromJson(content, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}