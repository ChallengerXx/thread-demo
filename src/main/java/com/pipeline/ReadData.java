package com.pipeline;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {

    public void readMethod(PipedInputStream inputStream) {
        try {
            System.out.println("Read :");
            byte[] byteArray = new byte[20];
            int readLenth = inputStream.read(byteArray);
            while (readLenth != -1) {
                String newData = new String(byteArray, 0, readLenth);
                System.out.print(newData);
                readLenth = inputStream.read(byteArray);
            }
            System.out.println();
            System.out.println("当前线程：" + Thread.currentThread().getName());
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
