package com.hb.test.serialized;

import com.hb.test.common.StringUtil;
import com.hb.test.serialized.model.InfoFile;
import com.hb.test.serialized.model.PBAInformation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 对象的序列化和反序列化的测试
 */
public class SerializedObjectTest {
    public static void main(String[] args) throws Exception {
        writeCompObject();
        readCompObject();
    }

    public static File tmpFile = new File("D:/workspace/tmp/a.obj");

    /**
     * 反序列化符合对象
     * @return
     * @throws Exception
     */
    public static PBAInformation readCompObject() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(tmpFile));
        PBAInformation obj = (PBAInformation)in.readObject();
        System.out.println(obj);
        in.close();

        return obj;
    }

    /**
     * 符合对象序列化
     * @return
     * @throws Exception
     */
    public static PBAInformation writeCompObject() throws Exception {
        PBAInformation pbaInformation = pbaInformation();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tmpFile));
        out.writeObject(pbaInformation);
        out.flush();
        out.close();

        return pbaInformation;
    }

    public static void simpleObjectEquale() throws Exception {
        System.out.println(writeSimpleObject() == readSimpleObject());
    }

    public static InfoFile readSimpleObject() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(tmpFile));
        InfoFile infoFile = (InfoFile)in.readObject();
        System.out.println(infoFile);
        in.close();

        return infoFile;
    }

    public static InfoFile writeSimpleObject() throws Exception {
        InfoFile infoFile = infoFile();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tmpFile));
        out.writeObject(infoFile);
        out.flush();
        out.close();

        return infoFile;
    }

    public static PBAInformation pbaInformation(){
        PBAInformation pbaInformation = new PBAInformation();

        pbaInformation.setId("123");
        pbaInformation.setToolFrom(true);
        pbaInformation.setToolPrice(15.5f);
        pbaInformation.setPrice(12.8f);
        pbaInformation.setFiles(infoFileList());
        pbaInformation.setPic(infoFile());

        return pbaInformation;
    }

    public static List<InfoFile> infoFileList(){
        List<InfoFile> fs = new ArrayList<>();

        fs.add(infoFile());
        fs.add(infoFile());
        fs.add(infoFile());

        return fs;
    }


    public static InfoFile infoFile(){
        InfoFile infoFile = new InfoFile();
        infoFile.setId((int)(Math.random() * 10000));
        infoFile.setName(StringUtil.randomStr());
        infoFile.setSaveUrl("http://" + StringUtil.randomStr());
        infoFile.setSize(12000L);
        infoFile.setCreateTime(new Date());
        return infoFile;
    }

}
