-- Inserir dados na tabela salary
INSERT INTO salary (amount, payment_date) VALUES (5000, '2024-09-24');
INSERT INTO salary (amount, payment_date) VALUES (3000, '2024-09-25');
INSERT INTO salary (amount, payment_date) VALUES (4500, '2024-09-26');

-- Inserir dados na tabela distribution
INSERT INTO distribution (salary_id, category, amount) VALUES (1, 'Essential Costs', 2750.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (1, 'Education', 250.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (1, 'Free', 500.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (1, 'Retirement', 500.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (1, 'Future Goals', 1000.0);

INSERT INTO distribution (salary_id, category, amount) VALUES (2, 'Essential Costs', 1650.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (2, 'Education', 150.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (2, 'Free', 300.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (2, 'Retirement', 300.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (2, 'Future Goals', 600.0);

INSERT INTO distribution (salary_id, category, amount) VALUES (3, 'Essential Costs', 2475.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (3, 'Education', 225.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (3, 'Free', 450.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (3, 'Retirement', 450.0);
INSERT INTO distribution (salary_id, category, amount) VALUES (3, 'Future Goals', 900.0);
