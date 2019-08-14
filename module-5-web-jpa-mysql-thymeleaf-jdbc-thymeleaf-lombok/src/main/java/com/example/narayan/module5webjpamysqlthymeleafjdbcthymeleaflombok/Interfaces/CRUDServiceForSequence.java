package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.Interfaces;

public interface CRUDServiceForSequence <KeyDataRype ,  ENTITYTYPE> {
	
	public int GetNextVal( KeyDataRype key ) ;
	
	
	
	public int  IncrementNextVal(KeyDataRype key);
}
