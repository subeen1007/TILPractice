package com.example.study.concurrent;

import java.nio.file.Path;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDirSize extends RecursiveTask<Long> {
    private final Path path;

    public ForkJoinDirSize(Path path){
        this.path = path;
    }

    @Override
    protected Long compute() {
        return null;
    }
}
