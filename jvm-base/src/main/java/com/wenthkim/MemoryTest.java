package com.wenthkim;

public class MemoryTest {


    public static void main(String[] args) throws InterruptedException {

        while (true) {
            User user = new User();
            user.setName("wenthkim");
            user.setAge(1000);

            Thread.sleep(50);
        }

    }

}
