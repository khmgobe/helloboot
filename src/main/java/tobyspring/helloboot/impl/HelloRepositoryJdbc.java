package tobyspring.helloboot.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tobyspring.helloboot.domain.Hello;
import tobyspring.helloboot.repository.HelloRepository;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hello findHello(String name) {

        try {
            return jdbcTemplate.queryForObject("select * from hello where name = '" + name + "'",
                    (rs, rowNum) -> new Hello(
                            rs.getString("name"), rs.getInt("count")));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);

        if(hello == null) {
            jdbcTemplate.update("insert into hello values(?,?)", name, 1);
        } else {
            jdbcTemplate.update("update hello set count = ? where name = ?", hello.getCount() + 1, name);
        }
    }
}
