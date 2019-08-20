package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices;

import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.Entity.Sequence;
import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.Interfaces.CRUDServiceForSequence;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Sequence1SqDAOImplimentation implements CRUDServiceForSequence <String , Sequence> {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	
	public Sequence1SqDAOImplimentation(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	public Sequence1SqDAOImplimentation() {
	
	}
	
	@Override
	public int GetNextVal(String key) {
		
		return getSequence(  key).getSqNextval();
	}
	
	
	@Override
	@Transactional(rollbackFor = InvalidSequenceException.class)
	public int IncrementNextVal(String key) {
		
		String query ="update sequence set SQ_NEXTVAL  = :id where person_seq = :personSeq " ;
		
		Sequence seqn = getSequence(key);
		
		// Adding params using MapSqlParameterSource class
		SqlParameterSource namedParameters = new MapSqlParameterSource().
				addValue("id",seqn.getSqNextval() + 1) .addValue( "personSeq"  , seqn.getPersonSeq()  );
		
		int status = namedParameterJdbcTemplate.update(query, namedParameters);
		
		return  status == 1 ? 1: 0;
	}
	
	
	private Sequence getSequence( String key) {
		
		//Another way
		String sql2 = "select * from sequence where PERSON_SEQ = :personSeq ";
		
		Sequence seqn  = namedParameterJdbcTemplate.queryForObject(  sql2, new MapSqlParameterSource().
				addValue( "personSeq" , key ), ((rs,i) -> {
			Sequence seq = new Sequence();
			seq.setPersonSeq( rs.getString("person_seq") );
			
			seq.setSqNextval( rs.getInt("sq_Nextval") );
			return seq;
		}
		));
		return seqn;
	}
	
	
	
	public int getNextSequence() {
		
		int seqId2 = GetNextVal( "PERSON_1SQ" );
		int stat = IncrementNextVal( "PERSON_1SQ" );
		
		return  seqId2   ;
	}
}
