package framework.spring.junit;




import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class AccountDao {

    private SqlSessionFactory sessionFactory;

    public AccountDao() {

    }

    public SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insert(Account account) {

        SqlSession session = sessionFactory.openSession();
        session.insert("am.add", account);
    }

    public Account getAccountById(Account account) {

        SqlSession session = sessionFactory.openSession();
        Account accountFromDb = (Account)session.selectOne("am.get", account);
        return accountFromDb;
    }
}