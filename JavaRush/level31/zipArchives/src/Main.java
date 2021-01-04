import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "/home/ars/JavaProjects/Java_my_edu/JavaRush/secretPasswords.txt";
        Path fileToAdd = Paths.get(fileName);
        String toCheck = "result/" + fileToAdd.getFileName().toString();
        String archive = "/home/ars/JavaProjects/Java_my_edu/JavaRush/root.zip";
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(archive)));
        Map<String, ByteArrayOutputStream> map = new TreeMap<>();
        ZipEntry entry;
        String name;
        long size;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            name = entry.getName();
            size=entry.getSize();  // получим его размер в байтах
            System.out.printf("File name: %s \t File size: %d \n", name, size);
            if (!entry.isDirectory()){
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
                byte[] buffer = new byte[2048];
                int len;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, len);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                map.put(name,byteArrayOutputStream);
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();

        if (map.containsKey(toCheck)) map.remove(toCheck);
        //zipInputStream.close();
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(archive)));
        ZipEntry newFile = new ZipEntry(toCheck);
        BufferedInputStream fileToAddInputStream = new BufferedInputStream(new FileInputStream(fileName));
        zipOutputStream.putNextEntry(newFile);
        byte[] buffer = new byte[2048];
        int len;
        while ((len = fileToAddInputStream.read(buffer)) > 0) {
            zipOutputStream.write(buffer, 0, len);
        }
        fileToAddInputStream.close();
        zipOutputStream.closeEntry();
        for (String path : map.keySet()) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(map.get(path).toByteArray()));
            ZipEntry file = new ZipEntry(path);
            zipOutputStream.putNextEntry(file);
            while ((len = bufferedInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }
            zipOutputStream.flush();
            zipOutputStream.closeEntry();
            bufferedInputStream.close();
        }
        zipOutputStream.close();

    }
}
