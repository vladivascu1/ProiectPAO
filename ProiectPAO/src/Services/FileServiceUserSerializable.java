package Services;

import java.io.*;

public class FileServiceUserSerializable {
    private static FileServiceUserSerializable ourInstance = new FileServiceUserSerializable();

    public static FileServiceUserSerializable getInstance() {
        return ourInstance;
    }

    private FileServiceUserSerializable() {
    }


    public Object CitesteObiectFisier(String CaleFisier) {
        Object object = null;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(CaleFisier));

            object = objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }


    public void ScrieObiectFisier(Object object, String CaleFisier) {


        try {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(CaleFisier));
            objectOutputStream.writeObject(object);

            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
