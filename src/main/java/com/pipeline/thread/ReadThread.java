package com.pipeline.thread;

import com.pipeline.ReadData;

import java.io.PipedInputStream;

public class ReadThread extends Thread {

    private ReadData readData;
    private PipedInputStream inputStream;

    public ReadThread(ReadData readData, PipedInputStream inputStream) {
        super();
        this.readData = readData;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        readData.readMethod(inputStream);
    }
}
