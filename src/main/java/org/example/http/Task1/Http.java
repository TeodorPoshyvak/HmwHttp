package org.example.http.Task1;

import java.io.IOException;

public class Http {
    public static void main(String[] args) throws IOException, InterruptedException {
        User user = new User(1, "Teodor", "Bobo", "poshyvak@gmai.com");
        Http_util httpUtil = new Http_util();
        Object o = httpUtil.getAllRequest();
        Object o1 = httpUtil.getIdRequest(1);
        Object o2 = httpUtil.getNameRequest("Delphine");
        Object o3 = httpUtil.deleteRequest(2);
        Object o4 = httpUtil.postRequest(user);
        Object o5 = httpUtil.getIdRequest(11);

        User userUpdate = new User(10, "Teo", "Bobo", "poshyvak@gmai.com");
        Object o6 = httpUtil.putRequest(userUpdate);
        System.out.println(o4);
        System.out.println(o6);


    }
}
