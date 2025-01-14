package co.edu.uco.businesslogic.business.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.businesslogic.business.IdTypeBusiness;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeBusinessImpl implements IdTypeBusiness{
	
	private DAOFactory daoFactory;
	
	public IdTypeBusinessImpl(DAOFactory daoFactory) {
		if (UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException("It's not possible create a IdTypeBusinessImpl when the DAOFactory is null");
		}
		this.daoFactory = daoFactory;
	}

	
	@Override
	public void create(IdTypeDTO dto) {
		validateIdTypeDoesNotExistWhithSameName(dto);
		daoFactory.getIdTypeDAO().create(dto);
	}
	
	
	@Override
	public void validateIdTypeDoesNotExistWhithSameName(IdTypeDTO dto) {
		
		
		IdTypeDTO dtoValidator = new IdTypeDTO();
		dtoValidator.setName(dto.getName());
		
		List<IdTypeDTO> list =  daoFactory.getIdTypeDAO().find(dtoValidator);
		
		if (!list.isEmpty()) {
			var message = "An Id Type With the same name alredy Exist!";
		}
			throw GradesException.buildBusinessLogicException(null);
		}
		

	@Override
	public void update(IdTypeDTO dto) {
		daoFactory.getIdTypeDAO().update(dto);
	}

	@Override
	public void delete(int id) {
		daoFactory.getIdTypeDAO().delete(id);
		
	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO dto) {
		return daoFactory.getIdTypeDAO().find(dto);
	}

}
