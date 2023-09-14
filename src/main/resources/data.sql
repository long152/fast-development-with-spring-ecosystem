INSERT INTO book
(id, title, publication_date)
VALUES
    (1, 'Refactoring: Improving the Design of Existing Code', '1999-01-01'),
    (2, 'Patterns of Enterprise Application Architecture', '2022-11-05'),
    (3, 'Domain-Specific Languages', '2010-09-23'),
    (4, 'Test-Driven Development', '2000-01-01'),
    (5, 'Extreme Programming Explained', '1999-01-01'),
    (6, 'Implementation Patterns', '2007-10-23');

INSERT INTO author
(id, first_name, last_name, birthday)
VALUES
    (1, 'Martin', 'Fowler', '1963-12-18'),
    (2, 'Kent', 'Beck', '1961-03-31');

INSERT INTO authors_books
(author_id, book_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 4),
    (2, 5),
    (2, 6);