package com.zeber;

import com.zeber.mapper.EmpMapper;
import com.zeber.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TliasWebManagementApplicationTests {

	@Autowired
	private EmpMapper empMapper;

	@Test
	public void testList(){

	}
}