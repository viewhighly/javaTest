package framework.spring.junit;

/**
 * Created with IntelliJ IDEA.
 * User: gaozhan
 * Date: 4/29/14
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */

public class AccountService {

    private AccountDao accountDao;

    /**
     * 新增一个帐户。
     * @param account
     */
    public void insertAccount(Account account) {

        accountDao.insert(account);
    }

    /**
     * 根据帐户ID查找帐户信息
     * @param account
     * @return
     */
    public Account getAccountById(Account account) {

        return accountDao.getAccountById(account);
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}