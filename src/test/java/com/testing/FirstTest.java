package com.testing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.junit.Before;

import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;




import java.io.File;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class FirstTest {
    private File file1;
    private File file2;
    private File file3;
    private File file4;


    @Before
    public void setUp() throws Exception {
        file1 = new File("test_file_1");
        file2 = new File("test_file_2");
        file3 = new File("test_file_3");
        file4 = new File("test_file_4");

    }

    @Test
    public void GetMinValue() throws FileNotFoundException {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(Main._min(file1));
        expected.add(Main._min(file2));
        expected.add(Main._min(file3));
        expected.add(Main._min(file4));
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(-234985);
        actual.add(-123413);
        actual.add(-1);
        actual.add(5);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void GetMaxValue() throws FileNotFoundException {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(Main._max(file1));
        expected.add(Main._max(file2));
        expected.add(Main._max(file3));
        expected.add(Main._max(file4));
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(245241);
        actual.add(32343);
        actual.add(-1);
        actual.add(5);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void GetSum() throws FileNotFoundException {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(Main._sum(file1));
        expected.add(Main._sum(file2));
        expected.add(Main._sum(file3));
        expected.add(Main._sum(file4));
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(198741);
        actual.add(-123510);
        actual.add(-2);
        actual.add(15);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void GetMult() throws FileNotFoundException {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(Main._mult(file1));
        expected.add(Main._mult(file2));
        expected.add(Main._mult(file3));
        expected.add(Main._mult(file4));
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(0);
        actual.add(0);
        actual.add(1);
        actual.add(125);

        Assert.assertEquals(expected, actual);

    }


    private Path createFileWithNumbers(int size) throws IOException {
        Path file = Files.createTempFile("largeFile", ".txt");
        Random random = new Random();
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < size; i++) {
            numbers.append(random.nextInt()).append(System.lineSeparator());
        }
        Files.write(file, numbers.toString().getBytes());
        return file;
    }


    @Test
    public void testSpeedOfOperationsWithDifferentFileSizes() throws IOException {
        int[] fileSizes = {100, 1000, 10000, 100000};
        for (int size : fileSizes) {
            Path file = createFileWithNumbers(size);


            long startTime = System.currentTimeMillis();
            Main._min(file.toFile());
            long endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода нахождения минимума в файле размера " + size + ": " + (endTime - startTime) + " миллисекунд");
            assertTrue((endTime - startTime) < 1000);



            startTime = System.currentTimeMillis();
            Main._max(file.toFile());
            endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода нахождения максимума в файле размера " + size + ": " + (endTime - startTime) + " миллисекунд");
            assertTrue((endTime - startTime) < 1000);


            startTime = System.currentTimeMillis();
            Main._sum(file.toFile());
            endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода нахождения суммы в файле размера " + size + ": " + (endTime - startTime) + " миллисекунд");
            assertTrue((endTime - startTime) < 1000);


            startTime = System.currentTimeMillis();
            Main._mult(file.toFile());
            endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода нахождения произведения в файле размера " + size + ": " + (endTime - startTime) + " миллисекунд");
            assertTrue((endTime - startTime) < 1000);

            Files.delete(file);
        }
    }



    private List<Path> createFilesWithNumbers(int numberOfFiles, int sizeOfEachFile) throws IOException {
        List<Path> files = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfFiles; i++) {
            Path file = Files.createTempFile("file" + i, ".txt");
            StringBuilder numbers = new StringBuilder();
            for (int j = 0; j < sizeOfEachFile; j++) {
                numbers.append(random.nextInt()).append(System.lineSeparator());
            }
            Files.write(file, numbers.toString().getBytes());
            files.add(file);
        }
        return files;
    }
    @Test
    public void testSpeedOfOperationsWithDifferentNumberOfFiles() throws IOException {
        int sizeOfEachFile = 1000;
        int[] numberOfFiles = {1, 2, 5, 10, 50};

        for (int filesCount : numberOfFiles) {
            List<Path> files = createFilesWithNumbers(filesCount, sizeOfEachFile);

            long startTime = System.currentTimeMillis();
            for (Path file : files) {

                Main._min(file.toFile());
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода нахождения минимума в " + filesCount +  " файлах: " + (endTime - startTime) + " миллисекунд");
            assertTrue((endTime - startTime) < 1000);



            startTime = System.currentTimeMillis();
            for (Path file : files) {

                Main._max(file.toFile());
            }
            endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода нахождения максимуама в " + filesCount +  " файлах: " + (endTime - startTime) + " миллисекунд");

            assertTrue((endTime - startTime) < 1000);



            startTime = System.currentTimeMillis();
            for (Path file : files) {

                Main._sum(file.toFile());
            }
            endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода нахождения суммы в " + filesCount +  " файлах: " + (endTime - startTime) + " миллисекунд");

            assertTrue((endTime - startTime) < 1000);



            startTime = System.currentTimeMillis();
            for (Path file : files) {

                Main._mult(file.toFile());
            }
            endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода нахождения произведения в " + filesCount +  " файлах: " + (endTime - startTime) + " миллисекунд");

            assertTrue((endTime - startTime) < 1000);

            for (Path file : files) {
                Files.delete(file);
            }
        }

    }

}


