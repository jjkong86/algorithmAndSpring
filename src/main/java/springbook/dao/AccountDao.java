package springbook.dao;

public class AccountDao {

	private ConnectionMaker connectionMaker;

	public AccountDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

}
