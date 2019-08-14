package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.Interfaces;

import java.util.List;

public interface CRUDServices <ENTITYCLASS , IDTYPE> {
	
	public ENTITYCLASS selectARow( IDTYPE  id );
	
	public List <ENTITYCLASS> selectMultipleRows (ENTITYCLASS  row );
	
	int insertARow ( ENTITYCLASS  row);
	
	int deleteARowById (IDTYPE  id );
	
	
	int deleteARow ( ENTITYCLASS  row);
	
	int updateARowdata(ENTITYCLASS  row);
	
	
}
