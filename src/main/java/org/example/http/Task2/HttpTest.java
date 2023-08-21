package org.example.http.Task2;
import java.io.*;
import java.io.FileWriter;


public class HttpTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpUtil util = new HttpUtil();
        int postID = 1;
        Object posts = util.getPosts(postID);
        System.out.println(posts);
        System.out.println("------------------");

        int commentID = 10;
        Object comments = util.getComment(commentID);
        System.out.println(comments);

        String fileName = String.format("user-%s-post-%s-comments.json", postID, commentID);
        System.out.println(fileName);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
            printWriter.write(comments.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
