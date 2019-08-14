package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices;

import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.Entity.Sequence;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.lang.Nullable;

public class SequenceDaoService{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	
	public SequenceDaoService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	
	@Nullable
	public int Sequence_1sq_get_Next() {
		
		/****************************
		 * // passing parameters
		 String sql = "select * from person_1sq  where id > :id ";
		 SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
		 int seqId  = namedParameterJdbcTemplate.queryForObject(  sql, namedParameters, Integer.class);
		 
		 ***************************/
		
		//Another way
		
		String sql1 = "select SQ_NEXTVAL from sequence where PERSON_SEQ = :personSeq   ";
		
		int seqId  = namedParameterJdbcTemplate.queryForObject(  sql1, new MapSqlParameterSource().
				addValue( "personSeq" , "PERSON_1SQ" ),Integer.class );
		
		String sql2 = "select * from sequence where PERSON_SEQ = :personSeq   ";
		
		Sequence seqn  = namedParameterJdbcTemplate.queryForObject(  sql2, new MapSqlParameterSource().
				addValue( "personSeq" , "PERSON_1SQ" ), ((rs,i) -> {
				Sequence seq = new Sequence();
				 seq.setPersonSeq( rs.getString("person_seq") );
					
					seq.setSqNextval( rs.getInt("sq_Nextval") );
							return seq;
				}
				));
		String query ="update sequence set SQ_NEXTVAL  = :id where person_seq = :personSeq " ;
		
		
		// Adding params using MapSqlParameterSource class
		SqlParameterSource namedParameters = new MapSqlParameterSource().
				addValue("id",seqn.getSqNextval() + 1) .addValue( "personSeq"  , seqn.getPersonSeq()  );
		
		int status = namedParameterJdbcTemplate.update(query, namedParameters);
		if(status != 0){
			System.out.println("person_1sq data updated for ID " + seqn.getSqNextval() + 1);
		}else{
			System.out.println("No person_1sq found with ID " + seqId);
		}
		
		
		return seqn.getSqNextval();
	}
}
