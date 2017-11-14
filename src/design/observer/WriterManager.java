package design.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者管理器，单例
 * Created by Mcl on 2017/11/13.
 */
public class WriterManager {

    private Map<String, Writer> writerMap = new HashMap<String, Writer>();

    /**
     * 添加作者
     *
     * @param writer
     */
    public void add(Writer writer) {
        writerMap.put(writer.getName(), writer);
    }

    /**
     * 根据作者姓名获取作者
     *
     * @param name
     * @return
     */
    public Writer getWriterByName(String name) {
        return writerMap.get(name);
    }

    /**
     * 获取WriterManager的唯一实例
     * @return
     */
    public static WriterManager getInstance() {
        return WriterManagerInstance.instance;
    }

    /**
     * 单例
     */

    private WriterManager() {
    }

    private static class WriterManagerInstance {
        private static WriterManager instance = new WriterManager();
    }


}
