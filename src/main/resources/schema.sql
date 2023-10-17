CREATE TABLE IF NOT EXISTS keys(
    kid VARCHAR(255) primary key not null ,
    public_key VARCHAR(255) not null ,
    date_time_at_creation TIMESTAMP not null
);

CREATE TABLE IF NOT EXISTS keys_history(
   khid VARCHAR(255) primary key not null ,
   public_key VARCHAR(255) not null ,
   date_time_at_creation TIMESTAMP not null
);

CREATE INDEX IF NOT EXISTS key_idx ON keys(kid);