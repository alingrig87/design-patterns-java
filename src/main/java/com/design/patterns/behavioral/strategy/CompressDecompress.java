package com.design.patterns.behavioral.strategy;

import java.io.File;

// Strategy interface for compression
interface CompressionStrategy {
    void compressFile(File file);
}

// Strategy interface for decompression
interface DecompressionStrategy {
    void decompressFile(File file);
}

// Compression implementation using Zip tool
class ZipCompressionStrategy implements CompressionStrategy {
    @Override
    public void compressFile(File file) {
        System.out.println("Compressing using ZIP tool: " + file.getName());
        // Specific logic for compression using ZIP tool
    }
}

// Compression implementation using Tar tool
class TarCompressionStrategy implements CompressionStrategy {
    @Override
    public void compressFile(File file) {
        System.out.println("Compressing using TAR tool: " + file.getName());
        // Specific logic for compression using TAR tool
    }
}

// Decompression implementation using Unzip tool
class UnzipDecompressionStrategy implements DecompressionStrategy {
    @Override
    public void decompressFile(File file) {
        System.out.println("Decompressing using Unzip tool: " + file.getName());
        // Specific logic for decompression using Unzip tool
    }
}

// Decompression implementation using Untar tool
class UntarDecompressionStrategy implements DecompressionStrategy {
    @Override
    public void decompressFile(File file) {
        System.out.println("Decompressing using Untar tool: " + file.getName());
        // Specific logic for decompression using Untar tool
    }
}

// Context for compression using a specific strategy
class CompressionContext {
    private CompressionStrategy compressionStrategy;

    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.compressionStrategy = strategy;
    }

    public void compressFile(File file) {
        compressionStrategy.compressFile(file);
    }
}

// Context for decompression using a specific strategy
class DecompressionContext {
    private DecompressionStrategy decompressionStrategy;

    public void setDecompressionStrategy(DecompressionStrategy strategy) {
        this.decompressionStrategy = strategy;
    }

    public void decompressFile(File file) {
        decompressionStrategy.decompressFile(file);
    }
}

// Example usage
 class Main {
    public static void main(String[] args) {
        // Compression using ZIP
        CompressionContext compressionContext = new CompressionContext();
        compressionContext.setCompressionStrategy(new ZipCompressionStrategy());
        compressionContext.compressFile(new File("example.txt"));

        // Compression using TAR
        compressionContext.setCompressionStrategy(new TarCompressionStrategy());
        compressionContext.compressFile(new File("another_example.txt"));

        // Decompression using Unzip
        DecompressionContext decompressionContext = new DecompressionContext();
        decompressionContext.setDecompressionStrategy(new UnzipDecompressionStrategy());
        decompressionContext.decompressFile(new File("example.zip"));

        // Decompression using Untar
        decompressionContext.setDecompressionStrategy(new UntarDecompressionStrategy());
        decompressionContext.decompressFile(new File("another_example.tar"));
    }
}
