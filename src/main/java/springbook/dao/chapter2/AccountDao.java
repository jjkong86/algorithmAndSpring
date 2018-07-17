package springbook.dao.chapter2;

public class AccountDao {

	private ConnectionMaker connectionMaker;

	public AccountDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

}
