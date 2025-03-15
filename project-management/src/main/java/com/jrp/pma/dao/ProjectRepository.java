package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.TimeChartData;
import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	public List<Project> findAll();

	@Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as stageCount" + " FROM project"
			+ " GROUP BY stage")
	public List<ChartData> getProjectStatus();

	@Query(nativeQuery = true, value = "SELECT name as projectName, start_date as startDate, end_date as endDate FROM project WHERE start_date IS NOT NULL AND end_date IS NOT NULL")
	public List<TimeChartData> getTimeData();
}
