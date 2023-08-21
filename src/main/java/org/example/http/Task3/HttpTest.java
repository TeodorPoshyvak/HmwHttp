package org.example.http.Task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HttpTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpUtil httpUtil = new HttpUtil();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Object X = httpUtil.getTaskTrue(1);
        String XJson = X.toString();

        Tasks[] tasksArray = gson.fromJson(XJson, Tasks[].class);
        List<Tasks> listCompleted = Arrays.stream(tasksArray).filter(arr -> arr.isCompleted()).collect(Collectors.toList());

        for (Tasks read : listCompleted) {
            System.out.println(gson.toJson(read));
        }
    }
}