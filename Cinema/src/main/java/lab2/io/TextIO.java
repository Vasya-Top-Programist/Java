package lab2.io;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TextIO<T> implements IO<T> {

    private static final String FIELD_LIMITER = " ";

    private Class<T> classType;

    public TextIO(Class<T> classType) {
        this.classType = classType;
    }

    @Override
    public void toFile(T object, File file) throws IOException, IllegalAccessException {
        FileWriter fileWriter = new FileWriter(file);

        StringBuilder stringBuilder = new StringBuilder();

        Field[] fields = classType.getDeclaredFields();

        for(Field field: fields) {
            if(!field.canAccess(object)) {
                field.setAccessible(true);
                stringBuilder.append(field.get(object)).append(FIELD_LIMITER);
                field.setAccessible(false);
            }
            else {
                stringBuilder.append(field.get(object)).append(FIELD_LIMITER);
            }
        }

        stringBuilder.replace(stringBuilder.lastIndexOf(FIELD_LIMITER),
                stringBuilder.length(), "");

        fileWriter.write(stringBuilder.toString());
        fileWriter.close();

    }

    @Override
    public T fromFile(File file) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException, IOException {


        InputStream is = new FileInputStream(file);
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String currentLine;
        StringBuilder str = new StringBuilder();

        while((currentLine = bf.readLine()) != null) {
            str.append(currentLine);
        }


        return classType.getConstructor(String.class, String.class)
                .newInstance(str.toString(), FIELD_LIMITER);

    }

    @Override
    public Class<T> getClassType() {
        return classType;
    }

    @Override
    public void setClassType(Class<T> classType) {
        this.classType = classType;
    }
}
