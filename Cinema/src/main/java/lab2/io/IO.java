package lab2.io;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface IO<T> {

    void toFile(T object, File file) throws IOException, IllegalAccessException;
    T fromFile(File file) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException;

    Class<T> getClassType();
    void setClassType(Class<T> type);

}
