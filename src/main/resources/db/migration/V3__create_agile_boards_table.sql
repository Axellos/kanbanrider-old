CREATE TABLE IF NOT EXISTS agile_boards (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    project_id BIGINT NOT NULL,
    name VARCHAR NOT NULL,

    CONSTRAINT fk_project FOREIGN KEY(project_id) REFERENCES projects(id)
);