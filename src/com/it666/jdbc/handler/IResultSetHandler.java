package com.it666.jdbc.handler;

import java.sql.ResultSet;

public interface IResultSetHandler<T>{
	 T handle(ResultSet rs) throws Exception;
}
