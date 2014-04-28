package framework.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * User: gaozhan
 * Date: 1/16/14
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class DBAccessor {

        public final static SqlSessionFactory sqlSessionFactory = init();

        private static SqlSessionFactory init() {
            String dataSourceConfiguration = "mytest/framework/mybatis/config/MyBatisConfiguration.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(dataSourceConfiguration);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
            return new SqlSessionFactoryBuilder().build(inputStream);
        }



}
