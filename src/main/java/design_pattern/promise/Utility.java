package design_pattern.promise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Utility {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);

    static Map<Character, Integer> characterFrequency(String fileLocation) {
        Map<Character, Integer> characterToFrequency = new HashMap<>();
        try {
            Reader reader = new FileReader(fileLocation);
            BufferedReader bufferedReader = new BufferedReader(reader);
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                for (char c : line.toCharArray()) {
                    if (!characterToFrequency.containsKey(c)) {
                        characterToFrequency.put(c, 1);
                    } else {
                        characterToFrequency.put(c, characterToFrequency.get(c) + 1);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return characterToFrequency;
    }

    static Character lowestFrequencyChar(Map<Character, Integer> characterFrequency) {
        Character lowestFrequencyChar = null;
        Iterator<Map.Entry<Character, Integer>> iterator = characterFrequency.entrySet().iterator();
        Map.Entry<Character, Integer> entry = iterator.next();
        int minFrequency = entry.getValue();

        while (iterator.hasNext()) {
            entry = iterator.next();
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                lowestFrequencyChar = entry.getKey();
            }
        }
        return lowestFrequencyChar;
    }

    static Integer countLines(String fileLocation) {
        int lineCount = 0;
        try {
            FileReader reader = new FileReader(fileLocation);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (bufferedReader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lineCount;
    }

    static String downloadFile(String urlString) throws Exception {
        LOGGER.info("Downloading contents form url: {}", urlString);
        URL url = new URL(urlString);
        File file = File.createTempFile("promise_pattern", null);

        Reader reader = new InputStreamReader(url.openStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        FileWriter writer = new FileWriter(file);
        try {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                writer.write(line);
                writer.write("\n");
            }
        } finally {
            reader.close();
            writer.close();
        }
        LOGGER.info("File downloaded at: {}", file.getAbsolutePath());
        return file.getAbsolutePath();
    }
}
