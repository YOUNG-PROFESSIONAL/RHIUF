package rhi.rhiuf.dashboard.bio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BioMockData {
    public static List<Bio> init() throws IOException {
        List<Bio> arrayBio = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("data/bio-init.json").getInputStream();
        BufferedReader reader = new  BufferedReader(new InputStreamReader(inputStream));
        String json = reader.lines().collect(Collectors.joining("\n"));
        reader.close();
        try{
        arrayBio = mapper.readValue(json,new TypeReference<List<Bio>>(){});
        } catch(IOException e){
            System.err.println(e);
        }
        /* Path path = Paths.get("data/bio-init.json");
        List<String> json = Files.readAllLines(path);*/
        return arrayBio;        
    }
}
