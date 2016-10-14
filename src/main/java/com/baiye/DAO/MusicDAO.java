package com.baiye.DAO;

import com.baiye.DB.DBConf;
import com.baiye.DB.SQL;
import com.baiye.entity.Music;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Baiye on 2016/10/11.
 */
public class MusicDAO {

    private Logger logger = LoggerFactory.getLogger(MusicDAO.class);

    private Connection conn;

    private QueryRunner queryRunner;

    private ArrayHandler arrayHandler;

    private MapHandler mapHandler;

    private BeanListHandler<Music> beanListHandler;


    public MusicDAO() {
        init();
    }

    public List<Music> getDataByCountAndStart(Integer start,Integer count)
    {
        List<Music> result = null;
        QueryRunner qr = getQueryRunner();
        Connection conn = getConnection();
        Object[] params = {start,start + count};
        try {
            result = qr.query(conn, SQL.MUSIC_SHOW_DATA_BY_COUNT_START,params,getBeanListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Connection getConnection()
    {
        if(conn != null)
            return conn;
        try {
            Class.forName(DBConf.readValue(DBConf.DATABASE_DRIVERNAME));
            conn = DriverManager.getConnection(DBConf.readValue(DBConf.DATABASE_URL),
                    DBConf.readValue(DBConf.DATABASE_USERNAME),
                    DBConf.readValue(DBConf.DATABASE_PASSWORD));

            return conn;
        } catch (ClassNotFoundException e) {
            logger.error("未找到数据库驱动：" + e.getMessage());
        } catch (SQLException e) {
            logger.error("获取数据库连接失败：" + e.getMessage());
        }
        return null;
    }


    private void init()
    {
        getConnection();
        getQueryRunner();
        getArrayHandler();
        getMapHandler();
    }

    private QueryRunner getQueryRunner() {
        if(queryRunner != null)
            return queryRunner;
        queryRunner = new QueryRunner();
        return queryRunner;
    }

    private ArrayHandler getArrayHandler() {
        if(arrayHandler != null)
            return arrayHandler;
        arrayHandler = new ArrayHandler();
        return arrayHandler;
    }

    private MapHandler getMapHandler() {
        if(mapHandler != null)
            return mapHandler;
        mapHandler = new MapHandler();
        return mapHandler;
    }

    private BeanListHandler<Music> getBeanListHandler() {
        if(beanListHandler != null)
            return beanListHandler;
        beanListHandler = new BeanListHandler<Music>(Music.class);
        return beanListHandler;
    }
}
