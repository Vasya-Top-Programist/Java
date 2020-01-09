package lab2.io;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;


public class XmlIO<T> implements IO<T> {

    private Class<T> classType;


    public XmlIO(Class<T> type) {
        this.classType = type;
    }

    @Override
    public Class<T> getClassType() {
        return this.classType;
    }

    @Override
    public void setClassType(Class<T> type) {
        this.classType = type;
    }

    @Override
    public void toFile(T object, File file) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(file, object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T fromFile(File file) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(file, classType);
    }

}
