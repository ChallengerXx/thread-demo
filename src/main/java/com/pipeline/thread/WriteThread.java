package com.pipeline.thread;

import com.pipeline.WriteData;

import java.io.PipedOutputStream;

public class WriteThread extends Thread {

    private WriteData writeData;
    private PipedOutputStream outputStream;

    public WriteThread(WriteData writeData, PipedOutputStream outputStream) {
        super();
        this.writeData = writeData;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(outputStream);
    }
}
