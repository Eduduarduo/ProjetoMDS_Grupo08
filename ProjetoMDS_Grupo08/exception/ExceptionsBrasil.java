package exception;

import java.sql.SQLException;
import dao.BrasilDao;

public class ExceptionsBrasil {

	BrasilDao brasilDao;
	
	public ExceptionsBrasil(){
		
	}

	// Usada para comparação do parametro ano para Brasil
	public boolean verificaParamentroAno(int ano) throws SQLException {
		brasilDao = new BrasilDao();
		for (int i = 0; i < brasilDao.getDatas().size(); i++) {
			if ((brasilDao.getDatas().get(i).getAno()) == ano)
				return true;
		}
		return false;
	}

		}
