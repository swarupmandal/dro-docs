package com.drofile.daoImpl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.drofile.Entity.User;
import com.drofile.dao.EmployeeDAO;
import com.drofile.mapper.UserMapper;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllEmployess() {
		return jdbcTemplate.query(
				"select DRO_USER_ID, USER_NAME from DRO_USER ",
				new UserMapper());
	}

	public void insert() {
		jdbcTemplate.update("INSERT INTO dro_section (\n"
				+ "    row_version_nbr,\n" + "    row_last_mod_user_key,\n"
				+ "    is_required,\n" + "    dro_page_id,\n"
				+ "    row_last_mod_proc_name,\n" + "    dro_question_id,\n"
				+ "    row_last_mod_dtts,\n" + "    dro_group_id,\n"
				+ "    row_create_dtts,\n" + "    dro_section_id\n"
				+ ") VALUES (\n" + "    0,\n" + "    0,\n" + "    1,\n"
				+ "    32,\n" + "    'Manual',\n" + "    45,\n"
				+ "    to_timestamp(\n"
				+ "        '2017-07-27 00:00:00.000000000',\n"
				+ "        'YYYY-MM-DD HH24:MI:SS.FF'\n" + "    ),\n"
				+ "    1,\n" + "    to_timestamp(\n"
				+ "        '2017-07-27 00:00:00.000000000',\n"
				+ "        'YYYY-MM-DD HH24:MI:SS.FF'\n" + "    ),35\n" + ")");
	}
}
