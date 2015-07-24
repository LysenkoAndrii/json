package task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws Exception {
        String path = "D:\\courses prog kiev ua\\projects\\xml\\json\\task\\json.txt";
        byte[] buf;
        RandomAccessFile f = new RandomAccessFile(path, "r");
        try {
            buf = new byte[(int)f.length()];
            f.read(buf);
        } finally {
            f.close();
        }

        String result = new String(buf);

        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(result, Person.class);

        System.out.print(person.name);
        System.out.print(person.address.city);
    }
}
