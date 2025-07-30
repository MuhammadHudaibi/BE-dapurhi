CREATE TABLE menus
(
    id            VARCHAR(255) PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    description   TEXT,
    image_url     VARCHAR(255),
    price         BIGINT       NOT NULL,
    is_main_menu  BOOLEAN DEFAULT FALSE,
    is_active     BOOLEAN DEFAULT TRUE
);