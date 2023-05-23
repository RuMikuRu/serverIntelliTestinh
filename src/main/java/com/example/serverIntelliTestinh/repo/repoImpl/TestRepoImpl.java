package com.example.serverIntelliTestinh.repo.repoImpl;

import com.example.serverIntelliTestinh.model.test.Test;
import com.example.serverIntelliTestinh.repo.TestRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestRepoImpl implements TestRepo {
    private final String db = "C:\\Users\\bkmzo\\IdeaProjects\\serverIntelliTestinh\\src\\main\\resources\\Content\\Content.sys";
    @Override
    public void add(Test newTest) throws IOException {
        String db = new BufferedReader(new FileReader(this.db)).lines().collect(Collectors.joining());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(db);
        ArrayNode jsonArray = (ArrayNode) jsonNode;
        JsonNode testJson = mapper.convertValue(newTest, JsonNode.class);
        jsonArray.add(testJson);
        String updatedJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.db));
        writer.write(updatedJsonString);
        writer.close();
    }

    @Override
    public void update(Test test, int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String db = new BufferedReader(new FileReader(this.db)).lines().collect(Collectors.joining());
        JsonNode jsonNode = mapper.readTree(db);
        ArrayNode jsonArray = (ArrayNode) jsonNode;
        JsonNode testJson = mapper.convertValue(test, JsonNode.class);

        Test[] tests = mapper.readValue(db,Test[].class);
        List<Test> optionalTest = new java.util.ArrayList<>(Arrays.stream(tests).toList());
        int index = 0;
        for(int i=0;i< optionalTest.size();i++){
            if(optionalTest.get(i).getId() == id){
                index = i;
            }
        }
        jsonArray.remove(index);
        jsonArray.add(testJson);
        String updatedJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.db));
        writer.write(updatedJsonString);
        writer.close();
    }

    @Override
    public void delete(int id) throws FileNotFoundException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String db = new BufferedReader(new FileReader(this.db)).lines().collect(Collectors.joining());
        List<Test> jsonArray = mapper.readValue(db, ArrayList.class);
        List<Object> newJsonArray = new ArrayList<>();
        for (Object obj : jsonArray) {
            // Пропускаем элемент, если его id совпадает с тем, который нужно удалить
            if (obj instanceof java.util.Map && ((java.util.Map) obj).get("id") instanceof Integer && (Integer) ((java.util.Map) obj).get("id") == 222) {
                continue;
            }
            newJsonArray.add(obj);
        }

        // Сериализуем новый ArrayList в формат JSON
        String newJson = mapper.writeValueAsString(newJsonArray);

    }
}
