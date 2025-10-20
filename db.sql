
INSERT INTO category (name, description) VALUES
('Flour', 'All kinds of baking flour such as wheat, rice, and almond flour'),
('Sugar', 'Various types of sugar used for baking and decoration'),
('Dairy', 'Butter, milk, cheese, and other dairy-based ingredients'),
('Flavoring', 'Extracts, essences, and spices for enhancing flavor'),
('Decoration', 'Sprinkles, chocolate chips, and other topping ingredients');


INSERT INTO brand (name, description) VALUES
('King Arthur', 'Premium baking flour and ingredients from the USA'),
('Bob’s Red Mill', 'Natural and organic baking ingredients'),
('Anchor', 'High-quality dairy products from New Zealand'),
('McCormick', 'Trusted brand for spices and flavor extracts'),
('Hershey’s', 'Famous for chocolate and confectionery ingredients');


INSERT INTO unit (name, description) VALUES
('gram', 'Weight in grams'),
('kilogram', 'Weight in kilograms'),
('liter', 'Volume in liters'),
('piece', 'Single item or piece'),
('pack', 'Package of multiple items');


INSERT INTO product 
(name, description, price, discount, stock, unit_price, vote, created_at, updated_at, brand_id, category_id, unit_id) VALUES
('All-purpose Flour', 'High quality all-purpose flour', 25.0, 0, 100, 25.0, 4.5, NOW(), NOW(), 1, 1, 2),       -- kg
('Whole Wheat Flour', 'Rich in fiber whole wheat flour', 30.0, 0, 80, 30.0, 4.2, NOW(), NOW(), 1, 1, 2),          -- kg
('Almond Flour', 'Gluten-free almond flour', 50.0, 0, 50, 50.0, 4.8, NOW(), NOW(), 2, 1, 2),                     -- kg
('Granulated Sugar', 'Fine granulated sugar', 15.0, 0, 200, 15.0, 4.0, NOW(), NOW(), 2, 2, 2),                    -- kg
('Brown Sugar', 'Rich flavored brown sugar', 18.0, 0, 150, 18.0, 4.1, NOW(), NOW(), 2, 2, 2),                     -- kg
('Butter', 'Creamy unsalted butter', 60.0, 0, 100, 60.0, 4.7, NOW(), NOW(), 3, 3, 1),                              -- gram
('Milk', 'Fresh whole milk', 20.0, 0, 120, 20.0, 4.3, NOW(), NOW(), 3, 3, 3),                                     -- liter
('Cheddar Cheese', 'Aged cheddar cheese', 80.0, 0, 60, 80.0, 4.6, NOW(), NOW(), 3, 3, 1),                         -- gram
('Vanilla Extract', 'Pure vanilla extract', 35.0, 0, 90, 35.0, 4.9, NOW(), NOW(), 4, 4, 3),                        -- liter
('Almond Extract', 'Natural almond extract', 38.0, 0, 70, 38.0, 4.5, NOW(), NOW(), 4, 4, 3),                        -- liter
('Chocolate Chips', 'Semi-sweet chocolate chips', 40.0, 0, 150, 40.0, 4.4, NOW(), NOW(), 5, 5, 1),                  -- gram
('Sprinkles', 'Colorful cake sprinkles', 12.0, 0, 180, 12.0, 4.2, NOW(), NOW(), 5, 5, 1),                            -- gram
('Dark Chocolate', 'Rich dark chocolate bar', 45.0, 0, 100, 45.0, 4.8, NOW(), NOW(), 5, 5, 4),                       -- piece
('Cocoa Powder', 'Unsweetened cocoa powder', 30.0, 0, 110, 30.0, 4.6, NOW(), NOW(), 5, 4, 1),                        -- gram
('Evaporated Milk', 'Concentrated milk for baking', 25.0, 0, 90, 25.0, 4.3, NOW(), NOW(), 3, 3, 3),                  -- liter
('Powdered Sugar', 'Fine powdered sugar', 15.0, 0, 150, 15.0, 4.1, NOW(), NOW(), 2, 2, 2),                            -- kg
('Cinnamon Powder', 'Aromatic cinnamon powder', 20.0, 0, 120, 20.0, 4.5, NOW(), NOW(), 4, 4, 1),                      -- gram
('Nutmeg Powder', 'Spicy nutmeg powder', 22.0, 0, 100, 22.0, 4.4, NOW(), NOW(), 4, 4, 1),                              -- gram
('Cream Cheese', 'Soft cream cheese for baking', 55.0, 0, 80, 55.0, 4.7, NOW(), NOW(), 3, 3, 1),                        -- gram
('Brownie Mix', 'Easy to make brownie mix', 35.0, 0, 90, 35.0, 4.6, NOW(), NOW(), 2, 1, 5);                              -- pack
