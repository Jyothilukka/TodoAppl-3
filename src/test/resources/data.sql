INSERT INTO todolist (todo, priority, status)
SELECT 'Watch Movie',
    'LOW',
    'TO DO'
WHERE NOT EXISTS (
        SELECT 1
        FROM todolist
        WHERE id = 1
    );
INSERT INTO todolist (todo, priority, status)
SELECT 'Finish Project',
    'HIGH',
    'IN PROGRESS'
WHERE NOT EXISTS (
        SELECT 2
        FROM todolist
        WHERE id = 2
    );
INSERT INTO todolist (todo, priority, status)
SELECT 'Buy Groceries',
    'MEDIUM',
    'TO DO'
WHERE NOT EXISTS (
        SELECT 3
        FROM todolist
        WHERE id = 3
    );
INSERT INTO todolist (todo, priority, status)
SELECT 'Learning from NxtWave',
    'HIGH',
    'IN PROGRESS'
WHERE NOT EXISTS (
        SELECT 4
        FROM todolist
        WHERE id = 4
    );
INSERT INTO todolist (todo, priority, status)
SELECT 'Go for a Run',
    'MEDIUM',
    'DONE'
WHERE NOT EXISTS (
        SELECT 5
        FROM todolist
        WHERE id = 5
    );