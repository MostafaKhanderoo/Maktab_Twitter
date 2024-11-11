package repository;

import datasource.Datasource;
import entity.Tag;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TagRepository {

    private static final String INSERT_SQL = """
            INSERT INTO TAGS(title)
            VALUES(?)
            """;
    private static final String DELETE_BY_ID = """
            DELETE FROM TAGS
            WHERE id=?
            """;
    private static final String FIND_BY_ID = """
            SELECT * FROM TAGS
            WHERE id =?
            """;
    private static final String FIND_BY_NAME = """
            SELECT * FROM TAGS
            WHERE title = ?
            """;

    public Tag save(Tag tag) throws SQLException {
        var statement = Datasource.getConnection().prepareStatement(INSERT_SQL);
        statement.setString(1, tag.getTitle());
        statement.execute();
        statement.close();
        return tag;
    }

    public void deleteById(int id) throws SQLException {
        try (var statement = Datasource.getConnection().prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, id);
            var affectedRows = statement.executeUpdate();
            System.out.println("Account delete: " + affectedRows);
        }

    }

    public Tag findById(int id) throws SQLException {
        try (var statement = Datasource.getConnection().prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            Tag tag = null;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long tagId = resultSet.getLong(1);
                String title = resultSet.getString(2);
                tag = new Tag(tagId, title);
            }
            return tag;
        }
    }

    public Tag findByName(String name) throws SQLException {
        try (var statement = Datasource.getConnection().prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            Tag tag = null;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long tagId = resultSet.getLong(1);
                String title = resultSet.getString(2);
                tag = new Tag(tagId, title);
            }
            return tag;
        }

    }

}
