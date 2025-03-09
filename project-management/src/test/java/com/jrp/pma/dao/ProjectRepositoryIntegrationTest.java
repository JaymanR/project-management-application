package com.jrp.pma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;

import com.jrp.pma.entities.Project;

@SpringBootTest
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:drop.sql",
		"classpath:schema.sql", "classpath:data.sql" }), })
public class ProjectRepositoryIntegrationTest {

	private static final Logger logger = LoggerFactory.getLogger(ProjectRepositoryIntegrationTest.class);

	@Autowired
	ProjectRepository proRepo;

	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New Test Project", "COMPLETE", "TEST DESCRIPTION");
		proRepo.save(newProject);

		logger.info("Total projects before saving: {}", proRepo.findAll().size());

		assertEquals(5, proRepo.findAll().size());
	}
}
