-- Criação da base de dados
DROP DATABASE IF EXISTS LibraryDB;
CREATE DATABASE IF NOT EXISTS LibraryDB;
USE LibraryDB;

-- Criação da tabela Livro
CREATE TABLE IF NOT EXISTS Livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ISBN VARCHAR(13),
    categoria VARCHAR(100),
    copia INT NOT NULL,
    status VARCHAR(100)
);

-- Criação da tabela Usuario
CREATE TABLE IF NOT EXISTS Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    CPF VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    permissao VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Criação da tabela Emprestimo
CREATE TABLE IF NOT EXISTS Emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    livro_id INT NOT NULL,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (livro_id) REFERENCES Livro(id),
    CONSTRAINT unico_emprestimo UNIQUE (livro_id, dataDevolucao)
);

-- Inserção de dados de exemplo
INSERT INTO Livro (titulo, autor, ISBN, categoria, copia, status)
VALUES
('O Senhor dos Anéis', 'J.R.R. Tolkien', '9780007525546', 'Fantasia', 1, 'disponível'),
('Harry Potter e a Pedra Filosofal', 'J.K. Rowling', '9780439554930', 'Fantasia', 1, 'emprestado'),
('Harry Potter e a Pedra Filosofal', 'J.K. Rowling', '9780439554930', 'Fantasia', 2, 'disponivel'),
('Harry Potter e a Pedra Filosofal', 'J.K. Rowling', '9780439554930', 'Fantasia', 3, 'emprestado'),
('1984', 'George Orwell', '9780451524935', 'Distopia', 1, 'disponível'),
('1984', 'George Orwell', '9780451524935', 'Distopia', 2, 'emprestado'),
('A Revolução dos Bichos', 'George Orwell', '9780451526342', 'Satira', 1, 'disponível'),
('O Apanhador no Campo de Centeio', 'J.D. Salinger', '9780316769488', 'Ficção', 1, 'emprestado'),
('Moby Dick', 'Herman Melville', '9780142437247', 'Aventura', 1, 'disponível'),
('Dom Quixote', 'Miguel de Cervantes', '9780060934347', 'Clássico', 1, 'emprestado'),
('O Grande Gatsby', 'F. Scott Fitzgerald', '9780743273565', 'Ficção', 1, 'disponível'),
('Cem Anos de Solidão', 'Gabriel Garcia Marquez', '9780060883287', 'Realismo Mágico', 1, 'disponível'),
('Cem Anos de Solidão', 'Gabriel Garcia Marquez', '9780060883287', 'Realismo Mágico', 2, 'disponível'),
('A Divina Comédia', 'Dante Alighieri', '9780142437223', 'Poema', 1, 'disponível'),
('Orgulho e Preconceito', 'Jane Austen', '9780141439518', 'Romance', 1, 'disponível'),
('Guerra e Paz', 'Liev Tolstói', '9780199232765', 'Histórico', 1, 'disponível'),
('Crime e Castigo', 'Fiódor Dostoiévski', '9780143058144', 'Ficção', 1, 'disponível');

INSERT INTO Usuario (nome, CPF, email, telefone, endereco, permissao, senha)
VALUES
('João Silva', '12345678901', 'joao.silva@example.com', '21987654321', 'Rua A, 123', 'Bibliotecario', '202cb962ac59075b964b07152d234b70'),
('Maria Oliveira', '10987654321', 'maria.oliveira@example.com', '21987654322', 'Rua B, 456', 'Usuario', '202cb962ac59075b964b07152d234b70'),
('Pedro Santos', '22345678901', 'pedro.santos@example.com', '21987654323', 'Rua C, 789', 'Bibliotecario', '202cb962ac59075b964b07152d234b70'),
('Ana Souza', '33345678901', 'ana.souza@example.com', '21987654324', 'Rua D, 101', 'Bibliotecario', '202cb962ac59075b964b07152d234b70'),
('Carlos Lima', '44345678901', 'carlos.lima@example.com', '21987654325', 'Rua E, 202', 'Usuario', '202cb962ac59075b964b07152d234b70'),
('Fernanda Pereira', '55345678901', 'fernanda.pereira@example.com', '21987654326', 'Rua F, 303', 'Usuario', '202cb962ac59075b964b07152d234b70'),
('Gustavo Almeida', '66345678901', 'gustavo.almeida@example.com', '21987654327', 'Rua G, 404', 'Usuario', '202cb962ac59075b964b07152d234b70'),
('Isabela Costa', '77345678901', 'isabela.costa@example.com', '21987654328', 'Rua H, 505', 'Usuario', '202cb962ac59075b964b07152d234b70'),
('Lucas Ferreira', '88345678901', 'lucas.ferreira@example.com', '21987654329', 'Rua I, 606', 'Usuario', '202cb962ac59075b964b07152d234b70'),
('Mariana Rocha', '99345678901', 'mariana.rocha@example.com', '21987654330', 'Rua J, 707', 'Usuario', '202cb962ac59075b964b07152d234b70');

INSERT INTO Emprestimo (usuario_id, livro_id, dataEmprestimo, dataDevolucao)
VALUES 
(2, 2, '2024-07-05', DATE_ADD('2024-07-01', INTERVAL 14 DAY)),
(5, 6, '2024-07-05', DATE_ADD('2024-07-02', INTERVAL 14 DAY)),
(6, 8, '2024-07-05', DATE_ADD('2024-07-03', INTERVAL 14 DAY)),
(7, 10, '2024-07-05', DATE_ADD('2024-07-04', INTERVAL 14 DAY)),
(8, 12, '2024-07-05', DATE_ADD('2024-07-05', INTERVAL 14 DAY));


