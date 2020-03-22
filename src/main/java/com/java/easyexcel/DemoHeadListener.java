package com.java.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.java.easyexcel.pojo.DemoHead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * author: ws
 * time: 2020/3/22 20:36
 */
public class DemoHeadListener extends AnalysisEventListener<DemoHead> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoHeadListener.class);
    /**
     * 每隔5条存储到数据库，实际使用中可以3000条，然后清理list，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<DemoHead> list = new ArrayList<>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private DemoDAO demoDAO;

    public DemoHeadListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
        demoDAO = new DemoDAO();
    }

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param demoDAO
     */
    public DemoHeadListener(DemoDAO demoDAO) {
        this.demoDAO = demoDAO;
    }

    /**
     * 这个每一条数据解析都会来调用
     * 这里的DemoHead是数据的表头pojo
     * @param demoHead
     * @param analysisContext
     */
    @Override
    public void invoke(DemoHead demoHead, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(demoHead));
        list.add(demoHead);
        if (list.size() >=  BATCH_COUNT) {
            saveData();
            //存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");

    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        demoDAO.save(list);
        LOGGER.info("存储数据库成功！");
    }
}
