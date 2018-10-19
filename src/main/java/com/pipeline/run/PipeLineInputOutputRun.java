package com.pipeline.run;

import com.pipeline.ReadData;
import com.pipeline.WriteData;
import com.pipeline.thread.ReadThread;
import com.pipeline.thread.WriteThread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeLineInputOutputRun {

    public static void main(String[] args) {

        try {
            ReadData readData = new ReadData();
            WriteData writeData = new WriteData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            //使两个管道流产生链接
//            inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            ReadThread thread1 = new ReadThread(readData, inputStream);
            thread1.start();

            Thread.sleep(2000);

            WriteThread thread2 = new WriteThread(writeData, outputStream);
            thread2.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
