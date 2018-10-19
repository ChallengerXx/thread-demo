package com.pipeline;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {

    public void writeMethod(PipedOutputStream outputStream) {
        try {
            System.out.println("Write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                outputStream.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            System.out.println("当前线程：" + Thread.currentThread().getName());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
